package ar.fiuba.tecnicas.framework;

public class Main {
    public static void main(String[] args) {
        TestWithFramework testwithframework= new TestWithFramework();
        TestReport testReport= new TestReport();
        testwithframework.excecute(testReport);
    }
}
