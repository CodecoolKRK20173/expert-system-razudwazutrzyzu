#!/bin/bash
find expertsystem/src -name '*.java' > sources.list
mkdir -p out
javac @sources.list -d out && java -cp out:resources com.codecool.expertsystem.Main
