import java.util.ArrayList;

public class TestSuite extends Test{
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

    public void addTest(Test test){
        testlineitem.add(test);
    }
    public Test getChild(int idx){
        return testlineitem.get(idx);
    }
}
