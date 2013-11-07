package ar.fiuba.tecnicas.framework;

public abstract class TestCase extends Assert implements Test{
    private String testname;

    public TestCase(String testname) {
        this.testname = testname;
    }

    @Override
    public void run(TestReport testReport) {
        testReport.run(this);
        testReport.setFirsttimeintest(false);
    }
    @Override
    public int countTestCases() {
        return 1;
    }
    public void setUp() throws Exception {}
    public void tearDown() throws Exception {}
    public abstract void runTest();
    private void tearingDown(Throwable exception){
        try {
            tearDown();
        } catch (Throwable tearingDown) {
            if (exception == null) exception = tearingDown;
        }
    }
    public void runTestSequence()throws Throwable{
        Throwable exception = null;
        setUp();
        try {
            runTest();
        } catch (Throwable running) {
            exception = running;
        } finally {
            tearingDown(exception);
        }
        if (exception != null) throw exception;
    }
    @Override
    public String toString() {
        return (testname);
    }
}
