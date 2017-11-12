package createsequences;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Created by lucas on 11/10/17.
 *
 * This will create a csv file with random 6 character sequences of A or B.
 *
 */
public class CreateFileLauncher {

    public static void main(String[] args) {
        final int runCount = 100000;

        StringBuilder output = new StringBuilder("run_id,sequence\n");

        for (int i = 0; i < runCount; i++) {
            output.append(i+1 + "," + getSequence() + "\n");
        }
        writeToFile(output);
    }

    private static char coinFlilp(){
        Random r = new Random();
        final int heads = 0;
        final int bound = 2;
        int result = r.nextInt(bound);
        if(result == heads){
            return 'A';
        }
        return 'B';
    }

    private static String getSequence(){
        final int sequenceLength = 6;
        String retVal = "";
        for (int i = 0; i < sequenceLength; i++) {
            retVal += coinFlilp();
        }
        return retVal;
    }

    private static void writeToFile(StringBuilder output){
        Path path = Paths.get("./output/random-sequences.txt");
        try {
            Files.write(path, output.toString().getBytes());
        } catch (IOException e) {
            System.err.println("cannot create file.");
            e.printStackTrace();
        }
    }
}
