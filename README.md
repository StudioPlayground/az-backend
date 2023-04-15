# az-backend

로컬에서 이미지 빌드 방법

```bash
./gradlew jibDockerBuild -Djib.dockerClient.executable=$(which podman)
```

docker 를 사용하시면 뒤에 -Djib 옵션을 제거하셔도 됩니다

which podman 부분에는 여러분이 사용하는 docker image builder 이름을 넣어주세요