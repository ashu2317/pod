package com.talpods.routesortingservice.model;

import lombok.Data;

@Data
public class BoardingPassModel {
    private String from;
    private String to;
    private String seat;
    private String transportType;
    private String instruction;

    public BoardingPassModel() {
    }

    public BoardingPassModel(String from, String to, String seat, String transportType, String instruction) {
        this.from = from;
        this.to = to;
        this.seat = seat;
        this.transportType = transportType;
        this.instruction = instruction;
    }

    public String prepareTheRouteInstruction() {
        String routeInstruction = "Take %S %S to %S. %S. %S";
        return String.format(routeInstruction, transportType, from, to, "Sit in seat " + seat == null? "No seat assignment.": seat, instruction);
    }
}
