/*

 */

package ar.fiuba.tecnicas.framework;


import java.util.Vector;

public class TestSuite extends Test {
    private Vector<Test> testlineitem;
    private boolean firsttimeinsuite;
    private TestSuite suiteFather;
    @Override
    public void setSuiteFather(TestSuite suiteFather)throws Exception{
        this.suiteFather = suiteFather;
    }

    @Override
    public int countTestCases() {
        int count = 0;
        for (Test test : testlineitem) {
            count += test.countTestCases();
        }
        return count;
    }

    @Override
    public String toString() {
        return  getNameFather();
    }

    @Override
    public void run(TestReport testReport) {
        testReport.printSuiteTrace(this);
        for (Test test : testlineitem){
            printSuiteTrace(test,testReport);
            runTest(test,testReport);
        }
    }

    private void printSuiteTrace(Test test, TestReport testReport) {
        if (test instanceof TestCase){
            testReport.print(getNameFather());
            if (firsttimeinsuite) testReport.insertHSeparator();
            firsttimeinsuite=false;
        }else firsttimeinsuite=true;
    }

    public void runTest(Test test, TestReport testReport) {
        test.run(testReport);
    }
    public TestSuite(String testname) {
        super(testname);
        this.testlineitem=new Vector<Test>();
        this.firsttimeinsuite=true;
        suiteFather = null;
    }

    public TestSuite() {
        super(null);
        this.testlineitem=new Vector<Test>();
        this.firsttimeinsuite=true;
        suiteFather = null;
    }

    public Test testAt(int index) {
        return testlineitem.get(index);
    }

    @Override
    public void addTest(Test test)throws Exception{
        if(!existsTest(test)) {
            if (test instanceof TestSuite) test.setSuiteFather(this);
            testlineitem.add(test);
        }
    }

    private boolean existsTest(Test newTest) {
        for(Test test: testlineitem) {
            if (test.getTestname().equals(newTest.getTestname()))
                return true;
        }
        return false;
    }

    private String getNameFather() {
        if(suiteFather == null)
            return getTestname();
        else {
            return suiteFather.getNameFather() + "." +getTestname();
        }
    }

}
