package com.francescociulla.springboot.model;

/**
 * Created by FrancescoXX on 06/09/17.
 */
public class Token {

    private String theToken;

    public Token(String theToken) {
        this.theToken = theToken;
    }

    public String getTheToken() {
        return theToken;
    }

    public void setTheToken(String theToken) {
        this.theToken = theToken;
    }
}
