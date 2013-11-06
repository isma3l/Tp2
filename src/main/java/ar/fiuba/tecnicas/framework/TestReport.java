package ar.fiuba.tecnicas.framework;

import java.util.ArrayList;
import java.util.List;

public class TestReport {
    private List<TestListener> testListeners;
    private int runTests;
    private int oktest;
    private int errortest;
    private int failedtest;

    public TestReport() {
        testListeners = new ArrayList<TestListener>();
        runTests = 0;
        oktest=0;
        errortest=0;
        failedtest=0;
    }
    public void startTest(Test test) {
        for (TestListener testlistener : testListeners) {
            testlistener.startTest(test);
        }
    }
    public void addSuccess(TestCase test) {
        runTests++;
        for (TestListener testListener : testListeners) {
            testListener.addSuccess(test);
        }
    }
    public void addFailure(Test test) {
        failedtest++;
        runTests++;
        for (TestListener testListener : testListeners) {
            testListener.addFailure(test);
        }
    }
    public void addError(Test test) {
        errortest++;
        runTests++;
        for (TestListener testListener : testListeners) {
            testListener.addError(test);
        }
    }
    public void printSuiteTrace(Test test){
        for (TestListener testListener : testListeners) {
            testListener.printSuiteTrace(test);
        }
    }
    public void addListener(TestListener listener) {
        testListeners.add(listener);
    }
    public void removeListener(TestListener listener) {
        testListeners.remove(listener);
    }
    public void endTest(Test test) {
        for (TestListener testListener : testListeners) {
            testListener.endTest(test);
        }
    }
    protected void run(final TestCase test) {
        startTest(test);
        try {
            test.runTestSequence();
            addSuccess(test);
        } catch (AssertionError assertionError) {
            addFailure(test);
        } catch (Throwable exception) {
            addError(test);
        }

        endTest(test);
    }

    public boolean wasSuccessful() {
        return ( failureCount()== 0);
    }
    public int failureCount() {
        return failedtest;
    }
    public int runCount() {
        return runTests;
    }
    public int errorCount() {
        return errortest;
    }
}
