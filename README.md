Для користувача "BohdanUserBroject" описано наступні дії:

Приклади запитів:

1.Приклад реєстрації:
```
POST http://localhost:8080/auth/register
Content-Type: application/json

{
  "firstName" : "Bohdan",
  "lastName" : "Yusk",
  "email" : "yusk@gmail.com",
  "password" : "123"
}
```

2.Приклад логіну:
```
POST http://localhost:8080/auth/login
Content-Type: application/json

{
  "username" : "yusk@gmail.com",
  "password" : "123"
}
```
3.Приклад відображення:
```

POST http://localhost:8080/contacts

Content-Type: application/json

Authorization: Bearer(тестовий)eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ5YXRzQGdtYWlsLmNvbSIsImlhdCI6MTY4ODY2MDI2OSwiZXhwIjoxNjg4NjYzODY5fQ.08K-_ws5vNyIfpPY9EA0t1skrHUTWlOPesEEglkNyBREkOwuT0xlcM0wxMmSMVyDPa1MuRCvB9uzWn_G9fxFBg


{
    "name": "Bohdan",

    "emails": ["xxx2345x@xxxx.com", "yyyy@yyyy.com"],

    "phones": ["+380979607116"]

}
```
