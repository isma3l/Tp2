package ar.fiuba.tecnicas.framework;

import static org.hamcrest.CoreMatchers.is;

public class TestWithFramework{
    public void objectComparisonEqualTest() {
        Integer k=2;
        Integer h=2;
        Assert.assertEquals("Objects have different value", k, h);
    }
    public void assertArrayEqualsTest() {
        Double[] list1 = {1.2, 9.8, 4.6};
        Double[] list2 = {1.2, 9.8, 4.6};
        Assert.assertArrayEquals("Arrays have different value",list1,list2);
    }

    public void conditionComparisonTrueTest() {
        boolean trueCondition= (2<3);
        Assert.assertTrue("The condition is false",trueCondition);
    }

    public void conditionComparisonFalseTest() {
        boolean falseCondition= (2>3);
        Assert.assertFalse("The condition is true",falseCondition);
    }

    public void referenceComparisonSameTest() {
        Integer num1 = 2;
        Integer num2 = num1;
        Assert.assertSame("Objects have different reference",num1,num2);
    }
    public void doubleComparisonEquals(){
        double num1=2.32456;
        double num2=2.32466;
        double delta=0.01;
        Assert.assertEquals("2.32456 is not equal to 2.32466 considering delta 0.01",num1,num2,delta);
    }
    public void referenceComparisonNotSameTest() {
        Integer num1 = 2;
        Integer num2 = 6;
        Assert.assertNotSame("num1 and num2 have the same reference",num1,num2);
    }

    public void nullObjectComparisonTest() {
        String chain=null;
        Assert.assertNull("Chain is not null",chain);
    }
    public void notNullObjectComparisonTest() {
        String chain= "abc";
        Assert.assertNotNull("Chain is null",chain);
    }

    public void assertThatTest() {
        Integer[] actualArray={1,2,3,4};
        Assert.assertThat("ActualArray size is not 4",actualArray.length, is(4));
    }

    public Test createTest() {
        TestSuite suite= new TestSuite();
        suite.addTest(new TestCase("objectComparisonEqualTest") {
             @Override
             public void runTest() {
                 objectComparisonEqualTest();
             }
         });
        suite.addTest(new TestCase("assertArrayEqualsTest") {
            @Override
            public void runTest() {
                assertArrayEqualsTest();
            }
        });
        suite.addTest(new TestCase("conditionComparisonTrueTest") {
            @Override
            public void runTest(){
                conditionComparisonTrueTest();
            }
        });
        suite.addTest(new TestCase("conditionComparisonFalseTest") {
            @Override
            public void runTest(){
                conditionComparisonFalseTest();
            }
        });
        suite.addTest(new TestCase("referenceComparisonSameTest") {
            @Override
            public void runTest(){
                referenceComparisonSameTest();
            }
        });
        suite.addTest(new TestCase("doubleComparisonEquals") {
            @Override
            public void runTest(){
                doubleComparisonEquals();
            }
        });
        suite.addTest(new TestCase("referenceComparisonNotSameTest") {
            @Override
            public void runTest(){
                referenceComparisonNotSameTest();
            }
        });
        suite.addTest(new TestCase("nullObjectComparisonTest") {
            @Override
            public void runTest(){
                nullObjectComparisonTest();
            }
        });
        suite.addTest(new TestCase("notNullObjectComparisonTest") {
            @Override
            public void runTest(){
                notNullObjectComparisonTest();
            }
        });
        suite.addTest(new TestCase("assertThatTest") {
            @Override
            public void runTest(){
                assertThatTest();
            }
        });
        return suite;
    }
}
