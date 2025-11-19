package com.backend.url_shortener.service;

import com.backend.url_shortener.model.UrlMapping;
import com.backend.url_shortener.repository.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UrlService {

    private final UrlMappingRepository urlMappingRepository;
    private final SecureRandom secureRandom = new SecureRandom();

    // Injects the base URL from application.properties (or hardcode for now)
    @Value("${app.baseUrl:http://localhost:8080/}")
    private String baseUrl;

    public UrlService(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    // Generates a random, unique short code
    private String generateUniqueShortCode() {
        String code;
        do {
            byte[] bytes = new byte[6]; // Generate 6 random bytes
            secureRandom.nextBytes(bytes);
            // Use Base64 URL encoding to get a short, alphanumeric string
            code = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
            code = code.substring(0, Math.min(code.length(), 6)); // Ensure length 6
        } while (urlMappingRepository.findByShortCode(code).isPresent());
        return code;
    }

    public String shortenUrl(String longUrl) {
        if (!longUrl.startsWith("http://") && !longUrl.startsWith("https://")) {
            longUrl = "https://" + longUrl; // Basic standardization
        }

        String shortCode = generateUniqueShortCode();
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setLongUrl(longUrl);
        urlMapping.setShortCode(shortCode);
        urlMappingRepository.save(urlMapping);

        return baseUrl + shortCode;
    }

    public String getLongUrl(String shortCode) {
        return urlMappingRepository.findByShortCode(shortCode)
                .map(UrlMapping::getLongUrl)
                .orElse(null);
    }
}