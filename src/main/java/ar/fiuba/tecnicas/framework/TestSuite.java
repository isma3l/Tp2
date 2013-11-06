/*

 */

package ar.fiuba.tecnicas.framework;

import java.util.Iterator;
import java.util.Vector;

public class TestSuite implements Test {
    private Vector<Test> testlineitem;
    private String testname;
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
        return testname;
    }

    @Override
    public void run(TestReport testReport) {
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
    }

    public TestSuite() {
        this.testlineitem=new Vector<Test>();
        this.testname=null;
    }

    public Test testAt(int index) {
        return testlineitem.get(index);
    }
    public void addTest(Test test){
        testlineitem.add(test);
    }

}
