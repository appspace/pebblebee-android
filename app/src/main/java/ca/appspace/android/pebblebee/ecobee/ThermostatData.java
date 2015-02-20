package ca.appspace.android.pebblebee.ecobee;

import java.io.Serializable;

/**
 * Created by eugene on 2015-02-19.
 */
public class ThermostatData implements Serializable {

    private Page page;
    private Status status;
    private Thermostat[] thermostatList;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Thermostat[] getThermostatList() {
        return thermostatList;
    }

    public void setThermostatList(Thermostat[] thermostatList) {
        this.thermostatList = thermostatList;
    }
}
