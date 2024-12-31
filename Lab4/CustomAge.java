import java.io.*;
import java.util.Scanner;

public class CustomAge {
    static class CustomAgeException extends Exception {
        public CustomAgeException(String message) {
            super(message);
        }
    }

    static class ExceptionLogger {
        private static final String LOG_FILE = "exceptions.txt";
        public static void logException(Exception e) {
            try (FileWriter fileWriter = new FileWriter(LOG_FILE, true);
                 PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println("Exception: " + e.getClass().getName() + " - " + e.getMessage());
            } catch (IOException ioException) {
                System.out.println("Ошибка при логировании исключения: " + ioException.getMessage());
            }
        }
    }
    static class AgeValidator {
        public static void validateAge(int age) throws CustomAgeException {
            if (age < 0 || age > 120) {
                throw new CustomAgeException("Недопустимый возраст: " + age);
            }
        }
        public static int getAgeFromUser() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите ваш возраст: ");
            return scanner.nextInt();
        }
    }
    public static void main(String[] args) {
        try {
            int age = AgeValidator.getAgeFromUser();
            AgeValidator.validateAge(age);
            
            System.out.println("Возраст принят: " + age);
        } catch (CustomAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
            ExceptionLogger.logException(e);
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
            ExceptionLogger.logException(e);
        }
    }
}
