public class SumArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = array.length;
        
        Thread thread1 = new Thread(() -> {
            sumArrayPart(array, 0, n / 2);
        });
        
        Thread thread2 = new Thread(() -> {
            sumArrayPart(array, n / 2, n);
        });

        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(sum1 + sum2);
    }

    static int sum1 = 0, sum2 = 0;

    public static void sumArrayPart(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        if (start == 0) {
            sum1 = sum;
        } else {
            sum2 = sum;
        }
    }
}