.PHONY: default run docker-run
default: docker-run

run:
	mvn compile exec:java -Dexec.mainClass="team.codium.legacytraining.gildedrose.Main"

docker-build:
	docker build .. -t codium-legacytraining

docker-run:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.m2:/root/.m2 -w /opt/project codium-legacytraining make run
