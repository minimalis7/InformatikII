/**
 *  Programm zur Umkehrung einer stabilen Selektion fuer
 *  eine sortierte Menge von Werten.
 *  Blatt 8, Aufgabe 31b, Sommersemester 2013
 */
public class TestUndoSelection {

    /**
     *  Ueberpruefe, ob ein gegebenes Feld sortiert ist.
     *  @param a Zu ueberpruefendes Feld.
     *  @return <code>true</code>, falls das Feld sortiert ist,
     *          <code>false</code> sonst.
     */
    protected  <T extends Comparable<T> > boolean isSorted(T[] a) {
        boolean isSorted = true;
        for(int i = 0; i < a.length - 1; i++) {
            isSorted = isSorted && (a[i].compareTo(a[i+1]) < 1);
        }
	return isSorted;
    }

    /**
     *  Vertausche in einem gegebenen Feld die Eintraege an
     *  den beiden gegebenen Stellen.
     *  @param a Eingabefeld
     *  @param indexA Index des ersten zu tauschenden Elements.
     *  @param indexB Index des zweiten zu tauschenden Elements.
     */
    protected  <T extends Comparable<T> > void swap(T[] a, int indexA, int indexB) {
        T temp  = a[indexA];
        a[indexA] = a[indexB];
        a[indexB] = temp;
    }

    /**
     *  Drucke Laenge und Inhalt eines gegebenen Felds auf dem Bildschirm.
     *  @param a Auszugebendes Feld.
     */
    protected  <T extends Comparable<T> > void printArray(T[] a) {

        if (a != null) {
	    System.out.print("  a = { ");
	    for (int i = 0; i < a.length - 1; i++) {
		System.out.print(a[i] + ", ");
	    }
	    System.out.print(a[a.length-1] + " } ");
	    System.out.println(); 
	}

    }

    /**
     *  Implementierung der Gruppe WI-25 (Daniel Grewe, Max Dietrich, Maksim Pachukevich)
     *  Mache die von stableSortedSelection durchgefuehrte Selektion
     *  rueckgaengig, ohne das Praedikat zu verwenden.
     *  @param a Feld im Zustand nach stableSortedSelection
     *  @param index Rueckgabewert von stableSortedSelection
     *  @throw IllegalArgumentException, falls das Feld leer oder 
     *         der Index ungueltig ist
     */
    public <T extends Comparable<T> > void undoStableSortedSelection(T[] a, int index) {

	if (a == null || a.length < 1) {
	    throw new IllegalArgumentException("Keine Eingabedaten vorhanden.");
	}
	if (index < 0 || index > a.length) {
	    throw new IllegalArgumentException("Ungueltiger Index.");
	}
	
	// Beginn der eigenen Implementierung des Algorithmus undoStableSortedSelection 
	
	for (int i = index - 1, j = a.length - 1; j >= 0 && i >= 0; j--) {
	 
		// Wenn a[j] < a[i], tausche mithilfe der swap-Methode
		if (a[j].compareTo(a[i]) < 0) {
			swap(a, j, i);
			// Verringere i um 1 fuer den neuen Vergleichindex im Feld
			if (i != 0) {
				i--;
			}
		}

		// Beende die Schleife, sobald a[j] = a[i] --> keine Suche im bereits sortierten Bereich des Feldes noetig
		if (a[j].compareTo(a[i]) == 0) {
			break;
		}
	
	}	
	}
		
	// Ende der eigenen Implementierung des Algorithmus undoStableSortedSelection

	

    /**
     *  Selektiere aus einem sortierten Eingabefeld stabil alle Werte,
     *  fuer die das Praedikat den Wert true ergibt und kehre das Ergebnis
     *  dann wieder um.
     *  @param a Sortiertes Eingabefeld
     *  @param f Praedikat auf den Werten in a
     *  @return <code>true</code>, falls die Umkehrung erfolgreich war,
     *          <code>false</code> sonst
     */
    protected boolean testPredicate(Integer[] a, int i) {

	System.out.println("Teste undoStableSortedSelection:");
	printArray(a);	
	System.out.println("  i = " + i);
	undoStableSortedSelection(a, i);
	printArray(a);	

	System.out.println();

	return isSorted(a);
    }
  

    public void run() {

	boolean passed = true;

	Integer[] a1 = { 2, 4, 6, 8, 10, 3, 7, 1, 9, 5, 11 };
	int       i1 = 5;
	passed = passed && testPredicate(a1, i1);
	
	Integer[] a2 = { 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 };
	int       i2 = 1;
	passed = passed && testPredicate(a2, i2);

	Integer[] a3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
	int       i3 = 1;
	passed = passed && testPredicate(a3, i3);

	Integer[] a4 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }; 
	int       i4 = 11;
	passed = passed && testPredicate(a4, i4);

	Integer[] a5 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }; 
	int       i5 = 0;
	passed = passed && testPredicate(a5, i5);

	Integer[] a6 = { 2, 3, 4, 5, 6, 7, 8, 9, 1, 10, 11 };
	int       i6 = 8;
	passed = passed && testPredicate(a6, i6);

	Integer[] a7 = { 7, 2, 3, 4, 5, 6, 1, 8, 9, 10, 11 };
	int       i7 = 1;    
	passed = passed && testPredicate(a7, i7);

	if (passed) {
	    System.out.println("Alle Tests bestanden.");
	} 
	else {
	    System.out.println("Nicht alle Tests bestanden.");
	}
    }
    
    public static void main(String[] args) {

	TestUndoSelection tus = new TestUndoSelection();
	tus.run();

    }
}