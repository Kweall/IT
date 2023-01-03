public class Palindrome {
    public static void main(String[] args){
        for (int i = 0; i < args.length; ++i){
            System.out.println(args[i] + " " + isPalindrome(args[i]));
        }
    }
    //функция для переворота строки
    public static String reverseString(String s){
        String result = "";
        int length = s.length() - 1;

        for (int i = length; i>=0; i--){
            result += s.charAt(i);
        }
        return result;
    }
    //функция, проверяющая строку на полиндромность
    public static boolean isPalindrome(String s){
        return s.equals(reverseString(s));
    }
}
