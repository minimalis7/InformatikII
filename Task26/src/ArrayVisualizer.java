import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * Klasse zur Visualisierung eines Integer-Felds mit Werten
 * im Bereich [0...length-1].
 */
public class ArrayVisualizer extends JPanel {
    
    private int size;        //  Breite und Hoehe der Zeichenflaeche
    private byte zoom;       //  Zoomfaktor
    private Integer[] data;  //  Referenz auf zu visualisierendes Feld

    /**
     *  Konstruktor, der die Breite (und damit auch Hoehe) der Zeichenflaeche
     *  sowie einen Zoomfaktor entgegen nimmt.
     *  @param size Breite der Zeichenflaeche
     *  @param zoom Zoomfaktor fuer die Zeichnung
     *  @throws IllegalArgumentExeption falls die Flaeche weniger als 10 Pixel gross ist.
     */
    public ArrayVisualizer(int size, byte zoom) {
	if (size < 10) {
	    throw new IllegalArgumentException("Groesse muss mindestens 10 betragen.");
	}
	this.size = size;
	this.zoom = zoom;
	data = new Integer[size];
	for(int i = 0; i < data.length; i++) {
	    data[i] = 0;
	}

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(size*zoom,size*zoom);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       

	//  Iteriere ueber das Feld und zeichne jeden Datenpunkt
	//  als Quadrat der Seitenlaenge zoom.
	for(int i = 0; i < data.length; i++) {
	    g.fillRect(i*zoom, (size-data[i])*zoom, zoom, zoom);
	}
    }  

    /**
     *  Speichert eine neue Referenz auf das zu visualisierende Feld.
     *  Es wird sicher gestellt, dass die Referenz nicht null ist,
     *  dass das Feld nicht laenger als die Dimension der Zeichenflaeche 
     *  ist und dass die Daten im Bereich [0..size-1] liegen.
     *  @param data Referenz auf das zu visualisierende Feld.
     *  @throws IllegalArgumentException falls eine der beschriebenen 
     *          Bedingungen nicht erfuellt ist.
     */
    public void setData(Integer[] data) {
	if (data != null) {
	    if (data.length > size) {
		throw new IllegalArgumentException("Uebergebenes Feld darf " +
						   "maximal " + size +
						   " Eintraege haben.");
	    }
	    for (int i = 0; i < data.length; i++) {
		if (data[i] < 0 || data[i] >= size) {
		    throw new IllegalArgumentException("Uebergebenes Feld darf " +
						       "nur Eintraege im Bereich " 
						       + "[0," + (size-1) +
						       "] haben.");
		}
	    }
	    this.data = data;
	}
    }
}