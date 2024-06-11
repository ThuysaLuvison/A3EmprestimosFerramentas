package principal;

import visao.FrmMenuPrincipal;

/**
 * Classe principal responsável por iniciar a aplicação. A classe Principal
 * contém o método main que é o ponto de entrada da aplicação.
 */
public class Principal {

    /**
     * Método main que inicia a aplicação. Cria uma instância da classe
     * FrmMenuPrincipal e a torna visível.
     *
     * @param args - Os argumentos da linha de comando (não utilizados neste
     * caso).
     */
    public static void main(String[] args) {

        FrmMenuPrincipal objetotela = new FrmMenuPrincipal();

        objetotela.setVisible(true);
    }
}
