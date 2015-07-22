/**
 *	Aufgabe 27 b)
 *  Implementierung des InsertionSort-Algorithmus mit Rekursion anstatt äußerer Schleife.
 *  Gruppe WI-25 (Daniel Grewe, Max Dietrich, Maksim Pachukevich)
 */
public class InsertionSortRecursive extends VisualizableSort implements Runnable{

	/**
	 * Konstruktor, der eine Referenz auf ein Objekt der Klasse
	 * ArrayVisualizer entgegen nimmt. Dieses Objekt wird in der
	 * update-Methode genutzt, um den aktuellen
	 * Zustand des Felds zu visualisieren
	 * @param av Referenz auf Visualisierungs-Objekt
	 */
	public InsertionSortRecursive(ArrayVisualizer av) {
		super(av);
	}
	
	private int i = 1; // Iterator für das Array
	
	/**
	 *  Methode, die ein uebergebenes Feld von <code>Integer</code>-
     *  Werten nach dem InsertionSort-Algorithmus sortiert.
	 *	Die aueßere Schleife wurde durch einen rekursiven Aufruf ersetzt.
	 *  @param a Zu sortierendes Feld.
	 */
	public void sort(Integer[] a) {
		
		if (i < a.length) {
			
			Integer gemerkt = a [i];
			int suchIndex = i-1;
			
			while ((suchIndex >= 0) && (gemerkt.compareTo(a[suchIndex]) < 1)) {
				a[suchIndex+1] = a[suchIndex];
				suchIndex--;
			}
			
			a[suchIndex+1] = gemerkt;
			i++;
			this.sort(a);
			
		}
	
	
	}
	
	public void run() {
		sort(av.data);
	}
	
}
