# Hospital Management System: Spring MVC

### Configuration
Build the docker image with command :

    mvn spring-boot:build-image -DskipTests

Start the application using this command after starting docker desktop :

    docker compose --env-file=.env  up -d

View Logs using : 

    docker-compose logs -f spring-deploy

Access mysql database using : 

    docker exec -it mysql-db mysql -u root -p

