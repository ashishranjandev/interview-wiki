package javalang.multithreading.practise.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RecursiveAction;

public class BlockingQueueMalformedColleagueService implements MalFormedColleagueService {

    private BlockingQueue<Runnable> taskList = null;

    private List<Colleague> colleagueList = new ArrayList<>();

    private List<String> exceptionList = new ArrayList<>();

    public BlockingQueueMalformedColleagueService() {
        taskList = new LinkedBlockingQueue<>();
        new ForkJoinPool(4).submit(new Consumer());
    }

    public MalFormedColleagueService getInstance() {
        return this;
    }


    public void add(Colleague colleague, String message) {
        taskList.offer(() -> {
            colleagueList.add(colleague);
            exceptionList.add(message);
        });
    }

    private class Consumer extends RecursiveAction {

        @Override protected void compute() {
            Runnable r = null;
            try {
                r = taskList.take();
                new Consumer().fork();
                r.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
