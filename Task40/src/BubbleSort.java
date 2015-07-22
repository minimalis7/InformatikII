/**
 * Klasse zur Realisierung des Bubblesort-Verfahrens
 * @author WI-Abgabegruppe 25 (Daniel Grewe, Maksim Pashukevich, Max Dietrich)
 */
public class BubbleSort extends VisualizableSort implements Runnable {

	
	/**
	 * Konstruktor, der eine Referenz auf ein Objekt der Klasse
	 * ArrayVisualizer entgegen nimmt. Dieses Objekt wird in der
	 * update-Methode genutzt, um den aktuellen
	 * Zustand des Felds zu visualisieren
	 * @param av Referenz auf Visualisierungs-Objekt
	 */
	public BubbleSort(ArrayVisualizer av) {
		super(av);
	}
	
	private int numberOfSwaps;
	private int numberOfComparisons;

	/**
	 * Sortiere ein gegebenes Feld mit Hilfe des Bubblesort-Verfahrens.
	 * @param a Zu sortierendes Feld
	 */
	public void sort(Integer[] a) {
		boolean swapped = false;
		do {
			swapped = false;
			for (int i = 0; i < a.length-1;i++) {
				if(a[i].compareTo(a[i+1]) > 0) {
					swap(a,i,i+1);
					numberOfSwaps++;
					super.update(); // hier kann auch ein long-Parameter uebergeben werden, um die Darstellung zu verlangsamen
					swapped = true;
				}
				numberOfComparisons++;
			}
		}
		while (swapped);
		System.out.println("Anzahl der Vertauschungen: " + numberOfSwaps);
		System.out.println("Anzahl der Vergleiche: " + numberOfComparisons);
	}
	
	public void run() {
		sort(av.data);
	}
	
}
