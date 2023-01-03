import java.util.*;

public class Taskssssss {
    public static void main(String args[]) throws Exception{
        print(1,"bell");
        System.out.println(bell(1)); // 
        System.out.println(bell(2)); // 
        System.out.println(bell(3)); // 
        print(2,"translateWord / translateSentence");
        System.out.println(translateWord("flag")); // lagfay
        System.out.println(translateWord("Apple")); // Appleyay
        System.out.println(translateWord("button")); // uttonbay
        System.out.println(translateWord("")); //  
        System.out.println(translateSentence("I like to eat honey waffles.")); // Iyay ikelay otay eatyay oneyhay afflesway.
        System.out.println(translateSentence(translateSentence("Do you think it is going to rain today?"))); // Oday youyay inkthay ityay isyay oinggay otay ainray odaytay?
        print(3, "validColor");
        System.out.println(validColor("rgb(0,0,0)")); // true
        System.out.println(validColor("rgb(0,,0)")); // false
        System.out.println(validColor("rgb(255,256,255)")); // false
        System.out.println(validColor("rgba(0,0,0,0.123456789)")); // true
        print(4, "sstripUrlParams");
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2")); // 
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[] {"b"})); // 
        System.out.println(stripUrlParams("https://edabit.com", new String[] {"b"})); // 
        print(5, "getHashTags");
        System.out.println(getHashTags("How the Avocado Became the Fruit of the Global Trade")); // ["#avocado", "#became", "#global"]
        System.out.println(getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year")); // ["#christmas", "#probably", "#will"]
        System.out.println(getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit")); // ["#surprise", "#parents", "#fruit"]
        System.out.println(getHashTags("Visualizing Science")); // ["#visualizing", "#science"]
        print(6, "ulam");
        System.out.println(ulam(4)); // 4
        System.out.println(ulam(9)); // 16
        System.out.println(ulam(206)); // 1856
        print(7,"longestNonrepeatingSubstring");
        System.out.println(longestNonrepeatingSubstring("abcabcbb")); // "abc"
        System.out.println(longestNonrepeatingSubstring("aaaaaa")); // "a"
        System.out.println(longestNonrepeatingSubstring("abcde")); // "abcde"
        System.out.println(longestNonrepeatingSubstring("abcda")); // "abcd"
        print(8, "convertToRoman");
        System.out.println(convertToRoman(2)); // "II"
        System.out.println(convertToRoman(12)); // "XII"
        System.out.println(convertToRoman(16)); // "XVI"
        print(9, "formula");
        System.out.println(formula("6 * 4 = 24")); // true
        System.out.println(formula("18 / 17 = 2")); // false
        System.out.println(formula("16 * 10 = 160 = 14 + 120")); // false
        print(10, "palindromeDescendant");
        System.out.println(palindromeDescendant(11211230));
        System.out.println(palindromeDescendant(13001120));
        System.out.println(palindromeDescendant(23336014));
        System.out.println(palindromeDescendant(11));
    }

    private static boolean palindrome(int n) {
        String a = Integer.toString(n);
        String b = "";
        for (int i = a.length() - 1 ; i >= 0; i--) {
            b += a.charAt(i);
        }
        if (Integer.parseInt(a) != Integer.parseInt(b)) {
            return false;
        }
        return true;
    }


    // 11211230 --> 2333 --> 56 --> 11
    private static int sumNum(int n) {
        String a = Integer.toString(n);
        String b = "";
        for (int i = 1; i < a.length(); i += 2) {
            int x = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(a.charAt(i-1));
            b += Integer.toString(x);
        }
        return Integer.parseInt(b);
    }

    private static boolean palindromeDescendant(int n) {
        int x = n;
        if (palindrome(n)) {
            return true;
        }
        else while (Integer.toString(x).length() % 2 == 0) {
            x = sumNum(x);
            if (palindrome(x)) {
                return true;
            }
        }
        return false;
    }

    // "6 * 4 = 24"
    private static boolean formula(String str) {
        if (str.substring(str.indexOf("=") + 1).contains("=")) {
            return false;
        }
        String[] arr = str.split(" [+-/=\\*] ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);
        if (str.contains("+") && a + b == c) {
            return true;
        }
        else if (str.contains("-") && a - b == c) {
            return true;
        }
        else if (str.contains("*") && a * b == c) {
            return true;
        }
        else if (str.contains("/") && a / b == c) {
            return true;
        }
        return false;
    }


    private static String convertToRoman(int n) {
        String roman = "";
        while (n - 1000 >= 0) {
            n -= 1000;
            roman += "M";
        }
        while (n - 900 >= 0) {
            n -= 900;
            roman += "CM";
        }
        while (n - 500 >= 0) {
            n -= 500;
            roman += "D";
        }
        while (n - 400 >= 0) {
            n -= 400;
            roman += "CD";
        }
        while (n - 100 >= 0) {
            n -= 100;
            roman += "C";
        }
        while (n - 90 >= 0) {
            n -= 90;
            roman += "XC";
        }
        while (n - 50 >= 0) {
            n -= 50;
            roman += "L";
        }
        while (n - 40 >= 0) {
            n -= 40;
            roman += "XL";
        }
        while (n - 10 >= 0) {
            n -= 10;
            roman += "X";
        }
        while (n - 9 >= 0) {
            n -= 9;
            roman += "IX";
        }
        while (n - 5 >= 0) {
            n -= 5;
            roman += "V";
        }
        while (n - 4 >= 0) {
            n -= 4;
            roman += "IV";
        }
        while (n - 1 >= 0) {
            n -= 1;
            roman += "I";
        }
        return roman;
    }

    // "abcabcbb" --> "abc"
    // "aaaaaa" --> "a"

    private static String longestNonrepeatingSubstring(String s) {
        ArrayList<String> list = new ArrayList<>();
        String a = "";
        String b = "";
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i) + "")) {
                if (b.length() > a.length()) {
                    a = b;
                }
                b = s.charAt(i) + "";
                // list.clear();
            }
            else {
                list.add(s.charAt(i) + "");
                b += s.charAt(i) + "";
                if (b.length() > a.length()) {
                    a = b;
                }
            }
        }
        return a;
    }



    private static int ulam(int n) {
        ArrayList<Integer> list = new ArrayList<>(n);
        list.add(1);
        list.add(2);
        list.add(3);
        int max = 3;
        int num = 4;
        while (list.size()+1 <= n) {
            int count = 0;
            int find = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                if (num < max) {
                    num++;
                    continue;
                }
                find = num - list.get(i);
                for (int j = list.size() - 1; j > i; j--) {
                    if (list.get(j) == list.get(i)) {
                        num++;
                        break;
                    }
                    if (find == list.get(j)) {
                        count++;
                        break;
                    }
                }
                
            }
            if (count == 1) {
                list.add(num);
                max = num;
            }
            num++;
        }
        return list.get(n-1);
    }


    // "Hey Parents, Surprise, Fruit Juice Is Not Fruit" ----> ["#surprise", "#parents", "#fruit"]
    // surprise parents fruit juice fruit hey not is


    private static ArrayList<String> getHashTags(String s) {
        ArrayList<String> list = new ArrayList<>();
        String str = "";
        s = s.toLowerCase().replace(",", " ");
        String[] arr = s.split(" ");
        if (arr.length < 3){
            if (arr[0].length() < arr[1].length()){
                list.add("#" + arr[1]);
                list.add("#" + arr[0]);
            }
            else{
                list.add("#" + arr[0]);
                list.add("#" + arr[1]);
            }
        }
        else{
            for(int i = 1; i < arr.length; i++) {
                for(int j = arr.length-1; j >= i; j--) {
                    if(arr[j-1].length() < arr[j].length()){
                        str = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = str;
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                list.add("#" + arr[i]);
            }
        }
        return list;
    }

    // "https://edabit.com?a=1&b=2&a=2", ["b"]           ----->      "https://edabit.com?a=2"

    private static String stripUrlParams(String url) {
        return stripUrlParams(url, new String[] { "" });
    }

    private static String stripUrlParams(String url, String[] arr) {
        String s = "";
        ArrayList<String> list = new ArrayList<>();
        if (url.contains("?")) {
            s = url.substring(url.indexOf("?") + 1);
            url = url.substring(0, url.indexOf("?") + 1);
        }
        else {
            return url;
        }
        String[] arr1 = s.split("&");
        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            list.add(arr1[i]);
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).substring(0, 1).equals(list.get(i-1).substring(0, 1))) {
                list.remove(i-1);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).substring(0, 1).equals(arr[0])) {
                list.remove(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            url += list.get(i) + "&";
        }
        return url.substring(0,url.length()-1);
    }

    // rgb(0,0,0)
    private static boolean validColor(String s) {
        if (s.substring(0,4).contains("rgb(") && s.substring(s.length()-1).contains(")")) {
            s = s.substring(4, s.length() - 1);
        }
        else if (s.substring(0, 5).contains("rgba(") && s.substring(s.length()-1).contains(")")) {
            s = s.substring(5, s.length() - 1);
        }
        String[] arr1 = s.split(",");
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].isEmpty()) return false;
        } 
        double[] arr2 = new double[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = Double.parseDouble(arr1[i]);
        }
        if (arr2.length == 3) {
            for (int i = 0; i < arr2.length; i++) {
                int b = (int) arr2[i];
                if (b >= 0 && b <= 255) continue;
                else return false;
            }
        }
        if (arr2.length == 4) {
            for (int i = 0; i < arr2.length - 1; i++) {
                int b = (int) arr2[i];
                if (b >= 0 && b <= 255) continue;
                else return false;
            }
            if (arr2[arr2.length - 1] >= 0 && arr2[arr2.length - 1] <= 1) return true;
        }
        return true;
    }
    




    // I like to eat honey waffles. --> Iyay ikelay otay eatyay oneyhay afflesway.
    private static String translateSentence(String s) {
        String symbol = s.substring(s.length()-1);
        String res = "";
        String[] arr = s.substring(0,s.length()-1).split(" ");
        res = translateWord(arr[0]);
        for (int i = 1; i < arr.length; i++){
            res += " " + translateWord(arr[i]);
        }
        return res + symbol;
    }


    // flag --> agflay
    private static String translateWord(String s) {
        String gl = "aeyuioAEYUIO";
        int n = 0;
        if (s.isEmpty()) {
            return "";
        }
        if (gl.indexOf(s.charAt(0)) != -1) {
            s += "yay";
        }
        else {
            while (gl.indexOf(s.charAt(n)) == -1) {
                n++;
            }
            if (Character.isUpperCase(s.charAt(0))) {
                s = s.substring(n, n + 1).toUpperCase() + s.substring(n + 1) + s.substring(0, n).toLowerCase() + "ay";
            } 
            else s = s.substring(n) + s.substring(0, n) + "ay";
        }
        return s;
    }

    private static int bell(int n) {
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int bell = 1;
        arr1[0] = bell;
        for (int i = 1; i < n; i++){
            arr2[0] = bell;
            for (int j = 1; j < i + 1; j++){
                arr2[j] = bell + arr1[j-1];
                bell = arr2[j];
            }
            bell = arr2[i];
            for (int j = 0; j < n; j++){
                arr1[j] = arr2[j];
            }
        }
        return bell;
    }

    private static void print(int i, String string) {
        System.out.println("");
        System.out.println("---> Task №" + i + " <--- " + string);
    }

}
