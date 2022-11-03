
import java.util.Scanner;
import java.util.HashMap;


class SecondTask {

    public static void main(String[] args) {
        Scanner scanner_obj = new Scanner(System.in);

        int arr[] = new int[5];

        for (int i=0; i<5; i++) {
            int num = scanner_obj.nextInt();
            arr[i] = num;
        }

        scanner_obj.close();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i=0; i<5; i++) {
            if (map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i]) + 1);
            else map.put(arr[i], 1);
        }

        boolean tripple = false;
        int num = -1;

        for (Integer value: map.keySet()) {
            if (map.get(value) == 3) {
                tripple = true;
                num = value;
                break;
            }
        }

        if (tripple == true) {
            for (int i=0; i<5; i++) {
                if (arr[i] != num) System.out.println(arr[i] + " was inputted at pos " + (i+1));
            }
        }
        else System.out.println("NO");

    }

}