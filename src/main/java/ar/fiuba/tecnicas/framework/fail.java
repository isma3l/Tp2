/*
    Falla una prueba y lanza un assertionError.
 */

package ar.fiuba.tecnicas.framework;

public class fail implements Test {
    private String message;

    public fail(String message) {
        this.message = message;
    }
    public void excecute(TestReport testreport)throws AssertionError{
        throw new AssertionError(message);
    }
}