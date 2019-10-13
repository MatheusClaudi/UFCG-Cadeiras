package teste;

import adt.linkedList.set.SetLinkedListImpl;

public class main {

	public static void main(String[] args) {
		
		SetLinkedListImpl<Integer> ff = new SetLinkedListImpl<Integer>();
		ff.insert(2);

		ff.insert(2);
		ff.insert(2);
		ff.insert(2);
		ff.insert(5);
		ff.insert(2);
		ff.insert(2);

	    
		
		Integer[] array1 = ff.toArray();
		
		for(int i=0; i<array1.length; i++){
			System.out.println("posicao " + (i+1) + " = " +array1[i] );
		}
	}

}
