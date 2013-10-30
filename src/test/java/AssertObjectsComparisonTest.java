import org.junit.Test;
public class AssertObjectsComparisonTest {
    @Test
    public void equalIntegersTest(){
        int i=2;
        int j=2;
          AssertObjectsComparison assertEquals=new AssertObjectsComparison(i,j,new EqualComparisonBehavior(),
                                                                               "Objects have different value");
          TestReport testreport=new TestReport();
          assertEquals.excecute(testreport);
    }
}
