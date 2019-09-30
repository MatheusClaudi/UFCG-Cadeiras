package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * This algorithm applies two bubblesorts simultaneously. In a same iteration, a
 * bubblesort pushes the greatest elements to the right and another bubblesort
 * pushes the smallest elements to the left. At the end of the first iteration,
 * the smallest element is in the first position (index 0) and the greatest
 * element is the last position (index N-1). The next iteration does the same
 * from index 1 to index N-2. And so on. The execution continues until the array
 * is completely ordered.
 */
public class SimultaneousBubblesort<T extends Comparable<T>> extends
		AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		boolean swi = true;	
		
		int f =leftIndex;
		int l = rightIndex;
		
		while(swi) {
			
			swi = false;
			
			for (int i = f; i < l; i++) {
				
				if (array[i].compareTo(array[i+1]) > 0){
					
					util.Util.swap(array, i, i++);
					swi = true;
				}
			}
			
			for (int i = l; i  > f; i--) {
				
				if (array[i-1].compareTo(array[i]) > 0) {
					
					util.Util.swap(array, i, i++);
					swi = true;
				}
			}
			
			f++;
			l--;
		}
		
	}
}
