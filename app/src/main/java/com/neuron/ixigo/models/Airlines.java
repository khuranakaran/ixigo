
package com.neuron.ixigo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Airlines {

    @SerializedName("SG")
    @Expose
    private String sG;
    @SerializedName("AI")
    @Expose
    private String aI;
    @SerializedName("G8")
    @Expose
    private String g8;
    @SerializedName("9W")
    @Expose
    private String _9W;
    @SerializedName("6E")
    @Expose
    private String _6E;

    public String getSG() {
        return sG;
    }

    public void setSG(String sG) {
        this.sG = sG;
    }

    public String getAI() {
        return aI;
    }

    public void setAI(String aI) {
        this.aI = aI;
    }

    public String getG8() {
        return g8;
    }

    public void setG8(String g8) {
        this.g8 = g8;
    }

    public String get9W() {
        return _9W;
    }

    public void set9W(String _9W) {
        this._9W = _9W;
    }

    public String get6E() {
        return _6E;
    }

    public void set6E(String _6E) {
        this._6E = _6E;
    }

}
