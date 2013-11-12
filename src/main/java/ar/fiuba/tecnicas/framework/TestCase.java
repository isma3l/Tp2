package ar.fiuba.tecnicas.framework;
/*
Responsabilidad: Ejecutar test con metodos que permitan ejecutar algo antes y algo despues del test
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class TestCase extends Test{
    private List<String> tags;
    public TestCase(String testname) {
        super(testname);
        tags= new ArrayList<String>();
    }
    public TestCase(String testname,List<String> tags) {
        super(testname);
        this.tags=tags;
    }
    @Override
    public void run(TestReport testReport) {
        testReport.run(this);
        testReport.setFirsttimeintest(false);
    }
    @Override
    public int countTestCases() {
        return 1;
    }
    public abstract void runTest();

    public void runTestSequence()throws Throwable{
        Throwable exception = null;
        setUp();
        try {
            runTest();
        } catch (Throwable running) {
            exception = running;
        } finally {
            tearingDown(exception);
        }
        if (exception != null) throw exception;
    }
    public void addTag(String tag){
        tags.add(tag);
    }
    public void addAllTags(List<String> tags){
        this.tags.addAll(tags);
    }
    public boolean containsTag(String tag){
        return tags.contains(tag);
    }
    public boolean containsAllTags(List<String> tags){
        return this.tags.containsAll(tags);
    }
    @Override
    public String toString() {
        return getTestname();
    }
}
