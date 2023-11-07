package com.koroyan.restassuredexample.steps;

import com.koroyan.restassuredexample.data.models.Humans;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StepsGetListByName {
    @Test
    public Humans.GetListByNameResponse sendRequestAndGetResponse() {
        return XmlPath.from(
                given()
                        .contentType(ContentType.XML)
                        .header("SOAPaction", "http://tempuri.org/SOAP.Demo.GetListByName")
                        .body(new File("src/main/resources/request2.xml"))
                        .post("https://www.crcind.com/csp/samples/SOAP.Demo.cls")
                        .then()
                        .log().all()
                        .extract()
                        .body()
                        .asString()
        ).getObject("", Humans.GetListByNameResponse.class);
    }

    public List<Humans.PersonIdentification> getHumans(Humans.GetListByNameResponse response) {
        List<Humans.PersonIdentification> humans = new ArrayList<>();
        Humans.GetListByNameResult result = response.GetListByNameResult;
        if (result != null) {
            for (Humans.PersonIdentification person : result.PersonIdentification) {
                Humans.PersonIdentification human = new Humans.PersonIdentification();
                human.ID = person.ID;
                human.Name = person.Name;
                human.SSN = person.SSN;
                human.DOB = person.DOB;
                humans.add(human);
            }
        } else {
            System.out.println("GetListByNameResult is null");
        }
        return humans;
    }

}
