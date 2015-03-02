package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/Runtime.shtml
 */
public class Runtime implements Serializable {

	private String runtimeRev;
	private Boolean connected;
	private String firstConnected;
	private String connectDateTime;
	private String disconnectDateTime;
	private String lastModified;
	private String lastStatusModified;
	private String runtimeDate;
	private Integer runtimeInterval;
	private Integer actualTemperature;
	private Integer actualHumidity;
	private Integer desiredHeat;
	private Integer desiredCool;
	private Integer desiredHumidity;
	private Integer desiredDehumidity;
	private String desiredFanMode;

	public String getRuntimeRev() {
		return runtimeRev;
	}

	public void setRuntimeRev(String runtimeRev) {
		this.runtimeRev = runtimeRev;
	}

	public Boolean getConnected() {
		return connected;
	}

	public void setConnected(Boolean connected) {
		this.connected = connected;
	}

	public String getFirstConnected() {
		return firstConnected;
	}

	public void setFirstConnected(String firstConnected) {
		this.firstConnected = firstConnected;
	}

	public String getConnectDateTime() {
		return connectDateTime;
	}

	public void setConnectDateTime(String connectDateTime) {
		this.connectDateTime = connectDateTime;
	}

	public String getDisconnectDateTime() {
		return disconnectDateTime;
	}

	public void setDisconnectDateTime(String disconnectDateTime) {
		this.disconnectDateTime = disconnectDateTime;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public String getLastStatusModified() {
		return lastStatusModified;
	}

	public void setLastStatusModified(String lastStatusModified) {
		this.lastStatusModified = lastStatusModified;
	}

	public String getRuntimeDate() {
		return runtimeDate;
	}

	public void setRuntimeDate(String runtimeDate) {
		this.runtimeDate = runtimeDate;
	}

	public Integer getRuntimeInterval() {
		return runtimeInterval;
	}

	public void setRuntimeInterval(Integer runtimeInterval) {
		this.runtimeInterval = runtimeInterval;
	}

	public Integer getActualTemperature() {
		return actualTemperature;
	}

	public void setActualTemperature(Integer actualTemperature) {
		this.actualTemperature = actualTemperature;
	}

	public Integer getActualHumidity() {
		return actualHumidity;
	}

	public void setActualHumidity(Integer actualHumidity) {
		this.actualHumidity = actualHumidity;
	}

	public Integer getDesiredHeat() {
		return desiredHeat;
	}

	public void setDesiredHeat(Integer desiredHeat) {
		this.desiredHeat = desiredHeat;
	}

	public Integer getDesiredCool() {
		return desiredCool;
	}

	public void setDesiredCool(Integer desiredCool) {
		this.desiredCool = desiredCool;
	}

	public Integer getDesiredHumidity() {
		return desiredHumidity;
	}

	public void setDesiredHumidity(Integer desiredHumidity) {
		this.desiredHumidity = desiredHumidity;
	}

	public Integer getDesiredDehumidity() {
		return desiredDehumidity;
	}

	public void setDesiredDehumidity(Integer desiredDehumidity) {
		this.desiredDehumidity = desiredDehumidity;
	}

	public String getDesiredFanMode() {
		return desiredFanMode;
	}

	public void setDesiredFanMode(String desiredFanMode) {
		this.desiredFanMode = desiredFanMode;
	}
}
