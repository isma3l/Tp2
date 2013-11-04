package ar.fiuba.tecnicas.framework;

public interface TestBuilder {
    TestSuite makeAll();
    Test    makePart();
}
