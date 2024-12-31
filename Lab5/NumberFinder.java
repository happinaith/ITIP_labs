import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "apple costs 25 and water 15";
        
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
