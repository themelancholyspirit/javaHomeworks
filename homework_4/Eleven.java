import java.util.Scanner;


class Eleven {

    private static Scanner scan_obj = new Scanner(System.in);
    public static void main(String[] args) {
        String bin = scan_obj.nextLine();
        System.out.println(toDecimal(bin));
    }

    public static int toDecimal(String binary) {
        int decimal = 0;
        int length = binary.length() - 1;

        for (int i=0; i<binary.length()-1; i++) {
            if (binary.charAt(i) == '1') decimal = decimal + (int)Math.pow(2, length - i);
        }

        return decimal;
    }

}
