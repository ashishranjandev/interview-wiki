package javalang.multithreading.practise.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class ColleaguePipelineTestWithSmallDataSet {

    public static void main(String...args) {
        long start = System.currentTimeMillis();
        testWithNoMultiThreading();
        System.out.println("Processing with no multithreading finished in " + (System.currentTimeMillis() - start) +  " ms");
        start = System.currentTimeMillis();
        testWithAsyncErrorHandling();
        System.out.println("Processing with no multithreading - async error handling finished in "
                                   + (System.currentTimeMillis() - start) +  " ms");
        start = System.currentTimeMillis();
        testWithBlockingQueueMalformed();
        System.out.println("Processing with no multithreading - async error handling finished in "
                                   + (System.currentTimeMillis() - start) +  " ms");
    }

    private static void testWithNoMultiThreading() {
        SyncMalFormedColleagueService syncMalFormedColleagueService = new SyncMalFormedColleagueService();
        ColleaguePipeline colleaguePipeline = new ColleaguePipeline(syncMalFormedColleagueService);
        try {
            Map<String, Integer> map = colleaguePipeline.process(new FileInputStream("resources/colleague-small.txt"));
            System.out.println("City Map: " + map.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void testWithAsyncErrorHandling() {
        AsyncMalFormedColleagueService asyncMalFormedColleagueService = new AsyncMalFormedColleagueService();
        ColleaguePipeline colleaguePipeline = new ColleaguePipeline(asyncMalFormedColleagueService);
        try {
            Map<String, Integer> map = colleaguePipeline.process(new FileInputStream("resources/colleague-small.txt"));
            System.out.println("City Map: " + map.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void testWithBlockingQueueMalformed() {
        BlockingQueueMalformedColleagueService blockingQueueMalformedColleagueService = new BlockingQueueMalformedColleagueService();
        ColleaguePipeline colleaguePipeline = new ColleaguePipeline(blockingQueueMalformedColleagueService);
        try {
            Map<String, Integer> map = colleaguePipeline.process(new FileInputStream("resources/colleague-small.txt"));
            System.out.println("City Map: " + map.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
