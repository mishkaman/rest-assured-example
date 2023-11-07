package com.koroyan.restassuredexample.data.models;

import java.sql.Date;
import java.util.List;

public class Humans {

    public static class PersonIdentification {
        public int ID;
        public String Name;
        public String SSN;
        public Date DOB;
    }

    public static class GetListByNameResult {
        public List<PersonIdentification> PersonIdentification;
    }

    public static class GetListByNameResponse {
        public GetListByNameResult GetListByNameResult;
        public String xmlns;
        public String text;
    }

}
