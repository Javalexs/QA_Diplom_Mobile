<p align="center">
  <img src="images/screen/social.jpg" alt="social" width="900">
</p> 

# Проект по автоматизации тестирования мобильного приложения Wikipedia


##	Содержание

- [Технологии и инструменты](#technologist-технологии-и-инструменты)
- [Реализованыe проверки](#bookmark_tabs-реализованные-проверки)
- [Запуск тестов](#computer-запуск-тестов)
- [Отчет о результатах тестирования в Allure Report](#отчет-о-результатах-тестирования-в-Allure-report)
- [Интеграция с Allure TestOps](#интеграция-с-allure-testops)
- [Уведомления в Telegram с использованием бота](#уведомления-в-telegram-при-помощи-бота)
- [Пример запуска теста в Selenoid](#пример-запуска-тестов-в-selenoid)


## :technologist: Технологии и инструменты

<code><img width="5%" title="IntelliJ IDEA" src="images/icons/Idea.svg"></code>
<code><img width="5%" title="Java" src="images/icons/Java.svg"></code>
<code><img src="images/icons/Selenoid.svg" title="Selenoid" width="5%"/></code>
<code><img width="5%" title="Selenide" src="images/icons/Selenide.svg"></code>
<code><img width="5%" title="Gradle" src="images/icons/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="images/icons/Junit5.svg"></code>
<code><img width="5%" title="GitHub" src="images/icons/GitHub.svg"></code>
<code><img width="5%" title="Allure Report" src="images/icons/Allure.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/icons/Allure_TO.svg"></code>
<code><img width="5%" title="Jenkins" src="images/icons/Jenkins.svg"/></code>
<code><img width="5%" title="Jira" src="images/icons/Jira.svg"></code>


## :bookmark_tabs: Реализованные проверки:

- Проверка на наличие заголовка вакансии
- Проверка содержания заголовка вакансии
- Проверка названия вакансии на странице
- Поиск подзаголовка в тексте вакансии
- Проверка присутствия названия статьи, в результате ввода запроса в поиск
- Проверка отображения списка подкатегорий в выбранной категории 
- Поиск элемента в навигации страницы
- Проверка отсутсвия фавикона


## :computer: Запуск тестов

### Локальный запуск тестов производится из терминала среды разработки IntelliJ IDEA командой:
```bash
gradle clean test -Denv=local
```
#### Параметры сборки по умолчанию:

 <code>baseUrl</code> =https://ibs.ru - адрес сайта на котором запускаются тесты

 <code>browserName=chrome</code> - имя браузера

 <code>browserVersion=100</code> - версия браузера

 <code>browserSize=1920x1080</code> - размер экрана

 <code>isRemote=false</code> - проверка запуска теста локально


### Удаленный запуск тестов производится при помощи программы [Jenkins](https://jenkins.autotests.cloud/job/QA_Project_UI) через удаленный сервер 

Для запуска тестов в программе нужно нажать <code>Собрать с параметрами</code>. В графе
BROWSER выбрать браузер для запуска и подтвердить кликнув на кнопку <code>Собрать</code>


<p align="center">
  <img src="images/screen/Jenkins1.jpg" alt="Jenkins1" width="1000">
</p>


В левом нижнем углу сборка начнет собираться. После окончания появится значок AllureTestOps и Allure Report.
Если сборка успешная до будет подветчиваться зеленым цветом. Также, в правом углу будет показан графический 
тренд изменения состояния тестов от количества сборок.


<p align="center">
  <img src="images/screen/Jenkins2.jpg" alt="Jenkins2" width="1000">
</p>

#### Параметры сборки по умолчанию:

 <code>baseUrl=https://ibs.ru</code> - адрес сайта на котором запускаются тесты

 <code>browserName=chrome</code> - имя браузера

 <code>browserVersion=100</code> - версия браузера

 <code>browserSize=1920x1080</code> - размер экрана

 <code>isRemote=true</code> - проверка запуска теста удаленно

 <code>remoteUrl=https://user:@selenoid.autotests.cloud/wd/hub</code> - адрес удаленного сервера (url изменен в целях безопасности)


## Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/QA-Project_UI/3/allure)


Кликнув на значок Allure Report или Allure TessOps можно посмотреть подробный отчет по тестам.


<p align="center">
  <img src="images/screen/goto.jpg" alt="AllureErr" width="900">
</p>


На данной странице все тесты прошли успешно, что показывает зеленая круговая диаграмма "STATUS"


<p align="center">
  <img src="images/screen/allure1.jpg" alt="allure1" width="900">
</p>


Тут два теста упали, а один тест был приостановлен 


<p align="center">
  <img src="images/screen/allure2.jpg" alt="allure2" width="900">
</p>


## Интеграция с [Allure TestOps](https://allure.autotests.cloud/launch/20096)<img width="4%" title="Allure TestOPS" src="images/icons/Allure_TO.svg">
<p align="center">
  <img src="images/screen/AllureTOps.jpg" alt="AllureTestOps" width="900">
</p>


## Уведомления в Telegram при помощи бота
После завершения сборки бот, созданный в <code>Telegram</code>, обрабатывает и отправляет сообщение с отчетом о прохождении тестов.



<p align="center">
<img title="Telegram Notifications" src="images/screen/MesTel.jpg">
</p>


## Пример запуска тестов в Browserstack


На данном видео выполняется процесс тестирования раздела "поиск" мобильного приложения Wikipedia


<p align="center">
  <img title="Selenoid Video" src="images/screen/video1.gif">
</p>