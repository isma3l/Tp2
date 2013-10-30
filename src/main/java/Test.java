
public abstract class Test {
    public abstract void excecute(TestReport testReport);
    public TestReport excecute(){
        TestReport testReport=new TestReport();
        excecute(testReport);
        return testReport;
    }
}
