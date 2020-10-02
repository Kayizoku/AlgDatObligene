

////////////////// class DobbeltLenketListe //////////////////////////////

import javax.swing.*;
import java.util.*;


public class DobbeltLenketListe<T> implements Liste<T> {
    public static void main(String[] args) {


        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

        System.out.println(liste.toString() + " " + liste.omvendtString());

        for (int i = 1; i <= 3; i++) {

            liste.leggInn(i);
            System.out.println(liste.toString() + " " + liste.omvendtString());
        }

    }

    /**
     * Node class
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        hode = hale = null;
        antall = endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
        a = Objects.requireNonNull(a, "Tabellen er tom");

        for (T q : a) {
            if (q != null) {
                if (antall() == 0) {
                    hode = new Node<T>(q, hode, hale);
                    hale = hode;
                } else {
                    hale = new Node<T>(q, hale, null);
                    hale.forrige.neste = hale;
                }
                antall++;
            }
        }

    }

    public Liste<T> subliste(int fra, int til){
        throw new UnsupportedOperationException();
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        if(antall == 0) {
            return true;
        } else
            return false;
    }


    @Override
    public boolean leggInn(T verdi) {

        Objects.requireNonNull(verdi, "Nullverdier er ikke tillatt");

        if(tom()) {
            hode = hale = new Node<T>(verdi, null, null);
        } else {
            hale = hale.neste = new Node<T>(verdi, hale, null);
        }
        antall++;
        endringer++;
        return true;

    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }

    private Node<T> finnNode(int indeks) {

        if (indeks < antall/2) {
            Node<T> p = hode;
            for (int i = 0; i < indeks; i++) {
                p = p.neste;
            }
            return p;
        } else {
            Node<T> p = hale;
            for (int i = antall - 1; i > indeks; i--) {
                p = p.forrige;
            }
            return p;
        }
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return (T) finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {

        if (antall == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> node = hode;
        if (node.verdi != null) {
            sb.append(node.verdi);
        }
        node = node.neste;

        while (node != null) {
            sb.append(", ");
            sb.append(node.verdi);
            node = node.neste;
        }
        sb.append("]");

        return sb.toString();
    }

    public String omvendtString() {

        if (antall == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> node = hale;
        if (node.verdi != null) {
            sb.append(node.verdi);
        }
        node = node.forrige;

        while (node != null) {
            sb.append(", ");
            sb.append(node.verdi);
            node = node.forrige;
        }
        sb.append("]");

        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator(){
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks){
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext(){
            return denne != null;
        }

        @Override
        public T next(){
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


