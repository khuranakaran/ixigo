
package com.neuron.ixigo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Flight {

    @SerializedName("originCode")
    @Expose
    private String originCode;
    @SerializedName("destinationCode")
    @Expose
    private String destinationCode;
    @SerializedName("departureTime")
    @Expose
    private Long departureTime;
    @SerializedName("arrivalTime")
    @Expose
    private Long arrivalTime;
    @SerializedName("fares")
    @Expose
    private List<Fare> fares = null;
    @SerializedName("airlineCode")
    @Expose
    private String airlineCode;
    @SerializedName("class")
    @Expose
    private String _class;

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public Long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Long departureTime) {
        this.departureTime = departureTime;
    }

    public Long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<Fare> getFares() {
        return fares;
    }

    public void setFares(List<Fare> fares) {
        this.fares = fares;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

}
