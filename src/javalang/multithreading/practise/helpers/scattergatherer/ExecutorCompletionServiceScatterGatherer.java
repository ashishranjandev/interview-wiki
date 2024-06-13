package javalang.multithreading.practise.helpers.scattergatherer;

import javalang.multithreading.practise.helpers.Colleague;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorCompletionServiceScatterGatherer implements ScattererGatherer{
    private final ExecutorService pool = Executors.newCachedThreadPool();

    @Override
    public Colleague go(Scatterer s, Gatherer g) {
        ExecutorCompletionService<Colleague> ecs = new ExecutorCompletionService<>(pool);

        int numberOfTasks = 0;
        while ( s.hasNext() ) {
            ecs.submit(s.next());
            numberOfTasks++;
        }

        // Since take is a blocking method, we only want to call it at most the number of tasks
        // submitted. take will block even if there are no currently running tasks
        while ( numberOfTasks > 0 && g.needsMore() ) {
            try {
                Colleague i = ecs.take().get();
                g.gatherResult(i);
                numberOfTasks--;
            } catch ( InterruptedException | ExecutionException e ) {
                e.printStackTrace();
            }
        }

        return g.getFinalResult();
    }
}
