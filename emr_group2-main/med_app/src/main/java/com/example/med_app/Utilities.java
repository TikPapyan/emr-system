package com.example.med_app;

public class Utilities {
    public static String getYearsOptions(int from, int to) {
        String res = "";
        for (int i=from; i<=to; ++i) {
            res += "<option value=\"" + i + "\">" + i + "</option>\"\n";
        }
        return res;
    }
}
