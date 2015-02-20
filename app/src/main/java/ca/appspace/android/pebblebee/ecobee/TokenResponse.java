package ca.appspace.android.pebblebee.ecobee;

import java.io.Serializable;

/**
 * Created by eugene on 2015-02-12.
 */
public class TokenResponse implements Serializable {
    /*
        {
            "access_token": "Rc7JE8P7XUgSCPogLOx2VLMfITqQQrjg",
            "token_type": "Bearer",
            "expires_in": 59,
            "refresh_token": "og2Obost3ucRo1ofo0EDoslGltmFMe2g",
            "scope": "smartWrite"
        }
     */
    private String access_token;
    private String token_type;
    private int expires_in;
    private String refresh_token;
    private String scope;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
