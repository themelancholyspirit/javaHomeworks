import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Fourth {
    public static void main(String[] args) {
        for (int i=1; i<=30; i++) {
            try {

                File file = new File(String.format("myfiles2/file%d", i));
                file.createNewFile();
                
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(String.format("Programmer%d", i));
                writer.close();

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
