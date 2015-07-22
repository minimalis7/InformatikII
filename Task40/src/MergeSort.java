/**
 * Klasse zur Realisierung des Mergesort-Verfahrens
 * @author WI-Abgabegruppe 25 (Daniel Grewe, Maksim Pashukevich, Max Dietrich)
 */
public class MergeSort extends VisualizableSort implements Runnable{
	
	/**
	 * Konstruktor, der eine Referenz auf ein Objekt der Klasse
	 * ArrayVisualizer entgegen nimmt. Dieses Objekt wird in der
	 * update-Methode genutzt, um den aktuellen
	 * Zustand des Felds zu visualisieren
	 * @param av Referenz auf Visualisierungs-Objekt
	 */
	public MergeSort(ArrayVisualizer av) {
		super(av);
	}

	private int numberOfSwaps;
	private int numberOfComparisons;
	
	/**
	 * Sortiere ein gegebenes Feld mit Hilfe des Mergesort-Verfahrens.
	 * @param a zu sortierendes Feld
	 */
	public void sort(Integer[] a) {
		// Rufe die rekursive Methode auf
		mergesortIntern(a,0,a.length, new Integer[a.length]);
		System.out.println("Anzahl der Vertauschungen (Einfuegen in Feld temp): " + numberOfSwaps);
		System.out.println("Anzahl der Vergleiche: " + numberOfComparisons);
	}
	
	/**
	 * Sortiere ein Teilfeld eines gegebenen Felds mit Hilfe des Mergesort-Verfahrens.
	 * @param a Zu sortierendes Feld
	 * @param b untere Grenze des Teilfeldes (inklusive)
	 * @param e obere Grenze des Teilfeldes (exklusive)
	 * @param temp Hilfsfeld zum Zusammenfuegen
	 */
	protected void mergesortIntern(Integer[] a, int b, int e, Integer[] temp) {
		// Falls das zu sortierende Feld nur ein Element hat, ist nichts zu tun.
		if (e-b > 1) {
			int m = (e+b) / 2;               // Bestimme die Mitte des Teilfeldes
			mergesortIntern(a, b, m, temp);  // Sortiere a[b,...,m-1]
			mergesortIntern(a, m, e, temp);  // Sortiere a[m,...,e-1]
			merge(a, b, m, e, temp);         // Fuege die sortierten Teile zusammen
		}
	}
	
	/**
	 * Fuege zwei sortierte Teilfelder zusammen.
	 * @param a Zu sortierendes Feld
	 * @param b untere Grenze des ersten Teilfelds (inklusive)
	 * @param m obere Grenze des ersten Teilfelds (exklusive), gleichzeitig
	 * 			untere Grenze des zweiten Teilfelds (inklusive)
	 * @param e obere Grenze des zweiten Teilfeldes (exklusive)
	 * @param temp Hilfsfeld zum Zusammenfuegen
	 */
	protected void merge(Integer[] a, int b, int m, int e, Integer[] temp) {
		int i = b; // Index fuer das erste Teilfeld
		int j = m; // Index fuer das zweite Teilfeld
		
		for (int k=b; k<e; k++) { // Fuege zu temp[b,...,e-1] zusammen
			super.update();
			if (!(i<m) || 						 // Ist erster Teil schon abgearbeitet
				((j<e) &&						 // oder ist zweiter Teil nicht
				(a[i].compareTo(a[j]) > 0)	)) { // abgearbeitet und a[i] < a[j]?
				temp[k] = a[j]; // Nimm naechstes Element aus zweitem Teil
				numberOfSwaps++;
				j++;
			}
			else {
				temp[k] = a[i]; // Nimm naechstes Element aus erstem Teil
				numberOfSwaps++;
				i++;
			}
			numberOfComparisons++;
			
		}
		
		// Kopiere temp[b,...,e-1] nach a[b,...,e-1]
		System.arraycopy(temp, b, a, b, e-b);
		super.update();
	}
	
	public void run() {
		sort(av.data);
	}
}
