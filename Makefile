run: compile

Main.class: Main.java
	javac Main.java

SCREEN = :1 java xxx

compile: Main.class 
	java Main
       	
test: testData testBackend testFrontend

testFrontend: TestFrontEnd.class 
	java TestFrontEnd prepare maintask

TestFrontEnd.class: TestFrontEnd.java
	javac TestFrontEnd.java

testBackend: TestBackEnd.class BackendInterface.class
	java TestBackEnd prepare maintask

TestBackEnd.class: TestBackEnd.java
	javac TestBackEnd.java
	javac BackendInterface.java

testData: TestMovieAndMovieDataReader.class MovieDataReaderInterface.class
	java TestMovieAndMovieDataReader prepare maintask

TestMovieAndMovieDataReader.class: TestMovieAndMovieDataReader.java
	javac TestMovieAndMovieDataReader.java
	javac MovieDataReaderInterface.java

clean:
	$(RM) *.class
