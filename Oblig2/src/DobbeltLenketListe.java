// Mohammad Tayyab Khalid (s319229)

////////////////// class DobbeltLenketListe //////////////////////////////

import java.util.*;


public class DobbeltLenketListe<T> implements Liste<T> {
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
/*
        private Node(T verdi) {
            this(verdi, null, null);
        }
*/

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
        for (T q : a) {
            if (q != null) {
                if (antall() == 0) {
                    hode = new Node<>(q, hode, hale);
                    hale = hode;
                } else {
                    hale = new Node<>(q, hale, null);
                    hale.forrige.neste = hale;
                }
                antall++;
            }
        }

    }

    private void fraTilKontroll(int fra, int til) {
        if (fra < 0) {
            throw new IndexOutOfBoundsException("Verdien til fra er mindre enn 0");

        } else if (til > antall) {
            throw new IndexOutOfBoundsException("Verdien til er storre enn listen");

        } else if (til < fra) {
        throw new IllegalArgumentException("Verdien til er mindre enn verdien fra");
        }
    }

    public Liste<T> subliste(int fra, int til){

        fraTilKontroll(fra, til);
        DobbeltLenketListe<T> b = new DobbeltLenketListe<>();
        Node<T> p = finnNode(fra);
        for (int i = fra; i < til; i++) {
            b.leggInn(p.verdi);
            p = p.neste;
        }
        return b;

    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }


    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Nullverdier er ikke tillatt");
        if(tom()) {
            hode = hale = new Node<>(verdi, null, null);
        } else {
            hale = hale.neste = new Node<>(verdi, hale, null);
        }
        antall++;
        endringer++;
        return true;

    }

    @Override
    public void leggInn(int indeks, T verdi) {

        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdi");
        indeksKontroll(indeks, true);

        if (tom()) {
            hode = new Node<>(verdi, null, hode);
            hale = hode;

        } else if (indeks == 0 && antall > 0) {

            Node<T> p = hode;
            hode = new Node<>(verdi, null, p);
            p.forrige = hode;

        } else if (indeks == antall) {

            Node<T> p = hale;
            hale = new Node<>(verdi, hale, null);
            p.neste = hale;

        } else {

            Node<T> p = null;
            Node<T> q = hode;
            while (indeks > 0) {
                p = q;
                q = q.neste;
                indeks--;
            }

            Node<T> node = new Node<>(verdi, p, q);
            if ( p != null) {
                p.neste = node;
            }
            q.forrige = node;
        }
        antall++;
        endringer++;
    }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }


    private Node<T> finnNode(int indeks) {

        Node<T> p;
        if (indeks < antall/2) {
            p = hode;
            for (int i = 0; i < indeks; i++) {
                p = p.neste;
            }
        } else {
            p = hale;
            for (int i = antall - 1; i > indeks; i--) {
                p = p.forrige;
            }
        }
        return p;
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
         if (verdi == null) return - 1;
         Node<T> p = hode;

         for (int i = 0; i < antall; i++, p = p.neste) {
             if (p.verdi.equals(verdi)) {
                 return i;
             }
         }
         return - 1;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        Objects.requireNonNull(nyverdi, "Du kan ikke legge inn nullverdier");
        indeksKontroll(indeks,false);

        Node<T> p = finnNode(indeks);
        T forrigeVerdi = p.verdi;
        p.verdi = nyverdi;
        endringer++;
        return forrigeVerdi;

    }

    @Override
    public boolean fjern(T verdi) {

        if (tom()) {
            return false;

        } else if (antall == 1 && hode.verdi.equals(verdi)) {
            hode = hale = null;
            antall--;
            endringer++;
            return true;

        } else {
            Node<T> q = hode;

            for (int i = 0; i < antall; i++) {
                if (q.verdi.equals(verdi)) {
                    Node<T> p = q.forrige;
                    Node<T> r = q.neste;

                    if (q == hode) {
                        r.forrige = null;
                        hode = r;

                    } else if (q == hale) {
                        p.neste = null;
                        hale = p;

                    } else {
                        p.neste = r;
                        r.forrige = p;
                    }

                    antall--;
                    endringer++;

                    return true;
                }
                q = q.neste;
            }
        }
        return false;
    }

    @Override
    public T fjern(int indeks) {

        if(tom()) {
            throw new IndexOutOfBoundsException("Listen er tom");

        } else if (indeks < 0 || indeks >= antall) {
            throw new IndexOutOfBoundsException("Dett er ikke lov");

        } else {
            Node<T> q = finnNode(indeks);
            Node<T> p = q.forrige;
            Node<T> r;

            if (antall == 1) {
                hode = hale = null;

            } else if (indeks == 0) {
                r = q.neste;
                r.forrige = null;
                hode = r;

            } else if (indeks == (antall - 1)) {
                p.neste = null;
                hale = p;

            } else {
                r = q.neste;
                p.neste = r;
                r.forrige = p;
            }

            antall--;
            endringer++;

            return q.verdi;
        }
    }

    @Override
    public void nullstill() {
/*
        if (antall == 1) {
            hode = hale = null;
        } else {
            Node<T> p = hode;
            Node<T> q = p.neste;
            for (int i = 0; i < antall; i++) {
                p.verdi =  null;
                p = q;
            }
        }
        antall = 0;
        endringer++;
*/
        while (antall > 0)
            fjern(0);
    }

    //2. måten er mye raskere og effektivt. Bruker ikke mange linjer med kode.

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
       return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks, false);
        return new DobbeltLenketListeIterator(indeks);
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private final int iteratorendringer;

        private DobbeltLenketListeIterator(){
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks){
            denne = finnNode(indeks);
            fjernOK = false;
            iteratorendringer = endringer;
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next(){
            if (iteratorendringer != endringer) {
                throw new ConcurrentModificationException("Feil i antall endringer!");

            } else if (!hasNext()) {
                throw new NoSuchElementException("Ikke flere elementer igjen i listen!");
            }

            fjernOK = true;
            T temp = denne.verdi;
            denne = denne.neste;
            return temp;
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
/*
        public boolean isFjernOK() {
            return fjernOK;
        }
*/

/*
        public boolean isFjernOK() {
            return fjernOK;
        }

        public void setFjernOK(boolean fjernOK) {
            this.fjernOK = fjernOK;
        }

        public boolean isFjernOK() {
            return fjernOK;
        }
        */
    } // class DobbeltLenketListeIterator
/*
    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }
*/
} // class DobbeltLenketListe


