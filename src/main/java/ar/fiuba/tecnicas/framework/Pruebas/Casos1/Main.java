package ar.fiuba.tecnicas.framework.Pruebas.Casos1;

import ar.fiuba.tecnicas.framework.TestRunner;

public class Main {

    public static void main(String args[]) {
        AllTests allTests = new AllTests();
        TestRunner.setCreatorTest(allTests);
        TestRunner.main(args);
    }
}
