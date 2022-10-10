# Exchange Account Project with Spring Boot 
***

![](https://img.shields.io/badge/java_17-✓-blue.svg)
![](https://img.shields.io/badge/spring_boot-✓-blue.svg)
![](https://img.shields.io/badge/postgreSQL-✓-blue.svg)
![](https://img.shields.io/badge/jwt-✓-blue.svg)
![](https://img.shields.io/badge/swagger-✓-blue.svg)
***
Main purpose in project is to manage exchange operations and take notes of operation 
details in database and showing last 5 operation when checking details page. 
Exchange operations with 4 currency : TL , DOLLAR , GOLD , EURO . Exchange rates created 
randomly when every operation applied.

***
### Entities
- Customer, Account, AccountDetails
***

### Controller
- LoginController, AccountController, ExchangeController

***
### Services
- AccountService, ExchangeService 
- LoginService, UserDetailsImpl (for Jwt Authorization and Authentication)
***

Login : 
```json
{
  "user": "abkode",
  "password": "123456"
}
```
Example @RequestBody to exchange :
```json
{
  "buy": "TRY",
  "amount": 20,
  "sell": "DOLLAR",
  "customerId": 1,
  "accountId": 1
}
```
