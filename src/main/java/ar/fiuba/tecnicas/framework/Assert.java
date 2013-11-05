package ar.fiuba.tecnicas.framework;

import java.util.Arrays;

public abstract class Assert<T> extends Test{
    public void assertArrayEquals(T[] expecteds, T[] actuals)throws AssertionError{
        if (!Arrays.equals(expecteds, actuals)) throw new AssertionError();
    }
    public void assertArrayEquals(String message, T[] expecteds, T[] actuals)throws AssertionError{
        if (!Arrays.equals(expecteds,actuals)) throw new AssertionError(message);
    }
    public void assertEquals(double expected, double actual, double delta)throws AssertionError{
        double realdelta= Math.abs(expected-actual);
        if (realdelta>delta) throw new AssertionError();
    }
    public void assertEquals(String message, double expected, double actual, double delta)throws AssertionError{
        double realdelta= Math.abs(expected-actual);
        if (realdelta>delta) throw new AssertionError(message);
    }
    public void assertEquals(T expected, T actual)throws AssertionError{
        if (!expected.equals(actual)) throw new AssertionError();
    }
    public void assertEquals(String message, T expected, T actual)throws AssertionError{
        if (!expected.equals(actual)) throw new AssertionError(message);
    }
    public void assertFalse(boolean condition)throws AssertionError{
        if (condition) throw new AssertionError();
    }
    public void assertFalse(String message, boolean condition)throws AssertionError{
        if (condition) throw new AssertionError(message);
    }
    public void assertNotNull(T object)throws AssertionError{
        if (object ==null) throw new AssertionError();
    }
    public void assertNotNull(String message, T object)throws AssertionError{
        if (object==null) throw new AssertionError(message);
    }
    public void assertNotSame(T unexpected, T actual)throws AssertionError{
         if (unexpected==actual) throw new AssertionError();
    }
    public void assertNotSame(String message, T unexpected, T actual)throws AssertionError{
        if (unexpected==actual) throw  new AssertionError(message);
    }
    public void assertNull(T object)throws AssertionError{
        if (object!=null) throw new AssertionError();
    }
    public void assertNull(String message, T object)throws AssertionError{
        if (object!= null) throw new AssertionError(message);
    }
    public void assertSame(T expected, T actual)throws AssertionError{
        if (expected!=actual) throw new AssertionError();
    }
    public void assertSame(String message, T expected, T actual)throws AssertionError{
        if (expected!=actual) throw new AssertionError(message);
    }
    public <k> void assertThat(String reason, T actual, org.hamcrest.Matcher<k> matcher)throws AssertionError{
        if (!matcher.matches(actual)) throw new AssertionError(reason);
    }
    public <k> void assertThat(T actual, org.hamcrest.Matcher<k> matcher)throws AssertionError{
        if (!matcher.matches(actual)) throw new AssertionError();
    }
    public void assertTrue(boolean condition)throws AssertionError{
        if (!condition) throw new AssertionError();
    }
    public void assertTrue(String message, boolean condition)throws AssertionError{
        if (!condition) throw new AssertionError(message);
    }
    public void fail()throws AssertionError{
        throw new AssertionError();
    }
    public void fail(String message)throws AssertionError{
        throw new AssertionError(message);
    }
}
