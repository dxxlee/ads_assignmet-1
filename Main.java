import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.reflect.Array.*;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {10, 1, 32, 3, 45};
        System.out.println("Problem 1: " + findMin(arr1));

        int[] arr2 = {3, 2, 4, 1};
        System.out.println("Problem 2: " + findAverage(arr2));

        System.out.println("Problem 3: " + (isPrime(5) ? "Prime" : "Composite"));

        System.out.println("Problem 4: " + factorial(5));


        int num = 17;
        long[] mem = new long[num+1];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = -1;
        }
        System.out.println("Problem 5: " + fibanacci(num, mem));


        System.out.println("Problem 6: " + power(2, 5));

        String input = "IOX";
        ArrayList<String> permutationsArr = permutation(input);
        System.out.print("Problem 7: ");
        for (String perm : permutationsArr) {
            System.out.print(perm + " - ");
        }

        System.out.println("\n" + "Problem 8: " + (isDigit("123456") ? "Yes" : "No"));

        int n = 7, k = 3;
        System.out.println("Problem 9: " + "Value of C(" + n + ", " + k + ") is " + binonialCoeff(n, k));

        System.out.println("Problem 10: " + gcd(32, 48));
    }

    //Complexity: linear O(n) because it iterates through the array once, comparing each element with the current minimum value
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }

    //Complexity: linear O(n) similar to findMin, this function iterates through the array once to calculate the sum of all elements
    public static double findAverage(int[] arr) {
        int sum = 0;
        for (int num : arr){
            sum += num;
        }
        return (double) sum / arr.length;
    }

    //Complexity: square root - O(sqrt(n))
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    //Complexity: linear - O(n)
    public static long factorial(int n){
        if (n==0 || n==1){
            return 1;
        }
        return n * factorial(n-1);
    }

    //Complexity: linear - O(n)
    public static long fibanacci(int n, long[] mem){
        if (mem[n] != -1)
            return mem[n];
        if (n<=1)
            return n;
        long res = fibanacci(n-1, mem) + fibanacci(n-2, mem);
        mem[n] = res;

        return res;
    }

    //Complexity: logarithmic - O(log n)
    public static int power(int a, int n) {
        if(n==0) return 1;
        else if (n<0) return 1 / (power(a, -n));
        else if (n % 2 == 0){ // if n is even
            int temp = power(a, n/2);
            return temp * temp;
        }
        else{ // if n is odd
            return a * power(a, n-1);
        }
    }

    //Complexity - O(n!)
    public static ArrayList<String> permutation(String input) {
        ArrayList<String> perm = new ArrayList<>();
        permutationH("", input, perm);
        return perm;
    }

    private static void permutationH(String prefix, String remaining, ArrayList<String> perm) {
        int n = remaining.length();
        if (n == 0) {
            perm.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutationH(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1, n), perm);
            }
        }
    }


    //Complexity: linear O(n)
    public static boolean isDigit(String s){
        for (int i = 0; i < s.length(); i++){
            if (!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    //Complexity: polynomial O(n*max(k,n-k))
    public static int binonialCoeff(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;
        return binonialCoeff(n-1, k-1) + binonialCoeff(n-1, k);
    }

    /* Complexity: logarithmic O(log (min(a, b)))
    Since the algorithm reduces the problem size by half with each iteration,
    its complexity is logarithmic in terms of the minimum of a and b
     */
    public static int gcd(int a, int b){
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
}

/*
output will be:
Problem 1: 1
Problem 2: 2.5
Problem 3: Prime
Problem 4: 120
Problem 5: 1597
Problem 6: 32
Problem 7: IOX - IXO - OIX - OXI - XIO - XOI -
Problem 8: Yes
Problem 9: Value of C(7, 3) is 35
Problem 10: 16
*/