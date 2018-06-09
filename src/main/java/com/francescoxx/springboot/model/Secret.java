package com.francescoxx.springboot.model;

/**
 * Created by FrancescoXX on 06/09/17.
 */
public class Secret {

    private int message;

    public Secret() {
    }

    public Secret(int message) {
        this.message = message;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Secret{" +
                "message='" + message + '\'' +
                '}';
    }
}
