package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		int result = 0;
		
		return result;
	}
	public long calcularFatorial(int n) {
		
		long result = 1;
		
		if (n != 0) {
			
			result = n * calcularFatorial(n-1);
		}
		
		return result;
	}

	public int calcularFibonacci(int n) {
		
		int result = 1;
		
		if (n != 1 && n != 2) {
			
			result = calcularFibonacci(n-1) + calcularFibonacci(n-2);
		}
		
		return result;
	}

	public int countNotNull(Object[] array, int n) {
		
		int result = 0;
		
		if (n != 0 && array[n] == null) {
			
			result += 1;
		}
		
		return result;
	}

	public long potenciaDe2(int expoente) {
		int result = 1;
		
		if (expoente != 0) {
			
			result *= (2 * potenciaDe2(expoente - 1));
		}
		
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		
		double result = 0;
		
		if (n != 0) {
			
			result += progressaoAritmetica(termoInicial, razao, n-1) + razao;
		}
		
		
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		
		if (n != 0) {
			
			result += progressaoAritmetica(termoInicial, razao, n-1) * razao;
		}
		
		
		return result;       
	}
	
	
}
