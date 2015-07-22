/**
 *  Aufsteigende Sortierung eines Feldes mit HeapSort.
 *  Blatt 12, Aufgabe 48, Sommersemester 2013
 *  @author Gruppe WI-25 (Daniel Grewe, Max Dietrich, Maksim Pachukevich)
 */
public class HeapSortAsc {
	
	private Integer[] a;
	private int n;
	
	/**
     *  Klasse fuer den Test der Implementierung.
     */
	public void run() {
		
		Integer[] a1 = new Integer[] {30, 1, 26, 39, 7, 18, 31, 4, 43, 3, 11, 14};
		sort(a1);
	}
	
	/**
     *  Sortiere ein Feld a mit dem HeapSort-Agorithmus.
     *  Die <code>sort</code>-Methode nimmt Daten entgegen und ruft die innere Methode auf.
     *  @param a Zu untersuchendes Feld
     */
	public void sort(Integer[] a) {
		this.a = a;
		this.n = a.length;
		heapsort();
		// Beginn Bildschirmausgabe
		System.out.println("Vollstaendig aufsteigend sortiertes Feld:");
		printArray(a);
		// Ende Bildschirmausgabe
	}
	
	/**
     *  Innere Methode zum sortieren eines Feldes mit dem HeapSort-Agorithmus.
     */
	private void heapsort() {
		buildheap();
		// Beginn Bildschirmausgabe
		System.out.println("Feld nach Heap-Aufbau-Phase:");
		printArray(a);
		System.out.println("Korrespondierender Heap:" + a[n-1]);
		System.out.println(); 
		// Ende Bildschirmausgabe
		while (n > 1) {
			// Heap-Elemente werden nicht gezielt geloescht, sondern durch
			// Dekrementierung von n ausgeblendet
			n--;
			swap(a, 0, n);
			// Beginn Bildschirmausgabe
			System.out.println("Feld nach 'delete'-Operation:");
			printArray(a);
			System.out.println("Korrespondierender Heap:" + a[n]);
			System.out.println(); 
			// Ende Bildschirmausgabe
			downheap(0);
		}
	}
	
	/**
     *  Innere Methode zum sortieren eines Feldes mit dem HeapSort-Agorithmus.
     */
	private void buildheap() {
		for (int x = n / 2 - 1; x >= 0; x--) {
			downheap(x);
		}
	}
	
	private void downheap(int x) {
		// erster Nachfolger von x
		int y = 2 * x + 1; 
		while (y < n) {
			if (y + 1 < n)
				if (a[y + 1] > a[y]) y++;
			if (a[x] >= a[y]) break;
			swap(a, x, y);
			x = y;
			y = 2 * x + 1;
		}
		
	}
	
	/**
     *  Vertausche in einem gegebenen Feld die Eintraege an
     *  den beiden gegebenen Stellen.
     *  @param a Eingabefeld
     *  @param indexA Index des ersten zu tauschenden Elements.
     *  @param indexB Index des zweiten zu tauschenden Elements.
     */
    public void swap(Integer[] a, int indexA, int indexB) {
        Integer temp  = a[indexA];
        a[indexA] = a[indexB];
        a[indexB] = temp;
    }
    
	/**
     *  Drucke den Inhalt eines gegebenen Felds auf den Bildschirm.
     *  @param a Auszugebendes Feld.
     */
	public void printArray(Integer[] a) {

        if (a != null) {
        	for (int i = 0; i < a.length; i++) {
        		System.out.print(a[i] + " ");
        	}
        	System.out.println(); 
        }
	}
	
	public static void main(String[] args) {
		HeapSortAsc test = new HeapSortAsc();
	    test.run();
	}
}
