/*

 */

package ar.fiuba.tecnicas.framework;

import java.util.Iterator;
import java.util.Vector;

public class TestSuite implements Test {
    private Vector<Test> testlineitem;
    @Override
    public int countTestCases() {
        int count = 0;
        for (Test test : testlineitem) {
            count += test.countTestCases();
        }
        return count;
    }
    @Override
    public void run(TestReport testReport) {
        Iterator<Test> it=testlineitem.iterator();
        while ((it.hasNext()) &&(!testReport.shouldStop()))
            runTest(it.next(),testReport);
    }
    public void runTest(Test test, TestReport testReport) {
        test.run(testReport);
    }
    public TestSuite() {
        testlineitem=new Vector<Test>();
    }

    public Test testAt(int index) {
        return testlineitem.get(index);
    }
    public void addTest(Test test){
        testlineitem.add(test);
    }

}
