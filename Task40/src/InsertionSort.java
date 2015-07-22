/**
 * Klasse zur Realisierung des Insertionsort-Verfahrens
 * @author WI-Abgabegruppe 25 (Daniel Grewe, Maksim Pashukevich, Max Dietrich)
 */
public class InsertionSort extends VisualizableSort implements Runnable{

	/**
	 * Konstruktor, der eine Referenz auf ein Objekt der Klasse
	 * ArrayVisualizer entgegen nimmt. Dieses Objekt wird in der
	 * update-Methode genutzt, um den aktuellen
	 * Zustand des Felds zu visualisieren
	 * @param av Referenz auf Visualisierungs-Objekt
	 */
	public InsertionSort(ArrayVisualizer av) {
		super(av);
	}

	private int numberOfSwaps;
	private int numberOfComparisons;
	
	/**
	 * Sortiere ein Feld mit Hilfe des Insertionsort-Verfahrens.
	 * @param a zu sortierendes Feld
	 */
	public void sort(Integer[] a) {
		for (int i=1; i<a.length; i++) {
			
			Integer gemerkt = a[i]; // a[i] merken (wird ueberschrieben)
			int suchIndex = i-1;    // Start der Suche rueckwaerts
			
			while ((suchIndex >= 0) && (gemerkt.compareTo(a[suchIndex]) < 1)) {
				numberOfComparisons++;
				super.update();
				// Falls suchIndex noch nicht passend,
				// a[suchIndex] nach rechts verschieben und
				// mit suchIndex weiter nach links wandern.
				a[suchIndex+1] = a[suchIndex];
				suchIndex--;
			}
			
			a[suchIndex+1] = gemerkt;
			// Altes a[i] wird rechts von suchIndex eingefuegt.
			numberOfSwaps++;
			super.update(); // hier kann auch ein long-Parameter uebergeben werden, um die Darstellung zu verlangsamen
		}
		System.out.println("Anzahl der Vertauschungen: " + numberOfSwaps);
		System.out.println("Anzahl der Vergleiche: " + numberOfComparisons);
	}

	public void run() {
		sort(av.data);
	}

	
	
}
