
/**
 *  Programm zum stabilen Vertauschen zweier Teilfelder.
 *  Blatt 8, Aufgabe 30, Sommersemester 2013
 */
public class TestSwapSubarrays {

    /**
     *  Vertausche in einem gegebenen Feld die Eintraege an
     *  den beiden gegebenen Stellen.
     *  @param a Eingabefeld
     *  @param indexA Index des ersten zu tauschenden Elements.
     *  @param indexB Index des zweiten zu tauschenden Elements.
     */
    protected void swap(Object[] a, int indexA, int indexB) {
        Object temp  = a[indexA];
        a[indexA] = a[indexB];
        a[indexB] = temp;
    }

    /**
     *  Drucke Laenge und Inhalt eines gegebenen Felds auf dem Bildschirm.
     *  @param a Auszugebendes Feld.
     */
    protected void printArray(Object[] a) {
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
     *  Vertausche stabil die Teilfelder a[0,...,i-1] und a[i,...,a.length-1].
     *  @param a Eingabefeld
     *  @param i Aufteilungsindex
     */
    protected void swapSubarrays(Object[] a, int i) {

    	for (int j = 0, k = i-1; j < Math.floor(i/2); j++, k--) {
    		swap(a,j,k);
    		System.out.println("j="+j+", k="+k);
    	}

    	for (int j = i, k = a.length-1; j < k; j++, k--) {
    		swap(a,j,k);
    	}

    	for (int j = 0, k = a.length-1; j < k; j++, k--) {
    		swap(a,j,k);
    	}
    }
       
        
	
    

    /**
     *  Uberpruefe, ob das Teilfeld a[b,...,e-1] mit dem bei
     *  Position start beginnenden Teilfeld von c uebereinstimmt.
     *  @param a Zu betrachtendes Feld.
     *  @param b untere Grenze (inklusive)
     *  @param e obere Grenze (exklusive)
     *  @param c Zu betrachtendes Vergleichsfeld.
     *  @param start Startindex in c
     *  @return <code>true</code>, falls die Teilfelder uebereinstimmen,
     *          <code>false</code> sonst
     */
     protected boolean compareSubarrays(Object[] a, int b, int e, Object[] c, int start) {
	for (int i = 0; i < (e-b); i++) {
	    if (!a[b+i].equals(c[start+i])) {
		return false;
	    }
	}
	return true;
    }

    /**
     *  Vertausche stabil die Teilfelder a[0,...,i-1] und a[i,..,a.length-1]
     *  und ueberpruefe das Ergebnis.
     *  @param a Eingabefeld
     *  @param i Aufteilungsindex
     *  @return <code>true</code>, falls die Vertauschung stabil erfolgte,
     *          <code>false</code> sonst
     *  @throw IllegalArgumentException, falls das Feld leer oder 
     *         nicht sortiert ist
     */
    protected boolean testSwapSubarrays(Object[] a, int i) {

	if (a == null || a.length < 1) {
	    throw new IllegalArgumentException("Keine Eingabedaten vorhanden.");
	}

	boolean passed = true;

	//  Erzeuge eine Kopie des Eingabefelds zu Vergleichszwecken...
	Object[] b = new Object[a.length];
	System.arraycopy(a, 0, b, 0, a.length);

	System.out.println("Teste swapSubarrays:");
	printArray(a);	
	System.out.println("  i = " + i);	
	swapSubarrays(a, i);
	printArray(a);	
	System.out.println();

	//  Wurde die Vertauschung stabil durchgefuehrt?
	passed = passed && compareSubarrays(a, 0, a.length - i, b, i);
	passed = passed && compareSubarrays(a, a.length - i, a.length, b, 0);

	return passed;
    }

    public void run() {

	boolean passed = true;

	Integer[] a1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
	int       i1 = 6;
	passed = passed && testSwapSubarrays(a1, i1);

	Integer[] a2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
	int       i2 = 1;
	passed = passed && testSwapSubarrays(a2, i2);

	Integer[] a3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
	int       i3 = a3.length;
	passed = passed && testSwapSubarrays(a3, i3);

	Integer[] a4 = { 1, 2 };
	int       i4 = 1;
	passed = passed && testSwapSubarrays(a4, i4);

	Integer[] a5 = { 1, 2 };
	int       i5 = 2;
	passed = passed && testSwapSubarrays(a5, i5);

	Integer[] a6 = { 1 };
	int       i6 = 1;
	passed = passed && testSwapSubarrays(a6, i6);


	if (passed) {
	    System.out.println("Alle Tests bestanden.");
	} 
	else {
	    System.out.println("Nicht alle Tests bestanden.");
	}


    }

    public static void main(String[] args) {
	
	TestSwapSubarrays tss = new TestSwapSubarrays();
	tss.run();

    }

}