import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class ApiTests {

    private static String URL = "https://cleanuri.com/api/v1/shorten";

    @Test
    public void simpleUriTest() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("url", PropertyReader.getProperty("simple_url"));
        given()
                .header("Content-Type", "application/json")
                .body(requestParams.toString())
                .when()
                .post(URL)
                .then()
                .statusCode(200)
                .and()
                .assertThat().body("$", hasKey("result_url"))
                .and()
                .assertThat().body("result_url", matchesPattern("^https://cleanuri\\.com/\\w+$"))
                .and()
                .assertThat().body("result_url", not(emptyOrNullString()));
    }

    /*
    * Сервис распознает все кривые url, поэтому невозможно добиться того, чтобы
    * вышла ошибка по 1-ому или 2-ому пункту.
    * В качестве примера:
    * first_condition_url - в url есть символ "&", что неудовлетворяет 1 условию (Тест - errorOfTheFirstConditionTest)
    * second_condition_url - в url есть пробелы, что не удовлетворяет 2 условию (Тест - errorOfTheSecondConditionTest)
    * При запуске тестов ожидаемый результат 400, получаем 200.
    * Вывод: сервис обрабатывает все url
    * Ошибку можно получить, только если url будет без "https://" (Тест - incorrectUrlTest)
    * */
    @Test
    public void errorOfTheFirstConditionTest() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("url", PropertyReader.getProperty("first_condition_url"));
        given()
                .header("Content-Type", "application/json")
                .body(requestParams.toString())
                .when()
                .post(URL)
                .then()
                .statusCode(400);
    }

    @Test
    public void errorOfTheSecondConditionTest() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("url", PropertyReader.getProperty("second_condition_url"));
        given()
                .header("Content-Type", "application/json")
                .body(requestParams.toString())
                .when()
                .post(URL)
                .then()
                .statusCode(400);
    }

    @Test
    public void incorrectUrlTest() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("url", PropertyReader.getProperty("incorrect_url"));
        given()
                .header("Content-Type", "application/json")
                .body(requestParams.toString())
                .when()
                .post(URL)
                .then()
                .statusCode(400);
    }

}
