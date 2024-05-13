package com.learning.cartservice.model;

public class Barcode {
    private String barcodeId;
    private String barcodeData;

    public Barcode() {
    }

    public Barcode(String barcodeId, String barcodeData) {
        this.barcodeId = barcodeId;
        this.barcodeData = barcodeData;
    }

    public String getBarcodeId() {
        return barcodeId;
    }

    public void setBarcodeId(String barcodeId) {
        this.barcodeId = barcodeId;
    }

    public String getBarcodeData() {
        return barcodeData;
    }

    public void setBarcodeData(String barcodeData) {
        this.barcodeData = barcodeData;
    }
}
