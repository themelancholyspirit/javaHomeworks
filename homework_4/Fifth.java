import java.util.Scanner;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;

class Fifth {

    private static Scanner scanner_obj = new Scanner(System.in);
    private static Random random_obj = new Random();
    public static void main(String[] args) {

        System.out.print("a: ");
        int a = scanner_obj.nextInt();
        System.out.print("b: ");
        int b = scanner_obj.nextInt();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("myfiles/data2.txt", true));
            
            for (int i=0; i<100; i++) {
                int random_num = random_obj.nextInt(b - a) + a;
                writer.write(Integer.toString(random_num) + "\n");
            }
            
            writer.close();

        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }

}
