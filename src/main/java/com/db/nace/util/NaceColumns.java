package com.db.nace.util;

public enum NaceColumns {
    ORDER(1,"Order");
    private int colNumber;
    private String colHeading;

    NaceColumns(int colNumber, String colHeading) {
        this.colNumber = colNumber;
        this.colHeading = colHeading;
    }




}
