package com.javeylew.stt.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TranslateResult {
    private List<Translation> translations;


    public TranslateResult() {
    }

    public TranslateResult(List<Translation> res) {
        this.translations = res;
    }

    public List<Translation> getRes() {
        return translations;
    }

    public void setRes(List<Translation> res) {
        this.translations = res;
    }

    @Override
    public String toString() {
        return "TranslateResult{" +
                "res=" + translations +
                '}';
    }
}


