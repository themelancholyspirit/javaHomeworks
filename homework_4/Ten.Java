import java.util.Scanner;

class Ten {
    private static Scanner my_scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = my_scan.nextInt();

        System.out.println(toBinary(n));
    }

    public static String toBinary(int n) {

        String binary = "";

        while (n > 0) {
            binary = Integer.toString(n & 1) + binary;
            n >>= 1;    
        }

        return binary;
    }
}