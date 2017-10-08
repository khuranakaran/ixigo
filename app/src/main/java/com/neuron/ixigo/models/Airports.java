
package com.neuron.ixigo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Airports {

    @SerializedName("DEL")
    @Expose
    private String dEL;
    @SerializedName("BOM")
    @Expose
    private String bOM;

    public String getDEL() {
        return dEL;
    }

    public void setDEL(String dEL) {
        this.dEL = dEL;
    }

    public String getBOM() {
        return bOM;
    }

    public void setBOM(String bOM) {
        this.bOM = bOM;
    }

}
