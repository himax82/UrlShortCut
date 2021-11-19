[![Build Status](https://app.travis-ci.com/himax82/UrlShortCut.svg?branch=master)](https://app.travis-ci.com/himax82/UrlShortCut)
![codecov](https://codecov.io/gh/himax82/UrlShortCut/branch/master/graph/badge.svg?token=GMDHFHLXKR)
MazeGenerator
=============
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

Регистрация сайта в сервисе. POST: /registration
![ScreenShot](images/2.png)
Авторизация. POST: /login
![ScreenShot](images/3.png)
Конвертировать ссылку в код. POST: /convert
![ScreenShot](images/4.png)
Получить ссылку по коду. GET: /redirect/{code}
![ScreenShot](images/5.png)
Получитб статистику по ссылкам. GET: /statistic
![ScreenShot](images/6.png)