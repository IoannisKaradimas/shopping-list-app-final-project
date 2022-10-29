# README

### Maven Enablement
In the terminal run the following command: **mvn clean install**

### Run Backend
Run the application or the following command: **mvn spring-boot:run**

The application listens to http://localhost:9096


### Run Frontend
You will need **node.js** installed

Run --**npm install**

Go to shopping-list\frontend and run --**npm start**

The frontend application listens to http://localhost:3000

### Alternatives
Postman can be used to access the endpoints provided by the API.\
A Json body has to be given in case of POST and PUT methods, e.g.\
{\
"productDescription": "milk",\
"quantity": "1"\
}
