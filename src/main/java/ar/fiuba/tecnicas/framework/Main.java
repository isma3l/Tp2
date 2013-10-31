package ar.fiuba.tecnicas.framework;

public class Main {
    public static void main(String[] args) {
        Test assertTest= new TestSuite();
        TestWithFramework testSuite = new TestWithFramework(assertTest);
        testSuite.excecute();
    }
}
