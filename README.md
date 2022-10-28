# STEPS TAKEN TO CREATE THE PROJECT

## INSTALLATION OF REQUIRED COMPONENTS

1. DOCKER:

   - Download and execute the provided installation script

     ```
     wget https://raw.githubusercontent.com/gcpexamples/gcpdemos/master/installation_scripts/install_docker_ubuntu
     chmod +x install_docker_ubuntu
     ./install_docker_ubuntu
     ```

2. DOCKER COMPOSE

   - Download and execute the provided installation script

     ```
     wget https://raw.githubusercontent.com/gcpexamples/gcpdemos/master/installation_scripts/install_dockercompose
     chmod +x install_dockercompose
     ./install_dockercompose
     ```

3. KUBERNETES

   - Download and execute the provided installation script

     ```
     wget https://raw.githubusercontent.com/gcpexamples/gcpdemos/master/installation_scripts/install_kubectl
     chmod +x install_kubectl
     ./install_kubectl
     ```

## CREATING DOCKER CONTAINER FROM SPRINT 1 PROJECT

1. Clone the sprint 1 repository

   ```
   git clone https://github.com/Sarthak-Bhagat/Sprint1_ABC_ELectronics.git
   cd Sprint1_ABC_ELectronics
   ```

2. Switch to the sprint 2 branch

   ```
   git checkout sprint2
   ```

3. Create Dockerfile

   ```docker
    FROM openjdk:11
    COPY target/Sprint1ABCElectronics-0.0.1-SNAPSHOT.jar /app.jar
    CMD  java -jar /app.jar
   ```

4. Create JAR file from project

   ```
   mvn package
   ```

5. Build the docker image

   ```
   docker build -t [IMAGE_NAME]:[TAG] .
   ```

6. Push the docker image to dockerhub

   - Log in to dockerhub

     ```
     docker login
     ```

   - Tag docker image
     ```
     docker tag sprint1:v1 [DOCKERHUB_USERNAME]/[IMAGE_NAME]:[TAG]
     ```
   - Push docker image
     ```
     docker push [DOCKERHUB_USERNAME]/[IMAGE_NAME]:[TAG]
     ```

7. Create Docker Compose

   ```yml
   version: "3.8"

   services:
     customer:
       image: [DOCKERHUB_USERNAME]/[IMAGE_NAME]:[TAG]
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

8. Launch with docker compose

   ```
   docker-compose up -d
   ```

9. Check all running containers

   ```
   docker ps
   ```

10. Connect to the database running in the container

    ```
    docker exec -i postgres psql -U postgres
    ```

## DEPLOY PROJECT ON KUBERNETES

1. Switch to the branch sprint2-scripts

   ```
   git checkout sprint2-scripts
   ```

2. Apply all deployments and services in the folder with kubectl

   ```
   kubectl apply -f .
   ```
