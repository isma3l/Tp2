package ar.fiuba.tecnicas.framework;

import java.util.HashMap;
/*
Responsabilidad: Definir una interfaz para los elementos de la composicion
 */
public abstract class Test<T> {
    private String testname;
    private HashMap<String,T> context;
    public String getTestname() {
        return testname;
    }
    public Test(String testname) {
        this.testname = testname;
        context=new HashMap<String,T>();
    }

    public HashMap<String, T> getContext() {
        return context;
    }

    public abstract void run(TestReport testReport);
    public abstract int countTestCases();
    public void setUp() throws Exception {}
    public void tearDown() throws Exception {}

}
