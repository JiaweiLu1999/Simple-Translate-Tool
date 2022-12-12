package com.javeylew.stt.pojo;

import com.google.gson.annotations.SerializedName;
import org.springframework.stereotype.Component;

@Component
public class Translation {

    @SerializedName("detected_source_language")
    private String detectedSourceLanguage;

    private String text;

    public Translation() {
    }

    public Translation(String detectedSourceLanguage, String text) {
        this.detectedSourceLanguage = detectedSourceLanguage;
        this.text = text;
    }

    public String getDetectedSourceLanguage() {
        return detectedSourceLanguage;
    }

    public void setDetectedSourceLanguage(String detectedSourceLanguage) {
        this.detectedSourceLanguage = detectedSourceLanguage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "translation{" +
                "detectedSourceLanguage='" + detectedSourceLanguage + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
