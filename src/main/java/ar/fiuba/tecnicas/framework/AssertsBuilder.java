package ar.fiuba.tecnicas.framework;


import static org.hamcrest.CoreMatchers.is;

public class AssertsBuilder implements TestBuilder {
    private volatile static AssertsBuilder INSTANCE = null;
    private AssertsBuilder(){}
    private AssertsBuilder(final AssertsBuilder assertsbuilder){}
    private synchronized static void createExclusionZoneCkeckInstanceAndCreate() {
        synchronized(AssertsBuilder.class) {
            if (INSTANCE == null) {
                INSTANCE = new AssertsBuilder();
            }
        }
    }
    private synchronized static void createInstance() {
        if (INSTANCE == null)
            createExclusionZoneCkeckInstanceAndCreate();
    }
    public void objectComparisonEqualTest(Test test) {
        Integer k=2;
        Integer h=2;
        AssertObjectsComparison assertEquals=new AssertObjectsComparison(h,k,new EqualComparisonBehavior(),
                "Objects have different value");
        test.addTest(assertEquals);
    }


    public void objectComparisonNotEqualTest(Test test) {
        AssertObjectsComparison assertNotEquals=new AssertObjectsComparison(2,3,new NotEqualComparisonBehavior(),
                "Objects have the same value");
        test.addTest(assertNotEquals);
    }


    public void assertArrayEqualsTest(Test test) {
        Double[] list1 = {1.2, 9.8, 4.6};
        Double[] list2 = {1.2, 9.8, 4.6};

        AssertArrayEquals assertArrayEquals = new AssertArrayEquals(list1, list2, "Arrays have different value");
        test.addTest(assertArrayEquals);
    }

    public void conditionComparisonEqualTest(Test test) {
        boolean trueCondition= (2<3);
        AssertConditionComparison assertTrue= new AssertConditionComparison(trueCondition,
                new EqualConditionComparisonBehavior(), "The condition is false");
        test.addTest(assertTrue);
    }

    public void conditionComparisonNotEqualTest(Test test) {
        boolean falseCondition= (2>3);
        AssertConditionComparison assertFalse= new AssertConditionComparison(falseCondition,
                new NotEqualConditionComparisonBehavior(), "The condition is true");
        test.addTest(assertFalse);
    }

    public void referenceComparisonEqualTest(Test test) {
        Integer num1 = 2;
        Integer num2 = num1;
        AssertObjectReferenceComparison assertSame=new AssertObjectReferenceComparison(num1,num2,
                new EqualReferenceComparisonBehavior(), "Objects have different reference");
        test.addTest(assertSame);
    }

    public void referenceComparisonNotEqualTest(Test test) {
        Integer num1 = 2;
        Integer num2 = 6;
        AssertObjectReferenceComparison assertNotSame =new AssertObjectReferenceComparison(num1, num2,
                new NotEqualReferenceComparisonBehavior(),"Objects have the same reference");
        test.addTest(assertNotSame);
    }

    public void nullObjectComparisonTest(Test test) {
        String chain=null;
        AssertNullObjectComparison assertNull=new AssertNullObjectComparison(chain,new NullComparisonBehavior(),
                "The object is not null");
        test.addTest(assertNull);
    }

    public void notNullObjectComparisonTest(Test test) {
        String chain= "abc";
        AssertNullObjectComparison assertNotNull=new AssertNullObjectComparison(chain,new NotNullComparisonBehavior(),
                "The object is null");
        test.addTest(assertNotNull);
    }

    public void assertThatTest(Test test) {
        Integer[] actualArray={1,2,3,4};

        AssertThat assertThat=new AssertThat(actualArray.length, is(4),
                "Actual doesn 't match the condition specified by matcher");
        test.addTest(assertThat);
    }

    public void addTests(Test test) {
        assertArrayEqualsTest(test);
        conditionComparisonEqualTest(test);
        conditionComparisonNotEqualTest(test);
        referenceComparisonEqualTest(test);
        referenceComparisonNotEqualTest(test);
        nullObjectComparisonTest(test);
        notNullObjectComparisonTest(test);
        objectComparisonEqualTest(test);
        objectComparisonNotEqualTest(test);
        assertThatTest(test);
    }
    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    public final static AssertsBuilder getInstance() {
        createInstance();
        return INSTANCE;
    }
    @Override
    public TestSuite makeAll() {
        return new TestSuite();
    }

    @Override
    public Test makePart() {
        Test assertTest= new TestSuite();
        addTests(assertTest);
        return assertTest;
    }
}
