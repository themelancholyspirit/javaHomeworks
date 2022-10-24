import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


class Fifteen {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("m: ");
        int m = scanner.nextInt();
        System.out.print("n: ");
        int n = scanner.nextInt();

        check_validity(m);
        check_validity(n);

        int[][] arr = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                arr[i][j] = (int)Math.round(Math.random());
            }
        }

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("info.txt", true));

            for (int i=0; i<m; i++) {
                String row = "";

                for (int j=0; j<n; j++) row = row + arr[i][j];
                
                writer.write(row + "\n");
            }
        
            writer.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        readFile();
    }

    public static void readFile() {
        
        int ones = 0;
        int zeros = 0;

        try {

            BufferedReader reader = new BufferedReader(new FileReader("info.txt"));

            while(true) {
                String row = reader.readLine();

                if (row == null) break;

                for (int i=0; i<row.length(); i++) {
                    if (row.charAt(i) == '1') ones++;
                    else zeros++;
                }

                System.out.println(row);
            }

            reader.close();
        }
    
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("amount of ones: %d amount of zeros: %d", ones, zeros));

    }

    public static void check_validity(int n) {
        if (!(n <= 50)) throw new IllegalArgumentException("Given integer exceeds the range: val <= 50");
    }

}