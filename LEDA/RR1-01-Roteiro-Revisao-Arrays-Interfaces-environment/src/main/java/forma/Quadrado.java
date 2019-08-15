package forma;

public class Quadrado extends Retangulo {

	
	public Quadrado() {};
	
	public Quadrado(double lado) {
		
		super(lado, lado);
	}
	
	public void setLado(double lado) {
		
		super.setAltura(lado);
		super.setLargura(lado);
	}
	
}
