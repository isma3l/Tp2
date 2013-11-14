package ar.fiuba.tecnicas.framework;

public abstract class  TestListener {
    public void addFailure(Test test, String time)throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Unsupported add failure operation");
    }
    public void addError(Test test, String time)throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Unsupported add error operation");
    }
    public void addSuccess(TestCase test, String time)throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Unsupported add success operation");
    }
    public void print(String messsage)throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Unsupported print operation");
    }
    public void insertHSeparator()throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Unsupported insert horizontal separator operation");
    }
}
