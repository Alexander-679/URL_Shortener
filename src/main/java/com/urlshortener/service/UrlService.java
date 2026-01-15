package com.urlshortener.service;

import com.urlshortener.model.Url;
import com.urlshortener.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    // Generate and save short URL
    public Url shortenUrl(String originalUrl) {
        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortCode(generateShortCode());
        return urlRepository.save(url);
    }

    // Fetch original URL using short code
    public Url getOriginalUrl(String shortCode) {
        return urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));
    }

    // Generate unique short code
    private String generateShortCode() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
