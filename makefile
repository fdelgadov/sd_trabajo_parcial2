jar:
	jar -ecf DOMParserExample parser.jar *.class

c:
	javac *.java

run:
	java -jar parser.jar $F