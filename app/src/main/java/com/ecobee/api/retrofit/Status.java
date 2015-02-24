package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-02-19.
 * Response status object.
 * @see https://www.ecobee.com/home/developer/api/documentation/v1/objects/Status.shtml
 */
public class Status implements Serializable {

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
