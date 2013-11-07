package ar.fiuba.tecnicas.framework;

public class SuiteATest implements TestCreator{
    private TestSuite suite;
    private boolean trueCondition;
    public SuiteATest() {
        this.suite=new TestSuite("SuiteATest"){
            @Override
            public void setUp() throws Exception {
                getContext().put("k",2);
                getContext().put("h",2);
                getContext().put("list1",new Double[]{1.2, 9.8, 4.6});
                getContext().put("list2",new Double[]{1.2, 9.8, 4.6});
                getContext().put("trueCondition",2<3);
            }
        };
    }
    public void assetEqualWithSetUpTest() {

        Assert.assertEquals("Objects have different value",suite.getContext().get("k"), suite.getContext().get("h"));
    }
    public void assertArrayEqualsWithSetUpTest() {
        Assert.assertArrayEquals("Arrays have different value",((int[])suite.getContext().get("list1")[0]),list2);
    }
    public void assertTrueWithSetUpTest() {
        Assert.assertTrue("The condition is false",trueCondition);
    }

    @Override
    public void createTest(TestSuite test) throws Exception {
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
        test.addTestSuite(suite);
    }
}
