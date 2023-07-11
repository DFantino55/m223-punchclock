package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;

import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Test;

import com.google.common.net.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.swing.text.AbstractDocument.Content;
import javax.ws.rs.core.Response;

import ch.zli.m223.model.Entry;
import groovy.json.JsonBuilder;

@QuarkusTest
public class EntryResourceTest {

    @Test
    public void testIndexEndpoint() {
        given()
          .when().get("/entries")
          .then()
             .statusCode(200)
             .body(is("[]"));
    }
    /* 
    @Test
    public void testCreateEntry() {
        Entry entry = new Entry();
        entry.setCheckIn(null);
        entry.setCheckOut(null);

        given()
            .contentType()
            .body(JsonBuilder.create().toJson(entry))
        .when()
            .post("/entries")
        .then()
            .statusCode(200)
            .body(is("[]"));
    }
    */
}