import java.io.BufferedWriter;
import java.io.FileWriter;

public class ExampleSave {

    public static void main(String[] args) {

        try{

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

            bufferedWriter.write("Hello ");
            bufferedWriter.write("Its me!");

            bufferedWriter.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
