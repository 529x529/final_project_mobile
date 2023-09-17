# Проект по автоматизации тестирования мобильного приложения wikipedia

### Технологии и инструменты:
<p align="center">
<img src="images/logos/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/>
<img src="images/logos/Java.svg" width="50" height="50"  alt="Java"/>
<img src="images/logos/Github.svg" width="50" height="50"  alt="Github"/>
<img src="images/logos/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/>
<img src="images/logos/Appium.svg" width="50" height="50"  alt="Jenkins"/>
<img src="images/logos/Browserstack.svg" width="50" height="50"  alt="Jenkins"/>
<img src="images/logos/Gradle.svg" width="50" height="50"  alt="Gradle"/>
<img src="images/logos/Allure_Report.svg" width="50" height="50"  alt="Allure_Report"/>
<img src="images/logos/Rest-Assured.svg" width="50" height="50"  alt="Jenkins"/>
<img src="images/logos/Jenkins.svg" width="50" height="50"  alt="Jenkins"/>
<img src="images/logos/Telegram.svg" width="50" height="50"  alt="Jenkins"/>
</p>

### Реализованные проверки:
* Проверка прохождения начальных экранов
* Проверка поиска в приложении
* Изменение языка в приложении
* Проверка поискового запроса
  

### Запуск тестов из терминала
#### Удаленный запуск тестов в Browserstack:

```bash
gradle ${PLATFORM}_test 
-Denv=${PLATFORM}
```
где:

- <code>PLATFORM</code> – платформа на которой будут выполняться тесты;

### Сборка в [Jenkins](https://jenkins.autotests.cloud/job/final_project_mobile/)
<p align="center">
<img title="Jenkins Build" src="images/screens/Jenkins.png">
</p>

### Отчет в [Allure report](https://jenkins.autotests.cloud/job/final_project_mobile/11/allure/)
#### Основная страница отчета
<p align="center">
<img title="Jenkins Build" src="images/screens/Allure-report.png">
</p>

#### Тест-кейсы
<p align="center">
<img title="Jenkins Build" src="images/screens/Allure-tests.png">
</p>

### Уведомления в Telegram с использованием бота
<p align="center">
<img title="Jenkins Build" src="images/screens/Telegram.png">
</p>

### Пример видео выполнения теста в Browserstack
<p align="center">
  <img title="Browserstack Video" src="images/screens/Video.gif">
</p>
