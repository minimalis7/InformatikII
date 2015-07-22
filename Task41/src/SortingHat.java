
public class SortingHat {
	
	void sort (int[] a, int n)
	{ 
	    int i, j, k, h, t;
	 
	    int[] spalten = {2147483647, 1131376761, 410151271, 157840433,
	    58548857, 21521774, 8810089, 3501671, 1355339, 543749, 213331,
	    84801, 27901, 11969, 4711, 1968, 815, 271, 111, 41, 13, 4, 1};
	 
	    for (k=0; k<23; k++)
	    { 
	        h=spalten[k];
	        // Sortiere die "Spalten" mit Insertionsort
	        for (i=h; i<n; i++)
	        { 
	            t=a[i];
	            j=i;
	            while (j>=h && a[j-h]>t)
	            { 
	                a[j]=a[j-h];
	                j=j-h;
	            }
	            a[j]=t;
	        }
	    }
	}
}
