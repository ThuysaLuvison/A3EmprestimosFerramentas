package modelo;

import dao.EmprestimoDAO;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Classe que representa um Empréstimo de Ferramenta.
 */
public class Emprestimo {

    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean entregue;
    private int id, idAmg;
    private EmprestimoDAO dao;

    /**
     * Construtor padrão da classe Emprestimo.
     */
    public Emprestimo() {
        this(null, null, false, 0, 0);
        this.dao = new EmprestimoDAO();
    }

    /**
     * Construtor sobrecarregado da classe Emprestimo.
     *
     * @param dataEmprestimo Data do empréstimo.
     * @param dataDevolucao Data prevista de devolução.
     * @param entregue Indica se o item emprestado foi devolvido.
     * @param id Identificador do empréstimo.
     * @param idAmg Identificador do amigo relacionado.
     */
    public Emprestimo(Date dataEmprestimo, Date dataDevolucao, boolean entregue, int id, int idAmg) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.entregue = entregue;
        this.id = id;
        this.idAmg = idAmg;
    }

    /**
     * Retorna a data do empréstimo.
     *
     * @return Data do empréstimo.
     */
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * Define a data do empréstimo.
     *
     * @param dataEmprestimo Data do empréstimo.
     */
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * Retorna a data de devolução.
     *
     * @return Data de devolução.
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * Define a data de devolução.
     *
     * @param dataDevolucao Data de devolução.
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * Verifica se o item foi devolvido.
     *
     * @return True se foi devolvido, false caso contrário.
     */
    public boolean isEntregue() {
        return entregue;
    }

    /**
     * Define se o item foi devolvido.
     *
     * @param entregue Status de devolução.
     */
    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    /**
     * Retorna o ID do empréstimo.
     *
     * @return ID do empréstimo.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do empréstimo.
     *
     * @param id ID do empréstimo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o ID do amigo relacionado.
     *
     * @return ID do amigo.
     */
    public int getIdAmg() {
        return idAmg;
    }

    /**
     * Define o ID do amigo relacionado.
     *
     * @param idAmg ID do amigo.
     */
    public void setIdAmg(int idAmg) {
        this.idAmg = idAmg;
    }

    /**
     * Método para obter a lista de empréstimos do banco de dados.
     *
     * @return Lista de empréstimos.
     */
    public ArrayList<Emprestimo> getListaEmprestimos() {
        return dao.getMinhaLista();
    }

    /**
     * Método para inserir um novo empréstimo no banco de dados.
     *
     * @param dataEmprestimo Data do empréstimo.
     * @param dataDevolucao Data de devolução.
     * @param entregue Status de devolução.
     * @param idAmg ID do amigo relacionado.
     * @return True se a inserção foi bem-sucedida, false caso contrário.
     */
    public boolean inserirEmprestimo(Date dataEmprestimo, Date dataDevolucao, boolean entregue, int idAmg) {
        id = dao.maiorId() + 1;
        Emprestimo objeto = new Emprestimo(dataEmprestimo, dataDevolucao, entregue, id, idAmg);
        dao.inserirEmprestimoBD(objeto);
        return true;
    }

    /**
     * Método para apagar um empréstimo do banco de dados.
     *
     * @param id ID do empréstimo a ser apagado.
     * @return True se a exclusão foi bem-sucedida, false caso contrário.
     */
    public boolean apagarEmprestimo(int id) {
        dao.apagarEmprestimoBD(id);
        return true;
    }

    /**
     * Método para alterar os dados de um empréstimo no banco de dados.
     *
     * @param dataDevolucao Nova data de devolução.
     * @param entregue Novo status de devolução.
     * @param id ID do empréstimo a ser alterado.
     * @return True se a alteração foi bem-sucedida, false caso contrário.
     */
    public boolean alterarEmprestimo(Date dataDevolucao, boolean entregue, int id) {
        Emprestimo objeto = new Emprestimo(dataEmprestimo, dataDevolucao, entregue, id, idAmg);
        dao.alterarEmprestimoBD(objeto);
        return true;
    }

    /**
     * Método para carregar os dados de um empréstimo do banco de dados.
     *
     * @param id ID do empréstimo a ser carregado.
     * @return Objeto Emprestimo correspondente.
     */
    public Emprestimo carregarEmprestimo(int id) {
        return dao.carregarEmprestimoBD(id);
    }
}
