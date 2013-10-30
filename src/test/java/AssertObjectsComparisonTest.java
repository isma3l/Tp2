import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class AssertObjectsComparisonTest {
    private TestSuite testSuite;
    private TestReport testReport;

    public AssertObjectsComparisonTest() {
        testSuite= new TestSuite();
        testReport= new TestReport();
    }
     @Before
     public void setUp(){
         TestSuite assertTests=new TestSuite();
         Integer k=2;
         Integer h=2;
         AssertObjectsComparison assertEquals=new AssertObjectsComparison(h,k,new EqualComparisonBehavior(),
                 "Objects have different value");
         AssertObjectsComparison assertNotEquals=new AssertObjectsComparison(2,3,new NotEqualComparisonBehavior(),
                 "Objects have the same value");
         Integer i=2;
         Integer j=i;
         AssertObjectReferenceComparison assertSame=new AssertObjectReferenceComparison(i,j,
                                                                                 new EqualReferenceComparisonBehavior(),
                                                                                 "Objects have different reference");
         j= new Integer(2);
         AssertObjectReferenceComparison assertNotSame =new AssertObjectReferenceComparison(i,j
                                                                              ,new NotEqualReferenceComparisonBehavior(),
                                                                              "Objects have the same reference");
         Integer[] expectedarray={1,2,3,4};
         Integer[] actualarray={1,2,3,4};
         AssertArrayEquals assertArrayEquals= new AssertArrayEquals(expectedarray,
                                                                    actualarray,
                                                                    "The arrays contian different elements");
         boolean condition= (2<3);
         AssertConditionComparison assertTrue= new AssertConditionComparison(condition,
                                                                            new EqualConditionComparisonBehavior(),
                                                                            "The condition is false");
         boolean falsecondition= (2>3);
         AssertConditionComparison assertFalse= new AssertConditionComparison(falsecondition,
                 new NotEqualConditionComparisonBehavior(),
                 "The condition is true");
         String chain=null;
         AssertNullObjectComparison assertNull=new AssertNullObjectComparison(chain,new NullComparisonBehavior(),
                                                                              "The object is not null");
         chain= "abc";
         AssertNullObjectComparison assertNotNull=new AssertNullObjectComparison(chain,new NotNullComparisonBehavior(),
                 "The object is null");
         AssertThat assertThat=new AssertThat(actualarray.length,
                                              is(4),
                                             "Actual doesn 't match the condition specified by matcher");
         assertTests.addTest(assertEquals);
         assertTests.addTest(assertNotEquals);
         assertTests.addTest(assertSame);
         assertTests.addTest(assertNotSame);
         assertTests.addTest(assertArrayEquals);
         assertTests.addTest(assertTrue);
         assertTests.addTest(assertFalse);
         assertTests.addTest(assertNull);
         assertTests.addTest(assertNotNull);
         assertTests.addTest(assertThat);
         testSuite.addTest(assertTests);
     }
    @Test
    public void assertTest(){
        testSuite.getChild(0).excecute(testReport);

    }
}
