all: build/Main.class build/Test.class

build/Main.class: Main.java
	javac -d ./build Main.java

build/Test.class: Test.java
	javac -d ./build Test.java

run:
	java -cp ./build Main

test:
	java -cp ./build Test

jar:
	make
	cd build&&jar cf tree_machine.jar tree_machine/*.class tree_machine/exp/*.class tree_machine/env/*.class tree_machine/utils/*.class