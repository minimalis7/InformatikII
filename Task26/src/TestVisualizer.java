import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class TestVisualizer implements Runnable {

    private JFrame myFrame;
    private ArrayVisualizer av;
   
    private void setupFrame() {
        myFrame = new JFrame("Visualizer");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	myFrame.add(av);
	myFrame.pack();
	myFrame.setVisible(true);
    }

    @Override
    public void run() {
	RandomArrayGenerator rg = new RandomArrayGenerator(200);
        av = new ArrayVisualizer(200,(byte)2);

	Integer[] data = rg.createPermutation();
	av.setData(data);
	setupFrame();
	
	VisualizableSort bubble = new BubbleSort;
	bubble.sort()
	/*	
	   Hier Programmtext ergaenzen.
	*/

    }

    public static void main(String[] args) {
	TestVisualizer tv = new TestVisualizer();
        SwingUtilities.invokeLater(tv);
    }
}