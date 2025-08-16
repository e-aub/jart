#!/bin/bash

curl -L -o maven-mvn.tar.gz https://dlcdn.apache.org/maven/maven-3/3.9.11/binaries/apache-maven-3.9.11-bin.tar.gz

tar -xzf maven-mvn.tar.gz -C ~/

echo "export M2_HOME=$HOME/apache-maven-3.9.11" >> ~/.zshrc
echo "export PATH=$M2_HOME/bin:\$PATH" >> ~/.zshrc

rm maven-mvn.tar.gz

echo "Maven installed successfully!"
