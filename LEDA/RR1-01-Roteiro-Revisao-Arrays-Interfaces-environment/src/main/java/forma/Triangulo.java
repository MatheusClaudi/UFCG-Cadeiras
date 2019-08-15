package forma;

public class Triangulo implements Forma {
	
	private double base;
	private double altura;
	
	public Triangulo(double base, double altura) {
		
		super();
		this.base = base;
		this.altura = altura;
	}
	
	public Triangulo() {}
	
	public void setBase(double base) {
		
		this.base = base;
	}
	
	public void setLAtura(double altura) {
		
		this.altura -= altura;
	}

	@Override
	public double calculaArea() {
		
		double area = (base * altura)/2;
		
		return area;
	}
	
	

}
