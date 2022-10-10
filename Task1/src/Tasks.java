public class Tasks{
    public static void main(String args[]) throws Exception{
        print(1,"remainder");
        System.out.println(remainder(1,3));
        System.out.println(remainder(3,4));
        System.out.println(remainder(-9,45));
        System.out.println(remainder(5,5));
        print(2,"triArea");
        System.out.println(triArea(3,2));
        System.out.println(triArea(7,4));
        System.out.println(triArea(10,10));
        print(3, "animals");
        System.out.println(animals(2,3,5));
        System.out.println(animals(1,2,3));
        System.out.println(animals(5,2,8));
        print(4, "profitableGamble");
        System.out.println(profitableGamble(0.2,50,9));
        System.out.println(profitableGamble(0.9,1,2));
        System.out.println(profitableGamble(0.9,3,2));
        print(5, "operation");
        System.out.println(operation(24,15,9));
        System.out.println(operation(24,26,2));
        System.out.println(operation(15,11,11));
        print(6, "ctoa");
        System.out.println(ctoa('A'));
        System.out.println(ctoa('m'));
        System.out.println(ctoa('['));
        System.out.println(ctoa('\\'));
        print(7,"addUpTo");
        System.out.println(addUpTo(3));
        System.out.println(addUpTo(10));
        System.out.println(addUpTo(7));
        print(8, "nextEdge");
        System.out.println(nextEdge(8,10));
        System.out.println(nextEdge(5,7));
        System.out.println(nextEdge(9,2));
        print(9, "sumOfCubes");
        System.out.println(sumOfCubes(new int[]{1,5,9}));
        System.out.println(sumOfCubes(new int[]{3,4,5}));
        System.out.println(sumOfCubes(new int[]{2}));
        System.out.println(sumOfCubes(new int[]{}));
        print(10, "abcmath");
        System.out.println(abcmath(42,5,10));
        System.out.println(abcmath(5,2,1));
        System.out.println(abcmath(1,2,3));
    }

    private static boolean abcmath(int a, int b, int c) {
        int sum = a;
        for (int i = 0; i < b; i++);{
            sum += sum;
        }
        return remainder(sum,c) == 0;
    }

    private static int sumOfCubes(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i] * arr[i] * arr[i];
        }
        return sum;
    }

    private static int nextEdge(int i, int j) {
        return i+j-1;
    }

    private static int addUpTo(int i) {
        return (1 + i) * i / 2;
    }

    private static int ctoa(char c) {
        return (int)c;
    }

    private static String operation(int N, int a, int b) {
        String s = "none";
        if (a + b == N)
        s = "added";
        if (a - b == N)
        s = "subtracted";
        if (a * b == N)
        s = "multiplied";
        if (a / b == N)
        s = "divided";
        return s;
    }

    private static boolean profitableGamble(double prob, double prize, double pay) {
        return (prob*prize) > pay;
    }

    private static int animals(int chickens, int cows, int pigs) {
        return 2*chickens+4*cows+4*pigs;
    }

    private static float triArea(int i, int j) {
        return (i*j)/2;
    }

    private static void print(int i, String string) {
        System.out.println("");
        System.out.println("---> Task №" + i + " <--- " + string);
    }

    private static int remainder(int i, int j) {
        return i % j;
    }
}
