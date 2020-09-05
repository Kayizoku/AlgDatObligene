import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {
    public static void main(String[] args) {

        int[] a = {9, 1, 2, 3,5, 6, 7, 8 ,5};
        antallUlikeUsortert(a);
        System.out.println(antallUlikeUsortert(a));
    }

    public static void bytteInt(int[] a, int h, int v) {
        int temp = a[v];
        temp = a[h];
        a[h] = temp;
    }

    public static void byttChar(char[] a, int h, int v) {
        int temp = a[v];
        a[v] = a[h];
        a[h] = (char) temp;
    }


    public static boolean isSorted(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {

            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    //Oppgave 1

    /**
     * - spørsmål
     * Denne metoden funker fint for å finne maks i en liten tabell, mens til større tabeller, så
     * vil denne metoden bli svært ineffektiv. På grunn av metoden iterer gjennom hele tabellen og
     * flytter på mange variabler før den kommer til sluttpunktet. Dermed føler jeg denne metoden er dårligere
     * enn den vi har sett på tidligere.
     */


    public static int maks(int[] a) {

        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen er tom!");
        }

        if (a.length == 1) {
            return a[0];
        }
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }

        }
        return a[a.length - 1];
    }

    /**
     * - Spørsmål
     * Når blir det flest ombyttinger? Det blir flest ombyttinger hvis tabellen blir sortert revers.
     * Når blir det færrest? Det blir færrest ombyttinger når tabellen står i stigende rekkefølge.
     * Hvor mange blir det i gjennomsnitt? Hvis det gjelder en tabell med lengde 10 og 10 verdier.
     * Så blir svaret 7 ombytter ut av 10 tilfeldige permuterte tabeller.
     */

    public static int ombyttinger(int[] a) {
        int teller = 0;

        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen er tom");
        }

        if (a.length == 1) {
            System.out.println("Lengden til tabellen er 1. Ingen ombyttinger har blitt utført");

        } else {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1] && a[i + 1] < a.length) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    teller++;
                }
            }
        }
        return teller;
    }

    // Oppgave 2
    public static int antallUlikeSortert(int[] a) {

        if (!isSorted(a)) {
            throw new IllegalStateException("Tabellen er ikke sortert stigende");
        }

        int antallUlike = 1;

        if (a.length == 0) {
            antallUlike = 0;

        } else {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] < a[i + 1]) antallUlike++;
            }
        }
        return antallUlike;
    }

    // Oppgave 3
    public static int antallUlikeUsortert(int[] a) {

        if (a.length < 1) {
            return 0;
        }

        int antallUlike = 0;
        int storst = a[0];

        for (int i : a) {
            if (storst < i) {
                storst = i;
            }
        }

        for (int j = 0; j <= storst; j++) {
            for (int k = 0; k < a.length; k++) {
                if(a[k] == j) {
                    antallUlike++;
                    break;
                }
            }
        }
        return antallUlike;
    }
}





