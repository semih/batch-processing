# batch-processing

Please perform the following instructions to run this project:

1. Go to the project directory
  - Run ```docker compose up``` command.

2. Check Docker containers to see whether they are running.
![Screenshot 2023-03-27 at 3 31 29 AM](https://user-images.githubusercontent.com/2884010/227815069-a109f08f-f980-4400-ae65-226a702345e6.png)

3. Build the project in the current directory.
   - ```mvn clean install```
4. Go to the kafka-consumer module and run the jar file under the target file.
   - ```java -jar target/kafka-consumer-0.0.1-SNAPSHOT.jar```
5. Go to the kafka-producer module and run the jar file under the target file.
   - ```java -jar target/kafka-producer-0.0.1-SNAPSHOT.jar```
6. Send a request to the products rest service. products/{skip}/{limit}
```
curl -X GET http://localhost:6000/api/products/0/1
curl -X GET http://localhost:6000/api/products/0/4340
curl -X GET http://localhost:6000/api/products/1/100
```

7. You will see the results in the Mongo database.
![Screenshot 2023-03-27 at 3 39 10 AM](https://user-images.githubusercontent.com/2884010/227815524-51216626-7dea-4e40-8888-1d557e5d505b.png)
