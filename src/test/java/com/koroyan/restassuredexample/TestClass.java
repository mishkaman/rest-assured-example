package com.koroyan.restassuredexample;

import com.koroyan.restassuredexample.data.models.Humans;
import com.koroyan.restassuredexample.enums.SOAPAction;
import com.koroyan.restassuredexample.steps.StepsGetListByName;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TestClass {
    @Test
    public void test(){
        StepsGetListByName steps = new StepsGetListByName();
        Humans.GetListByNameResponse response = steps.sendRequestAndGetResponse();
        List<Humans.PersonIdentification> humans = steps.getHumans(response);
    }
}

