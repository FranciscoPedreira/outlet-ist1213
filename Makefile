all:
	javac `find rest pt -name "*.java"`
	jar -cfm rest-`date "+%Y%m%d%H%M%S"`.jar MANIFEST.MF `find rest pt -name "*.java"` Makefile MANIFEST.MF
	jar -cf pt.jar `find pt -name "*.class"`
	jar -cfm rest.jar MANIFEST.MF pt.jar `find rest -name "*.class"`
run:
	java -jar rest.jar
swing:
	java -Dui=swing -jar rest.jar
clean:
	rm -f `find rest pt -name "*.class"`
