// Mohammad Tayyab Khalid - s319229

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {
    public static void byttInt(int[] a, int h, int v) {
        int temp = a[v];
        a[v] = a[h];
        a[h] = temp;
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
                if (a[k] == j) {
                    antallUlike++;
                    break;
                }
            }
        }
        return antallUlike;
    }

    //Oppgave 4
    public static void delsortering(int[] a) {

        int v = 0;
        int h = a.length - 1;

        while (v <= h) {
            if ((a[v] & 1) == 1) v++;

            else {
                if ((a[h] % 2) == 0) h--;
                else byttInt(a, v++, h--);
            }
        }

        Arrays.sort(a, 0, v);
        Arrays.sort(a, v, a.length);
    }

    //Oppgave 5
    public static void rotasjon(char[] a) {
        if (a.length == 0 || a.length == 1) return;

        for (int i = a.length - 1; i > 0; i--) {
            char temp = a[i];
            a[i] = a[i - 1];
            a[i - 1] = temp;
        }
    }

    // Oppgave 7a
    public static String flett(String a, String b) {

        String flettet = "";

        int tellerA = 0;
        int tellerB = 0;

        while (tellerA != a.length() || tellerB != b.length()) {
            if (tellerA < a.length()) {
                flettet += a.charAt(tellerA++);
            }

            if (tellerB < b.length()) {
                flettet += b.charAt(tellerB++);
            }
        }
        return flettet;
    }

    //Oppgave 7b
    public static String flett(String... s) {
        if (s.length == 0) return "";

        int l = s[0].length();

        for (int i = 0; i < s.length; i++) {
            int n = s[i].length();

            if (n > l) {
                l = n;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < l; i++) {

            for (String t : s) {
                if (i < t.length()) {
                    stringBuilder.append(t.charAt(i));
                }
            }

        }
        return stringBuilder.toString();
    }
}







