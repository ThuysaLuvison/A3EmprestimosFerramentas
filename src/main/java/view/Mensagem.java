package view;
/**
 * Classe de exceção personalizada para mensagens específicas.
 * Permite a criação de exceções personalizadas com mensagens específicas.
 * Esta classe é utilizada para lançar mensagens de erro em situações específicas.
 */
public class Mensagem extends Exception {
/**
 * Construtor da classe Mensagem.
 * @param mensagem - A mensagem de erro a ser exibida.
 */
    public Mensagem(String mensagem){
        super(mensagem);
    }
}
