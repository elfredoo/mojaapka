docker build . -t mojaapka
docker stop mojaapka
docker rm mojaapka
docker run -d -p 8080:8080 --name=mojaapka mojaapka

