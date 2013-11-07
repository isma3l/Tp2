package ar.fiuba.tecnicas.framework;

public class AllTests {
    public static Test suite() throws Exception {
        TestSuite suite= new TestSuite("AllTests");
        TestSuite assertSuite= new TestSuite("AssertSuite");
        AssertTest assertTest= new AssertTest();
        assertTest.createTest(assertSuite);
        suite.addTest(assertSuite);
        TestSuite suiteA= new TestSuite("SuiteA");
        SuiteATest suiteATest= new SuiteATest();
        suiteATest.createTest(suiteA);
        suite.addTest(suiteA);
        //suite.addTest(new SuiteATest("SuiteATest"));
        return suite;
    }
}
