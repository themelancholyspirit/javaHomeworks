
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Fourteen {

    private static Scanner scanner_obj = new Scanner(System.in);
    private static Random random_obj = new Random();

    public static void main(String[] args) {
        System.out.print("a: ");
        int a = scanner_obj.nextInt();
        System.out.print("b: ");
        int b = scanner_obj.nextInt();
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("numbers.txt", true));            
            
            for (int i=0; i<40; i++) {
                int random_num = random_obj.nextInt(b - a) + a;
                writer.write(Integer.toString(random_num) + "\n");
            }

            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"));

            int sum_even = 0;
            int sum_odd = 0;

            while (true) {
                String val = reader.readLine();

                if (val == null) break;

                int val_int = Integer.parseInt(val);

                if (val_int % 2 == 0) sum_even = sum_even + val_int;
                else sum_odd = sum_odd + val_int;

            }

            reader.close();

            System.out.println(String.format("sum of evens is: %d, sum of odds is: %d", sum_even, sum_odd));

            int min = Math.min(sum_even, sum_odd);
            int max = Math.max(sum_even, sum_odd);
            
            System.out.println(String.format("%d%d", min,max));


            writer = new BufferedWriter(new FileWriter("numbers2.txt"));

            for (int i=0; i<5; i++) {
                int random_num = random_obj.nextInt(max - min) + min;
                writer.write(Integer.toString(random_num) + "\n");
            }
        
            writer.close();
        
        }
        catch (IOException e) {
            e.printStackTrace();        
        }
    }

}
