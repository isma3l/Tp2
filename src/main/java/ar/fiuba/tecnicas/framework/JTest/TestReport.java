package ar.fiuba.tecnicas.framework.JTest;

import java.util.ArrayList;
import java.util.List;

public class TestReport {
    private List<TestListener> testListeners;
    private int runTests;
    private int oktest;
    private int errortest;
    private int failedtest;
    private PatternRecognizer recognizerExpressionsTestcase;
    private PatternRecognizer recognizerExpressionsTestsuite;
    private RecognizerTag recognizerTags;

    public void setFirsttimeintest(boolean firsttimeintest) {
        this.firsttimeintest = firsttimeintest;
    }

    private boolean firsttimeintest;

    public TestReport() {
        testListeners = new ArrayList<TestListener>();
        runTests = 0;
        oktest=0;
        errortest=0;
        failedtest=0;
        firsttimeintest=true;
        recognizerExpressionsTestcase = null;
        recognizerExpressionsTestsuite=null;
        recognizerTags = null;
    }

    public void initializeRecognizerExpression(String testcaseregexp,String testsuiteregexp) {
        recognizerExpressionsTestcase = new PatternRecognizer(testcaseregexp);
        recognizerExpressionsTestsuite= new PatternRecognizer(testsuiteregexp);
    }

    public void setRecognizerExpressionsTestcase(PatternRecognizer recognizer) {
        recognizerExpressionsTestcase = recognizer;
    }

    public void setRecognizerExpressionsTestsuite(PatternRecognizer recognizer) {
        recognizerExpressionsTestsuite = recognizer;
    }

    public void setRecognizerTag(RecognizerTag recognizerTags) {
        this.recognizerTags = recognizerTags;
    }

    public void addSuccess(TestCase test) {
        runTests++;
        for (TestListener testListener : testListeners) {
            testListener.addSuccess(test, Timer.getTime());
        }
    }
    public void addFailure(Test test) {
        failedtest++;
        runTests++;
        for (TestListener testListener : testListeners) {
            testListener.addFailure(test, Timer.getTime());
        }
    }
    public void addError(Test test) {
        errortest++;
        runTests++;
        for (TestListener testListener : testListeners) {
            testListener.addError(test, Timer.getTime());
        }
    }
    public void insertHSeparator(){
        for (TestListener testListener : testListeners) {
            testListener.insertHSeparator();
        }
    }
    public void print(String messsage){
        for (TestListener testListener : testListeners) {
            testListener.print(messsage);
        }
    }
    public void addListener(TestListener listener) {
        testListeners.add(listener);
    }
    public void run(final TestCase test) {
        if(validateTestCase(test)){
            Timer.initialize();
            try {
                 test.runTestSequence();
                 addSuccess(test);
            } catch (AssertionError assertionError) {
                addFailure(test);
                System.out.println(assertionError);
            } catch (Throwable exception) {
                addError(test);
            }
        }
    }

    private boolean validateTestCase(TestCase test) {
        return (testNameMatchRegularExpression(test)) && validateTagTestCase(test) && !test.isSkype();
    }

    private boolean validateTagTestCase(TestCase test) {
        return recognizerTags.validate(test.getTags());
    }

    private boolean testNameMatchRegularExpression(Test test) {
        return recognizerExpressionsTestcase == null || recognizerExpressionsTestcase.validate(test.toString());
    }
    public boolean testsuiteNameMatchRegularExpression(Test test) {
        return recognizerExpressionsTestsuite == null || recognizerExpressionsTestsuite.validate(test.getTestname());
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
