package javalang.multithreading.practise.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ColleaguePipelineTest {

    public static void main(String...args) {
        SyncMalFormedColleagueService syncMalFormedColleagueService = new SyncMalFormedColleagueService();
        ColleaguePipeline colleaguePipeline = new ColleaguePipeline(syncMalFormedColleagueService);
        long start = System.currentTimeMillis();
        try {
            new FileInputStream(new File("resources/colleague.txt"));
            colleaguePipeline.process(new FileInputStream("resources/colleague.txt"));
            System.out.println("Processing finished in " + (System.currentTimeMillis() - start) +  " ms");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
