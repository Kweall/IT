public class Primes {
    //метод, начинающий исполнение программы
    public static void main(String[] args) {
        for (int i = 2; i <= 100; ++i) {
            if (isPrime(i)) {
                System.out.println(i + "");
            }
            // else {
            //     System.out.println(i + " - непростое число");
            // }
        }

    }
    //проверка числа на простоту
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; ++i){
            if (n % 3 == 0) {
                return true;
            }
        }
        return false;
    }
}