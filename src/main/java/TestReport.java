
public class TestReport {
    public int excecutedtests;

    public TestReport() {
       excecutedtests=0;
    }
    public void start(Test test){
        excecutedtests++;
    }
}
