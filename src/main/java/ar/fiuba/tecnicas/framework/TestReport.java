/*
    Se encarga de mostrar el resultado de los tests y lleva
    el rastreo de la cantidad de test que fueron ejecutados.
 */

package ar.fiuba.tecnicas.framework;

public class TestReport {
    private int excecutedtests;
    private String message;
    public TestReport() {
       excecutedtests=0;
       message= new String();
    }
    public synchronized void start(String testpassed){
        excecutedtests++;
        message=testpassed;
        System.out.println("TEST PASSED: "+Integer.toString(excecutedtests)+"\t"+message);
    }
}
