all: build/Main.class build/Test.class

build/Main.class:
	javac -d ./build Main.java

build/Test.class:
	javac -d ./build Test.java

run:
	java -cp ./build Main

test:
	java -cp ./build Test