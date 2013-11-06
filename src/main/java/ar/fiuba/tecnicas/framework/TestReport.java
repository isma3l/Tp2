/*
    Se encarga de mostrar el resultado de los tests y lleva
    el rastreo de la cantidad de test que fueron ejecutados.
 */

package ar.fiuba.tecnicas.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class TestReport {
    private List<TestFailure> testFailures;
    private List<TestFailure> testErrors;
    private List<TestListener> testListeners;
    private int runTests;
    private boolean stopTest;

    public TestReport() {
        testFailures = new ArrayList<TestFailure>();
        testErrors = new ArrayList<TestFailure>();
        testListeners = new ArrayList<TestListener>();
        runTests = 0;
        stopTest = false;
    }
    public void startTest(Test test) {
        final int count = test.countTestCases();
        runTests += count;
        for (TestListener testlistener : testListeners) {
            testlistener.startTest(test);
        }
    }

    /*public synchronized void start(String testpassed){
        excecutedtests++;
        message=testpassed;
        System.out.println("TEST PASSED: "+Integer.toString(excecutedtests)+"\t"+message);
    }*/
    public boolean shouldStop() {
        return stopTest;
    }
    public void addFailure(Test test,AssertionError assertionError) {
        testFailures.add(new TestFailure(test, assertionError));
        for (TestListener testListener : testListeners) {
            testListener.addFailure(test, assertionError);
        }
    }
    public void addError(Test test,Throwable exception) {
        testErrors.add(new TestFailure(test,exception));
        for (TestListener testListener : testListeners) {
            testListener.addError(test, exception);
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
        } catch (AssertionError assertionError) {
            addFailure(test, assertionError);
        } catch (Throwable exception) {
            addError(test, exception);
        }

        endTest(test);
    }

    public Enumeration<TestFailure> failures() {
        return Collections.enumeration(testFailures);
    }
    public boolean wasSuccessful() {
        return ( failureCount()== 0);
    }

    public int failureCount() {
        return testFailures.size();
    }

    public int runCount() {
        return runTests;
    }

    public Enumeration<TestFailure> errors() {
        return Collections.enumeration(testErrors);
    }

    public int errorCount() {
        return testErrors.size();
    }
}
