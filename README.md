# Code Challenge

Simple microservice using springboot


Clone repository

```
git clone https://github.com/jestevez/code-challenge.git
```

Build

```
cd code-challenge
mvn clean install
```

Run

```
java -jar target/code-challenge-0.0.1-SNAPSHOT.jar
```

# API Endpoints



**/create:**
 
Create transaction

Example in cURL

```
curl -X POST \
  http://localhost:8001/create \
  -H 'Accept: */*' \
  -H 'Content-Type: application/json' \
  -d ' {
 	"reference": "12345A",
 	"account_iban": "ES9820385778983000760236",
 	"date": "2019-07-16T16:55:42.000Z",
 	"amount": -1193.38,
 	"fee": 3.18,
 	"description": "Restaurant Payment"
 }'
```

**/status:**
 
Transaction status

Example in cURL

```
curl -X POST \
  http://localhost:8001/status \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 54' \
  -H 'Content-Type: application/json' \
  -d '{
    "reference": "000002",
    "channel": "CLIENT"
}'
```

**/search:**

Search transactions

Example in cURL

```
curl -X GET \
  'http://localhost:8001/search?accountIban=ES9820385778983000760236&orderBy=amount&direction=ASC&page=0&size=10%20' \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'User-Agent: PostmanRuntime/7.20.1' \
  -H 'cache-control: no-cache'
```
  
  