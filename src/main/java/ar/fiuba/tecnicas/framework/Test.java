package ar.fiuba.tecnicas.framework;

public abstract class Test {
    public abstract void excecute(TestReport testReport);
    public void addTest(Test test) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Unsupported addTest");
    }
    public Test getChild(int idx) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Unsupported getChild");
    }
}
