package com.variant.ktapp.model;

public class Patients {
    private int patientsId;
    private String patientName;
    private int woundCount;
    private long updateTime;
    private int healProgress;
    private boolean isEmgeancy;


    public Patients(int patientsId, String patientName, int woundCount, long updateTime, int healProgress, boolean isEmgeancy) {
        this.patientsId = patientsId;
        this.patientName = patientName;
        this.woundCount = woundCount;
        this.updateTime = updateTime;
        this.healProgress = healProgress;
        this.isEmgeancy = isEmgeancy;
    }

    public int getPatientsId() {
        return patientsId;
    }

    public void setPatientsId(int patientsId) {
        this.patientsId = patientsId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getWoundCount() {
        return woundCount;
    }

    public void setWoundCount(int woundCount) {
        this.woundCount = woundCount;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getHealProgress() {
        return healProgress;
    }

    public void setHealProgress(int healProgress) {
        this.healProgress = healProgress;
    }

    public boolean isEmgeancy() {
        return isEmgeancy;
    }

    public void setEmgeancy(boolean emgeancy) {
        isEmgeancy = emgeancy;
    }
}
