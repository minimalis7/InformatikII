/**
 *  Implementierung des BubbleSort-Algorithmus.
 *  Gruppe WI-25 (Daniel Grewe, Max Dietrich, Maksim Pachukevich)
 */
public class BubbleSort extends VisualizableSort {
	
	/**
	 *  Methode, die ein uebergebenes Feld von <code>Integer</code>-
     *  Werten nach dem BubbleSort-Algorithmus sortiert.
	 *  @param a Zu sortierendes Feld.
	 */
	public void sort(Integer[] a) {
		
		
		int n = a.length();
		while (n > 1) {
		    int newn = 1;
		    for (i = 0; i < n-1; ++i) {
		    	if (a[i] > a[i+1]) {
		    		int temp = a[i];
		    		a[i] = a[i+1];
		    		a[+1] = temp;
		    		newn = i+1;
		    		av.update();
		    	}
		    } 
		    n = newn;
		 } 
		
	}
	
}
