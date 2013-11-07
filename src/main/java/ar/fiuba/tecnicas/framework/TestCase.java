package ar.fiuba.tecnicas.framework;

import java.util.Map;

public abstract class TestCase extends Test{
    public TestCase(String testname) {
        super(testname);
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
        return getTestname();
    }
}
