
package com.neuron.ixigo.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightSearch {

    @SerializedName("appendix")
    @Expose
    private Appendix appendix;
    @SerializedName("flights")
    @Expose
    private List<Flight> flights = null;

    public Appendix getAppendix() {
        return appendix;
    }

    public void setAppendix(Appendix appendix) {
        this.appendix = appendix;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

}
