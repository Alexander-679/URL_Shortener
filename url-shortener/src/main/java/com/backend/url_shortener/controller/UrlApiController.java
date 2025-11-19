package com.backend.url_shortener.controller;

import com.backend.url_shortener.dto.ShortenRequest;
import com.backend.url_shortener.dto.ShortenResponse;
import com.backend.url_shortener.service.UrlService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UrlApiController {

    private final UrlService urlService;

    public UrlApiController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<ShortenResponse> createShortUrl(@Valid @RequestBody ShortenRequest request) {
        String shortUrl = urlService.shortenUrl(request.getLongUrl());
        return ResponseEntity.ok(new ShortenResponse(shortUrl));
    }
}