package modelo;

import dao.RelatorioDAO;
import java.util.ArrayList;

/**
 * Classe que representa um Relatório de Empréstimos.
 */
public class Relatorio {

    private String amigoNome;
    private String ferramentaNome;
    private String telefone;
    private Double preco;

    private RelatorioDAO dao;

    /**
     * Construtor sobrecarregado da classe Relatorio.
     *
     * @param amigoNome - Nome do amigo.
     * @param ferramentaNome - Nome da ferramenta.
     * @param telefone - Telefone do amigo.
     * @param preco - Preço da ferramenta.
     */
    public Relatorio(String amigoNome, String ferramentaNome, String telefone, Double preco) {
        this.amigoNome = amigoNome;
        this.ferramentaNome = ferramentaNome;
        this.telefone = telefone;
        this.preco = preco;
        this.dao = new RelatorioDAO();
    }

    /**
     * Construtor padrão da classe Relatorio.
     */
    public Relatorio() {
        this("", "", "", 0.0);
    }

    /**
     * Retorna o nome do amigo.
     *
     * @return - Nome do amigo.
     */
    public String getAmigoNome() {
        return amigoNome;
    }

    /**
     * Define o nome do amigo.
     *
     * @param amigoNome - Nome do amigo.
     */
    public void setAmigoNome(String amigoNome) {
        this.amigoNome = amigoNome;
    }

    /**
     * Retorna o nome da ferramenta.
     *
     * @return - Nome da ferramenta.
     */
    public String getFerramentaNome() {
        return ferramentaNome;
    }

    /**
     * Define o nome da ferramenta.
     *
     * @param ferramentaNome - Nome da ferramenta.
     */
    public void setFerramentaNome(String ferramentaNome) {
        this.ferramentaNome = ferramentaNome;
    }

    /**
     * Retorna o telefone do amigo.
     *
     * @return - Telefone do amigo.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do amigo.
     *
     * @param telefone - Telefone do amigo.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna o preço da ferramenta.
     *
     * @return - Preço da ferramenta.
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * Define o preço da ferramenta.
     *
     * @param preco - Preço da ferramenta.
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * Retorna a lista de relatórios com os totais.
     *
     * @return - Lista de relatórios com os totais.
     */
    public ArrayList<Relatorio> getTotais() {
        return dao.getTotais();
    }

    /**
     * Retorna a lista de relatórios com os empréstimos ativos.
     *
     * @return - Lista de relatórios com os empréstimos ativos.
     */
    public ArrayList<Relatorio> getAtivos() {
        return dao.getAtivos();
    }

    /**
     * Retorna a lista de relatórios com os empréstimos atrasados.
     *
     * @return - Lista de relatórios com os empréstimos atrasados.
     */
    public ArrayList<Relatorio> getAtrasados() {
        return dao.getAtrasados();
    }
}
