package com.javeylew.stt.pojo;

import org.springframework.stereotype.Component;

@Component
public class TranslateInput {
    private String inputLang;
    private String inputText;

    public TranslateInput() {
    }

    public TranslateInput(String inputLang, String inputText) {
        this.inputLang = inputLang;
        this.inputText = inputText;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public String getInputLang() {
        return inputLang;
    }

    public void setInputLang(String inputLang) {
        this.inputLang = inputLang;
    }

    @Override
    public String toString() {
        return "TranslateInput{" +
                "inputLang='" + inputLang + '\'' +
                ", inputText='" + inputText + '\'' +
                '}';
    }
}
