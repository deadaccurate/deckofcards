
To compile:

cd into deckofcards directory

Execute: javac -d bin -sourcepath ./src/ src/jdeck/*.java

Two run from deckofcards directory:

Execute: java -cp bin jdeck.DeckEngine <number of iterations>
the results will be printed to standard out

I provided two scripts to perform the setups above on a linux host
build.sh will compile the classes and place them in bin

run.sh <num interations> will execute DeckEngine with the specified

number of iterations
