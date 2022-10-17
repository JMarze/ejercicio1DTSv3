package testClean;

import factoryRequest.FactoryRequest;
import factoryRequest.RequestInfo;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import util.ApiConfiguration;

import static org.hamcrest.Matchers.equalTo;

public class ItemsTest {
    Response response;
    JSONObject body = new JSONObject();
    RequestInfo requestInfo = new RequestInfo();

    @Test
    public void verifyCRUDItems(){
        /*
         * CREACIÓN
         */
        body.put("Content", "Nuevo Item");
        requestInfo.setUrl(ApiConfiguration.CREATE_ITEM);
        requestInfo.setBody(body.toString());

        response = FactoryRequest.make("post").send(requestInfo);
        response.then().body(
                "Content", equalTo(body.get("Content"))
        ).statusCode(200);

        int idItem = response.then().extract().path("Id");

        /*
         * LECTURA
         */
        requestInfo.setUrl(String.format(ApiConfiguration.READ_ITEM, idItem));
        response = FactoryRequest.make("get").send(requestInfo);
        response.then().body(
                "Content", equalTo(body.get("Content"))
        ).statusCode(200);

        /*
         * ACTUALIZACIÓN
         */
        body.remove("Content");
        body.put("Content", "Item Modificado");
        body.put("Checked", "true");
        requestInfo.setUrl(String.format(ApiConfiguration.UPDATE_ITEM, idItem));
        requestInfo.setBody(body.toString());
        response = FactoryRequest.make("put").send(requestInfo);
        response.then().body(
                "Content", equalTo(body.get("Content"))
        ).statusCode(200);

        /*
         * ELIMINACIÓN
         */
        requestInfo.setUrl(String.format(ApiConfiguration.DELETE_ITEM, idItem));
        response = FactoryRequest.make("delete").send(requestInfo);
        response.then().body(
                "Id", equalTo(idItem)
        ).statusCode(200);
    }
}
