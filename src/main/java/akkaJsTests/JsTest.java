package akkaJsTests;

import java.util.List;

public class JsTest {
    private String packageId;
    private String jsCode;
    private String functionName;
    private String testName;
    private String expectedResult;
    private List<String> params;
    private String result;

    public JsTest(String packageId, String jsCode, String functionname, String testName, String expectedResult,
                  List<String> params) {
        this.packageId = packageId;
        this.jsCode = jsCode;
        this.functionName = functionname;
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getJsCode() {
        return jsCode;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getTestName() {
        return testName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public List<String> getParams() {
        return params;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
