package com.jonny.model;

public class Raiting {
    private int idPerson;
    private int raitingPerson;
    private float raitingTotalPerson;
    private boolean wasAutoWin;

    public Raiting(int idPerson, int raitingPerson, float raitingTotalPerson, boolean wasAutoWin) {
        this.idPerson = idPerson;
        this.raitingPerson = raitingPerson;
        this.raitingTotalPerson = raitingTotalPerson;
        this.wasAutoWin = wasAutoWin;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getRaitingPerson() {
        return raitingPerson;
    }

    public void setRaitingPerson(int raitingPerson) {
        this.raitingPerson = raitingPerson;
    }

    public float getRaitingTotalPerson() {
        return raitingTotalPerson;
    }

    public void setRaitingTotalPerson(float raitingTotalPerson) {
        this.raitingTotalPerson = raitingTotalPerson;
    }

    public boolean isWasAutoWin() {
        return wasAutoWin;
    }

    public void setWasAutoWin(boolean wasAutoWin) {
        this.wasAutoWin = wasAutoWin;
    }
}
