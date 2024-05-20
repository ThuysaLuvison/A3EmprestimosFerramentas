package visao;

import java.sql.Connection;
import java.util.ArrayList;
import modelo.Ferramenta;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Amigo;

/**
 * Classe para a interface gráfica de cadastro de amigos.
 *
 * Classe responsável por permitir o cadastro, alteração, exclusão e
 * visualização de amigos.
 *
 * @author joaopedrofariasdasilva
 */
public class FrmCadastroAmigos extends javax.swing.JFrame {

    /**
     * Objeto amigo para operações de cadastro.
     */
    private Amigo objetoamigo;

    /**
     * Conecção com o baco de dados.
     */
    private Connection conn;

    /**
     * Construtor da classe FrmCadastroAmigos.
     *
     * Inicializa os componentes da interface e carrega a tabela de amigos.
     */
    public FrmCadastroAmigos() {
        initComponents();
        /**
         * Carrega objeto vazio de ferramenta.
         */
        this.objetoamigo = new Amigo();
        /**
         * Carrega os dados da tabela.
         */
        this.carregaTabela();
    }

    /**
     * Método gerado automaticamente pelo Form Editor para inicializar os
     * componentes. AVISO: Não modifique este código. O conteúdo deste método é
     * sempre regenerado pelo Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        JTableAmigos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JTFNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTFTelefone = new javax.swing.JTextField();
        b_cadastrar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        b_alterar = new javax.swing.JButton();
        b_apagar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTableAmigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone"
            }
        ));
        JTableAmigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableAmigosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTableAmigos);

        jLabel1.setText("Nome:");

        jLabel2.setText("Telefone:");

        b_cadastrar.setText("Cadastrar");
        b_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cadastrarActionPerformed(evt);
            }
        });

        b_cancelar.setText("Cancelar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        b_alterar.setText("Alterar");
        b_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_alterarActionPerformed(evt);
            }
        });

        b_apagar.setText("Apagar");
        b_apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_apagarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel4.setText("CADASTRO DE AMIGOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFTelefone))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFNome))
                    .addComponent(b_cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(b_alterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_apagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(239, 239, 239))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(b_cadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_apagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_cancelar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_b_cancelarActionPerformed

    /**
     * Método para cadastrar um novo amigo.
     *
     * @param evt - Evento associado ao botão de cadastro.
     */
    private void b_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cadastrarActionPerformed

        try {
            /**
             * Recebendo e validando dados da interface gráfica.
             */
            String nome = "";
            String telefone = "";

            if (this.JTFNome.getText().length() < 2) {
                throw new Mensagem("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.JTFNome.getText();
            }

            if (this.JTFTelefone.getText().length() < 11) {
                throw new Mensagem("Telefone deve conter ao menos 11 caracteres.");
            } else {
                telefone = (this.JTFTelefone.getText());
            }

            System.out.println(nome);
            System.out.println(telefone);

            /**
             * Envia os dados para o controlador cadastrar.
             */
            if (this.objetoamigo.insertAmigoBD(nome, telefone)) {
                JOptionPane.showMessageDialog(null, "Amigo Cadastrada com Sucesso!");
                /**
                 * Limpa campos da interface.
                 */
                this.JTFNome.setText("");
                this.JTFTelefone.setText("");
            }
            /**
             * Exibe no console o ferramenta cadastrado.
             */
            System.out.println(this.objetoamigo.getMinhaLista().toString());

        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
        }
        this.carregaTabela();
    }//GEN-LAST:event_b_cadastrarActionPerformed

    private void b_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_alterarActionPerformed

        try {

            /**
             * Recebendo a validando dados da interface gráfica.
             */
            int id = 0;
            String nome = "";
            String telefone = "";

            if (this.JTFNome.getText().length() < 2) {
                throw new Mensagem("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.JTFNome.getText();
            }

            if (this.JTFTelefone.getText().length() < 2) {
                throw new Mensagem("Telefone deve conter ao menos 11 caracteres.");
            } else {
                telefone = (this.JTFTelefone.getText());
            }

            if (this.JTableAmigos.getSelectedRow() == -1) {
                throw new Mensagem("Primeiro Selecione uma amigo para Alterar");
            } else {
                id = Integer.parseInt(this.JTableAmigos.getValueAt(this.JTableAmigos.getSelectedRow(), 0).toString());
            }

            /**
             * Envia os dados para a ferramenta processar.
             */
            if (this.objetoamigo.updateAmigoBD(id, nome, telefone)) {

                /**
                 * Limpa os campos.
                 */
                this.JTFNome.setText("");
                this.JTFTelefone.setText("");
                JOptionPane.showMessageDialog(null, "Amigo alterada com Sucesso!");

            }
            /**
             * Exibe no console a ferramenta cadastrada.
             */
            System.out.println(this.objetoamigo.getMinhaLista().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
        } finally {
            /**
             * Atualiza a tabela.
             */
            carregaTabela();
        }
    }//GEN-LAST:event_b_alterarActionPerformed

    private void b_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_apagarActionPerformed

        try {
            /**
             * Validando dados da interface gráfica.
             */
            int id = 0;
            if (this.JTableAmigos.getSelectedRow() == -1) {
                throw new Mensagem("Primeiro Selecione uma amigo para APAGAR");
            } else {
                id = Integer.parseInt(this.JTableAmigos.getValueAt(this.JTableAmigos.getSelectedRow(), 0).toString());
            }

            /**
             * Retorna 0 -> primeiro botão | 1 -> segundo botão | 2 -> terceiro
             * botão.
             */
            int respostaUsuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar este amigo ?");

            if (respostaUsuario == 0) {

                /**
                 * Envia os dados para o Ferramneta processar.
                 */
                if (this.objetoamigo.deleteAmigoBD(id)) {
                    /**
                     * Limpa os campos
                     */
                    this.JTFNome.setText("");
                    this.JTFTelefone.setText("");
                    JOptionPane.showMessageDialog(rootPane, "Amigo apagada com sucesso!");
                }
            }
            /**
             * Atualiza a tabela.
             */

            System.out.println(this.objetoamigo.getMinhaLista().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            /**
             * Atualiza a tabela.
             */
            carregaTabela();
        }
    }//GEN-LAST:event_b_apagarActionPerformed

    private void JTableAmigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableAmigosMouseClicked

        if (this.JTableAmigos.getSelectedRow() != -1) {
            String nome = this.JTableAmigos.getValueAt(this.JTableAmigos.getSelectedRow(), 1).toString();
            String telefone = this.JTableAmigos.getValueAt(this.JTableAmigos.getSelectedRow(), 2).toString();

            this.JTFNome.setText(nome);
            this.JTFTelefone.setText(telefone);
        }
    }//GEN-LAST:event_JTableAmigosMouseClicked

    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.JTableAmigos.getModel();
        /**
         * Posiciona na primeira linha da tabela.
         */
        modelo.setNumRows(0);
        /**
         * Carrega a lista de objetos ferramenta.
         */
        ArrayList<Amigo> minhaLista = objetoamigo.getMinhaLista();
        for (Amigo a : minhaLista) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getTelefone()});
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(FrmCadastroAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroAmigos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTFNome;
    private javax.swing.JTextField JTFTelefone;
    private javax.swing.JTable JTableAmigos;
    private javax.swing.JButton b_alterar;
    private javax.swing.JButton b_apagar;
    private javax.swing.JButton b_cadastrar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
