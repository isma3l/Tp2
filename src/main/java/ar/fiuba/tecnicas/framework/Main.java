package ar.fiuba.tecnicas.framework;

public class Main {
    public static void main(String[] args) {
        AssertsBuilder assertbuilder= AssertsBuilder.getInstance();
        Test tests= assertbuilder.makeAll();
        Test assertTest=assertbuilder.makePart();
        tests.addTest(assertTest);
        TestReport testReport= new TestReport();
        tests.excecute(testReport);
    }
}
