package javalang.multithreading.practise.helpers;

import java.util.ArrayList;
import java.util.List;

public class SyncMalFormedColleagueService implements MalFormedColleagueService{

    private List<Colleague> colleagueList = new ArrayList<>();

    private List<String> exceptionList = new ArrayList<>();


    public SyncMalFormedColleagueService getInstance() {
        return this;
    }

    public SyncMalFormedColleagueService() {

    }

    public void add(Colleague colleague, String message) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        colleagueList.add(colleague);
        exceptionList.add(message);
    }
}
