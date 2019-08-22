package produto;

public class RepositorioProdutoArray implements RepositorioProduto {

	/**
	 * A estrutura (array) onde os produtos sao mantidos.
	 */
	private Produto[] produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	private int index = -1;
	
	public RepositorioProdutoArray(int size) {
		super();
		this.produtos = new Produto[size];
	}
	
	private int procurarIndice(int codigo) {
		int i = 0;
		int saida = -1;

		while (i <= index) {
			if (produtos[i].getCodigo() == codigo) {
				saida = i;
				break;
			}
			i++;
		}
		return saida;

	}
	
	@Override
	public boolean existe(int codigo) {
		
		boolean saida = true;
	
		int indice = this.procurarIndice(codigo);
		
		if (indice == -1) {
			saida = false;
		}

		return saida;
	}

	@Override
	public void inserir(Produto produto) {
		
		index++;
		
		this.produtos[index] = produto;	
	}

	@Override
	public void atualizar(Produto produto) {
		
		int indice = this.procurarIndice(produto.getCodigo());
		
		if (indice != -1) {
			produtos[indice] = produto;
		} 
		else {
			throw new RuntimeException("Produto nao cadastrado");
		}
	}

	@Override
	public void remover(int codigo) {
		
		int indice = this.procurarIndice(codigo);
		
		if (indice != -1) {
			
			produtos[indice] = produtos[index];
			produtos[index] = null;
			index--;
		} 
		else {
			throw new RuntimeException("Produto nao cadastrado");
		}
	}

	@Override
	public Produto procurar(int codigo) {
		
		Produto saida = null;
		
		int indice = this.procurarIndice(codigo);
		
		if (indice != -1) {
			saida = produtos[indice];
		} 
		else {
			throw new RuntimeException("Produto nao cadastrado");
		}

		return saida;
	}

}
