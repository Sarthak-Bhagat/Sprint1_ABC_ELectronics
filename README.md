# STEPS TAKEN TO CREATE THE PROJECT

## INSTALLATION OF REQUIRED COMPONENTS

1. DOCKER:

   * Download and execute the provided installation script
     
     ```curl -s https://raw.githubusercontent.com/gcpexamples/gcpdemos/master/installation_scripts/install_docker_ubuntu | bash```

2. DOCKER COMPOSE

   * Download and execute the provided installation script
     
     ```curl -s https://raw.githubusercontent.com/gcpexamples/gcpdemos/master/installation_scripts/install_dockercompose | bash```
     
3. KUBERNETES

   * Download and execute the provided installation script
     
     ```curl -s https://raw.githubusercontent.com/gcpexamples/gcpdemos/master/installation_scripts/install_kubernetes | bash```

## CREATING DOCKER CONTAINER FROM SPRINT 1 PROJECT

1. Clone the sprint 1 repository
    
    ```git clone https://github.com/Sarthak-Bhagat/Sprint1_ABC_ELectronics.git```

2. Switch to the sprint 2 branch
   
   ```git checkout sprint2```

3. Create Dockerfile
   
   ```docker
    FROM openjdk:11
    COPY target/Sprint1ABCElectronics-0.0.1-SNAPSHOT.jar /app.jar
    CMD  java -jar /app.jar
   ```

4. Build the docker image

    `docker build -t sprint1:v1 .`
    
5. Push the docker image to dockerhub
   
   * Log in to dockerhub 
        `docker login`
   
   * Tag docker image
        `docker tag sprint1:v1 sarthakbhagat/sprint1:v1`
        
   * Push docker image
        `docker push sarthakbhagat/sprint1`

6. Create Docker Compose
   ```docker
        version: '3.8'

        services:

            customer:
                image: sarthakbhagat/sprint1:v2
                ports:
                    - 8080:8080
     

            postgres:
                image: postgres:14.5
                ports:
                    - 5432:5432
       
                environment:
                    POSTGRES_USER: postgres
                    POSTGRES_PASSWORD: password
                    POSTGRES_DB: sprint1
   ```

7. Launch with docker compose
   `docker-compose up -d`
