import java.util.regex.*;

public class WordFinder {
    public static void main(String[] args) {
        String text = "hello world i need to send this message to everyone and me hungry";
        char startingLetter = 'm';
        Pattern pattern = Pattern.compile("\\b" + startingLetter + "\\w*\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
