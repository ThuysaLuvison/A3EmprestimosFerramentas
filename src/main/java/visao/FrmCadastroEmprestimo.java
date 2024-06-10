package visao;

import com.google.protobuf.TextFormat;
import dao.AmigoDAO;
import dao.ConexaoDataBaseDAO;
import dao.EmprestimoDAO;
import dao.FerramentaDAO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Emprestimo;
import modelo.Ferramenta;
import modelo.Util;

public class FrmCadastroEmprestimo extends javax.swing.JFrame {

    /**
     * Declaração de variáveis de controle e instâncias de DAOs e objetos
     */
    private AmigoDAO daoAmg;
    private FerramentaDAO dao;
    private EmprestimoDAO daoEmp;
    private boolean countData = true;
    private Emprestimo objetoEmprestimo;
    private ConexaoDataBaseDAO db;
    public ArrayList<String> FerSelect;

    /**
     * Construtor da classe
     */
    public FrmCadastroEmprestimo() {
        initComponents();
        String data = Util.dataAtual().toString();
        JTFDataEmp.setText(data);
        db = new ConexaoDataBaseDAO();
        this.objetoEmprestimo = new Emprestimo();
        this.daoAmg = new AmigoDAO();
        this.dao = new FerramentaDAO();
        this.daoEmp = new EmprestimoDAO();
        this.FerSelect = new ArrayList<>();
        preencherComboBox();
        JValorTotal.setText("R$" + daoEmp.valorTotal());
        carregaTabelaFerramentas();
    }

    /**
     * Método para preencher o ComboBox com os nomes dos amigos.
     */
    private void preencherComboBox() {
        try {
            // Consulta SQL para obter os nomes dos amigos.
            String query = "SELECT nome FROM tb_amigos";
            PreparedStatement statement = db.getConexao().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Adiciona os nomes dos amigos no ComboBox.
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                JCBAmigo.addItem(nome);
            }

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
            // Lidar com exceções adequadamente.
        }
    }

    /**
     * Método para carregar a tabela de ferramentas disponíveis.
     */
    private void carregaTabelaFerramentas() {
        // Define o modelo da tabela e zera o número de linhas.
        DefaultTableModel modelo = (DefaultTableModel) this.jTable.getModel();
        modelo.setNumRows(0);
        // Adiciona as ferramentas disponíveis no modelo da tabela.
        for (Ferramenta a : dao.getFerramentasDisponiveis()) {
            modelo.addRow(new Object[]{
                a.getNome()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        JTFDataEmp = new javax.swing.JTextField();
        JCBAmigo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        JTFDataDev = new javax.swing.JTextField();
        JTFFerramenta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JTFAmigo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        JBCancelar = new javax.swing.JButton();
        JBCadastrar = new javax.swing.JButton();
        JBAdicionar = new javax.swing.JButton();
        JValorTotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Empréstimos");
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel2.setText("Data do Empréstimo:");

        JTFDataEmp.setEditable(false);
        JTFDataEmp.setBackground(new java.awt.Color(255, 255, 255));
        JTFDataEmp.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        JTFDataEmp.setBorder(null);

        JCBAmigo.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        JCBAmigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));
        JCBAmigo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JCBAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBAmigoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel3.setText("Data de Devolução:");

        JTFDataDev.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        JTFDataDev.setText("yyyy-MM-dd");
        JTFDataDev.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JTFDataDev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTFDataDevMouseClicked(evt);
            }
        });
        JTFDataDev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTFDataDevKeyPressed(evt);
            }
        });

        JTFFerramenta.setEditable(false);
        JTFFerramenta.setBackground(new java.awt.Color(255, 255, 255));
        JTFFerramenta.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        JTFFerramenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel1.setText("Amigo:");

        JTFAmigo.setEditable(false);
        JTFAmigo.setBackground(new java.awt.Color(255, 255, 255));
        JTFAmigo.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        JTFAmigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Ferramentas"
            }
        ));
        jTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable);

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel4.setText("CADASTRO DE EMPRÉSTIMOS");

        JBCancelar.setText("Fechar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });

        JBAdicionar.setText("Adicionar Ferramenta");
        JBAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAdicionarActionPerformed(evt);
            }
        });

        JValorTotal.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        JValorTotal.setText("0.0");

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel6.setText("Valor total das ferramentas:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCBAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JTFAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JTFDataDev, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTFDataEmp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JTFFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(JBAdicionar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(263, 263, 263))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(JBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(246, 246, 246))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCBAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTFFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(JTFDataEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(JTFDataDev, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JBCadastrar)
                            .addComponent(JBCancelar))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JValorTotal)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        setSize(new java.awt.Dimension(756, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JCBAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBAmigoActionPerformed
        /**
         * Obtém o nome do amigo selecionado no ComboBox e o define no campo de
         * texto correspondente.
         */
        String nomeSelecionado = (String) JCBAmigo.getSelectedItem();
        JTFAmigo.setText(nomeSelecionado);
    }//GEN-LAST:event_JCBAmigoActionPerformed

    private void JTFDataDevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTFDataDevMouseClicked
        /**
         * Verifica se a variável countData é verdadeira. Se for, limpa o campo
         * de data de devolução e define countData como falso.
         */
        if (countData == true) {
            JTFDataDev.setText("");
            countData = false;
        }
    }//GEN-LAST:event_JTFDataDevMouseClicked

    private void JTFDataDevKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFDataDevKeyPressed
        if (countData == true) {
            JTFDataDev.setText("");
            countData = false;
        }
    }//GEN-LAST:event_JTFDataDevKeyPressed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        /**
         * Verifica se há uma linha selecionada na tabela. Se houver, obtém o
         * nome da ferramenta da célula selecionada e define o texto do campo
         * JTFFerramenta com esse nome.
         */
        if (this.jTable.getSelectedRow() != -1) {
            String nome = this.jTable.getValueAt(this.jTable.getSelectedRow(), 0).toString();
            this.JTFFerramenta.setText(nome);
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTableAncestorAdded

    }//GEN-LAST:event_jTableAncestorAdded

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        // Fecha a janela atual
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed
        /**
         * Tenta realizar o cadastro do empréstimo com base nos dados fornecidos
         * pelo usuário.
         *
         * @throws Mensagem Se ocorrer algum erro durante o cadastro do
         * empréstimo.
         */
        try {
            // Expressão regular para validar o formato da data
            String regex = "\\d{4}-\\d{2}-\\d{2}";
            int idAmg = 0;
            Date dataEmprestimo = Util.dataAtual();
            boolean entregue = false;
            Date dataDevolucao = null;

            // Verifica se foi selecionado um amigo
            if ("".equals(this.JTFAmigo.getText())) {
                throw new Mensagem("Primeiro selecione um Amigo.");
            } else {
                // Obtém o ID do amigo selecionado
                idAmg = AmigoDAO.getIdPeloNome(JTFAmigo.getText());
                // Verifica se o amigo possui empréstimos pendentes
                boolean Ver = daoAmg.verificarPendencia(idAmg);
                if (Ver == true) {
                    // Exibe um diálogo de confirmação se o amigo tem empréstimos pendentes
                    int respostaUsuario = JOptionPane.showConfirmDialog(null, "Esse amigo tem empréstimos pendentes. Deseja continuar?");

                    if (respostaUsuario != 0) {
                        return;
                    }
                }
            }

            // Verifica se foi selecionada pelo menos uma ferramenta
            if (FerSelect.size() == 0) {
                throw new Mensagem("Primeiro selecione pelo menos uma Ferramenta");
            }

            // Verifica se a data de devolução foi inserida no formato correto
            if (this.JTFDataDev.getText().matches(regex)) {
                dataDevolucao = Util.stringParaDateSQL(JTFDataDev.getText());
                if (dataDevolucao.before(dataEmprestimo)) {
                    dataDevolucao = null;
                    throw new Mensagem("Data de Devolução não pode ser antes da Data do Empréstimo");

                } else if (dataDevolucao.after(dataEmprestimo)) {
                    dataDevolucao = Util.stringParaDateSQL(JTFDataDev.getText());
                } else {
                    dataDevolucao = null;
                    throw new Mensagem("Data de Devolução não pode ser igual a da Data do Empréstimo");
                }
            } else {
                throw new Mensagem("Data de Devolução deve conter o seguinte formato:\nyyyy-MM-dd");
            }

            // Insere o empréstimo no banco de dados
            if (this.objetoEmprestimo.inserirEmprestimo(dataEmprestimo, dataDevolucao, entregue, idAmg)) {
                JOptionPane.showMessageDialog(rootPane, "Empréstimo Cadastrado com Sucesso!");
                this.JTFAmigo.setText("");
                this.JTFFerramenta.setText("");
                this.JTFDataDev.setText("");
            }
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (TextFormat.ParseException ex) {
            Logger.getLogger(FrmCadastroEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(FrmCadastroEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            carregaTabelaFerramentas();
        }

        /**
         * Verifica se há uma linha selecionada na tabela. Se houver, obtém o
         * nome da ferramenta da célula selecionada e define o texto do campo
         * JTFFerramenta com esse nome.
         */
    }//GEN-LAST:event_JBCadastrarActionPerformed

    private void JBAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAdicionarActionPerformed
        /**
         * Verifica se há uma linha selecionada na tabela. Se não houver, exibe
         * uma mensagem de erro. Se houver uma linha selecionada, obtém o ID da
         * ferramenta dessa linha e verifica se esse ID já está na lista de
         * ferramentas selecionadas. Se não estiver, adiciona o ID à lista e
         * exibe uma mensagem de sucesso. Caso contrário, exibe uma mensagem
         * informando que a ferramenta já foi adicionada anteriormente.
         */
        if (this.jTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Primeiro Selecione uma Ferramenta");
        } else {
            if (this.jTable.getSelectedRow() != -1) {
                String id = this.jTable.getValueAt(this.jTable.getSelectedRow(), 0).toString();
                if (!FerSelect.contains(id)) {
                    FerSelect.add(id);
                    System.out.println("Selecionados: " + FerSelect);
                    JOptionPane.showMessageDialog(null, "Ferramenta adicionada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Essa Ferramenta já foi adicionada!");
                }
            }
        }
    }//GEN-LAST:event_JBAdicionarActionPerformed
    /**
     * Método principal que inicializa a interface gráfica do formulário de
     * cadastro de empréstimos. É chamado pelo método main da aplicação para
     * iniciar a execução da interface.
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroEmprestimo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAdicionar;
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JComboBox<String> JCBAmigo;
    private javax.swing.JTextField JTFAmigo;
    private javax.swing.JTextField JTFDataDev;
    private javax.swing.JTextField JTFDataEmp;
    private javax.swing.JTextField JTFFerramenta;
    private javax.swing.JLabel JValorTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
