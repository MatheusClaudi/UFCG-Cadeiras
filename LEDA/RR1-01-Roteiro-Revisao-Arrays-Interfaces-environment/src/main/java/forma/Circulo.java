package forma;


public class Circulo implements Forma {

	private double raio;
	
	Quadrado a = new Quadrado();
	
	public Circulo() {}
	
	public Circulo(double raio) {

		super();
		this.raio = raio;
	}
	
	public void setRaio(double raio) {
		
		this.raio = raio;
	}
	
	@Override
	public double calculaArea() {
		
		double area = Math.PI * Math.pow(this.raio, this.raio);
		return area;
	}
	
}
