import java.util.Random;
import java.util.Scanner;


class FourthTask {

    private static Random random_obj = new Random();
    private static Scanner scanner_obj = new Scanner(System.in);

    public static void main(String[] args) {

        int arr[][] = new int[6][5];
        initialize_arr(arr);
        print_arr(arr);
        bubble_sort(arr);
        System.out.println();
        print_arr(arr);

    }

    public static void bubble_sort(int arr[][]) {

        for (int i=0; i<6; i++) {
            for (int j=i+1; j<6; j++) {
                if (arr[i][0] < arr[j][0]) {
                    int[] temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void initialize_arr(int[][] arr) {
        
        int a = scanner_obj.nextInt();
        int b = scanner_obj.nextInt();

        for (int i=0; i<6; i++) {
            for (int j=0; j<5; j++) {
                int random_num = random_obj.nextInt(b - a) + a;
                arr[i][j] = random_num;
            }
        }
    }

    public static void print_arr(int arr[][]) {
        for (int i=0; i<6; i++) {
            for (int j=0; j<5; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
