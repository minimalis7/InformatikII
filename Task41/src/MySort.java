/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 28.06.2013
  * @author 
  */

public class MySort {
  
  static int tausch=0;
  static int vgl=0;
  
  public static void main(String[] args) {
    int[] test = new int[]{1,4,2,3,4,1,2,2,2,2,1,4,2,2,3,1,2,3,4,2,1,3,2,1,2,2,1,1,1,1,1,2,2,3,2,1,2,1,2,3,1,2,3,4,2,1,2,3,2,2};
    sort(test);
    System.out.println(tausch+" "+vgl+" Länge: "+test.length);
    
    tausch=0;
    vgl=0;
    test = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,1,1,1,1,1,1,1};
    sort(test);
    System.out.println(tausch+" "+vgl+" Länge: "+test.length);
    
    
    tausch=0;
    vgl=0;
    test = new int[]{4,1,2,3,4,2,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
    sort(test);
    System.out.println(tausch+" "+vgl+" Länge: "+test.length);
    
    
    tausch=0;
    vgl=0;
    test = new int[]{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,3,2,1};
    sort(test);
    System.out.println(tausch+" "+vgl+" Länge: "+test.length);
  } // end of main
  
  public static void sort(int[] array)
  {
    int k=4;
    int maxElement=-1;
    int toFind=1;
    while (toFind<=k) { 
      boolean found =false;
      for (int i = maxElement+1; i<array.length; i++) {
        vgl++;
        if (array[i]==toFind) {
          swap(array, i, maxElement+1);
          maxElement++;
          found = true;
          break;
        } // end of if
      } // end of for
      if (!found) {
        toFind++;
      } // end of if
      while (maxElement+1<array.length && array[maxElement+1]==toFind) { 
        vgl++;
        maxElement++;
      } // end of while
      //  maxElement--;
      
    } // end of while
    
  }
  
  private static void swap(int[] array, int a, int b)
  {
    int m = array[a];
    array[a]=array[b];
    array[b]=m;
    tausch++;
  }
} // end of class MySort
