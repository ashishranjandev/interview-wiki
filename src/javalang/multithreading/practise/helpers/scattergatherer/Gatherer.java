package javalang.multithreading.practise.helpers.scattergatherer;

import javalang.multithreading.practise.helpers.Colleague;

public interface Gatherer {

    boolean needsMore();
    void gatherResult(Colleague i);
    Colleague getFinalResult();

}
