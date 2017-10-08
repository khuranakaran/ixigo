
package com.neuron.ixigo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Appendix {

    @SerializedName("airlines")
    @Expose
    private Airlines airlines;
    @SerializedName("airports")
    @Expose
    private Airports airports;
    @SerializedName("providers")
    @Expose
    private Providers providers;

    public Airlines getAirlines() {
        return airlines;
    }

    public void setAirlines(Airlines airlines) {
        this.airlines = airlines;
    }

    public Airports getAirports() {
        return airports;
    }

    public void setAirports(Airports airports) {
        this.airports = airports;
    }

    public Providers getProviders() {
        return providers;
    }

    public void setProviders(Providers providers) {
        this.providers = providers;
    }

}
