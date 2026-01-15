package com.urlshortener.controller;

import com.urlshortener.model.Url;
import com.urlshortener.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/api/shorten")
    public Url shortenUrl(@RequestBody Map<String, String> request) {
        return urlService.shortenUrl(request.get("url"));
    }

    @GetMapping("/r/{shortCode}")
    public void redirect(
            @PathVariable String shortCode,
            HttpServletResponse response) throws IOException {

        Url url = urlService.getOriginalUrl(shortCode);
        response.sendRedirect(url.getOriginalUrl());
    }
}

