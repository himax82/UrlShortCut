package ru.job4j.urlshortcut.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.urlshortcut.domain.Site;
import ru.job4j.urlshortcut.domain.URL;


import javax.transaction.Transactional;
import java.util.Optional;

public interface URLRepository extends CrudRepository<URL, Integer> {

    @Query("SELECT u FROM URL u JOIN FETCH u.site WHERE u.url = :url")
    Optional<URL> findByUrl(@Param("url") String url);

    @Query("SELECT u FROM URL u JOIN FETCH u.site WHERE u.code = :code")
    Optional<URL> findByCode(@Param("code") String code);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("UPDATE URL u SET u.total = u.total + 1 WHERE u.id = :id")
    void incrementURL(@Param("id") Integer id);

    Iterable<URL> findAllBySite(@Param("site") Site site);
}
