package javalang.multithreading.practise.helpers;

import java.util.HashMap;
import java.util.Map;

public class StatsLedger {

    private static StatsLedger statsLedger = new StatsLedger();

    private Long totalPayroll;

    private Map<String, Integer> cityCount;


    public static StatsLedger getInstance() {
        return statsLedger;
    }

    private StatsLedger() {

    }

    public void recordEntry(Colleague colleague) {
        totalPayroll += colleague.getSalary();
        cityCount.put(colleague.getCity(), cityCount.get(colleague.getCity()) + 1);
    }

    public Map<String, Integer> getCityCount() {
        return new HashMap<>();
    }
}
