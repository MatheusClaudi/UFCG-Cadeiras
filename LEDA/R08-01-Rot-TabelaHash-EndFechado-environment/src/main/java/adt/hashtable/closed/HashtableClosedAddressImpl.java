package adt.hashtable.closed;

import java.util.LinkedList;

import adt.hashtable.hashfunction.HashFunction;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionDivisionMethod;
import adt.hashtable.hashfunction.HashFunctionFactory;

public class HashtableClosedAddressImpl<T> extends
		AbstractHashtableClosedAddress<T> {

	/**
	 * A hash table with closed address works with a hash function with closed
	 * address. Such a function can follow one of these methods: DIVISION or
	 * MULTIPLICATION. In the DIVISION method, it is useful to change the size
	 * of the table to an integer that is prime. This can be achieved by
	 * producing such a prime number that is bigger and close to the desired
	 * size.
	 * 
	 * For doing that, you have auxiliary methods: Util.isPrime and
	 * getPrimeAbove as documented bellow.
	 * 
	 * The length of the internal table must be the immediate prime number
	 * greater than the given size (or the given size, if it is already prime). 
	 * For example, if size=10 then the length must
	 * be 11. If size=20, the length must be 23. You must implement this idea in
	 * the auxiliary method getPrimeAbove(int size) and use it.
	 * 
	 * @param desiredSize
	 * @param method
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashtableClosedAddressImpl(int desiredSize,
			HashFunctionClosedAddressMethod method) {
		int realSize = desiredSize;

		if (method == HashFunctionClosedAddressMethod.DIVISION) {
			realSize = this.getPrimeAbove(desiredSize); // real size must the
														// the immediate prime
														// above
		}
		initiateInternalTable(realSize);
		HashFunction function = HashFunctionFactory.createHashFunction(method,
				realSize);
		this.hashFunction = function;
	}

	// AUXILIARY
	/**
	 * It returns the prime number that is closest (and greater) to the given
	 * number.
	 * If the given number is prime, it is returned. 
	 * You can use the method Util.isPrime to check if a number is
	 * prime.
	 */
	int getPrimeAbove(int number) {
		
		int n = number + 1;
		
		while(!util.Util.isPrime(n)) {
			
			n++;
		}
		
		return n;
	}

	@Override
	public void insert(T element) {
		
		int hash = ((HashFunctionDivisionMethod) this.hashFunction).hash(element);
		
		LinkedList<T> listaPos = ((LinkedList<T>) this.table[hash]);
		
		if (listaPos == null) {
			
			listaPos = new LinkedList<T>();
			listaPos.add(element);
			
			this.table[hash] = listaPos;
			this.elements++;
		}else {
			
			listaPos.add(element);
			this.table[hash] = listaPos;
			this.COLLISIONS++;
			this.elements++;
		}
	}

	@Override
	public void remove(T element) {
		
		int hash = ((HashFunctionDivisionMethod) this.hashFunction).hash(element);
		
		LinkedList<T> listaPos = ((LinkedList<T>) this.table[hash]);
		
		for (int i = 0; i < listaPos.size(); i++) {
			
			if (element.equals(listaPos.get(i))) {
				
				listaPos.remove(i);
				this.table[hash] = listaPos;
				break;
			}
		}
	}

	@Override
	public T search(T element) {
		
		int hash = ((HashFunctionDivisionMethod) this.hashFunction).hash(element);
		
		T retorno = null;
		
		LinkedList<T> listaPos = ((LinkedList<T>) this.table[hash]);
		
		for (int i = 0; i < listaPos.size(); i++) {
			
			if (element.equals(listaPos.get(i))) {
				
				retorno = listaPos.get(i);				
			}
		}
		
		return retorno;
	}

	@Override
	public int indexOf(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
