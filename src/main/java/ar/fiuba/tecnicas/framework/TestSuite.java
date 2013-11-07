/*

 */

package ar.fiuba.tecnicas.framework;


import java.util.Vector;

public class TestSuite implements Test {
    private Vector<Test> testlineitem;
    private String testname;
    private boolean firsttimeinsuite;
    private TestSuite suiteFather;

    @Override
    public int countTestCases() {
        int count = 0;
        for (Test test : testlineitem) {
            count += test.countTestCases();
        }
        return count;
    }

    @Override
    public String getName() {
        return testname;
    }

    @Override
    public String toString() {
        return  getNameFather();
    }

    @Override
    public void run(TestReport testReport) {
        if (!firsttimeinsuite) testReport.print(".");
        firsttimeinsuite=false;
        testReport.printSuiteTrace(this);
        for (Test test : testlineitem)
            runTest(test,testReport);
    }
    public void runTest(Test test, TestReport testReport) {
        test.run(testReport);
    }
    public TestSuite(String testname) {
        this.testlineitem=new Vector<Test>();
        this.testname=testname;
        this.firsttimeinsuite=true;
        suiteFather = null;
    }

    public TestSuite() {
        this.testlineitem=new Vector<Test>();
        this.testname=null;
        this.firsttimeinsuite=true;
        suiteFather = null;
    }

    public Test testAt(int index) {
        return testlineitem.get(index);
    }
    public void addTest(TestCase test){
        if(!existsTest(test))
            testlineitem.add(test);
    }
    public void addTestSuite(TestSuite test) {
        if(!existsTest(test)) {
            test.suiteFather = this;
            testlineitem.add(test);
        }
    }

    private boolean existsTest(Test newTest) {
        for(Test test: testlineitem) {
            if (test.getName().equals(newTest.getName()))
                return true;
        }
        return false;
    }

    private String getNameFather() {
        if(suiteFather == null)
            return testname;
        else {
            return suiteFather.getNameFather() + "." + testname;
        }
    }

}
