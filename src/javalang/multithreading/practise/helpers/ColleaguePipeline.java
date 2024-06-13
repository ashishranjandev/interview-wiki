package javalang.multithreading.practise.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class ColleaguePipeline {

    private MalFormedColleagueService malFormedColleagueService = null;

    private BufferedReader reader;

    public ColleaguePipeline(MalFormedColleagueService malFormedColleagueService) {
        this.malFormedColleagueService = malFormedColleagueService;
    }

    public Map<String, Integer> process(InputStream stream) {
        System.out.println("Starting Processing of Stream");
        Colleague inputColleague;
        while ((inputColleague = readColleague(stream)) != null ) {
            System.out.println("Processing Colleague " + inputColleague.getEmailAddress());
            final Colleague colleague = inputColleague;
            try {
                validateAddress(colleague);
                formatPhoneNumber(colleague);

                validateEmail(colleague);
                    StatsLedger.getInstance().recordEntry((inputColleague));
            } catch (Exception e) {
                malFormedColleagueService.getInstance().add(colleague, e.getMessage());
            }
        }
        return StatsLedger.getInstance().getCityCount();
    }


    private void validateEmail(Colleague colleague) {
        sleep(100);
    }

    private Colleague readColleague(InputStream stream) {
        System.out.println("Reading Colleague from Stream");
        if (reader == null) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }
        try {
            // Read and return the first line
            String line = reader.readLine();
            if (line != null) {
                String[] data = line.split(",");
                Colleague colleague = new Colleague();
                colleague.setFirstName(data[0]);
                colleague.setLastName(data[1]);
                colleague.setCity(data[2]);
                colleague.setPincode(Integer.valueOf(data[3]));
                colleague.setPhoneNumber(data[4]);
                colleague.setEmailAddress(data[5]);
                colleague.setSalary(Long.valueOf(data[6]));
                return colleague;
            } else {
                System.out.println("Stream return null");
            }
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void formatPhoneNumber(Colleague colleague) {
        sleep(1000);
        if (colleague.getPhoneNumber() != null && !colleague.getPhoneNumber().startsWith("+91")) {
            colleague.setPhoneNumber("+91" + colleague.getPhoneNumber());
        }
    }

    private void validateAddress(Colleague colleague) {
        sleep(100);
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setMalFormedColleagueService(
            MalFormedColleagueService malFormedColleagueService) {
        this.malFormedColleagueService = malFormedColleagueService;
    }
}
