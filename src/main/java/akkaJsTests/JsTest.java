package akkaJsTests;

import java.util.List;

public class JsTest {
    private String jsCode;
    private String testName;
    private ResultType expectedResult;
    private Object result;
    private List<Object> params;

    public JsTest(String jsCode, String testName, Object expectedResult, List<Object> params) {
        this.jsCode = jsCode;
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.result = result;
        this.params = params;
    }

    public String getTestName() {
        return testName;
    }

    public ResultType getExpectedResult() {
        return expectedResult;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public List<ParamsType> getParams() {
        return params;
    }

    public String getJsCode() {
        return jsCode;
    }
}
