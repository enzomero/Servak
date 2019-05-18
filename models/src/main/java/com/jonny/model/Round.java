package com.jonny.model;

public class Round {
    private int idPerson;
    private int idOpponent;
    private Score scorePerson;

    public Round(int idPerson, int idOpponent, Score scorePerson) {
        this.idPerson = idPerson;
        this.idOpponent = idOpponent;
        this.scorePerson = scorePerson;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdOpponent() {
        return idOpponent;
    }

    public void setIdOpponent(int idOpponent) {
        this.idOpponent = idOpponent;
    }

    public Score getScorePerson() {
        return scorePerson;
    }

    public void setScorePerson(Score scorePerson) {
        this.scorePerson = scorePerson;
    }
}
