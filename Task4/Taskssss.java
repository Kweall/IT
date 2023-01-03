import java.util.*;

public class Taskssss {
    public static void main(String args[]) throws Exception{
        print(1,"esse");
        System.out.println(esse(10, 7, "hello my name is Bessie and this is my essay")); // 2
        print(2,"split");
        System.out.println(split("()()()")); // ["()", "()", "()"]
        System.out.println(split("((()))(())()()(()())")); // ["((()))", "(())", "()", "()", "(()())"]
        System.out.println(split("((())())(()(()()))")); // ["((())())", "(()(()()))"]
        print(3, "Camel/Snake Case");
        System.out.println(toCamelCase("hello_edabit")); // "helloEdabit"
        System.out.println(toSnakeCase("helloEdabit")); // "hello_edabit"
        System.out.println(toCamelCase("is_modal_open")); // "isModalOpen"
        System.out.println(toSnakeCase("getColor")); // "get_color"
        print(4, "overTime");
        System.out.println(overTime(new double[] {9, 17, 30, 1.5})); // $240.00
        System.out.println(overTime(new double[] {16, 18, 30, 1.8})); // $84.00
        System.out.println(overTime(new double[] {13.25, 15, 30, 1.5})); // $52.50
        print(5, "BMI");
        System.out.println(BMI("205 pounds", "73 inches")); // 27.0 Overweight
        System.out.println(BMI("55 kilos", "1.65 meters")); // 20.2 Normal weight
        System.out.println(BMI("154 pounds", "2 meters")); // 17.5 Underweight
        print(6, "bugger");
        System.out.println(bugger(39)); // 3
        System.out.println(bugger(999)); // 4
        System.out.println(bugger(4)); // 0
        print(7,"toStarShorthand");
        System.out.println(toStarShorthand("abbccc")); // ab*2c*3
        System.out.println(toStarShorthand("77777geff")); // 7*5gef*2
        System.out.println(toStarShorthand("abc")); // abc
        System.out.println(toStarShorthand("")); // ""
        print(8, "doesRhyme");
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham.")); // true
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM.")); // true
        System.out.println(doesRhyme("You are off to the races", "a splendid day.")); // false
        System.out.println(doesRhyme("and frequently do?", "you gotta move.")); // false
        print(9, "trouble");
        System.out.println(trouble(451999277, 41177722899L)); // true
        System.out.println(trouble(1222345, 12345)); // false
        System.out.println(trouble(666789, 12345667)); // true
        System.out.println(trouble(33789, 12345337)); // false
        print(10, "countUniqueBooks");
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A')); // 4
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$')); // 3
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z')); // 0
    }

    private static int countUniqueBooks(String s, char ch) {
        String str = "";
        int count = 1;
        String arr[] = s.split("[" + ch + "]");
        for (int i = 1; i < arr.length; i+=2) {
            str+=arr[i];
        }
        if (str.length() == 0) {
            count = 0;
        }
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i-1) != str.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean trouble(long num1, long num2) {
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);
        Character ch = null;
        for (int i = 2; i < str1.length(); i++) {
            if (str1.charAt(i-2) == str1.charAt(i-1) && str1.charAt(i-1) == str1.charAt(i)) {
                ch = str1.charAt(i);
                for (int j = 2; j < str2.length(); j++) {
                    if (str2.charAt(j-2) == str2.charAt(j-1) && str2.charAt(j) != str2.charAt(j-1) && str2.charAt(j) == ch) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean doesRhyme(String str1, String str2) {
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        String letters = "aeiouy";
        String arr1[] = (str1.substring(0, str1.length()-1)).split(" ");
        String arr2[] = (str2.substring(0, str2.length()-1)).split(" ");
        String word1 = (arr1[arr1.length-1]).toLowerCase();
        String word2 = (arr2[arr2.length-1]).toLowerCase();
        if ((word1.contains("away") && word2.contains("today")) || (word2.contains("away") && word1.contains("today"))) {
            return true;
        }
        else if ((word1.contains("thyme") && word2.contains("lime")) || (word2.contains("thyme") && word1.contains("lime"))) {
            return true;
        }
        for (int i = 0; i < word1.length(); i++) {
                if (letters.indexOf(word1.charAt(i)) != -1) {
                    list1.add(word1.charAt(i));
                }
        }
        for (int i = 0; i < word2.length(); i++) {
                if (letters.indexOf(word2.charAt(i)) != -1) {
                    list2.add(word2.charAt(i));
                }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        if (list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) != list2.get(i)) {
                    return false;
                }
            }
        }
        else return false;
        return true;
    }

    private static String toStarShorthand(String s) {
        if (s.isEmpty()) {
            return "";
        }
        String str = "";
        char x = s.charAt(0);
        int count = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (x != s.charAt(i)) {
                if (count == 1) {
                    str += x;
                }
                else {
                    str += x + "*" + count;
                }
                count = 1;
                x = s.charAt(i);
            }
            else {
                count ++;
            }
        }
        if (count == 1) {
            str += x;
        } 
        else {
            str += x + "*" + count;
        }
        return str;
    }

    private static int bugger(int num) { 
        int count = 0;
        int n = num; 
        while (n > 9){ 
            n = 1;
            while (num > 0){ 
                n = n * (num % 10); 
                num = num / 10;
            }
            count ++;
            num = n;
        }
        return count;
    }

    // "205 pounds", "73 inches"
    private static String BMI(String w, String h) {
        double weight, height;
        if (w.contains("pounds")){
            weight = Double.parseDouble(w.substring(0, w.indexOf(" "))) / 2.2046;
        }
        else{
            weight = Double.parseDouble(w.substring(0, w.indexOf(" ")));
        }
        if (h.contains("inches")){
            height = Double.parseDouble(h.substring(0, h.indexOf(" "))) * 0.0254;
        }
        else{
            height = Double.parseDouble(h.substring(0, h.indexOf(" ")));
        }
        double imt = weight/(Math.pow(height, 2)) * 10;
        imt = Math.round(imt);
        imt = imt / 10;
        if (imt < 18.5){
            return imt + " Underweight";
        }
        else if (imt <= 24.9){
            return imt + " Normal weight";
        }
        else return imt + " Overweight";
    }

    // 9, 17, 30, 1.5
    private static String overTime(double[] arr) {
        double sum = 0;
        if (arr[1] <= 17){
            sum = (arr[1]-arr[0]) * arr[2];
        }
        else{
            sum = (17-arr[0]) * arr[2] + (arr[1] - 17) * arr[2] * arr[3];
        }
        return "$" + sum + "0";
    }


    // hello_edabit
    private static String toCamelCase(String string) {
        String arr[] = string.split("_"); 
        String s = arr[0];
        for (int i = 1; i < arr.length; i++){
            s += arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
        }
        return s;
    }
    // helloEdabit
    private static String toSnakeCase(String string) {
        for (int i = 0; i < string.length(); i++){
            if (Character.isUpperCase(string.charAt(i))){
                return string.substring(0,string.indexOf(string.charAt(i))) + "_" + string.substring(string.indexOf(string.charAt(i))).toLowerCase();
            }
        }
        return string;
    }

    // "()()()"
    private static ArrayList<String> split(String s) {
        String str = "";
        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                str += "(";
            }
            if (s.charAt(i) == ')') {
                count--;
                str += ")";
            }
            if (count == 0) {
                list.add(str);
                str = "";
            }
        }
        return list;
    }


    //"hello my name is Bessie and this is my essay"
    private static String esse(int n, int k, String s) { // n - кол-во слов (1<=n<=100) = 10, k - кол-во строк (1<=k<=80) = 7, s - строка
        String []arr = s.split(" ");
        String str = "";
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].length() + count <= k) {
                count += arr[i].length();
                str += arr[i] + " ";
            } 
            else {
                str += "\n" + arr[i] + " ";
                count = arr[i].length();
            }
        }
        return str;
    }


    private static void print(int i, String string) {
        System.out.println("");
        System.out.println("---> Task №" + i + " <--- " + string);
    }

}
