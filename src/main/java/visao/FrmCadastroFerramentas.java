package visao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Ferramenta;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsável por fornecer uma interface gráfica para cadastro,
 * alteração e exclusão de ferramentas. 
 * Também exibe uma tabela com os dados das ferramentas cadastradas. Esta classe utiliza objetos da classe Ferramenta para manipulação dos dados.
 */
public class FrmCadastroFerramentas extends javax.swing.JFrame {

    /**
     * Objeto da classe Ferramenta para manipulação dos dados.
     */
    private Ferramenta objetoferramenta;
    /**
     * Conexão com o banco de dados.
     */
    private Connection conn;

    /**
     * Construtor da classe FrmCadastroFerramentas. Inicializa os componentes da
     * interface gráfica e o objeto da classe Ferramenta.
     */
    public FrmCadastroFerramentas() {
        initComponents();
        /**
         * Carrega objeto vazio de Ferramenta.
         */
        this.objetoferramenta = new Ferramenta();
        this.carregaTabela();
    }

    /**
     * Este método é chamado de dentro do construtor para inicializar o
     * formulário. AVISO: NÃO modifique este código. O conteúdo deste método é
     * sempre regenerado pelo Editor de Formulários.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JTFFerramenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTFMarca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTFCusto = new javax.swing.JTextField();
        b_cadastrar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableFerramentas = new javax.swing.JTable();
        b_alterar = new javax.swing.JButton();
        b_apagar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ferramentas");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel1.setText("Ferramenta:");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel2.setText("Marca:");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel3.setText("Preço");

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

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel4.setText("CADASTRO DE FERRAMENTAS");

        JTableFerramentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Ferramenta", "Marca", "Preço"
            }
        ));
        JTableFerramentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableFerramentasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTableFerramentas);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFFerramenta))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFCusto))
                    .addComponent(b_cadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_alterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_apagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(b_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(JTFFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(JTFCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(b_cadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_apagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_cancelar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(757, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     /**
     * Método responsável por cancelar a operação e fechar a janela.
     *
     * @param evt O evento de clique do botão.
     */
    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_b_cancelarActionPerformed
    /**
     * Método responsável por cadastrar uma nova ferramenta.
     *
     * @param evt - O evento de clique do botão.
     */
    private void b_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cadastrarActionPerformed
        try {

            /**
             * Recebendo e validando dados da interface gráfica.
             */
            String nome = "";
            String marca = "";
            double preco = 0.0;

            if (this.JTFFerramenta.getText().length() < 2) {
                throw new Mensagem("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.JTFFerramenta.getText();
            }

            if (this.JTFMarca.getText().length() < 2) {
                throw new Mensagem("Curso deve conter ao menos 2 caracteres.");
            } else {
                marca = this.JTFMarca.getText();
            }

            if (this.JTFCusto.getText().length() <= 0) {
                throw new Mensagem("Fase deve ser número e maior que zero.");
            } else {
                preco = Double.parseDouble(this.JTFCusto.getText());
            }

            /**
             * Envia os dados para o Controlador cadastrar.
             */
            if (this.objetoferramenta.insertFerramentaBD(nome, marca, preco)) {
                JOptionPane.showMessageDialog(null, "Ferramenta Cadastrada com Sucesso!");
                /**
                 * Limpa os campos da interface.
                 */
                this.JTFFerramenta.setText("");
                this.JTFMarca.setText("");
                this.JTFCusto.setText("");
            }
            /**
             * Exibie no console a ferramenta cadastrado.
             */
            System.out.println(this.objetoferramenta.getMinhaLista().toString());

        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
        }
        this.carregaTabela();
    }//GEN-LAST:event_b_cadastrarActionPerformed
    /**
     * Método responsável por atualizar os dados da tabela de ferramentas.
     */
    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) JTableFerramentas.getModel();
        /**
         * Limpa a tabela antes de atualizar.
         */
        model.setRowCount(0);

        String query = "SELECT nome, marca, preco FROM ferramentas";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String marca = resultSet.getString("marca");
                double preco = resultSet.getDouble("preco");
                Object[] rowData = {nome, marca, preco};
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método executado quando o botão de alterar é clicado. Realiza a validação
     * dos dados, atualiza a ferramenta no banco de dados e atualiza a tabela.
     *
     * @param evt - O evento de clique do botão.
     */
    private void b_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_alterarActionPerformed
        try {

            /**
             * Recebendo e validando dados da interface gráfica.
             */
            int id = 0;
            String nome = "";
            String marca = "";
            double preco = 0.0;

            if (this.JTFFerramenta.getText().length() < 2) {
                throw new Mensagem("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.JTFFerramenta.getText();
            }

            if (this.JTFMarca.getText().length() < 2) {
                throw new Mensagem("Marca deve conter ao menos 2 caracteres.");
            } else {
                marca = this.JTFMarca.getText();
            }

            if (this.JTFCusto.getText().length() <= 0) {
                throw new Mensagem("Custo deve ser um numero e maior que zero.");
            } else {
                preco = Double.parseDouble(this.JTFCusto.getText());
            }

            if (this.JTableFerramentas.getSelectedRow() == -1) {
                throw new Mensagem("Primeiro Selecione uma ferramenta para Alterar");
            } else {
                id = Integer.parseInt(this.JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(), 0).toString());
            }

            /**
             * Envia os dados para a ferramenta processar.
             */
            if (this.objetoferramenta.updateFerramentaBD(id, nome, marca, preco)) {
                /**
                 * limpa os campos.
                 */
                this.JTFFerramenta.setText("");
                this.JTFMarca.setText("");
                this.JTFCusto.setText("");
                JOptionPane.showMessageDialog(null, "Ferramenta alterada com Sucesso!");

            }
            /**
             * Exibe no console a ferramenta cadastrada.
             */
            System.out.println(this.objetoferramenta.getMinhaLista().toString());
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
    /**
     * Método acionado quando o botão "Apagar" é clicado, responsável por
     * excluir uma ferramenta.
     *
     * @param evt Evento de clique do botão.
     */
    private void b_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_apagarActionPerformed

        try {
            // validando dados da interface gráfica.
            /**
             * Verifica se uma ferramenta foi selecionada na tabela.
             */
            int id = 0;
            if (this.JTableFerramentas.getSelectedRow() == -1) {
                throw new Mensagem("Primeiro Selecione uma ferramenta para APAGAR");
            } else {
                id = Integer.parseInt(this.JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(), 0).toString());
            }

            /**
             * retorna 0 -> primeiro botão | 1 -> segundo botão | 2 -> terceiro
             * botão. Exibe uma caixa de diálogo para confirmar ao usuário a
             * exclusão da ferramenta.
             */
            int respostaUsuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar esta ferramenta?");

            if (respostaUsuario == 0) {
                /**
                 * Se o usuário clicar em "SIM". Envia os dados para a classe
                 * Ferramenta processar a exclusão. Chama o método
                 * deleteFerramentaBD da classe Ferramenta para excluir a
                 * ferramenta do banco de dados.
                 */

                if (this.objetoferramenta.deleteFerramentaBD(id)) {
                    /**
                     * Limpa os campode de texto na interface gráfica.
                     */
                    this.JTFFerramenta.setText("");
                    this.JTFMarca.setText("");
                    this.JTFCusto.setText("");
                    /**
                     * Exibe uma mensagem de sucesso na exclusão da ferramenta.
                     */
                    JOptionPane.showMessageDialog(rootPane, "Ferramenta apagada com sucesso!");
                }
            }

            /**
             * Chama o método carregaTabela() para atualizar a tabela após a
             * exclusão da ferramenta.
             */
            System.out.println(this.objetoferramenta.getMinhaLista().toString());
        } catch (Mensagem erro) {
            /**
             * Exibe uma caixa de diálogo com a mensagem de erro em caso de
             * exceção.
             */
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            /**
             * Chama o método carregaTabela() para atualizar a tabela mesmo em
             * caso de erro.
             */
            carregaTabela();
        }
    }//GEN-LAST:event_b_apagarActionPerformed
    /**
     * Método acionado quando ocorre um clique na tabela de ferramentas,
     * responsável por preencher os campos de texto com os dados da ferramenta
     * selecionada na tabela.
     *
     * @param evt Evento de clique do mouse na tabela.
     */
    private void JTableFerramentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableFerramentasMouseClicked

        if (this.JTableFerramentas.getSelectedRow() != -1) {
            /**
             * Obtém os dados da ferramenta selecionada na tabela.
             */
            String nome = this.JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(), 1).toString();
            String marca = this.JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(), 2).toString();
            String preco = this.JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(), 3).toString();
            /**
             * Preenche os campos de texto na interface gráfica com os dados da
             * ferramenta selecionada.
             */
            this.JTFFerramenta.setText(nome);
            this.JTFMarca.setText(marca);
            this.JTFCusto.setText(preco);
        }
    }//GEN-LAST:event_JTableFerramentasMouseClicked

    /**
     * Método responsável por carregar os dados da lista de ferramentas na
     * tabela.
     */
    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.JTableFerramentas.getModel();
        /**
         * Limpa a tabela antes de carregar os dados.
         */
        modelo.setNumRows(0);

        /**
         * Obtém a lista de ferramentas da classe Ferramenta.
         */
        ArrayList<Ferramenta> minhaLista = objetoferramenta.getMinhaLista();
        /**
         * Preenche a tabela na interface gráfica com os dados da lista de
         * ferramentas.
         */
        for (Ferramenta a : minhaLista) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getMarca(),
                a.getPreco(),});
        }
    }

    /**
     * Método principal que inicializa a aplicação.
     *
     * @param args Argumentos da linha de comando.
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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroFerramentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /**
         * Cria e exibe a interface gráfica.
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroFerramentas().setVisible(true);
            }
        });
    }
    /**
     * Declaração de variáveis - não modificar.
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTFCusto;
    private javax.swing.JTextField JTFFerramenta;
    private javax.swing.JTextField JTFMarca;
    private javax.swing.JTable JTableFerramentas;
    private javax.swing.JButton b_alterar;
    private javax.swing.JButton b_apagar;
    private javax.swing.JButton b_cadastrar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    /**
     * Fim da declaração de variáveis.
     */
}

