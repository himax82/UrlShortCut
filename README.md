[![Build Status](https://app.travis-ci.com/himax82/UrlShortCut.svg?branch=master)](https://app.travis-ci.com/himax82/UrlShortCut)
![codecov](https://codecov.io/gh/himax82/UrlShortCut/branch/master/graph/badge.svg?token=GMDHFHLXKR)]

### Описание проекта
Сервис позволяет обеспечить безопасность пользователей на сайте заменяя обычные ссылки на преобразованные. Проект представляет собой так же сервис для сбора статистики посещений страниц для различных сайтов, зарегистрированных в системе. Это веб-приложение реализует принцип архитектуры RESTful.

### Использованные технологии

<ul>
<li>Java 14</li>
<li>Spring Security & JWT authorization</li>
<li>Spring Boot 2</li>
<li>Spring Data JPA</li>
<li>PostgreSQL</li>
<li>Liquibase</li>
<li>Maven</li>
<li>Travis C.I.</li>
<li>Checkstyle</li>
<li>Jacoco</li>
</ul>

### Методы API

<ul>
<li>Регистрация сайта в сервисе. POST: /registration</li>
![ScreenShot](images/2.png)
<li>Авторизация. POST: /login</li>
![ScreenShot](images/3.png)
<li>Конвертировать ссылку в код. POST: /convert</li>
![ScreenShot](images/4.png)
<li>Получить ссылку по коду. GET: /redirect/{code}</li>
![ScreenShot](images/5.png)
<li>Получитб статистику по ссылкам. GET: /statistic</li>
![ScreenShot](images/6.png)
</ul>