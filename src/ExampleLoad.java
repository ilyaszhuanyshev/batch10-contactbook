import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ExampleLoad {

    public static void main(String[] args) {

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader("output.txt"));
            String text;

            while ((text = bufferedReader.readLine()) != null) {
                System.out.println(text);
            }

            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
