.PHONY: default test docker-test docker-coverage mutation docker-mutation
default: docker-test

test:
	mvn test

coverage: test
	mvn jacoco:report
	@printf "\nOpen target/site/jacoco/team.codium.legacytraining.gildedrose/GildedRose.java.html\n"

mutation: test
	mvn org.pitest:pitest-maven:mutationCoverage

docker-build:
	docker build .. -t codium-legacytraining

docker-test:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.m2:/root/.m2 -w /opt/project codium-legacytraining make test

docker-coverage:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.m2:/root/.m2 -w /opt/project codium-legacytraining make coverage

docker-mutation:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.m2:/root/.m2 -w /opt/project codium-legacytraining make mutation