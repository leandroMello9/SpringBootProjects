package com.gzip.teste.compactacao;

import java.io.Serializable;

public class Slip implements Serializable {
    private SlipBody slip;

    public Slip() {
    }

    public SlipBody getSlip() {
        return slip;
    }

    public void setSlip(SlipBody slip) {
        this.slip = slip;
    }
}
