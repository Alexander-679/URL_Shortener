package com.backend.url_shortener.controller;

import com.backend.url_shortener.service.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {

    private final UrlService urlService;

    public RedirectController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/{shortCode}")
    public RedirectView redirectToLongUrl(@PathVariable String shortCode) {
        String longUrl = urlService.getLongUrl(shortCode);

        if (longUrl != null) {
            // Found the URL, perform a 302 redirect
            RedirectView redirectView = new RedirectView(longUrl);
            redirectView.setStatusCode(org.springframework.http.HttpStatus.FOUND);
            return redirectView;
        } else {
            // Not found, redirect to the home page or a specific error page
            RedirectView notFoundView = new RedirectView("/");
            return notFoundView;
        }
    }
}