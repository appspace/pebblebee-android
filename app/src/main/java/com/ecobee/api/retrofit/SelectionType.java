package com.ecobee.api.retrofit;

/**
 * Created by Eugene on 2015-02-19.
 */
public enum SelectionType {

    NONE("none"),
    THERMOSTATS("thermostats"),
    USERS("user"),
    MANAGEMENT_SET("managementSet"),
	REGISTERED("registered");

    private final String textValue;

    private SelectionType(String textValue) {
        this.textValue = textValue;
    }

	public String asJsonValue() {
		return textValue;
	}

    @Override
    public String toString() {
        return "SelectionType{" +
                "textValue='" + textValue + '\'' +
                '}';
    }
}
