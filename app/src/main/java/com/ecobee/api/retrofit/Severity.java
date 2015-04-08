package com.ecobee.api.retrofit;

/**
 * Created by Eugene on 2015-04-08.
 */
public enum Severity {

    LOW("low"),
    MEDIUM("medium"),
    HIGH("high");

    private final String textValue;

    private Severity(String textValue) {
        this.textValue = textValue;
    }

    public String asJsonValue() {
        return textValue;
    }

    @Override
    public String toString() {
        return "Severity{"+ textValue +"}";
    }

}
