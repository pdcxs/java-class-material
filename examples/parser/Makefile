CLASS_PATH="bin;./lib/treemachine.jar"

all: bin/simpleparser/Parser.class bin/simpleparser/Lexer.class

bin/simpleparser/Parser.class: src/simpleparser/Parser.java
	javac -d bin -cp ${CLASS_PATH} src/simpleparser/*.java

bin/simpleparser/Lexer.class: src/simpleparser/Lexer.java
	javac -d bin -cp ${CLASS_PATH} src/simpleparser/*.java

run:
	java -cp ${CLASS_PATH} simpleparser.Parser code.txt
