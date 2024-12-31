import java.util.Arrays;

/*
 * Полуднева Юлиана
 * Группа: БВТ2306
 */

class Task_1yr{
    public static void main(String[] args){
        // 1 zadacha
        System.out.println("Задача 1:");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8) + "\n");

        //System.out.println();
        // 2 zadacha
        System.out.println("Задача 2:");
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3) + "\n");

        // 3 zadacha
        System.out.println("Задача 3:");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4) + "\n");

        // 4 zadacha
        System.out.println("Задача 4:");
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1) + "\n");

        // 5 zadacha
        System.out.println("Задача 5:");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9) + "\n");

        // 6 zadacha
        System.out.println("Задача 6:");
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2) + "\n");

        // 7 zadacha
        System.out.println("Задача 7:");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7) + "\n");

        // 8 zadacha
        System.out.println("Задача 8:");
        System.out.println(gcd(48,18));
        System.out.println(gcd(52,8));
        System.out.println(gcd(259,28) + "\n");

        // 9 zadacha
        System.out.println("Задача 9:");
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250) + "\n");

        // 10 zadacha
        System.out.println("Задача 10:");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58) + "\n");

    }
    public static double convert(int gal){
        return gal * 3.785;
    }

    public static int fitCalc(int min, int intense){
        return min * intense;
    }

    public static int containers(int box, int bag, int barrel){
        return box * 20 + bag * 50 + barrel * 100;
    }

    public static String triangleType(int x, int y, int z){

        int[] xyzArr = {x,y,z};
        Arrays.sort(xyzArr);

        if (xyzArr[0] + xyzArr[1] <= xyzArr[2]){
            return "not a triangle";
        }
        if (x == y & y == z){
            return "isosceles";
        }
        if (x == y || y == z || z == x){
            return "equilateral";
        }
        return "different-sided";
    }

    public static int ternaryEvaluation(int a, int b){
        return a > b ? a: b;
    }

    public static double howManyItems(double n, double w, double h){
        return (int)((n/2)/(w*h));
    }

    public static int factorial(int n){
        if (n == 1) return n;
        return factorial(n-1)*n;
    }

    public static int gcd(int a, int b){
        int[] newArr = {a,b};
        Arrays.sort(newArr);
        int bDel = 1;

        for (int i = 1; i <= newArr[1]; i++){
            if(a%i == 0 && b%i == 0){
                bDel = i;
            }
        }
        return bDel;
    }

    public static int ticketSaler(int numtick, int price){
        double percent = 0.28;
        int blackSum = numtick * price; 
        double percentSum = blackSum * percent;
        return blackSum - (int)percentSum;
    }

    public static int tables(int student, int table){
        int mest = table*2;
        if (student < mest){
            return 0;
        }
        int neededSpace = student - mest;
        if(neededSpace%2 == 0){
            return neededSpace/2;
        }
        return neededSpace/2 + 1;
    }
}