package ar.fiuba.tecnicas.framework;

public class TestWithFramework{
    private Test test;
    private TestReport testReport;
    public TestWithFramework(Test test) {
        this.test = test;
        this.testReport=new TestReport();
    }
    public  void excecute(){
       test.excecute(testReport);
    }
}
