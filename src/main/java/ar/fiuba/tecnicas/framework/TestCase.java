package ar.fiuba.tecnicas.framework;
/*
Responsabilidad: Ejecutar test con metodos que permitan ejecutar algo antes y algo despues del test
 */

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
