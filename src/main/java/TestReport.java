
public class TestReport {
    private int excecutedtests;
    private String message;
    public TestReport() {
       excecutedtests=0;
    }
    public void start(String testpassed){
        excecutedtests++;
        message.concat(testpassed+"\n");
        System.out.println("TEST PASSED: "+Integer.toString(excecutedtests)+"\t"+message);
    }
}
