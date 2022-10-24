import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;


public class Seven {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("myfiles/function.txt", true));

            for (double i=0.0; i<=2.0; i+=0.1) {
                double val = compute(i);
                String formattedVal = df.format(val);

                writer.write(formattedVal + "\n");
            }

            writer.close();
        
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static double compute(double x) {
        return x + 0.5;
    }

}
