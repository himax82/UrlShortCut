package ru.job4j.urlshortcut.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.urlshortcut.domain.Site;
import ru.job4j.urlshortcut.domain.URL;
import ru.job4j.urlshortcut.service.ShortCutService;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UrlShortcutController {

    private final ShortCutService service;

    public UrlShortcutController(ShortCutService service) {
        this.service = service;
    }

    @PostMapping("/registration")
    public ResponseEntity<Site> createSite(@RequestBody Site site) {
        return new ResponseEntity<Site>(
                service.saveSite(site),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/convert")
    public ResponseEntity<URL> createURL(Principal principal,
                                         @RequestBody URL url) {
        return new ResponseEntity<URL>(
                service.saveURL(url, principal.getName()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/redirect/{code}")
    public ResponseEntity<Void> getCode(@PathVariable String code) {
        String url = service.getURLByCode(code);
        if (url != null) {
            HttpHeaders header = new HttpHeaders();
            header.add("url", url);
            return new ResponseEntity<Void>(
                    header,
                    HttpStatus.MOVED_PERMANENTLY);
        }
        return new ResponseEntity<>(
                HttpStatus.NOT_FOUND
        );
    }

    @GetMapping("/statistic")
    public List<URL> getStatistic(Principal principal) {
        return new ArrayList<>(service.getStatistic(principal.getName()));
    }
}
