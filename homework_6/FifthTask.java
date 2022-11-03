
import java.util.Random;

class FifthTask {
    public static void main(String[] args) {
        Random random_obj = new Random();
        int c = 0;

        for (int i=0; i<100; i++) c = random_obj.nextInt(99) > i ? c + 1 : c;

        System.out.println(c);
        
    }    
}
