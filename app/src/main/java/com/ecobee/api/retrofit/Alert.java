package com.ecobee.api.retrofit;

import java.io.Serializable;

/**
 * Created by eugene on 2015-03-01.
 */
public class Alert implements Serializable {
    private String acknowledgeRef;
    private String date;
    private String time;
    private Severity severity;
    private String text;
    private Integer alertNumber;
    private AlertType alertType;
    private Boolean isOperatorAlert;
    private String reminder;
    private Boolean showIdt;
    private Boolean showWeb;
    private Boolean sendEmail;
    private String acknowledgement;
    private Boolean remindMeLater;
    private String thermostatIdentifier;
    private NotificationType notificationType;

    public String getAcknowledgeRef() {
        return acknowledgeRef;
    }

    public void setAcknowledgeRef(String acknowledgeRef) {
        this.acknowledgeRef = acknowledgeRef;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getAlertNumber() {
        return alertNumber;
    }

    public void setAlertNumber(Integer alertNumber) {
        this.alertNumber = alertNumber;
    }

    public AlertType getAlertType() {
        return alertType;
    }

    public void setAlertType(AlertType alertType) {
        this.alertType = alertType;
    }

    public Boolean getIsOperatorAlert() {
        return isOperatorAlert;
    }

    public void setIsOperatorAlert(Boolean isOperatorAlert) {
        this.isOperatorAlert = isOperatorAlert;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public Boolean getShowIdt() {
        return showIdt;
    }

    public void setShowIdt(Boolean showIdt) {
        this.showIdt = showIdt;
    }

    public Boolean getShowWeb() {
        return showWeb;
    }

    public void setShowWeb(Boolean showWeb) {
        this.showWeb = showWeb;
    }

    public Boolean getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(Boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public String getAcknowledgement() {
        return acknowledgement;
    }

    public void setAcknowledgement(String acknowledgement) {
        this.acknowledgement = acknowledgement;
    }

    public Boolean getRemindMeLater() {
        return remindMeLater;
    }

    public void setRemindMeLater(Boolean remindMeLater) {
        this.remindMeLater = remindMeLater;
    }

    public String getThermostatIdentifier() {
        return thermostatIdentifier;
    }

    public void setThermostatIdentifier(String thermostatIdentifier) {
        this.thermostatIdentifier = thermostatIdentifier;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }
}
