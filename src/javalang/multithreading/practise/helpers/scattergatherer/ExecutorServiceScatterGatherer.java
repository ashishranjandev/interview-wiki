package javalang.multithreading.practise.helpers.scattergatherer;

import javalang.multithreading.practise.helpers.Colleague;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceScatterGatherer implements ScattererGatherer{

    private final ExecutorService pool = Executors.newCachedThreadPool();

    @Override
    public Colleague go(Scatterer s, Gatherer g) {
        Queue<Future<Colleague>> results = new LinkedList<>();
        while ( s.hasNext() ) {
            Future<Colleague> futureResult = pool.submit(s.next());
            results.add(futureResult);
        }

        while ( !results.isEmpty() && g.needsMore() ) {
            try {
                Future<Colleague> futureResult = results.poll();
                Colleague result = futureResult.get();
                g.gatherResult(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return g.getFinalResult();
    }

}
