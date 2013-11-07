package ar.fiuba.tecnicas.framework;

import java.util.Vector;

public class AllTests {
    public static Test suite() throws Exception {
        TestSuite suite= new TestSuite("AllTests");
        TestSuite assertSuite= new TestSuite("AssertSuite");
        AssertTest assertTest= new AssertTest();
        assertTest.createTest(assertSuite);
        suite.addTestSuite(assertSuite);
        TestSuite suiteA= new TestSuite("SuiteA");
        SuiteATest suiteATest= new SuiteATest();
        suiteATest.createTest(suiteA);
        suite.addTestSuite(suiteA);
        return suite;
    }
}
