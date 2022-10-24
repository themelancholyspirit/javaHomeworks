import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;


class Second {
    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data1.txt"));

            for (int i=0; i<100; i++) {
                writer.write(Integer.toString(i) + '\n');
            }

            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}