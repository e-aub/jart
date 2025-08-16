clean:
	mvn clean
	rm -f image.png

build:
	mvn install

run: clean build
	mvn exec:java -Dexec.mainClass="jart.Main"

dependencies:
	./install_maven.sh

help:
	@echo "Available targets:"
	@echo "  build  - Compile and package the project"
	@echo "  run    - Build and run the application"
	@echo "  clean  - Remove build artifacts"
	@echo "  help   - Show this help message"
	@echo "  dependencies - Install dependencies"
