/**
 *	Aufgabe 27 a)
 *  Implementierung des BubbleSort-Algorithmus mit Rekursion anstatt ‰iﬂerer Schleife.
 *  Gruppe WI-25 (Daniel Grewe, Max Dietrich, Maksim Pachukevich)
 */
public class BubbleSortRecursive extends VisualizableSort implements Runnable{
	
	/**
	 * Konstruktor, der eine Referenz auf ein Objekt der Klasse
	 * ArrayVisualizer entgegen nimmt. Dieses Objekt wird in der
	 * update-Methode genutzt, um den aktuellen
	 * Zustand des Felds zu visualisieren
	 * @param av Referenz auf Visualisierungs-Objekt
	 */
	public BubbleSortRecursive(ArrayVisualizer av) {
		super(av);
	}
	
	/**
	 *  Methode, die ein uebergebenes Feld von <code>Integer</code>-
     *  Werten nach dem BubbleSort-Algorithmus sortiert.
	 *	Die aueﬂere Schleife wurde durch einen rekursiven Aufruf ersetzt.
	 *  @param a Zu sortierendes Feld.
	 */
	public void sort(Integer[] a) {
		
		boolean swapped = false;
		
		for(int i = 0; i < a.length -1; i++) {
			if (a[i].compareTo(a[i+1]) > 0) {
				swap(a, i, i+1);
				super.update(); // hier kann auch ein long-Parameter uebergeben werden, um die Darstellung zu verlangsamen
				swapped = true;
			}
		}
		
		if (swapped) { 				// Falls etwas getauscht wurde...
			this.sort(a);			// rufe den Algorithmus erneut auf.
		}	
		
	}
	
	public void run() {
		sort(av.data);
	}
	
}
