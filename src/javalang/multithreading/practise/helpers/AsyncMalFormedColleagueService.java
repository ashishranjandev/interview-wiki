package javalang.multithreading.practise.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncMalFormedColleagueService implements MalFormedColleagueService {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    private List<Colleague> colleagueList = new ArrayList<>();

    private List<String> exceptionList = new ArrayList<>();


    public MalFormedColleagueService getInstance() {
        return this;
    }

    public AsyncMalFormedColleagueService() {

    }

    public void add(Colleague colleague, String message) {
        executorService.submit(() -> addExceptions(colleague, message));
    }

    public void addExceptions(Colleague colleague, String message) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        colleagueList.add(colleague);
        exceptionList.add(message);
    }
}
