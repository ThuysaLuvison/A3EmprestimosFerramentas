package visao;

/**
 * Classe responsável por exibir a interface de relatórios da aplicação. Permite
 * ao usuário visualizar diferentes tipos de relatórios. A interface é composta
 * por opções para visualização de relatórios específicos e um botão para
 * cancelar e fechar a janela.
 *
 * @author Thuysa
 */
public class FrmRelatorio extends javax.swing.JFrame {

    /**
     * Construtor padrão da classe FrmRelatorio. Inicializa os componentes da
     * interface gráfica.
     */
    public FrmRelatorio() {
        initComponents();
    }

    /**
     * Este método é chamado a partir do construtor para inicializar o
     * formulário. AVISO: Não modifique este código. O conteúdo deste método é
     * sempre regenerado pelo editor de formulários.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatorio");
        setResizable(false);

        b_cancelar.setText("Cancelar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(b_cancelar)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(b_cancelar)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
     * Método que fecha a janela de relatórios ao clicar no botão "Cancelar".
     *
     * @param evt - O evento de clique do botão "Cancelar".
     */
    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_b_cancelarActionPerformed

    /**
     * Método principal que cria e exibe a janela de relatórios.
     *
     * @param args - Argumentos da linha de comando.
     */
    public static void main(String args[]) {

        /**
         * Defina a aparência do Nimbus.
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /**
         * Cria e exibe o formulário.
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRelatorio().setVisible(true);
            }
        });
    }
    /**
     * Declaração de variáveis - não modificar.
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancelar;
    // End of variables declaration//GEN-END:variables
/**
     * Fim de declaração de variáveis.
     */
}
