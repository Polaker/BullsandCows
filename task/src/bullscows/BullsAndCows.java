package bullscows;

import java.util.Scanner;

public class BullsAndCows {

    public String secretCode;
    public int bullsCounter = 0;
    public BullsAndCows() {

    }

    public void launch(int length) { // funkcja majaca na celu rozegranie gry oraz ocenienie ruchu gracza
        boolean isActive = true;
        int turn = 1;
        do {
            System.out.println("Turn " + turn + ":");
            turn++;
            String userGuess = guess();
            grade(userGuess, length); // Ocenienie gracza
            if (bullsCounter == length) { // jezeli ilosc bulls jest równa ilosci symboli kodu to gracz wygrał i zakonczyl gre
                System.out.println("Congratulations! You guessed the secret code.");
                isActive = false;
            }
            bullsCounter = 0; // co ruch ustawiam licznik bulls na 0
        }while (isActive);

    }


    private String guess() { // funkcja pobierająca mozliwe rozwiazanie od uzytkownika
        Scanner scanner = new Scanner(System.in);

        String guess;
        /*while (!isValidGuess(guess = scanner.next())) {
            System.out.println("Your guess should be a 4-digit number.");
        }*/
        return guess = scanner.next();
    }

    private boolean isValidGuess(String userGuess, int length) {
        return userGuess.length() == length;
    } // sprawdzenie czy mozliwe rozwiazanie uzytkownika nie jest dluzsze niz kod

    private void grade(String userGuess, int length) { // funkcja oceniajaca czy mozliwe rozwiazanie pokrywa sie z sekretnym kodem
        int numberOfBulls = 0;
        int numberOfCows = 0;

        for (int i = 0; i < length; i++) {
            if (secretCode.charAt(i) == userGuess.charAt(i)) { // jesli znak uzytkownika jest taki sam i w tym samym miejscu co w kodzie
                numberOfBulls++; // to zwiekszam ilosc bulls
                bullsCounter++;
            }
            for (int j = 0; j < length; j++) { // jesli znak uzytkownika jest taki sam ale w innym miejscu co w kodzie
                if (userGuess.charAt(j) == secretCode.charAt(i) && i != j) {
                    numberOfCows++; // to zwiekszam ilosc cows
                }
            }
        }
        printGrade(numberOfBulls, numberOfCows); // Wypisuje ocene a nastepnie ustawiam ilosc bulls i cows spowrotem na 0
        numberOfBulls = 0;
        numberOfCows = 0;

    }

    private void printGrade(int numberOfBulls, int numberOfCows) { // Funkcja oceniajaca gracza w zaleznosci od uzyskanych punktow
        if (numberOfBulls == 0 && numberOfCows == 0) {
            System.out.println("Grade: None.");
        } else if (numberOfBulls > 0 && numberOfCows == 0) {
            System.out.println("Grade: " + numberOfBulls + " bull(s).");
        } else if (numberOfBulls == 0 && numberOfCows > 0) {
            System.out.println("Grade: " + numberOfCows + " cow(s).");
        } else {
            System.out.println("Grade: " + numberOfBulls + " bull(s) and " + numberOfCows + " cow(s).");
        }
    }
}