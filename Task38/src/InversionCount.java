/**
 *  Klasse zur Bestimmung der Anzahl der Inversionen
 *  in einem Feld mit verschiedenen Elementen.
 *  Blatt 10, Aufgabe 38, Sommersemester 2013
 *  Gruppe WI-25 (Daniel Grewe, Max Dietrich, Maksim Pachukevich)
 */
public class InversionCount {
	
	private Integer[] a; 			// zu uebergebendes Array a
	private Integer[] h;			// Hilfsarray h
	private int n;					// Var. fuer die Laenge des uebergebenen Array a
	private int invCounter = 0;		// Zaehlvariable fuer die Anzahl der Inversionen
	
	/**
     *  Bestimme die Anzahl der Inversionen.
     *  @param a Zu untersuchendes Feld
     *  @return Anzahl der Inversionen
     */
	public int icount(Integer[] values) {
		
		this.a = values;
	    this.n = values.length;
	    this.h = new Integer[n];
	    icountMergesort(0, n - 1);
	    return invCounter;
	    
	    
	}
	
	/**
     *  Sortiere ein Teilfeld eines Feldes mit dem Mergesort-Verfahren.
     *  @param b Beginn des Teilfeldes
     *  @param e Ende des Teilfeldes
     */
	private void icountMergesort(int b, int e) {
	    // Falls b > e sein sollte, ist das Array bereits sortiert.
	    if (b < e) {
	      // Finde den Index des mittleren Elementes
	      int m = b + (e - b) / 2;
	      // Sortiere die linke Seite des Arrays
	      icountMergesort(b, m);
	      // Sortiere die rechte Seite des Arrays
	      icountMergesort(m + 1, e);
	      // Kombiniere beide Teilarrays
	      icountMerge(b, m, e);
	    }
	 }
	
	/**
     *  Fuege zwei sortierte Teilfelder mit dem Mergesort-Verfahren zusammen.
     *  @param b Beginn des Teilfeldes
     *  @param m Mitte des Teilfeldes
     *  @param e Ende des Teilfeldes
     */
	private void icountMerge(int b, int m, int e) {

	    // Kopiere beide Teilarrays in das Hilfsarray h
	    for (int i = b; i <= e; i++) {
	      h[i] = a[i];
	    }

	    int i = b;
	    int j = m + 1;
	    int k = b;
	    
	    // Die kleinsten Werte aus dem linken und rechten Teilarray von h 
	    // werden in das Zielarray kopiert
	    while (i <= m && j <= e) {
	    	// Wenn das sortierte Element aus des linken Teilfeld kommt...
	    	if (h[i] <= h[j]) {
	    		// ... kopiere das linke Element.
	    		a[k] = h[i];
	    		i++;
	    	// Wenn das sortierte Element aus dem rechten Teilfeld kommt...
	    	} else {
	    		// ... kopiere das rechte Element.
	    		a[k] = h[j];
	    		// Und erhoehe den Inversionszaehler um 1.
	    		invCounter++;
	        j++;
	      }
	      k++;
	    }
	    // Rest des linken Teilarrays wird in das Zielarray kopiert
	    while (i <= m) {
	    	a[k] = h[i];
	    	k++;
	    	i++;
	    }

	}
	
	
}
