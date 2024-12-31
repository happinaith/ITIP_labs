import java.util.regex.*;

public class PasswordChecker {
    public static void main(String[] args) {
        String password = "1234a";
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");

        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            System.out.println("Correct.");
        } else {
            System.out.println("Incorrect.");
        }
    }
}
