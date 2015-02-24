package com.ecobee.api.retrofit;

import com.ecobee.api.retrofit.ApiInfoObject;
import com.ecobee.api.retrofit.Status;

/**
 * Created by eugene on 2015-02-22.
 */
public class ThermostatSummary implements ApiInfoObject {

	private Status status;
	private Integer thermostatCount;
	private String[] revisionList;
	private String[] statusList;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getThermostatCount() {
		return thermostatCount;
	}

	public void setThermostatCount(Integer thermostatCount) {
		this.thermostatCount = thermostatCount;
	}

	public String[] getRevisionList() {
		return revisionList;
	}

	public void setRevisionList(String[] revisionList) {
		this.revisionList = revisionList;
	}

	public String[] getStatusList() {
		return statusList;
	}

	public void setStatusList(String[] statusList) {
		this.statusList = statusList;
	}
}
