import java.util.regex.*;

public class IPChecker {
    public static void main(String[] args) {
        String ip = "133.255.200.001";
        
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]?)$");
        Matcher matcher = pattern.matcher(ip);
        
        if (matcher.matches()) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect.");
        }
    }
}
