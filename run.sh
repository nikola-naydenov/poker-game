#!/usr/bin/env bash
mvn clean install
java -jar poker-cli/target/poker-game-cli-1.0.0-SNAPSHOT-jar-with-dependencies.jar
read -n1 -r -p "Press any key to continue..." key