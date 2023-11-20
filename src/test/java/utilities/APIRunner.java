//package utilities;
//
//import api.CashWiseAuthorizationToken;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import entities.CustomResponses;
//import entities.RequestBody;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//
//import java.util.Map;
//
//public class APIRunner {
//    private static CustomResponses customResponses;
//    //create method for HTTP GET
//
//
//    public static void runGet(String path) {
//        //url domain and path
//        //parameter and no parameter we will use overloading
//        //token
//
//        String url = Config.getProperty("cashWiseURI") + path;
//        String token = Config.getProperty("studyMateToken");
//
//        Response response = RestAssured.given().auth().oauth2(token).get(url);
//        System.out.println("Status code: " + response.statusCode());
//        //response.prettyPrint();
//
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            customResponses = mapper.readValue(response.asString(), CustomResponses.class);
//            customResponses.setResponseBody(response.asString());
//        } catch (JsonProcessingException e) {
//            System.out.println("This is most likely List of response");
//        }
//
//    }
//
//    public static CustomResponses getCustomResponses() {
//        return customResponses;
//    }
//
//
//    public static void runGet(String path, Map<String, Object> params) {
//        String url = Config.getProperty("cashWiseURI") + path;
//        String token = CashWiseAuthorizationToken.getToken();
//
//        Response response = RestAssured.given().auth().oauth2(token).params(params).get(url);
//        System.out.println("Status code: " + response.statusCode());
//
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            customResponses = mapper.readValue(response.asString(), CustomResponses.class);
//        } catch (JsonProcessingException e) {
//            System.out.println("This is most likely List of response (2)");
//        }
//
//    }
//
//
//    public static void runPOST(String path, RequestBody requestBody) {
//        String url = Config.getProperty("cashWiseURI") + path;
//        CashWiseAuthorizationToken cashWiseAuthorizationToken = new CashWiseAuthorizationToken();
//        String token = CashWiseAuthorizationToken.getToken();
//
//        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON)
//                .body(requestBody).post(url);
//
//        System.out.println("status code: " + response.statusCode());
//        //response.prettyPrint();
//
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            customResponses = mapper.readValue(response.asString(), CustomResponses.class);
//            customResponses.setResponseBody(response.asString());
//        } catch (JsonProcessingException e) {
//            System.out.println("This is most likely List of response");
//        }
//    }
//
//
//    public static void runPUT(String path, RequestBody requestBody) {
//        String url = Config.getProperty("cashWiseURI") + path;
//        CashWiseAuthorizationToken cashWiseAuthorizationToken = new CashWiseAuthorizationToken();
//        String token = CashWiseAuthorizationToken.getToken();
//
//        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON)
//                .body(requestBody).put(url);
//
//        System.out.println("status code: " + response.statusCode());
//        //response.prettyPrint();
//
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            customResponses = mapper.readValue(response.asString(), CustomResponses.class);
//            customResponses.setResponseBody(response.asString());
//        } catch (JsonProcessingException e) {
//            System.out.println("This is most likely List of response");
//        }
//    }
//}
