package ca.appspace.android.pebblebee.ecobee;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by eugene on 2015-02-08.
 */
public class AuthorizeResponse implements Serializable {
    /*
        {
    "ecobeePin": "bv29",
    "code": "uiNQok9Uhy5iScG4gncCAilcFUMK0zWT",
    "scope": "smartWrite",
    "expires_in": 9,
    "interval": 30
    }

     */
    private String ecobeePin;
    private String code;
    private String scope;
    private int expires_in;
    private int interval;

    public String getEcobeePin() {
        return ecobeePin;
    }

    public void setEcobeePin(String ecobeePin) {
        this.ecobeePin = ecobeePin;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public int getExpiresIn() {
        return expires_in;
    }

    public void setExpiresIn(int expires_in) {
        this.expires_in = expires_in;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

}
