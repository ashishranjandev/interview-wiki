package javalang.multithreading.practise.helpers.scattergatherer;

import javalang.multithreading.practise.helpers.Colleague;

public class SingleThreadedScatterGatherer {

    public Colleague go(Scatterer s, Gatherer g) {
        while ( s.hasNext() && g.needsMore() ) {
            try {
                Colleague result = s.next().call();
                g.gatherResult(result);
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }
        return g.getFinalResult();
    }

}
