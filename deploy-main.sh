export SPRING_IMAGE=$1
export SPRING_CONTAINER=$2

touch test
docker images --format="{{.Repository}}" | grep -w "${SPRING_IMAGE}" && docker rmi ${SPRING_IMAGE} || true
docker ps -a --filter="name=${SPRING_CONTAINER}" --format="{{.Names}}" | grep -w "${SPRING_CONTAINER}" && (docker stop ${SPRING_CONTAINER} && docker rm ${SPRING_CONTAINER}) || true
docker build -t ${SPRING_IMAGE}:latest .
docker run -p 8080:8080 -d --name ${SPRING_CONTAINER} ${SPRING_IMAGE}:latest