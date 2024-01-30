CLASS_PATH="bin;./lib/treemachine.jar"

all: bin/parser/Parser.class bin/parser/Lexer.class

bin/parser/Parser.class: src/parser/Parser.java
	javac -d bin -cp ${CLASS_PATH} src/parser/*.java

bin/parser/Lexer.class: src/parser/Lexer.java
	javac -d bin -cp ${CLASS_PATH} src/parser/*.java

run:
	java -cp ${CLASS_PATH} parser.Parser code.txt
