# Obligatoriske Oppgaver i Algoritmer og Datastrukturer

# Oppgaven er løst av:
* Mohammad Tayyab Khalid (s319229)

Dette repository inneholder alle Oblig innleveringene

# Beskrivelse av oppgaveløsning

## Oblig 2:

* Oppgave 0: løst ved lage et main-program i DobbetLenketListe klassen. Videre så lager vi en Instants av Liste med String av typen DobbeltLenketListe<>() hvor vi bruker   keyword new. 

* Oppgave 1: løst ved returnere antall i antall() og ved å lage en tom() funksjon som returnerer true/false avhengig om listen er faktisk tom eller ikke.

* Oppgave 2: Løst string tostring() ved å traverse først fra hode til hale og legge til verdi ved hjelp av StringBuiler. I omvendtString() starter vi fra hale og løper gjennom til hode, men selve prinsippet er det samme, med bare noen få kodesnutter er annerledes. b) var løst ved å skjekke om at listen er tom eller ei. Hvis den er tom så blir både hode og hale sin forrige og neste peker satt til null. Eller så flytter vi hale til neste node.

* Oppgave 3: løst ved at man finner posisjonen til midterste noden. Hvis indeksen er større går vi i gjennom fra hale til man ender opp på riktig node. Om indeksen er mindre går vi fra hode istendefor til man ender på riktig node. I b) ble det opprettet en ny DobbeltLenketListe, deretter traverserer vi fra verdi fra til verdi til og legger til node verdi som igjen blir peket til neste ledig plass i listen.

* Oppgave 4: løst ved å skjekke om verdi er null og da returnerers – 1 om den tilfredstiller kraven. Videre så traverser man gjennom alle nodene samtidig som indeks blir telt opp og returner, bare hvis verdien stemmer ellers returneres – 1 om den ikke stemmer. b) ble løst ved å skjekke om indeksTil(verdi) er lik som -1 og returnerer false eller true basert på det. Om indeks er like antall blir det laget en hale some blir pekt til neste plass.

* Oppgave 5: løst ved at man skjekker og passer på at det er ingen nullverdier og kontrollerer at det er riktig. Opretter noder og iterer over listen og sammenlikner og legger til nye node verdier. Dermed så skjekker man om verdien skal legge bakerst, forrest, og eller i mellom to andre.

* Oppgave 6: started me å løse ved at den første fjern funksjonen med boolean skjekker ved å løpe gjennom fra hode til hale og fjerner verdiene på posisjonen indeks steg etter steg, basert på hva som skjekkes. Andre fjern funksjonen nuller ut hode og hale først om antall er 1 og indeks er 0. Videre sjekker den neste og forrige-pekere verdiene og fjerner dem fra listen.

* Oppgave 7: Etter du kjører testen till Oppgave 8 kaller den på nullstill(), som sier at den må også implementertes. Denne funksjonen enkelt bare traverserer fra hode til hale og nuller alt ut.

* Oppgave 8: løste ved å skjekket at endrigene stemmer og kaster exception basert på hva vi får. Hvis det stemmer blir verdien flyttet til nesten node og returnert. Løste b) ved å returnere en ny instants av DobbeltlenketListeIterator() I Iterator<T>() metoden som ikke tar en indeks som parameter. c) var løst ved å sette verdien denne til finnNode(indeks) metoden. d) ble løst ved å utføre en indeksKontroll() for å skjekke om indeksen er lovelig. Så returnener vi nå ny instants av DobbetLenketListeIterator(int indeks) med indeks i parantesen.

