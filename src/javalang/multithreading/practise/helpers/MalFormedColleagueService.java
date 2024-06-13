package javalang.multithreading.practise.helpers;

public interface MalFormedColleagueService {

    MalFormedColleagueService getInstance();

    void add(Colleague colleague, String message);
}
