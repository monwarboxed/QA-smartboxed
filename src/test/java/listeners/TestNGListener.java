package listeners;

import com.boxed.smartboxed.AbstractTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;
import org.testng.internal.Utils;
import org.testng.reporters.EmailableReporter2;
import org.testng.xml.XmlSuite;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by monwarjalil on 3/21/19.
 */
public class TestNGListener extends EmailableReporter2 implements ISuiteListener, ITestListener, IInvokedMethodListener {
    public static int numberOfMethods;

    private int currentMethodNumber = 0;

    private Set<String> ranMethods = new HashSet<String>();

    private Map<String, String> screenshotMap = new HashMap<>();//key: qualified method name, value: base64 string of screenshot

    public void onStart(ISuite suite) {
        Reporter.log("\n\nRunning suite " + suite.getName() + "...", true);
    }

    public void onFinish(ISuite suite) {
        Reporter.log("Finished running suite " + suite.getName() + ".", true);
    }

    public void onStart(ITestContext context) {
        Reporter.log("\n\nRunning test " + context.getName() + "...", true);
    }

    public void onFinish(ITestContext context) {
        Reporter.log("Finished running test " + context.getName() + ".", true);
    }

    public void onTestSuccess(ITestResult result) {
        Reporter.log("PASSED: " + result.getName() + ": " + getExecutionTime(result), true);
    }

    private String getScreenshotMapKey(ITestResult result) {
        ITestNGMethod method = result.getMethod();
        String key = String.format("%s_%d_%d", method.getQualifiedName(), result.getStartMillis(), result.getEndMillis());
        System.out.println("key " + key);
        return key;
    }

    private void takeScreenshot(ITestResult result) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) AbstractTest.driver;
        String key = getScreenshotMapKey(result),
                val = takesScreenshot.getScreenshotAs(OutputType.BASE64);
        System.out.println("key " + key + " val " + val.hashCode());
        screenshotMap.put(key, val);
    }

    public void onTestFailure(ITestResult result) {
        takeScreenshot(result);
        Reporter.log("FAILED: " + result.getName() + ": " + getExecutionTime(result), true);
        System.out.println(Utils.longStackTrace(result.getThrowable(), false));
    }

    public void onTestSkipped(ITestResult result) {
        takeScreenshot(result);
        Reporter.log("SKIPPED: " + result.getName() + ": " + getExecutionTime(result), true);
        System.out.println(Utils.shortStackTrace(result.getThrowable(), false));
    }

    public void onTestStart(ITestResult result) {}

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if(method.isTestMethod()) {
            String methodName = getMethodName(method);
            if(!ranMethods.contains(methodName)) {
                ranMethods.add(methodName);
                currentMethodNumber++;
            }
            Reporter.log(String.format("\nRunning method (%d/%d) %s...", currentMethodNumber, numberOfMethods, methodName), true);
        }
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if(method.isTestMethod()) Reporter.log("Finished running method " + getMethodName(method) + ".", true);
    }

    private String getMethodName(IInvokedMethod method) {
        return method.getTestMethod().getQualifiedName();
    }

    private String getQualifiedMethodName(ITestNGMethod method) {
        return method.getRealClass().getName() + "#" + method.getMethodName();
    }

    private String getExecutionTime(ITestResult result) {
        long executionTimeInMillis = result.getEndMillis() - result.getStartMillis();
        long executionTimeInMinutes = TimeUnit.MILLISECONDS.toMinutes(executionTimeInMillis);
        long executionTimeInSeconds = TimeUnit.MILLISECONDS.toSeconds(executionTimeInMillis) -
                TimeUnit.MINUTES.toSeconds(executionTimeInMinutes);

        return String.format("(%d min, %d sec)", executionTimeInMinutes, executionTimeInSeconds);
    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        super.generateReport(xmlSuites, suites, outputDirectory);

        /*if(System.getProperty("sendReportToSlack").equals("true")) {
            try {
                SlackHelper.sendReportStatistics(suites);
                SlackHelper.uploadEmailableReport(new File(outputDirectory, getFileName()));

            } catch (IOException | SlackApiException e) {
                System.err.println("exception while sending/uploading report to slack: " + e.getMessage());
            }
        }*/
    }

    /**
     * Writes the details for all test scenarios.
     */
    protected void writeScenarioDetails() {
        int scenarioIndex = 0;
        for (SuiteResult suiteResult : suiteResults) {
            for (TestResult testResult : suiteResult.getTestResults()) {
                writer.print("<h2>");
                writer.print(Utils.escapeHtml(testResult.getTestName()));
                writer.print("</h2>");

                scenarioIndex += writeScenarioDetails(
                        testResult.getFailedConfigurationResults(),
                        scenarioIndex);
                scenarioIndex += writeScenarioDetails(
                        testResult.getFailedTestResults(), scenarioIndex);
                scenarioIndex += writeScenarioDetails(
                        testResult.getSkippedConfigurationResults(),
                        scenarioIndex);
                scenarioIndex += writeScenarioDetails(
                        testResult.getSkippedTestResults(), scenarioIndex);
                scenarioIndex += writeScenarioDetails(
                        testResult.getPassedTestResults(), scenarioIndex);
            }
        }
    }

    /**
     * Writes the scenario details for the results of a given state for a single
     * test.
     */
    private int writeScenarioDetails(List<ClassResult> classResults,
                                     int startingScenarioIndex) {
        int scenarioIndex = startingScenarioIndex;
        for (ClassResult classResult : classResults) {
            String className = classResult.getClassName();
            for (MethodResult methodResult : classResult.getMethodResults()) {
                List<ITestResult> results = methodResult.getResults();
                assert !results.isEmpty();

                String label = Utils
                        .escapeHtml(className
                                + "#"
                                + results.iterator().next().getMethod()
                                .getMethodName());
                for (ITestResult result : results) {
                    writeScenario(scenarioIndex, label, result);
                    scenarioIndex++;
                }
            }
        }

        return scenarioIndex - startingScenarioIndex;
    }

    /**
     * Writes the details for an individual test scenario.
     */
    private void writeScenario(int scenarioIndex, String label,
                               ITestResult result) {
        writer.print("<h3 id=\"m");
        writer.print(scenarioIndex);
        writer.print("\">");
        writer.print(label);
        writer.print("</h3>");

        writer.print("<table class=\"result\">");

        // Write test parameters (if any)
        Object[] parameters = result.getParameters();
        int parameterCount = (parameters == null ? 0 : parameters.length);
        if (parameterCount > 0) {
            writer.print("<tr class=\"param\">");
            for (int i = 1; i <= parameterCount; i++) {
                writer.print("<th>Parameter #");
                writer.print(i);
                writer.print("</th>");
            }
            writer.print("</tr><tr class=\"param stripe\">");
            for (Object parameter : parameters) {
                writer.print("<td>");
                writer.print(Utils.escapeHtml(Utils.toString(parameter)));
                writer.print("</td>");
            }
            writer.print("</tr>");
        }

        // Write reporter messages (if any)
        List<String> reporterMessages = Reporter.getOutput(result);
        if (!reporterMessages.isEmpty()) {
            writer.print("<tr><th");
            if (parameterCount > 1) {
                writer.print(" colspan=\"");
                writer.print(parameterCount);
                writer.print("\"");
            }
            writer.print(">Messages</th></tr>");

            writer.print("<tr><td");
            if (parameterCount > 1) {
                writer.print(" colspan=\"");
                writer.print(parameterCount);
                writer.print("\"");
            }
            writer.print(">");
            writeReporterMessages(reporterMessages);
            writer.print("</td></tr>");
        }

        // Write exception (if any)
        Throwable throwable = result.getThrowable();
        if (throwable != null) {
            writer.print("<tr><th");
            if (parameterCount > 1) {
                writer.print(" colspan=\"");
                writer.print(parameterCount);
                writer.print("\"");
            }
            writer.print(">");
            writer.print((result.getStatus() == ITestResult.SUCCESS ? "Expected Exception"
                    : "Exception"));
            writer.print("</th></tr>");

            writer.print("<tr><td");
            if (parameterCount > 1) {
                writer.print(" colspan=\"");
                writer.print(parameterCount);
                writer.print("\"");
            }
            writer.print(">");
            writeStackTrace(throwable);
            writer.print("</td></tr>");

            writer.print("<tr><th>Screenshot</th></tr>");
            writer.print("<tr><td>");
            System.out.println("scr map " + screenshotMap.size() + " " + screenshotMap.keySet().toString());
            String base64ImgSrc = "data:image/png;base64, " + screenshotMap.get(getScreenshotMapKey(result));
            writer.print("<img src=\"" + base64ImgSrc + "\" width = '1500 height='1000' />");
            writer.print("</td></tr>");
        }

        writer.print("</table>");
        writer.print("<p class=\"totop\"><a href=\"#summary\">back to summary</a></p>");
    }
}

