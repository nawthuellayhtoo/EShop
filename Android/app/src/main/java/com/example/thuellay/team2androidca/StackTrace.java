package com.example.thuellay.team2androidca;

/**
 * Created by ThueLlay on 12/20/2016.
 */
import java.io.PrintWriter;
import java.io.StringWriter;

public class StackTrace {
    public static String trace(Exception ex) {
        StringWriter outStream = new StringWriter();
        ex.printStackTrace(new PrintWriter(outStream));
        return outStream.toString();
    }
}