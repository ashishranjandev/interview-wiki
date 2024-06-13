package interview.zium;

import java.util.ArrayList;
import java.util.List;

public class ResponseParser {

    /*
    public static void main (String...args) {
        List<String> inputList = new ArrayList<>();
        inputList.add("username");
        inputList.add("EQUALS");
        inputList.add("CharviM");

        System.out.println(apiResponseParser(inputList, 3));
        System.out.println();
        System.out.println("*************************************");
        System.out.println();

        inputList = new ArrayList<>();
        inputList.add("company.name");
        inputList.add("IN");
        inputList.add("robert-techgiant,Sanganak");

        System.out.println(apiResponseParser(inputList, 3));
    }

    public static List<Integer> apiResponseParser(List<String> inputList, int size) {
        List<Integer> answer = new ArrayList<>();
        String jsonResponse = fetchDataFromRestEndpoint("https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users");
        com.google.gson.JsonArray jsonResponseArray =
                new com.google.gson.Gson().fromJson(jsonResponse, com.google.gson.JsonArray.class);

        String fieldName = inputList.get(0);
        String operation = inputList.get(1);
        String value = inputList.get(2);
        for (com.google.gson.JsonElement element: jsonResponseArray) {
            System.out.println(String.format(" Comparing %s %s %s %s", element, fieldName, operation, value));
            if (isConditionTrue(element, fieldName, operation, value)) {
                com.google.gson.JsonObject jsonObject = element.getAsJsonObject();
                answer.add(jsonObject.get("id").getAsInt());
            }
        }

        if (answer.size() == 0) {
            answer.add(-1);
        }
        return answer;
    }

    private static boolean isConditionTrue(com.google.gson.JsonElement element, String field, String operation, String value) {
        String jsonPath = field;
        String result = extractJsonValue(element, jsonPath);
        System.out.println(String.format(" Extracing json path - %s, result - %s", jsonPath, result));

        if (result == null) {
            return false;
        }
        String inputValue = result.toString();
        if ("EQUALS".equals(operation)) {
            return value.equals(inputValue);
        } else {
            String[] inValues = value.split(",");
            for (int index = 0; index < inValues.length; index++) {

            }
            for (String inValue : inValues) {
                System.out.println(String.format("comparing %s with %s", inValue, inputValue));
                if (inValue.equals(inputValue)) {
                    System.out.println("MATCH");
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private static String extractJsonValue(com.google.gson.JsonElement jsonElement, String jsonPath) {
        String[] pathSegments = jsonPath.split("\\.");
        com.google.gson.JsonElement currentElement = jsonElement;

        for (String pathSegment : pathSegments) {
            if (currentElement != null && currentElement.isJsonObject()) {
                com.google.gson.JsonObject jsonObject = currentElement.getAsJsonObject();
                currentElement = jsonObject.get(pathSegment);
            } else if (currentElement != null && currentElement.isJsonArray()) {
                com.google.gson.JsonArray jsonArray = currentElement.getAsJsonArray();
                try {
                    int index = Integer.parseInt(pathSegment);
                    currentElement = jsonArray.get(index);
                } catch (NumberFormatException e) {
                    return null;
                }
            } else {
                return null;
            }
        }
        if (currentElement != null && currentElement.isJsonPrimitive()) {
            return currentElement.getAsString();
        } else {
            return null;
        }
    }

    private static String fetchDataFromRestEndpoint(String url) {
        String response = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Vinay Kumar\",\n" +
                "    \"username\": \"vinayk\",\n" +
                "    \"email\": \"vinayk@abcu.com\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"random1\",\n" +
                "      \"suite\": \"APR\",\n" +
                "      \"city\": \"Mumbai\",\n" +
                "      \"zipcode\": \"192008-13874\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"-17.3159\",\n" +
                "        \"lng\": \"91.1496\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"website\": \"seuinfra.org\",\n" +
                "    \"company\": {\n" +
                "      \"name\": \"sec infra\",\n" +
                "      \"basename\": \"seu infra tech\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"Anandita Basu\",\n" +
                "    \"username\": \"PrernaB\",\n" +
                "    \"email\": \"Anandita.b@abc1f.cpm\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"Hawroh Bridge\",\n" +
                "      \"suite\": \"ATY\",\n" +
                "      \"city\": \"Kolkata\",\n" +
                "      \"zipcode\": \"700001\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"-67.3159\",\n" +
                "        \"lng\": \"91.8006\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"website\": \"techInfar.org\",\n" +
                "    \"company\": {\n" +
                "      \"name\": \"tech infar world\",\n" +
                "      \"basename\": \"seu infra tech\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 3,\n" +
                "    \"name\": \"Charvi Malhotra\",\n" +
                "    \"username\": \"CharviM\",\n" +
                "    \"email\": \"Charvim@mail.net\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"whitehouse Extension\",\n" +
                "      \"suite\": \"A782\",\n" +
                "      \"city\": \"Bengaluru\",\n" +
                "      \"zipcode\": \"560001\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"-68.6102\",\n" +
                "        \"lng\": \"-47.0653\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"website\": \"Infesystem.info\",\n" +
                "    \"company\": {\n" +
                "      \"name\": \"infeystems\",\n" +
                "      \"basename\": \"Information E stsyem\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 4,\n" +
                "    \"name\": \"Patricia Wilson\",\n" +
                "    \"username\": \"WilsonP\",\n" +
                "    \"email\": \"Wilsonp@mymail.org\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"Kalangut\",\n" +
                "      \"suite\": \"Apt 6\",\n" +
                "      \"city\": \"Panjim\",\n" +
                "      \"zipcode\": \"403110\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"29.4572\",\n" +
                "        \"lng\": \"-164.2990\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"website\": \"giant.Tech.biz\",\n" +
                "    \"company\": {\n" +
                "      \"name\": \"robert-techgiant\",\n" +
                "      \"basename\": \"transition cutting-edge web services provider\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 5,\n" +
                "    \"name\": \"Chetan Chauhan \",\n" +
                "    \"username\": \"ChauhanChetan\",\n" +
                "    \"email\": \"chetanc@mailme.in\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"Willow Walks\",\n" +
                "      \"suite\": \"1351\",\n" +
                "      \"city\": \"Hyderabad\",\n" +
                "      \"zipcode\": \"500001\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"-31.8129\",\n" +
                "        \"lng\": \"62.5342\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"website\": \"sanganak.info\",\n" +
                "    \"company\": {\n" +
                "      \"name\": \"Sanganak\",\n" +
                "      \"basename\": \"end-to-end solution provider\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 6,\n" +
                "    \"name\": \"Pragya Mathur\",\n" +
                "    \"username\": \"mathurpragya\",\n" +
                "    \"email\": \"pragya.mathur@mail.in\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"Rosewind Crossing\",\n" +
                "      \"suite\": \"A-50\",\n" +
                "      \"city\": \"Delhi\",\n" +
                "      \"zipcode\": \"100001\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"-71.4197\",\n" +
                "        \"lng\": \"71.7478\"\n" +
                "      }\n" +
                "    },\n" +
                "        \"website\": \"hola.in\",\n" +
                "    \"company\": {\n" +
                "      \"name\": \"Hola Technocrafts\",\n" +
                "      \"basename\": \"e-enable innovative applications\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7,\n" +
                "    \"name\": \"Krish Ahuja\",\n" +
                "    \"username\": \"ahujakrish\",\n" +
                "    \"email\": \"ahujakrish@mails.in\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"Havmore Extension\",\n" +
                "      \"suite\": \"A3221\",\n" +
                "      \"city\": \"Bengalura\",\n" +
                "      \"zipcode\": \"560058\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"24.8918\",\n" +
                "        \"lng\": \"21.8984\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"website\": \"tellybelly.in\",\n" +
                "    \"company\": {\n" +
                "      \"name\": \"Telly Belly\",\n" +
                "      \"basename\": \"generate application support solutions\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 8,\n" +
                "    \"name\": \"Nilofar Anam\",\n" +
                "    \"username\": \"anamnilofar\",\n" +
                "    \"email\": \"nilofaranam.d@maily.me\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"fountains lane\",\n" +
                "      \"suite\": \"B902\",\n" +
                "      \"city\": \"pune\",\n" +
                "      \"zipcode\": \"400001\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"-14.3990\",\n" +
                "        \"lng\": \"-120.7677\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"website\": \"techoba.com\",\n" +
                "    \"company\": {\n" +
                "      \"name\": \"Tech Happy Group\",\n" +
                "      \"basename\": \"e-support to middle retailers\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 9,\n" +
                "    \"name\": \"Garima Gupta\",\n" +
                "    \"username\": \"Garimag\",\n" +
                "    \"email\": \"gupta.garima22@myemails.io\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"Little Park\",\n" +
                "      \"suite\": \"B68\",\n" +
                "      \"city\": \"Surat\",\n" +
                "      \"zipcode\": \"764920\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"24.6463\",\n" +
                "        \"lng\": \"-168.8889\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"website\": \"contech.com\",\n" +
                "    \"company\": {\n" +
                "      \"name\": \"Configs Techs\",\n" +
                "      \"basename\": \"real-time technologies support\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 10,\n" +
                "    \"name\": \"Dharma Dhar\",\n" +
                "    \"username\": \"Dharmadhar55\",\n" +
                "    \"email\": \"dharmadhar55@olexa.in\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"Anam Street\",\n" +
                "      \"suite\": \"198/23\",\n" +
                "      \"city\": \"Surat\",\n" +
                "      \"zipcode\": \"314280\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"-38.2386\",\n" +
                "        \"lng\": \"57.2232\"\n" +
                "      }\n" +
                "    },\n" +
                "     \"website\": \"ampitech.net\",\n" +
                "    \"company\": {\n" +
                "      \"name\": \"Ampitech Solutions Ltd\",\n" +
                "      \"basename\": \"target end-to-end startup support\"\n" +
                "    }\n" +
                "  }\n" +
                "]";
        return response;
    }
    */
}
