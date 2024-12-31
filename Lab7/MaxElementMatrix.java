public class MaxElementMatrix {
    public static void main(String[] args) throws InterruptedException {
        int rows = 2;
        int cols = 2;
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }

        int[] rowMaxValues = new int[rows];
        Thread[] threads = new Thread[rows];

        for (int i = 0; i < rows; i++) {
            final int rowIndex = i;
            threads[i] = new Thread(() -> {
                rowMaxValues[rowIndex] = findMaxInRow(matrix, rowIndex);
            });
            threads[i].start();
        }

        for (int i = 0; i < rows; i++) {
            threads[i].join();
        }

        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            if (rowMaxValues[i] > maxElement) {
                maxElement = rowMaxValues[i];
            }
        }

        System.out.println(maxElement);
    }
    
    public static int findMaxInRow(int[][] matrix, int rowIndex) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[rowIndex].length; i++) {
            if (matrix[rowIndex][i] > max) {
                max = matrix[rowIndex][i];
            }
        }
        return max;
    }
}