/**
 *  Klasse zur Erzeugung verschiedener Eingabekonfiguration
 *  fuer Sortierverfahren.
 */
public class RandomArrayGenerator {

    private int defaultLaenge;

    /**
     *  Konstruktor. Initialisiert die Laenge des zu
     *  erzeugenden Felds mit 16.
     */
    RandomArrayGenerator() {
        this.defaultLaenge = 16;
    }

    /**
     *  Konstruktor, der die Laenge als Parameter entgegen nimmt.
     *  Das Feld muss mindestens 10 Eintraege haben.
     *  @param defaultLaenge Laenge des zu erzeugenden Felds.
     *  @throws IllegalArgumentException falls eine Laenge kleiner
     *          als 10 uebergeben wird.
     */
    RandomArrayGenerator(int defaultLaenge) {
	if (defaultLaenge < 10) {
	    throw new IllegalArgumentException("Laenge muss mindestens 10 sein.");
	}
        this.defaultLaenge = defaultLaenge;
    }

    /**
     *  Erzeuge unter Verwendung des Java-Zufallszahlengenerators
     *  ein Feld der Laenge <code>defaultLaenge</code> mit Eintraegen
     *  im Bereich <code>[0..defaultLaenge-1]</code>.
     *  @return Referenz auf das erzeugte Feld.
     */
    public Integer[] createArray() {
        Integer[] value = new Integer[defaultLaenge];

        for (int i = 0; i < value.length; i++) {
            value[i] = (int)(value.length*Math.random());
        }

        return value;
    }

    /**
     *  Erzeuge ein Feld der Laenge <code>defaultLaenge</code> 
     *  mit den Zahlen 0 bis <code>defaultLaenge-1</code> in 
     *  aufsteigender Reihenfolge.
     *  @return Referenz auf das erzeugte Feld.
     */
    public Integer[] createSortedArray() {
        Integer[] value = new Integer[defaultLaenge];

        for (int i = 0; i < value.length; i++) {
            value[i] = i;
        }

        return value;
    }

    /**
     *  Erzeuge ein Feld der Laenge <code>defaultLaenge</code> 
     *  mit den Zahlen 0 bis <code>defaultLaenge-1</code> in 
     *  absteigender Reihenfolge.
     *  @return Referenz auf das erzeugte Feld.
     */
    public Integer[] createInverseSortedArray() {
        Integer[] value = new Integer[defaultLaenge];

        for (int i = 0; i < value.length; i++) {
            value[i] = defaultLaenge - i;
        }

        return value;
    }

    /**
     *  Erzeuge ein Feld der Laenge <code>defaultLaenge</code> 
     *  mit den Zahlen 0 bis <code>defaultLaenge-1</code> in 
     *  zufaelliger Reihenfolge. Hierzu wird zunaechst ein
     *  sortiertes Feld erzeugt und anschliessend 5-mal zufaellig
     *  permutiert.
     *  @return Referenz auf das erzeugte Feld.
     */
    public Integer[] createPermutation() {
        Integer[] value = createSortedArray();

        for (int c = 0; c < 5; c++) {
            for (int i = 0; i<value.length; i++) {
                int j = (int)(Math.random()*value.length);
                int temp = value[i];
                value[i] = value[j];
                value[j] = temp;
            }
        }
        
        return value;
    }
}