package ar.fiuba.tecnicas.framework;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PatternRecognizer {
    private Pattern pattern;
    private Matcher matcher;

    public PatternRecognizer(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public boolean matchName(String name) {
        matcher = pattern.matcher(name);
        return matcher.find();
    }
}

