package ru.job4j.urlshortcut.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.urlshortcut.domain.Site;
import ru.job4j.urlshortcut.domain.URL;
import ru.job4j.urlshortcut.repository.SiteRepository;
import ru.job4j.urlshortcut.repository.URLRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ShortCutService {

    private final SiteRepository siteRepository;
    private final URLRepository urlRepository;
    private final BCryptPasswordEncoder encoder;

    public ShortCutService(SiteRepository siteRepository,
                               URLRepository urlRepository,
                               BCryptPasswordEncoder encoder) {
        this.siteRepository = siteRepository;
        this.urlRepository = urlRepository;
        this.encoder = encoder;
    }
    public Site saveSite(Site site) {
        if (siteRepository.findSiteByName(site.getName()).isEmpty()) {
            site.setLogin(UUID.randomUUID().toString());
            String password = UUID.randomUUID().toString();
            site.setPassword(encoder.encode(password));
            siteRepository.save(site);
            site.setPassword(password);
        }
        return site;
    }

    public URL saveURL(URL url, String login) {
        url = urlRepository.findByUrl(url.getUrl()).orElse(url);
        if (url.getId() == 0) {
            url.setCode(UUID.randomUUID().toString());
            url.setSite(siteRepository.findSiteByLogin(login).get());
            url = urlRepository.save(url);
        }
        return url;
    }

    public String getURLByCode(String code) {
        URL temp = urlRepository.findByCode(code).orElse(new URL());
        if (temp.getId() != 0) {
            urlRepository.incrementURL(temp.getId());
        }
        return temp.getUrl();
    }

    public List<URL> getStatistic(String login) {
        Site site = siteRepository.findSiteByLogin(login).get();
        return (List<URL>) urlRepository.findAllBySite(site);
    }
}
