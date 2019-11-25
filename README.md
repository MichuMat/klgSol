# klgSol recruitment task
### HSQLDB console
    http://localhost:8080/h
### swagger url
    http://localhost:8080/swagger-ui.html

## curl example
 **Add invoice**
```
 curl -X POST "http://localhost:8080/invoices" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"customer\": { \"name\": \"Customer\", \"role\": { \"name\": \"C\" } }, \"date\": \"2019-11-25T01:13:31.320Z\", \"products\": [ { \"id\": 1, \"name\": \"string\", \"price\": 0 } ], \"seller\": { \"name\": \"Seller\", \"role\": { \"name\": \"S\" } }}"
```
**Get customer invoices**
```
 curl -X GET "http://localhost:8080/invoices/Customer" -H "accept: */*"
```
**Add product**
```
 curl -X POST "http://localhost:8080/products" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"string\", \"price\": 0}"
```
**Update product**
```
 curl -X PUT "http://localhost:8080/products/2" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"string\", \"price\": 0}"
```
