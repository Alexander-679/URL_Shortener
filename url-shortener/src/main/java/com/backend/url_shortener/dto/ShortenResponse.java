package com.backend.url_shortener.dto;

import lombok.Data;

@Data
public class ShortenResponse {
    private String shortUrl;

    public ShortenResponse(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}