package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

/**
 *  Classe que representa um amigo com ID, nome e telefone.
 * 
 *  Fornece métodos para manipulação de objetos amigo e operações no banco de dados.
 * 
 * @author joaopedrofariasdasilva
 */
public class Amigo {

    /**
     * Atributos.
     */
    private int id;
    private String nome;
    private String telefone;
    AmigoDAO dao;

    /**
     * Construtor de objeto vazio.
     */
    public Amigo() {
        this(0, "", "");
    }

    /**
     * Construtor com parâmetro.
     * @param id - Atribui o valor do parâmetro id.
     * @param nome - Atribui o valor do parâmetro nome.
     * @param telefone - Atribui o valor do parâmetro telefone.
     */
    public Amigo(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        dao = new AmigoDAO();
    }

    /**
     * Métodos get e set.
     * @return - Retorna o valor do atributo id.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador (ID) deste objeto com o valor especificado.
     * @param id - O novo identificador (ID) a ser atribuído ao objeto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o valor do atributo nome.
     * @return - O valor do atributo nome.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome associoado a este objeto.
     * @param Nome - Novo nome a ser associado ao objeto.
     */
    public void setNome(String Nome) {
        this.nome = nome;
    }

    /**
     * Retorna o telefone associado a este objeto.
     * @return - Telefone associado a este objeto.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone associado a este objeto.
     * @param Telefone - O telefone a ser atribuído ao objeto
     */
    public void setTelefone(String Telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return super.toString() + "nome=" + nome + ", Telfone=" + telefone;
    }

    /**
     * Retorna a lista de amigos asociados a este objeto.
     * @return - Lista de amigos associados a este objeto.
     */
    public ArrayList<Amigo> getMinhaLista() {
        return dao.getMinhaLista();
    }
 
    /**
     * Insere um novo amigo no banco de dados com nome e telefone especificados.
     * @param nome - Nome do novo amigo a ser inserido no banco de dados.
     * @param telefone - Telefone do novo amigo a ser inserido no banco de dados.
     * @return - True se for bem-sudedida e operação, false caso o contrário.
     */
    public boolean insertAmigoBD(String nome, String telefone) {
        int id = this.maiorID() + 1;
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.insertAmigoBD(objeto);
        return true;
        
    }

    /**
     * Exclui o amigo do banco de dados com o ID especificado.
     * @param id - Id do amigo a ser excluído do banco de dados.
     * @return - True se a operação for bem-sucedida, false caso contrário.
     */
    public boolean deleteAmigoBD(int id) {
        dao.deleteAmigoBD(id);
        return true;
    }

    /**
     *  Atualiza as informações do amigo no banco de dados com o ID, nome e telefone especificados.
     * @param id - ID do amigo a ser atualizado no banco de dados.
     * @param nome - Nome do amigo a ser atualizado no banco de dados.
     * @param telefone - Telefone do amigo a ser atualizado no banco de dados.
     * @return - True se a operação for bem-sucedida, false caso contrário.
     */
    public boolean updateAmigoBD(int id, String nome, String telefone) {
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.updateAmigoBD(objeto);
        return true;
    }

    /**
     * Carrega as informações do amigo com o ID especificado do banco de dados.
     * @param id - ID do amigo a ser carregado do banco de dados.
     * @return - Amigo com o ID especificado, ou null se não for encontrado.
     */
    public Amigo carregaAmigo(int id) {
        return dao.carregaAmigo(id);
    }

    /**
     * Retorna o maior ID presente no banco de dados.
     * @return - O maior ID presente no banco de dados.
     */
    public int maiorID() {
        return dao.maiorID();
    }
}
