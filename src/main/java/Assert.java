
public class Assert implements Test {

    @Override
    public void excecute(TestReport testreport) {

    }
    public void assertArrayEquals(byte[] expecteds, byte[] actuals){}
    public void assertArrayEquals(char[] expecteds, char[] actuals){}
    public void assertArrayEquals(int[] expecteds, int[] actuals){}
    public void assertArrayEquals(long[] expecteds, long[] actuals){}
    public void assertArrayEquals(short[] expecteds, short[] actuals){}
    public void assertArrayEquals(String message, byte[] expecteds, byte[] actuals){}
    public void assertArrayEquals(String message, char[] expecteds, char[] actuals){}
    public void assertArrayEquals(String message, int[] expecteds, int[] actuals){}
    public void assertArrayEquals(String message, long[] expecteds, long[] actuals){}
    public void assertArrayEquals(String message,Object[] expecteds,Object[] actuals){}
    public void assertArrayEquals(String message, short[] expecteds, short[] actuals){}
    public void assertEquals(double expected, double actual, double delta){}
    public void assertEquals(long expected, long actual){}
    public void assertEquals(Object expected, Object actual){}
    public void assertEquals(String message, double expected, double actual, double delta){}
    public void assertEquals(String message, long expected, long actual){}
    public void assertEquals(String message,Object expected,Object actual){}
    public void assertFalse(boolean condition){}
    public void assertFalse(String message, boolean condition){}
    public void assertNotNull(Object object){}
    public void assertNotNull(String message, Object object){}
    public void assertNotSame(Object unexpected, Object actual){}
    public void assertNotSame(String message,Object unexpected,Object actual){}
    public void assertNull(Object object){}
    public void assertNull(String message,Object object){}
    public void assertSame(Object expected, Object actual){}
    public void assertSame(String message,Object expected,Object actual){}
    public <T> void assertThat(String reason, T actual, org.hamcrest.Matcher<T> matcher){}
    public void assertTrue(boolean condition){}
    public void assertTrue(java.lang.String message, boolean condition){}
    public void fail(){}
    public void fail(java.lang.String message){}
}
