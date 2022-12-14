package com.darya.crossfit.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CrossfitService {
    private final RestTemplate restTemplate;
    @Value("${service.url}")
    private String url;

    public CrossfitService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String client(Integer clientId) throws IOException {

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("clientId", "{clientId}")
                .encode()
                .toUriString();

        Map<String, Object> params = new HashMap<>();
        params.put("clientId", clientId);

        HttpEntity<String> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                null,
                String.class,
                params
        );
        return response.getBody();
    }
}
