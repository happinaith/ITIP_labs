public class ArrayArithm {
    public static void main(String[] args) {
        // Пример массива
        String[] arr = {"1", "2", "3", "4", "5"};
        double sum = 0;
        int count = 0;
        
        try {
            for (String element : arr) {
                try {
                    int num = Integer.parseInt(element);
                    sum += num;
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: элемент массива не является числом: " + element);
                    continue;
                }
            }
            if (count > 0) {
                double average = sum / count;
                System.out.println("Среднее арифметическое: " + average);
            } else {
                System.out.println("Нет числовых элементов для вычисления среднего.");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива.");
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
        }
    }
}
