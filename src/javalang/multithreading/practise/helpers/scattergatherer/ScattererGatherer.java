package javalang.multithreading.practise.helpers.scattergatherer;

import javalang.multithreading.practise.helpers.Colleague;

import java.util.concurrent.Callable;

public interface ScattererGatherer {

    public Colleague go(Scatterer s, Gatherer g);
}
