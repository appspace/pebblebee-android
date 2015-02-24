package ca.appspace.android.pebblebee.ecobee;

import java.io.Serializable;

import retrofit.RetrofitError;

/**
 * Created by eugene on 2015-02-23.
 */
public class ApiError implements ApiInfoObject {
	/*{
		"error": "invalid_client",
			"error_descripton": "Authentication error, invalid authentication method, lack of credentials, etc.",
			"error_uri": "http://tools.ietf.org/html/draft-ietf-oauth-v2-31#section-5.2"
	}*/
	private String error;
	private String error_descripton;    //Yes, there is a typo here :(
	private String error_uri;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorDescription() {
		return error_descripton;
	}

	public void setErrorDescription(String error_description) {
		this.error_descripton = error_description;
	}

	public String getErrorUri() {
		return error_uri;
	}

	public void setErrorUri(String error_uri) {
		this.error_uri = error_uri;
	}
}
