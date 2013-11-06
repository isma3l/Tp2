package ar.fiuba.tecnicas.framework;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TestFailure{
    private Test failedTest;
    private Throwable thrownException;

    public TestFailure(Test failedTest, Throwable thrownException) {
        this.failedTest = failedTest;
        this.thrownException = thrownException;
    }
    public Test failedTest() {
        return failedTest;
    }
    public Throwable thrownException() {
        return thrownException;
    }
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(failedTest + ": " + thrownException.getMessage());
        return buffer.toString();
    }

    public String trace() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        thrownException().printStackTrace(writer);
        StringBuffer buffer = stringWriter.getBuffer();
        return buffer.toString();
    }

    public String exceptionMessage() {
        return thrownException().getMessage();
    }

    public boolean isFailure() {
        return (thrownException() instanceof AssertionError);
    }
}