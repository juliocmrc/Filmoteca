

public class AcoesFilmoteca {
	private Filme primeiroNoTitulo;
	private Filme ultimoNoTitulo;
	private Filme primeiroNoAtorPrincipal;
	private Filme ultimoNoAtorPrinicpal;
	private Filme primeiroNoEstilo;
	private Filme ultimoNoEstilo;

	public AcoesFilmoteca() {
		this.primeiroNoTitulo = null;
		this.ultimoNoTitulo = null;
		this.primeiroNoAtorPrincipal = null;
		this.ultimoNoAtorPrinicpal = null;
		this.primeiroNoEstilo = null;
		this.ultimoNoEstilo = null;
	}

	public boolean verificaSeEstaVazia() {
		return (this.primeiroNoTitulo == null && this.primeiroNoAtorPrincipal == null && this.primeiroNoEstilo == null);
	}

	private void insereFilmeTitulo(Filme novoFilme) {
		Filme aux, anterior;

		// Verifica se o elemento sera o unico na lista
		if (this.verificaSeEstaVazia()) {
			// Seta elemento como primeiro e ultimo da fila
			this.primeiroNoTitulo = this.ultimoNoTitulo = novoFilme;
			return;
		}

		// Verifica se o novo elemento sera o primeiro
		if (novoFilme.getNome().compareTo(this.primeiroNoTitulo.getNome()) < 0) {
			novoFilme.setNoProxTitulo(this.primeiroNoTitulo);
			this.primeiroNoTitulo.setNoAnterior(novoFilme);
			this.primeiroNoTitulo = novoFilme;
			return;
		}

		anterior = this.primeiroNoTitulo;

		for (aux = this.primeiroNoTitulo.getNoProxTitulo(); aux != null
				&& novoFilme.getNome().compareTo(aux.getNome()) > 0; aux = aux.getNoProxTitulo()) {
			anterior = aux;
		}

		// adiciona o novo elemento na posicao encontrada
		anterior.setNoProxTitulo(novoFilme);
		novoFilme.setNoAnterior(anterior);
		novoFilme.setNoProxTitulo(aux);

		// Verifica se o novo elemento sera o ultimo da lista
		if (novoFilme.getNoProxTitulo() == null) {
			this.ultimoNoTitulo = novoFilme;
		} else {
			aux.setNoAnterior(novoFilme);
		}
	}

	private void insereFilmeAtorPrincipal(Filme novoFilme) {
		Filme aux, anterior;

		// Verifica se o elemento sera o unico na lista
		if (this.verificaSeEstaVazia()) {
			// Seta elemento como primeiro e ultimo da fila
			this.primeiroNoAtorPrincipal = this.ultimoNoAtorPrinicpal = novoFilme;
			return;
		}

		// Verifica se o novo elemento sera o primeiro
		if (novoFilme.getAtorPrincipal().compareTo(this.primeiroNoAtorPrincipal.getAtorPrincipal()) < 0) {
			novoFilme.setProxAtorPrincipal(this.primeiroNoAtorPrincipal);
			this.primeiroNoAtorPrincipal.setAntAtorPrincipal(novoFilme);
			this.primeiroNoAtorPrincipal = novoFilme;
			return;
		}

		anterior = this.primeiroNoAtorPrincipal;
		for (aux = this.primeiroNoAtorPrincipal.getProxAtorPrincipal(); aux != null
				&& novoFilme.getAtorPrincipal().compareTo(aux.getAtorPrincipal()) > 0; aux = aux
						.getProxAtorPrincipal()) {
			anterior = aux;
		}

		// adiciona o novo elemento na posicao encontrada
		anterior.setProxAtorPrincipal(novoFilme);
		novoFilme.setAntAtorPrincipal(anterior);
		novoFilme.setProxAtorPrincipal(aux);

		// Verifica se o novo elemento sera o ultimo da lista
		if (novoFilme.getProxAtorPrincipal() == null) {
			this.ultimoNoAtorPrinicpal = novoFilme;
		} else {
			aux.setAntAtorPrincipal(novoFilme);
		}
	}

	private void insereFilmeEstilo(Filme novoFilme) {
		Filme aux, anterior;

		// Verifica se o elemento sera o unico na lista
		if (this.verificaSeEstaVazia()) {
			// Seta elemento como primeiro e ultimo da fila
			this.primeiroNoEstilo = this.ultimoNoEstilo = novoFilme;
			return;
		}

		// Verifica se o novo elemento sera o primeiro
		if (novoFilme.getEstilo().compareTo(this.primeiroNoTitulo.getEstilo()) < 0) {
			novoFilme.setProxEstilo(this.primeiroNoEstilo);
			this.primeiroNoEstilo.setAntEstilo(novoFilme);
			this.primeiroNoEstilo = novoFilme;
			return;
		}

		anterior = this.primeiroNoEstilo;
		for (aux = this.primeiroNoEstilo.getProxEstilo(); aux != null
				&& novoFilme.getEstilo().compareTo(aux.getEstilo()) > 0; aux = aux.getProxEstilo()) {
			anterior = aux;
		}

		// adiciona o novo elemento na posicao encontrada
		anterior.setProxEstilo(novoFilme);
		novoFilme.setAntEstilo(anterior);
		novoFilme.setProxEstilo(aux);

		// Verifica se o novo elemento sera o ultimo da lista
		if (novoFilme.getProxEstilo() == null) {
			this.ultimoNoEstilo = novoFilme;
		} else {
			aux.setAntEstilo(novoFilme);
		}
	}

	public void insereFilme(String titulo, String sinopse, String produtora, String atorPrincipal, String estilo,
			String img) {
		Filme filme = new Filme(titulo, sinopse, produtora, atorPrincipal, estilo, img);
		
		if (this.verificaSeEstaVazia()) {
			this.primeiroNoTitulo = this.ultimoNoTitulo = filme;
			this.primeiroNoAtorPrincipal = this.ultimoNoAtorPrinicpal = filme;
			this.primeiroNoEstilo = this.ultimoNoEstilo = filme;
			return;
		}
		
		this.insereFilmeTitulo(filme);
		this.insereFilmeAtorPrincipal(filme);
		this.insereFilmeEstilo(filme);
	}

	private boolean excluiFilmeTitulo(Filme filme) {
		Filme filmeAnterior = null;
		String tituloFilme = filme.getNome();

		// Busca o elemento que sera excluido.
		for (filme = this.primeiroNoTitulo; filme != null
				&& filme.getNome().compareTo(tituloFilme) != 0; filme = filme.getNoProxTitulo()) {
			filmeAnterior = filme;
		}

		// Verifica se algum filme foi encontrado
		if (filme == null) {
			// Caso não, a rotina finaliza
			return false;
		}

		if (filmeAnterior == null) {
			this.primeiroNoTitulo = filme.getNoProxTitulo();
			// Verifica se a lista ficou vazia
			if (this.primeiroNoTitulo == null) {
				// Se primeiro for nulo a lista ficou vazia e o ultimo deve ser ajutado
				this.ultimoNoTitulo = this.primeiroNoTitulo;
			} else {
				// Se primeiro nao ficou nulo, existe pelo meno um na lista ainda e o ponteiro
				// de anterior do primeiro aponta para null
				this.primeiroNoTitulo.setNoAnterior(null);
			}
			return true;
		}

		// Caso o elemento nao seja o primeiro
		filmeAnterior.setNoProxTitulo(filme.getNoProxTitulo());

		// Verifica seu o elemento encontrado sera o ultimo da lista
		if (filme.getNoProxTitulo() == null) {
			this.ultimoNoTitulo = filmeAnterior;
		} else {

			filme.getNoProxTitulo().setNoAnterior(filmeAnterior);
		}

		return true;
	}
	
	private boolean excluiFilmeAtorPrincipal(Filme filme) {
		Filme filmeAnterior = null;
		String ator = filme.getAtorPrincipal();

		for (filme = this.primeiroNoAtorPrincipal; filme != null && !filme.getAtorPrincipal().equals(ator); filme = filme.getProxAtorPrincipal()) {
			filmeAnterior = filme;
		}
		
		if (filme == null) {
			return false;
		} else {
			if (filmeAnterior == null) {
				this.primeiroNoAtorPrincipal = filme.getProxAtorPrincipal();
				
				if(this.primeiroNoAtorPrincipal == null) {
					this.ultimoNoAtorPrinicpal = this.primeiroNoAtorPrincipal;
				}else {
					this.primeiroNoAtorPrincipal.setAntAtorPrincipal(null);

				}
				return true;
			}
			
			filmeAnterior.setProxAtorPrincipal(filme.getProxAtorPrincipal());
			
			if(filme.getProxAtorPrincipal() == null) {
				this.ultimoNoAtorPrinicpal = filmeAnterior;
			}else {
				filme.getProxAtorPrincipal().setAntAtorPrincipal(filmeAnterior);
			}
			
			return true;
		}

	}
	
	private boolean excluiFilmeEstilo(Filme filme) {
		Filme filmeAnterior = null;
		String estiloFilme = filme.getEstilo();

		for (filme = this.primeiroNoEstilo; filme != null && !filme.getEstilo().equals(estiloFilme); filme = filme.getProxEstilo()) {
			filmeAnterior = filme;
		}
		if (filme == null) {
			return false;
		} else {
			if (filmeAnterior == null) {
				this.primeiroNoEstilo = filme.getProxEstilo();
				
				if(this.primeiroNoEstilo == null) {
					this.ultimoNoEstilo = this.primeiroNoEstilo;
				}else {
					this.primeiroNoEstilo.setAntEstilo(null);

				}
				return true;
			}
			
			filmeAnterior.setProxEstilo(filme.getProxEstilo());
			
			if(filme.getProxEstilo() == null) {
				this.ultimoNoEstilo = filmeAnterior;
			}else {
				filme.getProxEstilo().setAntEstilo(filmeAnterior);
			}
			
			return true;
		}

	}
	
	public boolean excluiFilme(String titulo) {
		Filme filme;
		
		for(filme = this.primeiroNoTitulo; filme != null && filme.getNome().compareTo(titulo) != 0; filme = filme.getProxTitulo());

		if(this.verificaSeEstaVazia()) {
			return false;
		}
		
		if(this.excluiFilmeTitulo(filme)) {
			return this.excluiFilmeAtorPrincipal(filme) &&
			this.excluiFilmeEstilo(filme);
			
		}else {
			return false;
		}

	}


	public Filme retornaPrimeiro() {
		if (this.verificaSeEstaVazia() == false) {
			return this.primeiroNoTitulo;
		}

		return null;
	}
}