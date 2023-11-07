package com.koroyan.restassuredexample.enums;

public enum  SOAPAction {
    ADD_INTEGER("AddInteger"),
    DIVIDE_INTEGER("DivideInteger"),
    FIND_PERSON("FindPerson"),
    GET_LIST_BY_NAME("GetLIstByName");

    private final String value;

    SOAPAction(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
