/**
 * Klasse zur Realisierung des Quicksort-Verfahrens
 * @author WI-Abgabegruppe 25 (Daniel Grewe, Maksim Pashukevich, Max Dietrich)
 */
public class QuickSort extends VisualizableSort implements Runnable{
	
	/**
	 * Konstruktor, der eine Referenz auf ein Objekt der Klasse
	 * ArrayVisualizer entgegen nimmt. Dieses Objekt wird in der
	 * update-Methode genutzt, um den aktuellen
	 * Zustand des Felds zu visualisieren
	 * @param av Referenz auf Visualisierungs-Objekt
	 */
	public QuickSort(ArrayVisualizer av) {
		super(av);
	}
	
	private int numberOfSwaps;
	private int numberOfComparisons;
	
	/**
	 * Sortiere ein gegebenes Feld mit Hilfe des Quicksort-Verfahrens.
	 * @param a zu sortierendes Feld
	 */
	public void sort(Integer[] a) {
		// Rufe die rekursive Methode auf
		quicksortIntern(a,0,a.length-1);
		System.out.println("Anzahl der Vertauschungen: " + numberOfSwaps);
		System.out.println("Anzahl der Vergleiche: " + numberOfComparisons);
	}

	/**
	 * Sortiere ein Teilfeld eines gegebenen Feldes mit Hilfe des Quicksort-Verfahrens.
	 * @param a Zu sortierendes Feld
	 * @param L Index des ersten Elements des Felds
	 * @param R Index des letzten Elements des Felds
	 */
	protected void quicksortIntern(Integer[] a, int L, int R) {
		if (R-L > 0) {
			// Bestimme zufaelligen Index zwischen L und R.
			int zufallsIndex = L + (int) (Math.random()*(R-L));
			// Bringe Element von dieser Stelle an Ende des Arrays.
			swap(a,zufallsIndex,R);
			super.update();
			numberOfSwaps++;
			
			int pivotIndex = partition (a,L,R);   // Finde Teilungspunkt
			quicksortIntern(a, L, pivotIndex-1);  // 1. Rekursion
			quicksortIntern(a, pivotIndex+1, R);  // 2. Rekursion
		}
		numberOfComparisons++;
	}
	
	/**
	 * Teile das uebergebene Feld so auf, dass die enstehenden Teilfelder mit Hilfe des Quicksort-Verfahrens rekursiv bearbeitet werden koennen.
	 * @param a Zu sortierendes Feld
	 * @param L Index des ersten Elements des Felds
	 * @param R Index des letzten Elements des Felds
	 * @return
	 */
	protected int partition(Integer[] a, int L, int R) {
		Integer pivotElement = a[R]; // Fixiere Pivot-Element
		int i = L-1;
		for (int j = L; j < R; j++) { // Durchlaufe a[L,...,R-1]
			if (a[j].compareTo(pivotElement) <= 0) { // Falls a[j] <= P-Element
				i = i+1;                             // ... erhohe i um 1 und
				swap(a,i,j);                         // vertausche a[i] und a[j]
				super.update();
				numberOfSwaps++;
			}
			numberOfComparisons++;
		}
		swap(a,i+1,R); // Bringe P-Element an korrekte Position
		super.update();
		numberOfSwaps++;
		return i+1;    // Gib Index des P-Elements zurück
	}
	
	public void run() {
		sort(av.data);
	}
	
}
