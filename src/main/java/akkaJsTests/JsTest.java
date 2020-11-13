package akkaJsTests;

import java.util.List;

public class JsTest <ResultType, ParamsType> {
    private String testName;
    private ResultType expectedResult;
    private Object result;
    private List<ParamsType> params;

    public JsTest(String testName, ResultType expectedResult, Object result, List<ParamsType> params) {
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

    public List<ParamsType> getParams() {
        return params;
    }
}
