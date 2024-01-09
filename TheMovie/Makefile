.PHONY: launch up stop restart list build project

launch:
	mvn clean
	mvn install -DskipTests
	docker compose build

up:
	docker-compose up

stop:
	docker-compose stop

restart:
	docker-compose stop
	docker-compose up

list:
	docker-compose ps

build project:
	mvn clean
	mvn install -DskipTests