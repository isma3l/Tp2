package ar.fiuba.tecnicas.framework;

public class SuiteATest implements TestCreator{
    private TestSuite suite;
    private int k;
    private int h;
    private Double[] list1;
    private Double[] list2;
    private boolean trueCondition;
    public SuiteATest() {
        this.suite=new TestSuite("SuiteATest"){
            @Override
            public void setUp() throws Exception {
                k=2;
                h=2;
                list1 = new Double[]{1.2, 9.8, 4.6};
                list2 = new Double[]{1.2, 9.8, 4.6};
                trueCondition=(2<3);
            }
        };
    }
    public void assetEqualWithSetUpTest() {
        Assert.assertEquals("Objects have different value", k, h);
    }
    public void assertArrayEqualsWithSetUpTest() {
        Assert.assertArrayEquals("Arrays have different value",list1,list2);
    }
    public void assertTrueWithSetUpTest() {
        Assert.assertTrue("The condition is false",trueCondition);
    }

    @Override
    public void createTest(Test test) throws Exception {
        suite.addTest(new TestCase("assertArrayEqualsWithSetUpTest") {
            @Override
            public void runTest() {
                assertArrayEqualsWithSetUpTest();
            }
        });
        suite.addTest(new TestCase("assetEqualWithSetUpTest") {
            @Override
            public void runTest() {
                assetEqualWithSetUpTest();
            }
        });
        suite.addTest(new TestCase("assertTrueWithSetUpTest") {
            @Override
            public void runTest(){
                assertTrueWithSetUpTest();
            }
        });
        test.addTest(suite);
    }
}
