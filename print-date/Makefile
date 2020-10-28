.PHONY: default test docker-test docker-build
default: docker-test

test:
	mvn test

docker-build:
	docker build .. -t codium-legacytraining

docker-test:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.m2:/root/.m2 -w /opt/project codium-legacytraining make test
