package bullscows;

import java.net.SecureCacheResponse;
import java.util.*;

public class Randomm{
    public int symbolsLength = 0; // zmienna typu int do ktorej przypisuje ilosc symboli którą chce gracz
    public boolean isPossible = true;
    public int lengthOfCode = 0;
    public boolean isPossibleSymb = true;
    public int getLengthFromUser() { // Funkcja pobierająca z klawiatury informacje o długości kodu
        int result = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            int length = scanner.nextInt();
            if (length < 36) {
                lengthOfCode = length;
                result = length;
                return length;
            } else {
                System.out.println("Error: can't generate a secret number with a length of " + length + " because there aren't enough unique digits.");
                return 0;
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            result = 0;
        }
        return result;
    }

    public String randomGenerator(int length) { // generator kodu
        StringBuilder result = new StringBuilder(); // użycie stringbuildera do ktorego przypisywany bedzie kod
        Numbers randomNumber = new Numbers(); // stworzenie obiektu klasy Numbers w ktorej zaimportowałem Random
        String symbols = "0123456789abcdefghijklmnopqrstuvwxyz"; // String który posiada w sobie wszystkie mozliwe symbole
        int range = getNumberOfSymbols(length); // przypisanie do zmiennej typu int przedziału w jakim gracz chce mieć symbole
        if (isPossibleSymb == false) {
            return "Error: maximum number of possible symbols in the code is 36 (0-9, a-z).";
        } else {
        if (range == 0) {
            return "Error: it's not possible to generate a code with a length of " + length + " with " + symbolsLength + " unique symbols.";
        } else {
            symbols = symbols.substring(0, range); // Skrócenie Stringa ze wszystkimi symbolami w przedziale jaki wyznaczył gracz
            for (int i = 0; i < length; i++) { // pętla w której tworzyć będą się symbole kodu
                int randomizer = randomNumber.randnum.nextInt(range); // zmienna typu int która korzysta z random w danym przez gracza przedziale i wynajduje losowy symbol
                String myStr = result.toString(); // Przeniesienie StringBuildera do Stringa w celu porównania
                int rando = randomizer; // zmienna typu int w ktorej przechowuje wartosc losową ze zmiennej randomizer
                StringBuilder symbolThatMightBeIn = new StringBuilder(); // Stworzenie StringBuildera którego użyje do porównywania
                symbolThatMightBeIn.append(symbols.charAt(rando)); // dodanie do StringBuildera wylosowanego symbolu
                while (myStr.contains(symbolThatMightBeIn)) { // pętla while która nie kończy się dopóki w Stringu znajduje się już taki sam symbol
                    randomizer = randomNumber.randnum.nextInt(range); // co pętle znalezienie losowego indeksu do pobrania symbolu
                    rando = randomizer;
                    symbolThatMightBeIn.deleteCharAt(0); // ze stringBuildera usuwam pobrany wczesniej znak poniewaz juz wystepuje
                    symbolThatMightBeIn.append(symbols.charAt(rando)); // i przypisuje nowy z nowo pobranego indeksu, jezeli juz jest to pętla wykona się znów
                }
                result.append(symbols.charAt(rando)); // po znalezieniu symbolu którego jeszcze nie ma dodajemy go do StringBuildera do ktorego przypisany bedzie kod
            }
            return result.toString(); // Zwrócenie gotowego kodu
        }
    }

    }

    public void launchRandom() { // funkcja wykorzystywana w stage 1-3 w celu odpalenia programu // TODO: w przyszłości starac sie upchac w to caly kod
        int length = getLengthFromUser();
        if (length != 0) {
            System.out.println("The random secret number is " + randomGenerator(length));
        } else {
            System.out.println("Error: can't generate a secret number with a length of " + length + " because there aren't enough unique digits.");
        }
    }
    public int getNumberOfSymbols(int length) { // Funkcja przyjmująca z klawiatury ilość możliwych symboli w sekretnym kodzie
        Scanner scanner = new Scanner(System.in);
        int symb = scanner.nextInt();
        symbolsLength = symb; // przypisanie tej wartosci rowniez do zmiennej globalnej
        if (symbolsLength < length) {
            isPossible = false;
            return 0;
        }else if (symb > 36) {
            isPossibleSymb = false;
            return 0;
        }
        else {
            return symb;
        }
    }
    public void preparingCode(int length1, int lenght2) { // Funkcja mająca na celu stworzenie Zdania o przygotowywaniu kodu
        System.out.print("The secret is prepared: ");
        for (int i = 0; i < length1; i++) { // pętla wypełniająca sztucznie gwiazdkami luki po symbolach
            System.out.print("*");
        }
        String symbols = "abcdefghijklmnopqrstuvwxyz"; // Wszystkie możliwe litery jako String
        char[] symb = symbols.toCharArray(); // Przeniesienie symboli do tablicy znakowej
        System.out.print(" (0-9), ");
        if (lenght2 > 10) { // jesli ilosc symboli pozwala na zawarcie liter to
            for (int j = 0; j < lenght2 - 10; j++) { // wykonujemy pętle która wczyta litery (ilosc symboli - 10 cyfr daje ilosc mozliwych liter)
                if (j == 0) { // jezeli indeks wynosi 0 to wypisujemy pierwszą literę czyli a
                    System.out.print("a");
                } else  if (j == lenght2 - 11) { // następnie wypisujemy pauze oraz ostatni znak i kończymy Stringa w momencie gdy jestesmy na koncu pętli
                    System.out.print("-" + symb[j]+ ").");
                }
            }
        }

    }
}