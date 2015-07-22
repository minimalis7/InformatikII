/**
 *  Finde den groessten Fixpunkt in einem aufsteigend sortierten Feld
 *  Blatt 10, Aufgabe 37b, Sommersemester 2013
 */
public class TestFixpointSearch {

    /**
     *  Ueberpruefe, ob fuer einen Eintrag <code>a[i]</code> im uebergebenen
     *  aufsteigend sortierten Feld gilt: <code>a[i]=i</code>. 
     *  @param a Zu ueberpruefendes Feld.
     *  @return groesster Index i mit <code>a[i]=i</code>, falls ein solcher Eintrag
     *          existiert, <code>a.length</code> sonst
     *  @throw IllegalArgumentException, falls null-Referenz uebergeben wird.
     */
    public int search(Integer[] a) {
	if (a==null) {
	    throw new IllegalArgumentException("Null-Referenz uebergeben.");
	}
	
	FixpointSearch fs;
	fs = new FixpointSearch();
	
	return fs.search(a);
    }
    
    public void run() {
	Integer[] a1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
	Integer[] a2 = {0, 1, 3, 4, 5, 6, 7, 8, 9};
	Integer[] a3 = {1, 2, 3, 4, 5, 7, 19, 20, 24};
	Integer[] a4 = {0, 2, 3, 4, 5, 7, 19, 20, 24};

	boolean passed = true;

	//  Jeder Eintrag in a1 ist ein Fixpunkt.
	System.out.println(search(a1));
	passed = passed && (search(a1) == a1.length-1);

	//  a2[0] = 0, a2[1] = 1
	System.out.println(search(a2));
	passed = passed && (search(a2) == 1);

	//  Kein Eintrag in a3 ist ein Fixpunkt.
	System.out.println(search(a3));
	passed = passed && (search(a3) == a3.length);
	
	//  a4[0] = 0
	System.out.println(search(a4));
	passed = passed && (search(a4) == 0);

	if (passed) {
	    System.out.println("Es wurden alle Tests bestanden.");
	}
	else {
	    System.out.println("Es wurden nicht alle Tests bestanden.");
	}

    }

    public static void main(String[] args) {
	TestFixpointSearch tfp = new TestFixpointSearch();
	tfp.run();
    }
}