/*

 */

package ar.fiuba.tecnicas.framework;

import java.util.ArrayList;

public class TestSuite implements Test {
    private ArrayList<Test> testlineitem;

    @Override
    public void excecute(TestReport testReport) {
        for(Test test:testlineitem){
            test.excecute(testReport);
        }
    }

    public TestSuite() {
        testlineitem=new ArrayList<Test>();
    }

    public TestReport excecute(){
        TestReport testReport=new TestReport();
        excecute(testReport);
        return testReport;
    }

    public void addTest(Test test){
        testlineitem.add(test);
    }
    public Test getChild(int idx){
        return testlineitem.get(idx);
    }
}
