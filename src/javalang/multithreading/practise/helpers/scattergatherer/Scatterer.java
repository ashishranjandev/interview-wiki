package javalang.multithreading.practise.helpers.scattergatherer;

import javalang.multithreading.practise.helpers.Colleague;

import java.util.concurrent.Callable;

public interface Scatterer {
    boolean hasNext();
    Callable<Colleague> next();
}
