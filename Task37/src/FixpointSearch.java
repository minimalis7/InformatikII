/**
 *  Finde den groessten Fixpunkt in einem aufsteigend sortierten Feld
 *  Blatt 10, Aufgabe 38, Sommersemester 2013
 *  Gruppe WI-25 (Daniel Grewe, Max Dietrich, Maksim Pachukevich)
 */
public class FixpointSearch {
	
	private int bestposition = 0;
	
	/**
     *  Ueberpruefe, ob fuer einen Eintrag <code>a[i]</code> im uebergebenen
     *  aufsteigend sortierten Feld gilt: <code>a[i]=i</code>. 
     *  @param a Zu ueberpruefendes Feld.
     *  @return groesster Index i mit <code>a[i]=i</code>, falls ein solcher Eintrag
     *          existiert, <code>a.length</code> sonst
     */
	public int search(Integer[] a) {
		// Mache dir zunutze, dass es sich um ein paarweise verschieden sortiertes Array handelt,
		// ist der erste und letzte Wert gleich dem jew. Index, so ist jeder Wert des Arrays ein Fixpunkt
		// -> gede den letzten Arraywert zurueck.
		if (a[0] == 0 && a[a.length-1] == a.length-1)
			return a.length-1;
		// Ansonsten gebe die interne rekursive Methode zuerueck
		else
			return searchIntern(a, 0, a.length-1);
	}
	
	/**
     *  Interner Rekursionsaufruf der <code>search</code>-Methode 
     *  @param a Zu ueberpruefendes Feld.
     *  @return groesster Index i mit <code>a[i]=i</code>, falls ein solcher Eintrag
     *          existiert, <code>a.length</code> sonst
     */
	private int searchIntern(Integer[] a, int b, int e) {
		
		// Test ob das Array gueltig ist.
		if (e < b) {
			// Leeres Array, also gebe a.length zurueck
			return a.length;
		}
		else {
			// Berechne den Mittelpunkt m
			int m = (e+b)/ 2;
			// Wenn der Wert an der Stelle a[m] groeßer ist als m
			if (a[m] > m)
		        // suche die beste Position im oberen Teilarray
		        return searchIntern(a, b, m-1);
			// Wenn der Wert an der Stelle a[m] kleiner ist als m
			else if (a[m] < m)
				// suche die beste Position im oberen Teilarray
		        return searchIntern(a, m+1, e);
			// Wenn der Wert an der Stelle a[m] gleich m ist und der aktuelle hoechste Index kleiner m ist
			else if (a[m] == m && m > bestposition)
		        // gesuchtes Element a[m] = m ist neuer aktuell hoechster Index
				bestposition = m;
			// gebe den hoechsten Fixpunkt-Index zurueck
			return bestposition;
		        
		}
	}
}
