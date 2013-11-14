package ar.fiuba.tecnicas.framework;


import java.text.NumberFormat;

public class Timer {
    private static long startTime;

    public static void initialize() {
        long startTime = System.currentTimeMillis();
    }

    public static String getTime() {
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        return NumberFormat.getInstance().format((double) runTime / 1000);
    }
}
