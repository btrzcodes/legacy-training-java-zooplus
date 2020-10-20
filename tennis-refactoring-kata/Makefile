.PHONY: default run docker-build docker-run
default:
	@printf "$$HELP"

test:
	mvn test clean

docker-test:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.m2:/root/.m2 -w /opt/project maven:3.6-openjdk-8 mvn test clean

define HELP
# Local commands
	- make test\tRun locally using java 8
# Docker commands
	- make docker-test\tRun inside docker with Java 8
 Please execute "make <command>". Example make help

endef

export HELP