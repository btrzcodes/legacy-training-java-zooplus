.PHONY: default run docker-build docker-run
default:
	@printf "$$HELP"

run:
	mvn compile exec:java -Dexec.mainClass="team.codium.legacytraining.Main"
	@echo "Webpage generated at html/users.html"

docker-build:
	docker build . -t java-with-make

docker-run:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.m2:/root/.m2 -w /opt/project java-with-make make run

define HELP
# Local commands
	- make run\tRun locally using java 8
# Docker commands
	- make docker-run\tRun inside docker with Java 8
 Please execute "make <command>". Example make help

endef

export HELP