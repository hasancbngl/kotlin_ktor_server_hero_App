/*
This command at the base of project where Dockerfile is present,which build from the above Dockerfile with the name ktor-docker. '.' signifies find the Dockerfile here
*/
docker build -t ktor-docker .

/*
This command will have to run the above 'ktor-docker' with the name docker-ktor1 on port 8080
*/
docker run --name docker-ktor1 -p 8080:8080 ktor-docker