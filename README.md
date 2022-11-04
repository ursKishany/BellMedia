# Bell Media Assignment

Bell Media Application provides 3 APIs for Media Items

## Docker File

#Build Docker Image

```
docker build -f Dockerfile -t bell .

```
#RUN Docker Image

```
docker run -p 8080:8080 -t bell   
```


## Simple Java Application

#Build Docker Image

```
mvn clean install

```
#RUN 

```
java -jar target/BellMedia-0.0.1-SNAPSHOT.jar
```

## Three End points

i. API endpoint 1 - Use CAPI 1 to fetch the first <n> medias where n
can be 1-10

```
http://localhost:8080/medias/2

```

ii. API endpoint 2 - Use CAPI 2 to fetch the media details for each of
the items in the above list

```
http://localhost:8080/MediaDetailList/2

```

iii. API endpoint 3 - Use CAPI 2 to fetch the media details as above
where x is a media ID from API endpoint 1 and y is the image type

```
http://localhost:8080/MediaDetail/32254/poster
```
