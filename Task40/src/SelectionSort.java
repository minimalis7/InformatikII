/**
 * Klasse zur Realisierung des Selectionsort-Verfahrens
 * @author WI-Abgabegruppe 25 (Daniel Grewe, Maksim Pashukevich, Max Dietrich)
 */
public class SelectionSort extends VisualizableSort implements Runnable {

	/**
	 * Konstruktor, der eine Referenz auf ein Objekt der Klasse
	 * ArrayVisualizer entgegen nimmt. Dieses Objekt wird in der
	 * update-Methode genutzt, um den aktuellen
	 * Zustand des Felds zu visualisieren
	 * @param av Referenz auf Visualisierungs-Objekt
	 */
	public SelectionSort(ArrayVisualizer av) {
		super(av);
	}
	
	private int numberOfSwaps;
	private int numberOfComparisons;
	
	/**
	 * Sortiere ein Feld mit Hilfe des Selectionsort-Verfahrens.
	 * @param a zu sortierendes Feld
	 */
	public void sort(Integer[] a) {
		
		for(int i=0;i<a.length;i++) {
			
			int minIndex = i;
			
			for(int j=i;j<a.length;j++) {

				super.update(); // hier kann auch ein long-Parameter uebergeben werden, um die Darstellung zu verlangsamen

				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
				numberOfComparisons++;
			}


			super.update(); // hier kann auch ein long-Parameter uebergeben werden, um die Darstellung zu verlangsamen

			swap(a, i, minIndex);
			numberOfSwaps++;
			}
		System.out.println("Anzahl der Vertauschungen: " + numberOfSwaps);
		System.out.println("Anzahl der Vergleiche: " + numberOfComparisons);
		}


	public void run() {
		sort(av.data);
	}

}
