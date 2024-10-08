package com.gzip.teste.compactacao;

import java.io.Serializable;

public class SlipBody implements Serializable {
    private Integer id;
    private String advice;

    public SlipBody() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
