package akkaJsTests;

import java.util.List;

public class JsTest <ResultType, ParamsType> {
    private String testName;
    private ResultType expectedResult;
    private List<ParamsType> params;

    public JsTest(String testName, ResultType expectedResult, List<ParamsType> params) {
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public String getTestName() {
        return testName;
    }

    public ResultType getExpectedResult() {
        return expectedResult;
    }

    public List<ParamsType> getParams() {
        return params;
    }
}
