docker build . -t mojaapka
docker stop mojaapka || true
docker rm mojaapka || true
docker run -d -p 8080:8080 --name=mojaapka mojaapka