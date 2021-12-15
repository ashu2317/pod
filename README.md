
#Repository Link
- https://github.com/ashu2317/pod.git

# How to setup and run the project
## Setup steps
- Install JDK 1.8 or above on the machine [https://maven.apache.org/install.html]
- Install apache maven(dependency manager) [https://openjdk.java.net/install/]

## Execute following command
```sh
- mvn clean install
- java -jar target/route-sorting-service-1.0.0.jar
```

>First command will build the project and artifact will be generated in target folder with name "route-sorting-service-1.0.0.jar"
>Second command will run the executable JAR on port 8080. Please make sure port 8080 is not occupied.


## Testing

Test cases are available at
[src\test\java]

> test cases:
 ```sh
 - find_start_point_of_journey_in_the_map
 - find_the_output_list
```
## API
- POST: http://localhost:8080/api/route/sort


- GET: http://localhost:8080/api/route
    - POST Request Sample (JSON)
   ```sh
    [
        { 
            "from": "A",
            "to": "B",
            "seat": "2A",
            "transportType": "BUS"
        },
        { 
            "from": "B",
            "to": "C",
            "seat": "CA",
            "transportType": "BUS"
           }
    ]
    ```
    - Rsponse Sample (JSON)
    ```sh 
    [
        "Take Bus from A to B. Sit in seat 2A",
        "Take Bus from B to C. Sit in seat CA"
    ]
    ```

  # What is not included
  Docker image
  API documentation

## NOTE
Please use any client to make post request like POSTMAN [https://www.postman.com/downloads/]
Due to restriction of 'NO USE OF THIRD PARTY LIBRARY' SWAGGER is not added [https://swagger.io/specification/] which provides out of the box documentation of API and client as well
