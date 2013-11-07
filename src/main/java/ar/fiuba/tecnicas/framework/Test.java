package ar.fiuba.tecnicas.framework;

import java.util.Map;

public abstract class Test {
    private String testname;
    private Map<String,Object> context;
    public String getTestname() {
        return testname;
    }
    public Test(String testname) {
        this.testname = testname;
    }

    public Map<String, Object> getContext() {
        return context;
    }

    public abstract void run(TestReport testReport);
    public abstract int countTestCases();
    public void setUp() throws Exception {}
    public void tearDown() throws Exception {}

}
