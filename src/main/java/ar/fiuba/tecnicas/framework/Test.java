package ar.fiuba.tecnicas.framework;

public abstract class Test {
    public String getTestname() {
        return testname;
    }
    public Test(String testname) {
        this.testname = testname;
    }
    private String testname;
    public abstract void run(TestReport testReport);
    public abstract int countTestCases();
    public void setUp() throws Exception {}
    public void tearDown() throws Exception {}
    public void addTest(Test test)throws Exception{
        throw new Exception("unsupported operation: addTest");
    }
    public void setSuiteFather(TestSuite suiteFather)throws Exception{
        throw new Exception("unsupported operation: setSuiteFather");
    }
}
