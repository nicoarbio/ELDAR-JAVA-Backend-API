# ELDAR-JAVA-Backend-API
ELDAR's JAVA Backend Challenge (API).
Hosted at Heroku.

## PostMan
URL: https://eldar-java-backend-api.herokuapp.com/api/processingfee

### Body 1:
```
{
    "brand":"VISA",
    "transaction":"500"
}
```
### Response 1:
```
{
    "brand": "VISA",
    "transaction": 500.0,
    "processingFee": 13.75
}
```
### Body 2:
```
{
    "brand":"AMEX",
    "transaction":"500"
}
```
### Response 2:
```
{
    "brand": "AMEX",
    "transaction": 500.0,
    "processingFee": 4.0
}
```
### Body 3:
```
{
    "brand":"NARA",
    "transaction":"500"
}
```
### Response 3:
```
{
    "brand": "NARA",
    "transaction": 500.0,
    "processingFee": 25.0
}
```

## SpringBoot
Maven Project
SpringBoot 2.7.3
Java 17
Jar package

## Dependencies
- Spring Boot Devtools
- Lombok
- Spring Web


