package bullscows;

public class Main {
    public static void main(String[] args) {
        BullsAndCows bullsAndCows = new BullsAndCows(); // Stworzenie obiektów z klas BullsAndCows oraz Randomm
        Randomm random = new Randomm();

        System.out.println("Input the length of the secret code:");
        int length = random.getLengthFromUser(); // pobranie przy uzyciu funkcji z klasy Randomm długosci kodu ktory bedzie do odgadniecia
        if(length == 0) {
            System.out.println("Error: "+ "\"" + length + "\" isn't a valid number.");
        }
        if (length != 0) { // jezeli jego dlugosc nie zwrocila 0 (czyli kod nie jest ani za dlugi ani za krotki)
            String code = ""; // to tworzymy zmienna typu String do ktorej przypisany bedzie gotowy kod
            System.out.println("Input the number of possible symbols in the code:"); // prosimy o ilosc mozliwych symboli

            code = random.randomGenerator(length); // tworzymy kod przy uzyciu funckji randomGenerator o podanej dlugosci
            if (random.isPossibleSymb == false) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            } else {
            if (random.isPossible == true) {
                random.preparingCode(length, random.symbolsLength); // Wypisujemy ukryty kod i przedział symboli jaki zostal uzyty do jego utworzenia

                System.out.println("Okay, let's start a game!");
                bullsAndCows.secretCode = code;
                bullsAndCows.launch(length);// rozpoczynamy grę która skonczy się wraz z wygraną
            } else {
                System.out.println("Error: it's not possible to generate a code with a length of" + random.lengthOfCode + " with " + random.symbolsLength + " unique symbols.");
            }
        }
        }
    }

}
