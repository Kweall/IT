import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tasksssss {
    public static void main(String args[]) throws Exception{
        print(1,"encrypt / decrypt");
        System.out.println(encrypt("Hello")); // [72, 29, 7, 0, 3]
        System.out.println(decrypt(new int [] {72, 33, -73, 84, -12, -3, 13, -13, -68 })); // "Hi there!"
        System.out.println(encrypt("Sunshine")); // [83, 34, -7, 5, -11, 1, 5, -9]
        print(2,"canMove");
        System.out.println(canMove("Rook", "A8", "H8")); // true
        System.out.println(canMove("Bishop", "A7", "G1")); // true
        System.out.println(canMove("Queen", "C4", "D6")); // false
        print(3, "canComplete");
        System.out.println(canComplete("butl", "beautiful")); // true
        System.out.println(canComplete("butlz", "beautiful")); // false
        System.out.println(canComplete("tulb", "beautiful")); // false
        System.out.println(canComplete("bbutl", "beautiful")); // false
        print(4, "sumDigProd");
        System.out.println(sumDigProd(16, 28)); // 6
        System.out.println(sumDigProd(0)); // 6
        System.out.println(sumDigProd(1, 2, 3, 4, 5, 6)); // 6
        print(5, "sameVowelGroup");
        System.out.println(sameVowelGroup(new String [] {"toe", "ocelot", "maniac"})); // ["toe", "ocelot"]
        System.out.println(sameVowelGroup(new String [] {"many", "carriage", "emit", "apricot", "animal"})); // ["many"]
        System.out.println(sameVowelGroup(new String [] {"hoops", "chuff", "bot", "bottom"})); // ["hoops", "bot", "bottom"]
        print(6, "validateCard");
        System.out.println(validateCard(1234567890123456L)); // false
        System.out.println(validateCard(1234567890123452L)); // true
        print(7,"numToEng / numToRus");
        System.out.println(numToEng(0)); // "zero"
        System.out.println(numToEng(18)); // "eighteen"
        System.out.println(numToEng(126)); // "one hundred twenty six"
        System.out.println(numToEng(909)); // "nine hundred nine"
        System.out.println(numToRus(0)); // "ноль"
        System.out.println(numToRus(18)); // "восемнадцать"
        System.out.println(numToRus(126)); // "сто двадцать шесть"
        System.out.println(numToRus(909)); // "шестьсот девять"
        print(8, "getSha256Hash");
        System.out.println(getSha256Hash("password123"));
        System.out.println(getSha256Hash("Fluffy@home"));
        System.out.println(getSha256Hash("Hey dude!"));
        print(9, "correctTitle");
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(correctTitle("sansa stark, lady of winterfell.")); 
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
        print(10, "hexLattice");
        System.out.println(hexLattice(1));
        System.out.println(hexLattice(7));
        System.out.println(hexLattice(19));
        System.out.println(hexLattice(21));
    }

    private static String hexLattice(int n) {
        int count = 1;
        int i = 0;
        int step = 6;
        // Проверяем является ли число центрированным шестиугольным
        // находим количество итераций
        while (count < n) {
            i++;
            count += step * i;
        }
        if (count == n) {
            String s = "";
            int space = i;
            // Строки до центра включая
            for (int j = 0; j < i + 1; j++) {
                String line = "";
                line += " ".repeat(space - j);
                String middle = "";
                middle += "o ".repeat(i + 1 + j);
                middle = middle.strip();
                line += middle;
                line += " ".repeat(space - j) + "\n";
                s += line;
            }
            // Строки от центра
            for (int j = i - 1; j >= 0; j--) {
                String line = "";
                line += " ".repeat(space - j);
                String middle = "";
                middle += "o ".repeat(i + 1 + j);
                middle = middle.strip();
                line += middle;
                line += " ".repeat(space - j) + "\n";
                s += line;
            }
            return s;
        } 
        else return "Invalid";
    }

    private static String correctTitle(String s) {
        String str = "";
        String arr[] = s.toLowerCase().split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("and") || arr[i].equals("the") || arr[i].equals("of") || arr[i].equals("in")) {
                str += arr[i] + " ";
            }
            else str += arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1) + " ";
        }
        return str;
    }

    private static String getSha256Hash(String s) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(s.getBytes());
        byte[] hash = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : hash) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    private static String numToRus(int n) {
        String s = new String();
        int a, b, c;
        Map<Integer, String> numbers = new HashMap<Integer, String>();
        numbers.put(0, "ноль");
        numbers.put(1, "один");
        numbers.put(2, "два");
        numbers.put(3, "три");
        numbers.put(4, "четыре");
        numbers.put(5, "пять");
        numbers.put(6, "шесть");
        numbers.put(7, "семь");
        numbers.put(8, "восемь");
        numbers.put(9, "девять");
        numbers.put(10, "десять");
        numbers.put(11, "одиннадцать");
        numbers.put(12, "двенадцать");
        numbers.put(13, "тринадцать");
        numbers.put(14, "четырнадцать");
        numbers.put(15, "пятнадцать");
        numbers.put(16, "шестнадцать");
        numbers.put(17, "семнадцать");
        numbers.put(18, "восемнадцать");
        numbers.put(19, "девятнадцать");
        numbers.put(20, "двадцать");
        numbers.put(30, "тридцать");
        numbers.put(40, "сорок");
        numbers.put(50, "пятьдесят");
        numbers.put(60, "шестьдесят");
        numbers.put(70, "семьдесят");
        numbers.put(80, "восемьдесят");
        numbers.put(90, "девяносто");
        numbers.put(100, "сто");
        numbers.put(200, "двести");
        numbers.put(300, "триста");
        numbers.put(400, "четыреста");
        numbers.put(500, "пятьсот");
        numbers.put(600, "шестьсот");
        numbers.put(700, "семьсот");
        numbers.put(800, "восемьсот");
        numbers.put(900, "девятьсот");
        if (n >= 0 && n <= 20) {
            s = numbers.get(n);
        }
        if (n > 20 && n < 100) {
            a = n % 10;
            b = (n / 10) * 10;
            if (a != 0) s = numbers.get(b) + " " + numbers.get(a);
            else s = numbers.get(b);
        }
        if (n >= 100 && n <= 999) {
            a = n % 10;
            b = ((n % 100) / 10) * 10;
            c = n - n % 100;
            if (n % 100 == 0) s = numbers.get(c);
            else if (a == 0) s = numbers.get(c) + " " + numbers.get(b);
            else if (b == 0) s = numbers.get(c) + " " + numbers.get(a);
            else s = numbers.get(c) + " " + numbers.get(b) + " " + numbers.get(a);
        }
        return s;
    }

    private static String numToEng(int n) {
        String s = new String();
        int a, b, c;
        Map<Integer, String> numbers = new HashMap<Integer, String>();
        numbers.put(0, "zero");
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");
        numbers.put(5, "five");
        numbers.put(6, "six");
        numbers.put(7, "seven");
        numbers.put(8, "eight");
        numbers.put(9, "nine");
        numbers.put(10, "ten");
        numbers.put(11, "eleven");
        numbers.put(12, "twelve");
        numbers.put(13, "thirteen");
        numbers.put(14, "fourteen");
        numbers.put(15, "fifteen");
        numbers.put(16, "sixteen");
        numbers.put(17, "seventeen");
        numbers.put(18, "eighteen");
        numbers.put(19, "nineteen");
        numbers.put(20, "twenty");
        numbers.put(30, "thirty");
        numbers.put(40, "forty");
        numbers.put(50, "fifty");
        numbers.put(60, "sixty");
        numbers.put(70, "seventy");
        numbers.put(80, "eighty");
        numbers.put(90, "ninety");
        numbers.put(100, "hundred");
        if (n >= 0 && n <= 20) {
            s = numbers.get(n);
        }
        if (n > 20 && n < 100) {
            a = n % 10;
            b = (n / 10) * 10;
            if (a != 0) s = numbers.get(b) + " " + numbers.get(a);
            else s = numbers.get(b);
        }
        if (n >= 100 && n <= 999) {
            a = n % 10;
            b = ((n % 100) / 10) * 10;
            c = n / 100;
            if (n % 100 == 0) s = numbers.get(c) + " " + numbers.get(100);
            else if (a == 0) s = numbers.get(c) + " " + numbers.get(100) + " " + numbers.get(b);
            else if (b == 0) s = numbers.get(c) + " " + numbers.get(100) + " " + numbers.get(a);
            else s = numbers.get(c) + " " + numbers.get(100) + " " + numbers.get(b) + " " + numbers.get(a);
        }
        return s;
    }

    private static boolean validateCard(long n) {
        int sum = 0;
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        String s = String.valueOf(n).substring(0, String.valueOf(n).length()-1); // Удаляем последнюю цифру, переворачиваем число, удваиваем нечетные позиции, вычитаем последнюю цифру суммы из 10 и сравниваем удаленное и полученное число.
        if (s.length() < 13 || s.length() >= 18) {
            return false;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            list1.add(s.charAt(i));
        }
        for (int i = 0; i < list1.size(); i++) {
            if (i % 2 == 0) {
                list2.add(Character.getNumericValue(list1.get(i)) * 2);
            }
            else list2.add(Character.getNumericValue(list1.get(i)));
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list2.get(i) > 9) {
                list2.set(i, list2.get(i) / 10 + list2.get(i) % 10);
            }
            sum += list2.get(i);
        }
        int a = Integer.valueOf(String.valueOf(n).substring(String.valueOf(n).length()-1));
        int b = 10 - Integer.valueOf(String.valueOf(sum).substring(String.valueOf(sum).length()-1));
        
        return (a == b);
    }

    private static ArrayList<String> sameVowelGroup(String arr[]) {
        String letters = "aeyuio";
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        for (int i = 0; i < arr[0].length(); i++) {
            if (letters.indexOf(arr[0].charAt(i)) != -1) {
                list1.add(arr[0].charAt(i));
            }
        }
        Collections.sort(list1);
        for (int i = 1; i < list1.size(); i++) {
            if ((list1.get(i)).equals(list1.get(i-1))) {
                list1.remove(i-1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                if (letters.indexOf(arr[i].charAt(j)) != -1) {
                    list2.add(arr[i].charAt(j));
                }
                Collections.sort(list2);
                for (int n = 1; n < list2.size(); n++) {
                    if ((list2.get(n)).equals(list2.get(n-1))) {
                        list2.remove(n-1);
                    }
                }
            }
            if (list1.size() == list2.size()) {
                for (int n = 0; n < list2.size(); n++) {
                    if (list1.get(n) != list2.get(n)) {
                        break;
                    }
                    else {
                        list3.add(arr[i]);
                    }
                }
            }
            else break;
            list2.clear();
        }
        for (int i = 1; i < list3.size(); i++) {
            if ((list3.get(i)).equals(list3.get(i-1))) {
                list3.remove(i-1);
            }
        }
        return list3;
    }

    // 16, 28
    private static int sumDigProd(int ...nums) {
        int s = 0;
        for (int n: nums) {
            s += n; // 44
        }
        int x = s; // 44
        while (x > 9) {
            x = 1;
            while (s > 0) {
                x = x * s % 10;
                s = s / 10;
            }
            s = x;  // 16
        }
        return x;
    }


    // butl beautiful
    private static boolean canComplete(String word1, String word2) {
        int count = 0;
        boolean state = false;
        for (int i = 0; i < word1.length(); i++) {
            state = false;
            for (int j = count; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    count = word1.indexOf(word1.charAt(i)) + 1;
                    state = true;
                    break;
                }
            }
            if (state == false) {
                return false;
            }
        }
        return true;
    }



    private static boolean canMove(String name, String from, String to) {
        int x1 = from.charAt(0) - 64;
        int x2 = to.charAt(0) - 64;
        int y1 = from.charAt(1) - 48;
        int y2 = to.charAt(1) - 48;
        if (x1 == x2 && y1 == y2) {
            return false;
        }
        if (name.equals("Pawn")) { // Пешка
            // по умолчанию может двигаться на 1-2 клетки только по вертикали
            return ((Math.abs(y1 - y2) <= 2) && (x1 == x2));
        }
        if (name.equals("Rook")) { // Ладья
            return (x1 == x2 || y1 == y2);
        }
        if (name.equals("Bishop")) { // Слон
            return (Math.abs(x2 - x1) == Math.abs(y2 - y1));
        }
        if (name.equals("Knight")) { // Конь
            return (((Math.abs(x1 - x2) == 1) && (Math.abs(y1 - y2) == 2)) || ((Math.abs(x1 - x2) == 2) && (Math.abs(y1 - y2) == 1)));
        }
        if (name.equals("Queen")) { // Королева
            return (Math.abs(x2 - x1) == Math.abs(y2 - y1) || x1 == x2 || y1 == y2);
        }
        if (name.equals("King")) { // Король
            return (Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1);
        }
        return false;
    }



    // [ 72, 33, -73, 84, -12, -3, 13, -13, -68 ] ➞ "Hi there!"
    private static String decrypt(int [] arr) {
        String s = "";
        s = s + (char) arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
            s = s + (char) (arr[i]);
        }
        return s;
    }



    // Hello
    private static String encrypt(String s) {
        int[] arr1 = new int[s.length()]; // [0, 0, 0, 0, 0]
        int[] arr2 = new int[s.length()]; // [0, 0, 0, 0, 0]
        for (int i = 0; i < s.length(); i++) {
            arr1[i] = Integer.valueOf(s.charAt(i)); // [72, 101, 108, 108, 111]
        }
        arr2[0] = arr1[0];
        for (int i = 1; i < arr1.length; i++) {
            arr2[i] = arr1[i] - arr1[i - 1]; // [72, 29, 7, 0, 3]
        }
        return Arrays.toString(arr2);
    }




    private static void print(int i, String string) {
        System.out.println("");
        System.out.println("---> Task №" + i + " <--- " + string);
    }

}
