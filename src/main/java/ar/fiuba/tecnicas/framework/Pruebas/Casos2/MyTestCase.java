package ar.fiuba.tecnicas.framework.Pruebas.Casos2;


import ar.fiuba.tecnicas.framework.Assert;
import ar.fiuba.tecnicas.framework.TestCase;

public class MyTestCase extends TestCase {
    public MyTestCase(String testname) {
        super(testname);
    }

    @Override
    public void runTest() {
        Assert.assertFalse(false);
        Assert.assertTrue(true);
    }
}
