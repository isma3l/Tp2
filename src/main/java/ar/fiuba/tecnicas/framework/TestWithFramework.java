package ar.fiuba.tecnicas.framework;

import static org.hamcrest.CoreMatchers.is;

public class TestWithFramework extends Assert{
    public void objectComparisonEqualTest() {
        Integer k=2;
        Integer h=2;
        assertEquals("Objects have different value",k,h);
    }
    public void assertArrayEqualsTest() {
        Double[] list1 = {1.2, 9.8, 4.6};
        Double[] list2 = {1.2, 9.8, 4.6};
        assertArrayEquals("Arrays have different value",list1,list2);
    }

    public void conditionComparisonTrueTest() {
        boolean trueCondition= (2<3);
        assertTrue("The condition is false",trueCondition);
    }

    public void conditionComparisonFalseTest() {
        boolean falseCondition= (2>3);
        assertFalse("The condition is true",falseCondition);
    }

    public void referenceComparisonSameTest() {
        Integer num1 = 2;
        Integer num2 = num1;
        assertSame("Objects have different reference",num1,num2);
    }
    public void doubleComparisonEquals(){
        double num1=2.32456;
        double num2=2.32466;
        double delta=0.01;
        assertEquals("2.32456 is not equal to 2.32466 considering delta 0.01",num1,num2,delta);
    }
    public void referenceComparisonNotSameTest() {
        Integer num1 = 2;
        Integer num2 = 6;
        assertNotSame("num1 and num2 have the same reference",num1,num2);
    }

    public void nullObjectComparisonTest() {
        String chain=null;
        assertNull("Chain is not null",chain);
    }
    public void notNullObjectComparisonTest() {
        String chain= "abc";
        assertNotNull("Chain is null",chain);
    }

    public void assertThatTest() {
        Integer[] actualArray={1,2,3,4};
        assertThat("ActualArray size is not 4",actualArray.length, is(4));
    }
    @Override
    public void excecute(TestReport testReport) {
        assertArrayEqualsTest();
        conditionComparisonTrueTest();
        conditionComparisonFalseTest();
        referenceComparisonSameTest();
        referenceComparisonNotSameTest();
        nullObjectComparisonTest();
        notNullObjectComparisonTest();
        objectComparisonEqualTest();
        doubleComparisonEquals();
        assertThatTest();
    }
}
