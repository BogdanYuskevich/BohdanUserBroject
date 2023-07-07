Для користувача з проектом "BohdanUserBroject" описано наступні дії:

Реєстрація користувача:

-Відправити POST-запит на адресу http://localhost:8080/auth/register.

-Установити заголовок Content-Type зі значенням application/json.
У тілі запиту передати наступні дані в форматі JSON:

{
  "firstName": "Bohdan",
  "lastName": "Yuskevych",
  "email": "yusk@gmail.com",
  "password": "123"
}

Авторизація користувача:

-Відправити POST-запит на адресу http://localhost:8080/auth/login

-Установити заголовок Content-Type зі значенням application/json.
У тілі запиту передати наступні дані в форматі JSON:

{
  "username": "yusk@gmail.com",
  "password": "123"
}

Додавання контакту:

-Відправити POST-запит на адресу http://localhost:8080/contacts

-Установити заголовок Content-Type зі значенням application/json.

-Установити заголовок авторизації Authorization зі значенням Bearer яке вам видала програма.
У тілі запиту передати наступні дані в форматі JSON:

{
  "name": "Bohdan",
  "emails": ["xxx2345x@xxxx.com", "yyyy@yyyy.com"],
  "phones": ["+380979607116"]
}
