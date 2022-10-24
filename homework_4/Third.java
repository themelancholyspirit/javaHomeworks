import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Third {
    public static void main(String[] args) {
        for (int i=1; i<=30; i++) {
            try {

                File f = new File(String.format("myfiles1/file%d.txt", i));
                f.createNewFile();
                
                BufferedWriter writer = new BufferedWriter(new FileWriter(f));
                writer.write("Programmer");

                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}