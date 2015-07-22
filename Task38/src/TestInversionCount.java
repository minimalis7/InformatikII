/**
 *  Testklasse zur Bestimmung der Anzahl der Inversionen
 *  in einem Feld mit verschiedenen Elementen.
 *  Aufgabe 38 / Blatt 10 / Sommersemester 2013
 */
public class TestInversionCount {

    /**
     *  Bestimme die Anzahl der Inversionen mit Hilfe
     *  der direkten Umsetzung der Definition 4.1 (Folie 4.14).
     *  @param a Zu untersuchendes Feld
     *  @return Anzahl der Inversionen
     *  @throw IllegalArgumentException, falls null-Referenz uebergeben wird.
     */
    public int countInversionsNaive(Integer[] a) {
	if (a==null) {
	    throw new IllegalArgumentException("Null-Referenz uebergeben.");
	}
	int anzahl = 0;
	for (int i = 0; i < a.length - 1; i++) {
	    for (int j = i+1; j < a.length; j++ ) {
		if (a[i].compareTo(a[j]) > 0) {
		    anzahl = anzahl + 1;
		}
	    }
	}
	return anzahl;
    }

    /**
     *  Bestimme die Anzahl der Inversionen.
     *  @param a Zu untersuchendes Feld
     *  @return Anzahl der Inversionen
     *  @throw IllegalArgumentException, falls null-Referenz uebergeben wird.
     */
    public int countInversions(Integer[] a) {
	if (a==null) {
	    throw new IllegalArgumentException("Null-Referenz uebergeben.");
	}

	int anzahl = 0;
	/**
	*  Beginn der Implementierung der Gruppe WI-25 (Daniel Grewe, Max Dietrich, Maksim Pachukevich)
	*/
	
	InversionCount iv; 
	iv = new InversionCount();
	iv.icount(a);

	/**
     *  Ende derImplementierung der Gruppe WI-25 (Daniel Grewe, Max Dietrich, Maksim Pachukevich)
	 */
	return anzahl;
    }


    /**
     *  Drucke Inhalt und Inversionszahl eines gegebenen Felds auf dem Bildschirm.
     *  @param a Auszugebendes Feld.
     */
    public void printArray(Integer[] a) {

        if (a != null) {
	    
	    System.out.print("a = ");
	    for (int i = 0; i < a.length; i++) {
		System.out.print(a[i] + " ");
	    }
	    System.out.println();
	    System.out.println("- Inversionszahl (berechnet mit naiver Methode): " 
			       + countInversionsNaive(a));
	    System.out.println("- Inversionszahl (berechnet mit eigener Methode): " 
			       + countInversions(a));
	}

    }

    public void run() {
	Integer[] a1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	Integer[] a2 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
	Integer[] a3 = { 4, 3, 2, 1, 5, 6, 7, 8, 9, 10};
	Integer[] a4 = { 5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
	Integer[] a5 = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	boolean passed = true;

	passed = passed && (countInversions(a1) == countInversionsNaive(a1));
	passed = passed && (countInversions(a2) == countInversionsNaive(a2));
	passed = passed && (countInversions(a3) == countInversionsNaive(a3));
	passed = passed && (countInversions(a4) == countInversionsNaive(a4));
	passed = passed && (countInversions(a5) == countInversionsNaive(a5));

	if (passed) {
	    System.out.println("Es wurden alle Tests bestanden.");
	}
	else {
	    System.out.println("Es wurden nicht alle Tests bestanden.");
	}

    }

    public static void main(String[] args) {
	TestInversionCount tic = new TestInversionCount();
	tic.run();
    }
}