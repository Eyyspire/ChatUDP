JFLAGS := -g
JC := javac
JVM := java 
JDOC := javadoc
JARFILE := jar
FILE=

SRC := src
TEST := test
OUT := classes
DOCS := docs
    
PKG := chat
MAIN := $(PKG).ChatUDP


all :
	make cls
	make docs

cls :
	$(JC) -Xlint -sourcepath src -d classes src/chat/*.java

docs:
	$(JDOC) -sourcepath src -d doc src/**/*.java



clean:
	rm -rf classes
	rm -rf target
	rm -rf doc
