package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-02-24.
 */
public class CsvRevision implements Serializable {

	//"318318227506:Home:true:150225014049:150217205340:150225033535:150225031500"
	private String thermostatId;
	private String thermostatName;
	private Boolean connected;
	private String thermostatRevision;
	private String alertsRevision;
	private String runtimeRevision;
	private String intervalRevision;

	public String getThermostatId() {
		return thermostatId;
	}

	public void setThermostatId(String thermostatId) {
		this.thermostatId = thermostatId;
	}

	public String getThermostatName() {
		return thermostatName;
	}

	public void setThermostatName(String thermostatName) {
		this.thermostatName = thermostatName;
	}

	public Boolean getConnected() {
		return connected;
	}

	public void setConnected(Boolean connected) {
		this.connected = connected;
	}

	public String getThermostatRevision() {
		return thermostatRevision;
	}

	public void setThermostatRevision(String thermostatRevision) {
		this.thermostatRevision = thermostatRevision;
	}

	public String getAlertsRevision() {
		return alertsRevision;
	}

	public void setAlertsRevision(String alertsRevision) {
		this.alertsRevision = alertsRevision;
	}

	public String getRuntimeRevision() {
		return runtimeRevision;
	}

	public void setRuntimeRevision(String runtimeRevision) {
		this.runtimeRevision = runtimeRevision;
	}

	public String getIntervalRevision() {
		return intervalRevision;
	}

	public void setIntervalRevision(String intervalRevision) {
		this.intervalRevision = intervalRevision;
	}
}
