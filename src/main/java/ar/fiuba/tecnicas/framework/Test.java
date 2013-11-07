package ar.fiuba.tecnicas.framework;

public abstract class Test {
    private String testname;

    public String getTestname() {
        return testname;
    }
    public Test(String testname) {
        this.testname = testname;
    }

    public abstract void run(TestReport testReport);
    public abstract int countTestCases();
    public void setUp() throws Exception {}
    public void tearDown() throws Exception {}

}
