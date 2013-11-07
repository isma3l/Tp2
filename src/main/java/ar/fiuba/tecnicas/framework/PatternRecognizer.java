package ar.fiuba.tecnicas.framework;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PatternRecognizer {
    private Pattern pattern;
    private Matcher matcher;
    private String regularExpression;

    public PatternRecognizer(String expression) {
        regularExpression = expression;
        pattern = Pattern.compile(expression);
    }

    public boolean matchName(String nameTest) {
        if(!regularExpression.equals("")) {
            matcher = pattern.matcher(nameTest);
            return matcher.find();
        }
        else
            return true;
    }
}

