package interview.uprnetwrkz;

import java.util.*;
import java.util.stream.*;

public class IPMain2 {

    public static Map<String, String> findNextHops(List<PbrEntry> pbrEntries, List<String> ipAddresses) {
        Map<String, String> nextHopMap = new HashMap<>();
        for (String ipAddress : ipAddresses) {
            int highestPrefixLength = -1;
            String subnetMatch = null;

            for (PbrEntry pbrEntry : pbrEntries) {
                String[] subnetParts = pbrEntry.ipv4Subnet.split("/");
                String subnetIpAddress = subnetParts[0];
                Integer prefixLength = Integer.parseInt(subnetParts[1]);

                if (isPartOfSubnet(subnetIpAddress, ipAddress, prefixLength) && prefixLength >= highestPrefixLength) {
                    highestPrefixLength = prefixLength;
                    subnetMatch = pbrEntry.nextHop;
                }
            }
            nextHopMap.put(ipAddress, (subnetMatch == null) ? ipAddress : subnetMatch);
        }

        return nextHopMap;
    }

    private static boolean isPartOfSubnet(String subnetIpAddress, String ipAddress, Integer prefixLength) {
        String[] ipParts = ipAddress.split("\\.");
        String[] subnetParts = subnetIpAddress.split("\\.");

        for (int i = 0; i < prefixLength / 8; i++) {
            if (!ipParts[i].equals(subnetParts[i])) {
                return false;
            }
        }

        if (prefixLength % 8 != 0) {
            int remainingBits = prefixLength % 8;
            int ipPart = Integer.parseInt(ipParts[prefixLength / 8]);
            int subnetPart = Integer.parseInt(subnetParts[prefixLength / 8]);

            int mask = (1 << (8 - remainingBits)) - 1;
            mask = 255 - mask;

            if ((ipPart & mask) != (subnetPart & mask)) {
                return false;
            }
        }

        return true;
    }

    private static class PbrEntry {

        public final String ipv4Subnet;
        public final String nextHop;

        private PbrEntry(String ipv4Subnet, String nextHop) {
            this.ipv4Subnet = ipv4Subnet;
            this.nextHop = nextHop;
        }
    }



    /* DO NOT EDIT - TEMPLATE CODE */
    public static void main(String[] args) {
        Set<Map.Entry<List<PbrEntry>, Map<String, String>>> entries = TEST_CASES.entrySet();
        int i = 1;
        for (Map.Entry<List<PbrEntry>, Map<String, String>> entry : entries) {
            System.out.print("Test case " + i++ + ": ");
            Map<String, String> nextHopResults = entry.getValue();
            List<String> ipAddresses = nextHopResults.keySet().stream().collect(Collectors.toList());
            Map<String, String> nextHops = findNextHops(entry.getKey(), ipAddresses);
            if (nextHops == null || nextHops.size() != ipAddresses.size()) {
                System.out.println("FAILED");
                System.out.println("Expected next-hops: " + mapToString(nextHopResults));
                System.out.println("Actual next-hops: " + mapToString(nextHops));
                continue;
            }
            boolean failed = false;
            for (String ipAddress : ipAddresses) {
                if (!nextHopResults.get(ipAddress).equals(nextHops.get(ipAddress))) {
                    System.out.println("FAILED");
                    System.out.println("Expected next-hops: " + mapToString(nextHopResults));
                    System.out.println("Actual next-hops: " + mapToString(nextHops));
                    failed = true;
                    break;
                }
            }
            if (failed) {
                continue;
            }
            System.out.println("PASSED");
        }
    }

    public static String mapToString(Map<?, ?> map) {
        if (map == null) {
            return "null";
        }
        return map.keySet().stream().map(key -> key + "=" + map.get(key)).collect(Collectors.joining(", ", "{", "}"));
    }

    private static final Map<List<PbrEntry>, Map<String, String>> TEST_CASES = new HashMap<>();

    static {
        TEST_CASES.put(
                List.of(
                        new PbrEntry("168.19.100.34/32", "1.1.1.1"),
                        new PbrEntry("0.0.0.0/0", "1.1.1.5"),
                        new PbrEntry("168.19.100.0/24", "1.1.1.3"),
                        new PbrEntry("168.19.100.0/8", "1.1.1.4"),
                        new PbrEntry("168.19.100.0/25", "1.1.1.2")
                ),
                Map.of(
                        "168.19.100.34",
                        "1.1.1.1",
                        "168.19.100.198",
                        "1.1.1.3",
                        "169.0.0.0",
                        "1.1.1.5",
                        "168.20.100.23",
                        "1.1.1.4"
                )
        );
        TEST_CASES.put(
                List.of(
                        new PbrEntry("192.10.0.0/16", "1.1.1.1"),
                        new PbrEntry("10.10.0.0/16", "1.1.1.2"),
                        new PbrEntry("168.19.0.0/16", "1.1.1.3"),
                        new PbrEntry("10.11.0.0/16", "1.1.1.4"),
                        new PbrEntry("10.11.0.189/31", "1.1.1.5"),
                        new PbrEntry("10.11.0.11/29", "1.1.1.6")
                ),
                Map.of(
                        "192.10.9.11",
                        "1.1.1.1",
                        "174.19.20.31",
                        "174.19.20.31",
                        "10.10.10.10",
                        "1.1.1.2",
                        "10.11.11.11",
                        "1.1.1.4",
                        "10.11.0.188",
                        "1.1.1.5",
                        "10.11.0.9",
                        "1.1.1.6"
                )
        );
        TEST_CASES.put(
                List.of(),
                Map.of("192.10.9.11", "192.10.9.11", "10.10.10.13", "10.10.10.13", "174.19.20.31", "174.19.20.31")
        );
    }
}
