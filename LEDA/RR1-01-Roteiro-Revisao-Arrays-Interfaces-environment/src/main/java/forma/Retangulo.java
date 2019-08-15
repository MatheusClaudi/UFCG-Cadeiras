package forma;

public class Retangulo implements Forma {
	
	public double altura;
	public double largura;
	
	public Retangulo() {}
	
	public Retangulo(double altura, double largura) {
		
		super();
		this.altura = altura;
		this.largura = largura;
	}
	
	public void setAltura(double altura) {
		
		this.altura = altura;
	}
	
	public void setLargura(double largura) {
		
		this.largura = largura;
	}
	
	@Override
	public double calculaArea() {
		
		double area = this.altura * this.largura;
		
		return area;
	}
	
	
}
