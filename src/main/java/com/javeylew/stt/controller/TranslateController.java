package com.javeylew.stt.controller;

import com.google.gson.Gson;
import com.javeylew.stt.pojo.TranslateInput;
import com.javeylew.stt.pojo.TranslateResult;
import com.javeylew.stt.pojo.Translation;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

@Controller
public class TranslateController {
    @PostMapping("/translate")
    public String toSuccessPage(@ModelAttribute TranslateInput translateInput,
                                Model model) throws IOException {
        model.addAttribute("translateInput", translateInput);
        System.out.println(translateInput.getInputLang());

        String path = "api-auth/auth.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        properties.load(loader.getResourceAsStream(path));
        String password = properties.getProperty("password");
        System.out.println(password);

        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api-free.deepl.com/v2/translate";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "DeepL-Auth-Key " + password);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        String text = translateInput.getInputText();
        body.add("text", text);
        body.add("target_lang", "ZH");


        HttpEntity<?> entity = new HttpEntity<Object>(body, headers);
        System.out.println(entity.getBody());


        ResponseEntity<String> result =
                restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);


        TranslateResult translateResult = new Gson().fromJson(result.getBody(), TranslateResult.class);

        System.out.println(translateResult);
        model.addAttribute("output", translateResult.getRes().get(0).getText());

        return "index";
    }
}

