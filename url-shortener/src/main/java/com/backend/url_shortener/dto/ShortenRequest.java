package com.backend.url_shortener.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class ShortenRequest {
    @NotBlank(message = "URL cannot be empty")
    private String longUrl;
}