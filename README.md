# Rest API's for Automatic Irrigation System.

## Technology stack
- Java 8
- [Maven](https://maven.apache.org/)
- [H2 in memory database](https://www.h2database.com/html/main.html)
- [Maven](https://maven.apache.org/)
- [JUnit 5](https://junit.org/junit4/)
- [Mockito](https://site.mockito.org/) (for unit testing)

### Main Class

com.example.demo.AutomaticIrrigationSystemApplication

### API URL Routings

All the plot land related end points routing is done in the class as below path.
com.example.demo.PlotLandController

Sensor Slot booking routing is done in class com.example.demo.AutomaticIrrigationController


### How to run
```sh
mvn exec:java
```

Application is running in embedded tomcat server on localhost port 8080. H2 is a in memory database which has been initialized with some sample plot details through sql script 'data.sql' placed under resources folder 

- http://localhost:7000/api/user/test1
- http://localhost:7000/api/user/test2
- http://localhost:7000/api/account/1
- http://localhost:7000/api/account/2


### Available Rest API's for Plot

| HTTP METHOD | END POINT | USAGE |
| -----------| ------ | ------ |
| GET | /api/v1/plots | get all plot and details | 
| POST | /api/v1/plot | create a new plot
| PUT | /api/v1/plot/{id} | Update plot | 
| PUT | /api/v1/configure/plot/{id} | configure plot | 
| PUT | /api/v1/irrigation/{id}/{req} | Send request to sensor interface | 


### Http Status
- 200 OK: Request is ok and processed successfully.
- 400 Bad Request: Unknown parameter in a request which server doesn't know or accept.
- 404 Not Found: The requested resource is not found, or its not available in db.
- 500 Internal Server Error: The server encountered an unexpected condition or exception.

### Dummy JSON
##### Save Plot : 
```sh
{
    "registeredOwner": "MRC",
    "city": "Chandigarh",
    "district": "Chandigarh",
    "state": "Chandigarh",
    "area_ha": 1251,
    "unit_price": 500000
}
```
##### User Account: : 

```sh
{  
   "customerName":"test1",
   "balance":1000.0000,
   "currencyCode":"USD"
} 
```

##### Update Plot: : 

```sh
{
    "id":2,
    "registeredOwner": "MRC",
    "city": "Chandigarh",
    "district": "Chandigarh",
    "state": "Chandigarh",
    "area_ha": 1255,
    "unit_price": 550000
}
```

#### Irrigation Required:
```sh
{
    "id": 1,
    "registeredOwner": "MRC",
    "registeredBuyer": null,
    "city": "Chandigarh",
    "district": "Chandigarh",
    "state": "Chandigarh",
    "area_ha": 1251.0,
    "unit_price": 500000.0,
    "irrigationReq": true
}
```