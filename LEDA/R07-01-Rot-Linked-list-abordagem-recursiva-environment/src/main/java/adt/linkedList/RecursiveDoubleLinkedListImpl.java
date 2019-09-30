package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}
	
	@Override
	public void insert(T element) {
		
		if (this.isEmpty()) {
			
			RecursiveSingleLinkedListImpl<T> newNil = new RecursiveDoubleLinkedListImpl<T>(); 
			this.setData(element);
			this.setNext(newNil);
			if (previous == null) {
				RecursiveDoubleLinkedListImpl<T> previousNil = new RecursiveDoubleLinkedListImpl<T>();
				this.previous = previousNil;
			}
		}
		else {
			
			this.next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		
		if (!this.isEmpty()) {
			
			if (this.data.equals(element)) {
				
				if (getPrevious().isEmpty() && getNext().isEmpty()) {
					
					setData(null);
					setNext(null);
					setPrevious(null);
				}
				else {
				
					this.data = this.next.getData();
				
					if (!this.next.isEmpty()){
						this.next = this.next.getNext();
					}
					else {
						this.next = null;
					}
					
					if (getNext() != null) {
						((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious(this);
					}
				}
			}
			else {
				
				next.remove(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
