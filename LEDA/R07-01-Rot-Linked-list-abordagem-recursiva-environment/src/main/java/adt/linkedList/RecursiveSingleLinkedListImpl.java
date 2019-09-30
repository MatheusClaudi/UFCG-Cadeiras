package adt.linkedList;

import java.util.ArrayList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {
		
		

	}


	@Override
	public boolean isEmpty() {
			
		return (this.data == null && this.next == null);
	}

	@Override
	public int size() {
		
		if (this.isEmpty()) {
			
			return 0;
		}
		else {
			
			return 1 + this.next.size();
		}
	}

	@Override
	public T search(T element) {
		
		if (this.data.equals(element)) {
			
			return this.data;
		}
		
		if (!this.next.isEmpty()) {
			
			return this.next.search(element);
		}
		
		return null;
		
	}

	@Override
	public void insert(T element) {
		
		if (this.isEmpty()) {
			
			RecursiveSingleLinkedListImpl<T> newNil = new RecursiveSingleLinkedListImpl<T>(); 
			this.setData(element);
			this.setNext(newNil);
		}
		else {
			
			this.next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		
		if (!this.isEmpty()) {
			
			if (this.data.equals(element)) {
				
				this.data = this.next.getData();
				
				if (!this.next.isEmpty()){
					this.next = this.next.getNext();
				}
				else {
					this.next = null;
				}
			}
			else {
				
				next.remove(element);
			}
		}
	}
	
	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[this.size()];

		toArrayRecursive(result, this, 0);
		return result;
	}

	protected void toArrayRecursive(T[] array, RecursiveSingleLinkedListImpl<T> node, int cont) {
		if (!node.isEmpty()) {
			array[cont] = node.getData();
			toArrayRecursive(array, node.next, ++cont);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
