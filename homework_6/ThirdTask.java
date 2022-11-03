import java.util.Scanner;

class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner_obj = new Scanner(System.in);
        int num = scanner_obj.nextInt();

        while (num % 10 == 0) num = num / 10;

        int reversed_num = 0;

        while (num > 0) {
            reversed_num = (reversed_num * 10) + num % 10;
            num = num / 10;
        }

        int length = get_length(reversed_num);
        int middle = length / 2;

        String first_part = Integer.toString(reversed_num).substring(0, middle);
        String second_part = Integer.toString(reversed_num).substring(middle);

        int res = Integer.parseInt(first_part) * Integer.parseInt(second_part);
    
        System.out.println(res);
    }

    public static int get_length(int n) {
        int c = 0;

        while (n > 0) {
            n = n / 10;
            c++;
        }

        return c;
    }
}
