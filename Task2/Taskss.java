public class Taskss{
    public static void main(String args[]) throws Exception{
        print(1,"repeat");
        System.out.println(repeat("mice", 5)); // "mmmmmiiiiiccccceeeee"
        System.out.println(repeat("hello", 3)); // "hhheeellllllooo"
        System.out.println(repeat("stop", 1)); // "stop"
        print(2,"differenceMaxMin");
        System.out.println(differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21})); // Smallest number is -50, biggest is 32.
        System.out.println(differenceMaxMin(new int[]{44, 32, 86, 19})); // Smallest number is 19, biggest is 86.
        print(3, "isAvgWhole");
        System.out.println(isAvgWhole(new int[]{1, 3})); // true
        System.out.println(isAvgWhole(new int[]{1, 2, 3, 4})); // false
        System.out.println(isAvgWhole(new int[]{1, 5, 6})); // true
        System.out.println(isAvgWhole(new int[]{1, 1, 1})); // true
        System.out.println(isAvgWhole(new int[]{9, 2, 2, 5})); // false
        print(4, "cumulativeSum");
        int[][] tests = new int[][] {
            new int[] { 1, 2, 3 }, // [1, 3, 6]
            new int[] { 1, -2, 3 }, // [1, -1, 2]
            new int[] { 3, 3, -2, 408, 3, 3 }, // [3, 6, 4, 412, 415, 418]
            new int[] {2}
        };
        for (int i = 0; i < 4; i++) {
            int[] arr = cumulativeSum(tests[i]);
            if (arr.length == 0) {
                System.out.println("[]");
            } else {
                System.out.print("[");
                for (int j = 0; j < arr.length - 1; j++) {
                    System.out.print(arr[j] + ", ");
                }
                System.out.print(arr[arr.length - 1]);
                System.out.println("]");
            }
        }
        print(5, "getDecimalPlaces");
        System.out.println(getDecimalPlaces("43.20")); // 2
        System.out.println(getDecimalPlaces("400")); // 0
        System.out.println(getDecimalPlaces("3.1")); // 1
        print(6, "Fibonacci");
        System.out.println(Fibonacci(3)); // 3
        System.out.println(Fibonacci(7)); // 21
        System.out.println(Fibonacci(12)); // 233
        print(7,"isValid");
        System.out.println(isValid("59001")); // true
        System.out.println(isValid("853a7")); // false
        System.out.println(isValid("732 32")); // false
        System.out.println(isValid("393939")); // false
        print(8, "isStrangePair");
        System.out.println(isStrangePair("ratio", "orator")); // true
        System.out.println(isStrangePair("sparkling", "groups")); // true
        System.out.println(isStrangePair("bush", "hubris")); // false
        System.out.println(isStrangePair("", "")); // true
        print(9, "isPrefix or isSuffix");
        System.out.println(isPrefix("automation", "auto-")); // true
        System.out.println(isSuffix("arachnophobia", "-phobia")); // true
        System.out.println(isPrefix("retrospect", "sub-")); // false
        System.out.println(isSuffix("vocation", "-logy")); // false
        print(10, "boxSeq");
        System.out.println(boxSeq(0)); // 0
        System.out.println(boxSeq(1)); // 3
        System.out.println(boxSeq(2)); // 2
    }


    private static int boxSeq(int step) {
        int fInal = 0;
        if (step % 2 == 0)
        fInal = step;
        else fInal = step + 2;
        return fInal;
    }


    private static boolean isSuffix(String word, String suf) {
        return word.endsWith(String.copyValueOf(suf.toCharArray(), 1, suf.length() - 1));
    }


    private static boolean isPrefix(String word, String pref) {
        return word.startsWith(String.copyValueOf(pref.toCharArray(), 0, pref.length() - 1)) ? true : false;
    }


    private static boolean isStrangePair(String string1, String string2) {
        if (string1.length() == 0 && string2.length() == 0){
            return false;
        }
        if (string1.length() == 0 || string2.length() == 0){
            return false;
        }
        if (string1.charAt(0) == string2.charAt(string2.length() - 1) && string2.charAt(0) == string1.charAt(string1.length() - 1)){
            return true;
        }
        return false;
    }


    private static boolean isValid(String valid) {
        return valid.matches("\\d{5}");
        }


    private static int Fibonacci(int num) {
        if (num == 0) {
            return -1;
        } else if (num < 2) {
            return 1;
        }
        int[] fib = new int[num + 1];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i <= num; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[num];
    }


    private static int getDecimalPlaces(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '.') {
                return string.length() - i - 1;
            }
        }
        return 0;
    }


    private static int[] cumulativeSum(int[] arr) {
        if (arr.length == 0){
            return new int[] {};
        }
        int[] cumsum = new int[arr.length];
        cumsum[0] = arr[0];
        for (int i = 1; i < arr.length; i++){
        cumsum[i] += cumsum[i-1] + arr[i];
        }
        return cumsum;
    }


    public static boolean isAvgWhole(int[] arr) {
        int avg = 0;
        int length = arr.length;
        for (int i = 0; i < arr.length; i++){
            avg += arr[i];
        }
        return (avg % length == 0);
    }


    private static int differenceMaxMin(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        if (arr.length == 0)
        return -1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max)
            max = arr[i];
            if (arr[i] < min)
            min = arr[i];
        }
        return max-min;
    }


    private static String repeat(String a, int n) {
        String str = "";
        for (int i = 0; i < a.length(); i++){
            str += (a.charAt(i) + "").repeat(n);
        }
        return str;
    }
    
//     private static boolean abcmath(int a, int b, int c) {
//         int sum = a;
//         for (int i = 0; i < b; i++);{
//             sum += sum;
//         }
//         return remainder(sum,c) == 0;
//     }

//     private static int sumOfCubes(int[] arr) {
//         int sum = 0;
//         for (int i = 0; i < arr.length; i++){
//             sum += arr[i] * arr[i] * arr[i];
//         }
//         return sum;
//     }

//     private static int nextEdge(int i, int j) {
//         return i+j-1;
//     }

//     private static int addUpTo(int i) {
//         return (1 + i) * i / 2;
//     }

//     private static int ctoa(char c) {
//         return (int)c;
//     }

//     private static String operation(int N, int a, int b) {
//         String s = "none";
//         if (a + b == N)
//         s = "added";
//         if (a - b == N)
//         s = "subtracted";
//         if (a * b == N)
//         s = "multiplied";
//         if (a / b == N)
//         s = "divided";
//         return s;
//     }

//     private static boolean profitableGamble(double prob, double prize, double pay) {
//         return (prob*prize) > pay;
//     }

//     private static int animals(int chickens, int cows, int pigs) {
//         return 2*chickens+4*cows+4*pigs;
//     }

//     private static float triArea(int i, int j) {
//         return (i*j)/2;
//     }

    private static void print(int i, String string) {
        System.out.println("");
        System.out.println("---> Task №" + i + " <--- " + string);
}

    // private static int remainder(int i, int j) {
    //     return i % j;
    // }
}
    

