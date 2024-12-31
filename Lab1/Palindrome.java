public class Palindrome {
    public static void main(String[] args){
        for (int i = 0; i < args.length; i++){
            String s = args[i];
            palindrome(s);
        }
    }

    public static String reverseString(String s){
        String newS = new String();
        for (int i = s.length()-1; i >= 0; i--){
            newS += s.charAt(i);
        }
        return newS;
    }

    public static boolean palindrome(String s){
        if (reverseString(s).equals(s)){
            System.out.println(s);
            return true;
        }
        return false;
    }
}
