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

    
    public void run() {
	RandomArrayGenerator rg = new RandomArrayGenerator(200);
        av = new ArrayVisualizer(200,(byte)2);

	Integer[] data = rg.createPermutation();
	av.setData(data);
	setupFrame();

	/*
	BubbleSort bs = new BubbleSort(av);
	Thread t1 = new Thread(bs);
	t1.start();
	*/
	
	/*
	SelectionSort seso = new SelectionSort(av);
	Thread t2 = new Thread(seso);
	t2.start();
	*/
	
	/*
	InsertionSort is = new InsertionSort(av);
	Thread t3 = new Thread(is);
	t3.start();
	*/
	
	/*
	MergeSort ms = new MergeSort(av);
	Thread t4 = new Thread(ms);
	t4.start();
	*/
	
	/*
	QuickSort qs = new QuickSort(av);
	Thread t5 = new Thread(qs);
	t5.start();	
	*/
	
    }

    public static void main(String[] args) {
	TestVisualizer tv = new TestVisualizer();
        SwingUtilities.invokeLater(tv);
    }
}