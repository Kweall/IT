import java.util.*;

public class Tasksss {
    public static void main(String args[]) throws Exception{
        print(1,"solutions");
        System.out.println(solutions(1, 0, -1)); // 2
        System.out.println(solutions(1, 0, 0)); // 1
        System.out.println(solutions(1, 0, 1)); // 0
        print(2,"findZip");
        System.out.println(findZip("all zip files are zipped")); // 18
        System.out.println(findZip("all zip files are compressed")); // -1
        print(3, "checkPerfect");
        System.out.println(checkPerfect(6)); // true
        System.out.println(checkPerfect(28)); // true
        System.out.println(checkPerfect(496)); // true
        System.out.println(checkPerfect(12)); // false
        System.out.println(checkPerfect(97)); // false
        print(4, "flipEndChars");
        System.out.println(flipEndChars("Cat, dog, and mouse.")); // ".at, dog, and mouseC"
        System.out.println(flipEndChars("ada")); // "Two's a pair."
        System.out.println(flipEndChars("Ada")); // "adA"
        System.out.println(flipEndChars("z")); // "Incompatible."
        print(5, "isValidHexCode");
        System.out.println(isValidHexCode("#CD5C5C")); // true
        System.out.println(isValidHexCode("#EAECEE")); // true
        System.out.println(isValidHexCode("#eaecee")); // true
        System.out.println(isValidHexCode("#CD5C58C")); // false
        System.out.println(isValidHexCode("#CD5C5Z")); // false
        System.out.println(isValidHexCode("#CD5C&C")); // false
        System.out.println(isValidHexCode("CD5C5C")); // false
        print(6, "same");
        System.out.println(same(new Integer[] {1, 3, 4, 4, 4}, new Integer[] {2, 5, 7})); // true
        System.out.println(same(new Integer[] {9, 8, 7, 6}, new Integer[] {4, 4, 3, 1})); // false
        System.out.println(same(new Integer[] {2}, new Integer[] {3, 3, 3, 3, 3})); // true
        print(7,"isKaprekar");
        System.out.println(isKaprekar(3)); // false
        System.out.println(isKaprekar(5)); // false
        System.out.println(isKaprekar(297)); // true
        print(8, "longestZero");
        System.out.println(longestZero("01100001011000")); // "0000"
        System.out.println(longestZero("100100100")); // "00"
        System.out.println(longestZero("11111")); // ""
        print(9, "nextPrime");
        System.out.println(nextPrime(12)); // 13
        System.out.println(nextPrime(24)); // 29
        System.out.println(nextPrime(11)); // 11
        print(10, "rightTriangle");
        System.out.println(rightTriangle(3, 4, 5)); // true
        System.out.println(rightTriangle(145, 105, 100)); // true
        System.out.println(rightTriangle(70, 130, 110)); // false
    }


    private static boolean rightTriangle(int x, int y, int z) {
        if (x*x == y*y + z*z || y*y == x*x + z*z || z*z == y*y + x*x && x > 0 && y > 0 && z > 0){
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j <= i/2; j++) {
            if (i % j == 0)
                return false;
        }
        return true;
    }

    private static int nextPrime(int i) {
        if (i < 3){
            return 2;
        }
        while (!isPrime(i)){
            i += 1;
        }
        return i;
    }

    private static String longestZero(String str) {
        int max = 0;
        int now = 0;
        if (str.length() == 0){
            return "";
        }
        if (!str.contains("0")){
            return "";
        }
        if (str.length() == 1){
            if (str.charAt(0) == '0'){
                return "0";
            }
            else{
                return "";
            }
        }
        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i-1) == '0' && str.charAt(i) == '0'){
                now += 1;
            }
            else{
                max = Math.max(max, now);
                now = 1;
            }
        }
        return ('"'+"0".repeat(max)+'"');
    }

    private static boolean isKaprekar(int num) {
        int numm = num; // 297
        int n10 = 1; // кол-во цифр в числе 
        int number = num * num; // 88209
        int res = 0;
        int k = 10;
        while (number / 10 != 0){
            n10 += 1; // 5
            number = number / 10;
        }
        if (n10 % 2 == 0){
            res = (int) ((num * num / Math.pow(k, n10/2)) + (num * num % Math.pow(k, n10/2)));
        }
        else if(n10 == 1){
            res = number;
        }
        else{
            res = (int) ((num * num) / Math.pow(k, ((n10/2) + 1)) + ((num * num) % Math.pow(k, ((n10/2) + 1))));
        }
        if (numm == res){
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean same(Integer[] arr1, Integer[] arr2) {
        Set<Integer> set1 = new TreeSet<Integer>();
        set1.addAll(Arrays.asList(arr1));
        Set<Integer> set2 = new TreeSet<Integer>();
        set2.addAll(Arrays.asList(arr2));
        return set1.size() == set2.size();
    }

    private static boolean isValidHexCode(String arr) {
        return arr.matches("^#[a-f;A-F;0-9]{6}");
    }

    private static String flipEndChars(String arr) {
        String ans = "";
        if (arr.length() < 2){
            ans = "Incompatible.";
        }
        else{
            if (arr.charAt(0) == arr.charAt(arr.length()-1)){
                ans = "Two's a pair.";
            }
            else{
                for (int i = 0; i < arr.length(); i++){
                    ans = arr.charAt(arr.length() - 1) + "" + arr.subSequence(1, arr.length() - 1) + arr.charAt(0);
                }
            }
        }
        return ans;
    }

    private static boolean checkPerfect(int e) {
        int ans = 0;
        for (int i = 1; i < e; i++){
            if (e % i == 0){
                ans += i;
            }
        }
        if (ans == e){
            return true;
        }
        return false;
    }

    private static int findZip(String arr) {
        int ans = 0;
        int crack = -1;
        for (int i = 0; i < arr.length() - 2; i++){
            if (arr.charAt(i) == 'z' & arr.charAt(i+1) == 'i' & arr.charAt(i+2) == 'p'){
                ans += 1;
                if (ans == 2){
                    crack = i;
                    break;
                }
            }
        }
        return crack;
    }

    private static int solutions(int a, int b, int c) {
        int ans = 0;
        if (b*b-4*a*c == 0){
            ans = 1;
        }
        else if (b*b-4*a*c > 0){
            ans = 2;
        }
        else if (b*b-4*a*c < 0){
            ans = 0;
        }
        return ans;
    }

    private static void print(int i, String string) {
        System.out.println("");
        System.out.println("---> Task №" + i + " <--- " + string);
    }

}
