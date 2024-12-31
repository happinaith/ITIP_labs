import java.util.regex.*;

public class CapitalWords {
    public static void main(String[] args) {
        String text = "Hello wOrld This is my messAge!";
        Pattern pattern = Pattern.compile("([a-z])([A-Z])");
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll("!$1$2!");
        System.out.println(result);
    }
}

