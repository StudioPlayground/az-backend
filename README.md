# az-backend

## 로컬에서 이미지 빌드 방법

```bash
./gradlew jibDockerBuild -Djib.dockerClient.executable=$(which podman)
```

docker 를 사용하시면 뒤에 -Djib 옵션을 제거하셔도 됩니다.

which podman 부분에는 여러분이 사용하는 docker image builder 이름을 넣어주세요.

## 로컬에서 redis, mysql, adminer 실행

### docker-compose

- 최초 실행

```bash
docker-compose up
```

- 기존에 실행했던 도커 컨테이너 중지

```bash
docker-compose stop
```

- 기존에 실행했던 도커 컨테이너 재실행

```bash
docker-compose start
```

- docker-compose 값 수정되어 처음부터 다시 띄우기

```bash
docker-compose down
docker-compose up
```

### adminer

- http://localhost:18080 으로 접속
- 접속정보
  - 서버 : `az-mysql`
  - 사용자이름 : `test_user`
  - 비밀번호 : `azmysql123`
  - 데이터베이스 : `AZ_DB`

### redis

- redis-cli 접속
  - ```bash
    docker exec -it az-redis redis-cli
    ```

### mysql

- dbeaver에서 mysql 접속
  - connection 정보에서 driver properties, allowPublicKeyRetrieval = `true`로 설정
  - server host : `localhost`
  - port : `3306`
  - database : `AZ_DB`
  - username : `root`
  - password : `rootazmysql123`
