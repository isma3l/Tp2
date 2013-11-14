package ar.fiuba.tecnicas.framework.Pruebas.Casos2;

import ar.fiuba.tecnicas.framework.*;

public class CaseUse1 implements TestCreator{
    @Override
    public Test getTest() throws Exception {
        TestSuite suite =new TestSuite("TS1");
        TestCase test1 = new MyTestCase("T1");
        TestCase test2 = new MyTestCase("T2");
        TestCase test3 = new MyTestCase("T3");

        test1.addTag("SLOW");
        test3.addTag("SLOW");

        suite.addTest(test1);
        suite.addTest(test2);
        suite.addTest(test3);
        return suite;
    }

    public static void main(String args[]) {
        TestCreator creatorTest = new CaseUse1();
        TestRunner.setCreatorTest(creatorTest);
        TestRunner.main(args);
    }
}
