import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

class Main {
    
    private static Scanner scanner_obj = new Scanner(System.in);
    private static char drive_name;
    private static Random random_obj = new Random();

    public static void main(String[] args) {
        create_root();
        create_file_or_dir();
        write_to_file();
        read_data();
    }

    private static void create_root() {
        System.out.println("where to create the root dir? (C/D/E)");
        char drive_name = scanner_obj.nextLine().charAt(0);
        Main.drive_name = drive_name;
        
        File file = new File(String.format("%c:\\root", drive_name));
        file.mkdir();
    }

    private static void create_file_or_dir() {
        System.out.println("Should we create files or dirs? ( 0 = files / 1 = dirs )");
        char file_or_dir = scanner_obj.nextLine().charAt(0);

        System.out.println("input how many to create: ");
        int n = scanner_obj.nextInt();

        while (n-- > 0) {
            if (file_or_dir == '0') create_file();
            else create_dir();
        } 

    }

    private static void create_file() {
        System.out.println("Input the file name: ");
        String file_name = scanner_obj.nextLine();

        if (file_name == "") return;

        try {
            File f = new File(String.format("%c:\\root\\%s.txt", Main.drive_name, file_name));
            f.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void create_file(String file_name) { 
        try {
            File f = new File(String.format("%c:\\root\\%s.txt", Main.drive_name, file_name));
            f.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void create_dir() {
        System.out.println("Input the dir name: ");
        String dir_name = scanner_obj.nextLine();

        File dir = new File(String.format("%c:\\root\\%s", Main.drive_name, dir_name));
        dir.mkdir();
    }

    private static void write_to_file() {

        System.out.println("0 = Input your own data, 1 = Random Data");
        char choice = scanner_obj.nextLine().charAt(0);

        String s;

        if (choice == '0') s = scanner_obj.nextLine();
        else s = generate_random_data();

        File folder = new File(String.format("%c:\\root", Main.drive_name));
        File[] listOfFiles = folder.listFiles();
        boolean file_exists = false;
        String file_name = "TEMP";

        for (int i=0; i<listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                file_name = listOfFiles[i].getName();
                file_exists = true;
            }
        }

        if (!file_exists) {
            create_file("dummyFile");
            file_name = "dummyFile";
        };

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(String.format("%c:\\root\\%s", Main.drive_name, file_name)));
            writer.write(s);
            writer.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("done writing data to " + file_name);
    }

    private static String generate_random_data() {
 
        int random_num = random_obj.nextInt(100-50) + 50;
 
        String[] programming_languages = {
            "PHP", "Python", "C", "C++", "JavaScript", "Java", "C#", "Go"
        };

        String final_string = "";
        
        for (int i=0; i<random_num; i++) {
            String lang = programming_languages[random_obj.nextInt(programming_languages.length-1)];
            final_string = final_string + lang + "\n";
        }

        return final_string;

    }

    private static void read_data() {
 
        System.out.println();

        File folder = new File(String.format("%c:\\root", Main.drive_name));
        File[] listOfFiles = folder.listFiles();
        int choice = 0;

        for (int i=0; i<listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].length() != 0) {
                String file_name = listOfFiles[i].getName();
                System.out.println("Open " + file_name + "? (yes = 1, no = 0)");

                choice = scanner_obj.nextInt();

                if (choice == 1) read_file(String.format("%c:\\root\\%s", Main.drive_name, file_name));
            }
        }
    }

    private static void read_file(String path) {
 
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String s;
            
            while ((s=reader.readLine()) != null) System.out.println(s);
            
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}