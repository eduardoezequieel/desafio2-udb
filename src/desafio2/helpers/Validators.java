package desafio2.helpers;

import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Validators {
    private static String noMaliciousCharactersRegex = "^[a-zA-Z0-9_@./#&+\\- ]*$";
    
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
    
    public static void allowNumbers(JTextField textField, int maxLength) {
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (isInteger(string) && (fb.getDocument().getLength() + string.length() <= maxLength)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (isInteger(text) && (fb.getDocument().getLength() - length + text.length() <= maxLength)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean isInteger(String texto) {
                try {
                    Integer.parseInt(texto);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        });
    }

}
