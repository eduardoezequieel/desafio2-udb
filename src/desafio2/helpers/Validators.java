package desafio2.helpers;

import java.util.regex.Pattern;

public class Validators {
    private static String noMaliciousCharactersRegex = "^[a-zA-Z0-9_@./#&+-]*$";
    
    public static String getNoMaliciousCharactersRegex() {
        return noMaliciousCharactersRegex;
    }
    
    public static boolean checkTextLength(String text, int allowedText) {
        if (text.length() > allowedText) return false;
        
        return true;
    }
    
    public static boolean matchesRegex(String text, String regex) {
        return Pattern.matches(regex, text);
    }
}
