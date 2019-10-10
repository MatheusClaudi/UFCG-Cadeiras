package adt.linkedList.set;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SetLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SetLinkedList<T> { 
	
	@Override
	public void removeDuplicates() {
		
		SingleLinkedListNode<T> aux = this.head;
		
		while(!aux.isNIL()) {
			
			SingleLinkedListNode<T> aux2 = aux.getNext();
			
			
			while (!aux2.isNIL()) {
				
				if (aux.getData().equals(aux2.getData())) {
				
					this.remove(aux2.getData());
				} else {
					aux2 = aux2.getNext();
				}
			}
			
			aux = aux.getNext();
			
			
		}
	}

	@Override
	public SetLinkedList<T> union(SetLinkedList<T> otherSet) {
		//TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public SetLinkedList<T> intersection(SetLinkedList<T> otherSet) {
		//TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void concatenate(SetLinkedList<T> otherSet) {
		//TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
