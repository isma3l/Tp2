package ar.fiuba.tecnicas.framework;

import static org.hamcrest.CoreMatchers.is;

public class Main {


    public static void main(String[] args) {
        AssertsBuilder assertbuilder= AssertsBuilder.getInstance();
        Test tests= assertbuilder.makeAll();
        Test assertTest=assertbuilder.makePart();
        tests.addTest(assertTest);
        TestWithFramework testSuite = new TestWithFramework(tests);
        testSuite.excecute();
    }
}
