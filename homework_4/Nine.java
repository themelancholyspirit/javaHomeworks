import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Nine {
    public static void main(String[] args) {
    
        try {

            for (int i=1; i<10000; i++) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(String.format("myFiles/%d.txt", i)));
                writer.write(Integer.toString(i));
            }
        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
