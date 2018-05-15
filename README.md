# http://localhost:6162/rest/greetings
- Uses the Get Method
- This will fetch all the greetings in the JSON format from the service class

# http://localhost:6162/rest/greeting
- Uses the Post Method
- This will insert the below request in the map present in the service class
- Request details
- Request Header
```
    Content-Type =  application/json
```
- Request Body
```
{
	"id": 4,
	"name": "CCCC – CCCCC"
}
```

# http://localhost:6162/rest/greeting/2/
- Uses the delete Method
- This will remove the record from the map present in the service class using the parameter present in the url


# http://localhost:6162/rest/greeting
- Uses the put Method
- This will update the below request in the map present in the service class
- Request details
- Request Header
```
    Content-Type =  application/json
```
- Request Body
```
{
	"id": 4,
	"name": "CCCC – CCCCC"
}
```
