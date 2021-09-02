Web приложение по управлению туристическим телеграм ботом

С помощью REST WebService управляем данными о городах (CRUD операции) http://localhost:8080/bot/city

Старт приложения:

  1. Конфигурация БД:
     Создаём базу данных travelbot 
     spring.datasource.driver-class-name=org.postgresql.Driver
     spring.datasource.url=jdbc:postgresql://localhost:5432/travelbot
     spring.datasource.username=postgres
     spring.datasource.password=postgres

  2. git clone https://github.com/Vasili89/TravelTelegramBot

  3. cd TravelTelegramBot

  4. mvn spring-boot:run

Управлять REST CRUD операциями можем через Swagger-UI:
  http://localhost:8080/bot/swagger-ui/index.html
  
Телеграм бот:
  bot.username=VasiaTourBot
  bot.token=1967692901:AAFtiLYZ5RRm31n-O-cKNz1Lo8SeM_5ZF2A
