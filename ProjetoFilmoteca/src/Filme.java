

public class Filme {
	private String nome;
	private String sinopse;
	private String produtora;
	private String atorPrincipal;
	private String estilo;
	private String dirCapa;
	private Filme antTitulo;
	private Filme antAtorPrincipal;
	private Filme antEstilo;
	private Filme proxTitulo;
	private Filme proxAtorPrincipal;
	private Filme proxEstilo;
	

	public Filme() {
		this.antTitulo = null;
		this.antAtorPrincipal = null;
		this.antEstilo = null;
		this.proxTitulo = null;
		this.proxAtorPrincipal = null;
		this.proxEstilo = null;
	}

	public Filme(String nome, String sinopse, String produtora, String atorPrincipal, String estilo, String dirCapa) {
		super();
		this.nome = nome;
		this.sinopse = sinopse;
		this.produtora = produtora;
		this.atorPrincipal = atorPrincipal;
		this.estilo = estilo;
		this.dirCapa = dirCapa;
		this.antTitulo = null;
		this.antAtorPrincipal = null;
		this.antEstilo = null;
		this.proxTitulo = null;
		this.proxAtorPrincipal = null;
		this.proxEstilo = null;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the sinopse
	 */
	public String getSinopse() {
		return sinopse;
	}

	/**
	 * @param sinopse the sinopse to set
	 */
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	/**
	 * @return the produtora
	 */
	public String getProdutora() {
		return produtora;
	}

	/**
	 * @param produtora the produtora to set
	 */
	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}

	/**
	 * @return the atorPrincipal
	 */
	public String getAtorPrincipal() {
		return atorPrincipal;
	}

	/**
	 * @param atorPrincipal the atorPrincipal to set
	 */
	public void setAtorPrincipal(String atorPrincipal) {
		this.atorPrincipal = atorPrincipal;
	}

	/**
	 * @return the estilo
	 */
	public String getEstilo() {
		return estilo;
	}

	/**
	 * @param estilo the estilo to set
	 */
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	/**
	 * @return the noAnterior
	 */
	public Filme getNoAnterior() {
		return antTitulo;
	}

	/**
	 * @param noAnterior the noAnterior to set
	 */
	public void setNoAnterior(Filme noAnterior) {
		this.antTitulo = noAnterior;
	}

	/**
	 * @return the noProximo
	 */
	public Filme getNoProxTitulo() {
		return proxTitulo;
	}

	/**
	 * @param noProximo the noProximo to set
	 */
	public void setNoProxTitulo(Filme noProximo) {
		this.proxTitulo = noProximo;
	}

	/**
	 * @return the antTitulo
	 */
	public Filme getAntTitulo() {
		return antTitulo;
	}

	/**
	 * @param antTitulo the antTitulo to set
	 */
	public void setAntTitulo(Filme antTitulo) {
		this.antTitulo = antTitulo;
	}

	/**
	 * @return the antAtorPrincipal
	 */
	public Filme getAntAtorPrincipal() {
		return antAtorPrincipal;
	}

	/**
	 * @param antAtorPrincipal the antAtorPrincipal to set
	 */
	public void setAntAtorPrincipal(Filme antAtorPrincipal) {
		this.antAtorPrincipal = antAtorPrincipal;
	}

	/**
	 * @return the antProdutora
	 */
	public Filme getAntEstilo() {
		return antEstilo;
	}

	/**
	 * @param antProdutora the antProdutora to set
	 */
	public void setAntEstilo(Filme antProdutora) {
		this.antEstilo = antProdutora;
	}

	/**
	 * @return the proxTitulo
	 */
	public Filme getProxTitulo() {
		return proxTitulo;
	}

	/**
	 * @param proxTitulo the proxTitulo to set
	 */
	public void setProxTitulo(Filme proxTitulo) {
		this.proxTitulo = proxTitulo;
	}

	/**
	 * @return the proxAtorPrincipal
	 */
	public Filme getProxAtorPrincipal() {
		return proxAtorPrincipal;
	}

	/**
	 * @param proxAtorPrincipal the proxAtorPrincipal to set
	 */
	public void setProxAtorPrincipal(Filme proxAtorPrincipal) {
		this.proxAtorPrincipal = proxAtorPrincipal;
	}

	/**
	 * @return the proxProdutora
	 */
	public Filme getProxEstilo() {
		return proxEstilo;
	}

	/**
	 * @param proxProdutora the proxProdutora to set
	 */
	public void setProxEstilo(Filme proxProdutora) {
		this.proxEstilo = proxProdutora;
	}

	/**
	 * @return the dirCapa
	 */
	public String getDirCapa() {
		return dirCapa;
	}

	/**
	 * @param dirCapa the dirCapa to set
	 */
	public void setDirCapa(String dirCapa) {
		this.dirCapa = dirCapa;
	}

	@Override
	public String toString() {
		return "Filme [nome=" + nome + ", sinopse=" + sinopse + ", produtora=" + produtora + ", atorPrincipal="
				+ atorPrincipal + ", estilo=" + estilo + ", dirCapa=" + dirCapa + "]";
	}
}
