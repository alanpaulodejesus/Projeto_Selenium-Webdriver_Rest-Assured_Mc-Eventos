package api.endpoints;

import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class EventoService {

    public Response criarEvento(String nome, String nomeEvento, String dataEvento) {
        Map<String, Object> evento = new HashMap<>();
        evento.put("nomeEvento", nome);
        evento.put("descricaoEvento", nomeEvento);
        evento.put("dataEvento", dataEvento);

        return given()
                .contentType("application/json")
                .body(evento)
                .when()
                .post("/evento")
                .then()
                .log().all()
                .extract().response();
    }

    public Response excluirEvento() {
        return given()
                .contentType("application/json")
                .when()
                .delete("/evento");
    }
}
