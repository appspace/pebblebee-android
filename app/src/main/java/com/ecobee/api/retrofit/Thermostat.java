package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-02-19.
 * https://www.ecobee.com/home/developer/api/documentation/v1/objects/Thermostat.shtml
 */
public class Thermostat implements Serializable {

    private String identifier;
    private String name;
	private String thermostatRev;
	private boolean isRegistered;
	private String modelNumber;
	private String serialNumber;
	private String lastModified;
	private String thermostatTime;
	private String utcTime;
	private Alert[] alerts;
	private Settings settings;
	private Runtime runtime;
	private ExtendedRuntime extendedRuntime;
	private Electricity electricity;
	private Device[] devices;
	private Location location;
	private Technician technician;
	private Utility utility;
	private Management management;
	private Weather weather;
	private Event[] events;
	private Program program;
	private HouseDetails houseDetails;
	private ThermostatOemCfg oemCfg;
	private String equipmentStatus;
	private NotificationSettings notificationSettings;
	private ThermostatPrivacy privacy;
	private Version version;
	private SecuritySettings securitySettings;
    private RemoteSensor[] remoteSensors;

	public Thermostat() {
	}

	public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getThermostatRev() {
		return thermostatRev;
	}

	public void setThermostatRev(String thermostatRev) {
		this.thermostatRev = thermostatRev;
	}

	public boolean isRegistered() {
		return isRegistered;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public String getThermostatTime() {
		return thermostatTime;
	}

	public void setThermostatTime(String thermostatTime) {
		this.thermostatTime = thermostatTime;
	}

	public String getUtcTime() {
		return utcTime;
	}

	public void setUtcTime(String utcTime) {
		this.utcTime = utcTime;
	}

	public Alert[] getAlerts() {
		return alerts;
	}

	public void setAlerts(Alert[] alerts) {
		this.alerts = alerts;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	public Runtime getRuntime() {
		return runtime;
	}

	public void setRuntime(Runtime runtime) {
		this.runtime = runtime;
	}

	public ExtendedRuntime getExtendedRuntime() {
		return extendedRuntime;
	}

	public void setExtendedRuntime(ExtendedRuntime extendedRuntime) {
		this.extendedRuntime = extendedRuntime;
	}

	public Electricity getElectricity() {
		return electricity;
	}

	public void setElectricity(Electricity electricity) {
		this.electricity = electricity;
	}

	public Device[] getDevices() {
		return devices;
	}

	public void setDevices(Device[] devices) {
		this.devices = devices;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public Utility getUtility() {
		return utility;
	}

	public void setUtility(Utility utility) {
		this.utility = utility;
	}

	public Management getManagement() {
		return management;
	}

	public void setManagement(Management management) {
		this.management = management;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public Event[] getEvents() {
		return events;
	}

	public void setEvents(Event[] events) {
		this.events = events;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public HouseDetails getHouseDetails() {
		return houseDetails;
	}

	public void setHouseDetails(HouseDetails houseDetails) {
		this.houseDetails = houseDetails;
	}

	public ThermostatOemCfg getOemCfg() {
		return oemCfg;
	}

	public void setOemCfg(ThermostatOemCfg oemCfg) {
		this.oemCfg = oemCfg;
	}

	public String getEquipmentStatus() {
		return equipmentStatus;
	}

	public void setEquipmentStatus(String equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}

	public NotificationSettings getNotificationSettings() {
		return notificationSettings;
	}

	public void setNotificationSettings(NotificationSettings notificationSettings) {
		this.notificationSettings = notificationSettings;
	}

	public ThermostatPrivacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(ThermostatPrivacy privacy) {
		this.privacy = privacy;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public SecuritySettings getSecuritySettings() {
		return securitySettings;
	}

	public void setSecuritySettings(SecuritySettings securitySettings) {
		this.securitySettings = securitySettings;
	}

    public RemoteSensor[] getRemoteSensors() {
        return remoteSensors;
    }

    public void setRemoteSensors(RemoteSensor[] remoteSensors) {
        this.remoteSensors = remoteSensors;
    }
}
