### Summary

A web service (HTTP REST API) to work with tournaments.

### Glossary

A *Tournament* is an object consists of max number of participants multiples of 8 (8, 16, 32, etc...) and number of [single-elimination](https://en.wikipedia.org/wiki/Single-elimination_tournament) matches that will be played.

A *Match* is an object consist of two participants, start time, finish time and participant scores.

A *Participant* is an object consist of unique id and unique nickname or even just unique id. The mechanism for creating and storing members is not important. Any options are acceptable from filling in the *java.util.Map* by hand or saving to the database via endpoints.

### Details

Operations to be provided by the web service:

- Creating a tournament. +
- Getting a tournament by its identifier.
- Starting a tournament. Each tournament must have that endpoint, which must generate match grid and appoint opponents for participants (in random way). (including when there are an odd number of participants, e.g. 7/8 or 15/16 participants).
- Adding participants in tournament.
- Removing participants from tournament while it's on hold.
- Summarizing results in match.

### Requirements

- The API must conform to the REST architecture.
- Do only the server side, you don't need to do visualization.
- It should be a Spring Boot application.
- Maven or Gradle should be used as a build tool.
- Data should only be stored in RDBMS.
- Al least 30% of the code should be covered by tests.
- Submit sources via a public git repository.
- You should’t use @RepositoryRestController.


Ru

### Резюме

Веб-сервис (HTTP REST API) для работы с турнирами.

### Глоссарий

* Турнир * - это объект, состоящий из максимального количества участников, кратного 8 (8, 16, 32 и т. Д.)
И количества [single-elimination] (https://en.wikipedia.org/wiki/Single -elimination_tournament) матчи, которые будут сыграны.

A * Match * - это объект, состоящий из двух участников, времени начала, времени окончания и очков участников.

A * Участник * - это объект, состоящий из уникального идентификатора и уникального никнейма или даже просто уникального идентификатора.
Механизм создания и хранения членов не важен.
 Допускаются любые параметры: от заполнения * java.util.Map * вручную или сохранения в базе данных через конечные точки.

### Подробности

Операции, предоставляемые веб-службой:

- Создание турнира. +
- Получение турнира по его идентификатору.
- Старт турнира. У каждого турнира должна быть конечная точка, которая должна генерировать сетку матчей
и назначать соперников для участников (случайным образом). (в том числе при нечетном количестве участников, например, 7/8 или 15/16 участников).
- Добавление участников в турнир.
- Удаление участников из турнира, пока он приостановлен.
- Подведение итогов матча.

### Требования

- API должен соответствовать архитектуре REST.
- Делайте только серверную часть, визуализацию делать не нужно.
- Это должно быть приложение Spring Boot.
- Maven или Gradle следует использовать в качестве инструмента для сборки.
- Данные должны храниться только в СУБД.
- Как минимум 30% кода должно быть покрыто тестами.
- Отправляйте источники через публичный репозиторий git.
- Не используйте @RepositoryRestController.