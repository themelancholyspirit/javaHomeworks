import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class First {
    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
            writer.write("24\n");
            writer.write("39\n");
            writer.write("-90\n");
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }    
}