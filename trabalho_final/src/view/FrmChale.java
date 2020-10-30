package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ChaleController;
import model.Chale;

public class FrmChale extends JFrame {

	private JPanel contentPane;
	private JLabel lblMensagem;
	private JTextField txtCodChale;
	private JTextField txtLocalizacao;
	private JTextField txtValorAltaEstacao;
	private JTextField txtValorBaixaEstacao;
	private JTextField txtCapacidade;
	private JTable tblConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChale frame = new FrmChale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void pesquisar() {
		List<Chale> lista = new ArrayList<Chale>();
		ChaleController cc = new ChaleController();
		lista = cc.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		
		int i;
		for(i = tbm.getRowCount() - 1; i >= 0; i--) tbm.removeRow(i);
		
		i = 0;
		for(Chale c : lista) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(c.getCodChale(), i, 0);
			tblConsulta.setValueAt(c.getCapacidade(), i, 1);
			tblConsulta.setValueAt(c.getLocalizacao(), i, 2);
			tblConsulta.setValueAt(c.getValorAltaEstacao(), i, 3);
			tblConsulta.setValueAt(c.getValorBaixaEstacao(), i, 4);
			i++;
		}	
	}
	
	private void inserir() {
		Chale c = new Chale();
		ChaleController cc = new ChaleController();
		
		c.setCodChale(Integer.parseInt(txtCodChale.getText()));
		c.setLocalizacao(txtLocalizacao.getText());
		c.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
		c.setValorAltaEstacao(Double.parseDouble(txtValorAltaEstacao.getText()));
		c.setValorBaixaEstacao(Double.parseDouble(txtValorBaixaEstacao.getText()));
		
		lblMensagem.setText(cc.inserir(c));
	}
	
	private void alterar() {
		Chale c = new Chale();
		ChaleController cc = new ChaleController();
		
		c.setCodChale(Integer.parseInt(txtCodChale.getText()));
		c.setLocalizacao(txtLocalizacao.getText());
		c.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
		c.setValorAltaEstacao(Double.parseDouble(txtValorAltaEstacao.getText()));
		c.setValorBaixaEstacao(Double.parseDouble(txtValorBaixaEstacao.getText()));
		
		lblMensagem.setText(cc.alterar(c));
	}
	
	private void excluir() {
		Chale c = new Chale();
		ChaleController cc = new ChaleController();
		
		c.setCodChale(Integer.parseInt(txtCodChale.getText()));
		Object[] opcoes = {"Sim", "Não"};
		int i = JOptionPane.showOptionDialog(
			null, 
			"Deseja excluir a hospedagem de código: " + txtCodChale.getText() + "?",
			"Exclusão",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			opcoes, 
			opcoes[0]
		);
		
		if(JOptionPane.YES_OPTION == i) lblMensagem.setText(cc.excluir(c));
	}
	
	public void limpar() {
		txtCodChale.setText("");
		txtCapacidade.setText("");
		txtLocalizacao.setText("");
		txtValorAltaEstacao.setText("");
		txtValorBaixaEstacao.setText("");
		
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for(int i = tbm.getRowCount() - 1; i >= 0; i--) tbm.removeRow(i);
	}
	
	/**
	 * Create the frame.
	 */
	public FrmChale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel_top = new JPanel();
		
		JPanel panel_mid = new JPanel();
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				inserir();
				pesquisar();
			}
		});
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alterar();
				pesquisar();
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				excluir();
				pesquisar();
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pesquisar();
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limpar();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmChale.this.dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel_mid = new GroupLayout(panel_mid);
		gl_panel_mid.setHorizontalGroup(
			gl_panel_mid.createParallelGroup(Alignment.LEADING)
				.addGap(0, 606, Short.MAX_VALUE)
				.addGroup(gl_panel_mid.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnInserir)
					.addGap(14)
					.addComponent(btnAlterar)
					.addGap(18)
					.addComponent(btnExcluir)
					.addGap(18)
					.addComponent(btnPesquisar)
					.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
					.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(13))
		);
		gl_panel_mid.setVerticalGroup(
			gl_panel_mid.createParallelGroup(Alignment.LEADING)
				.addGap(0, 29, Short.MAX_VALUE)
				.addGroup(gl_panel_mid.createSequentialGroup()
					.addGroup(gl_panel_mid.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnLimpar)
						.addComponent(btnInserir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnPesquisar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_mid.setLayout(gl_panel_mid);
		
		JPanel panel_bot = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_top, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
						.addComponent(panel_bot, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 607, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_mid, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 606, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_top, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_mid, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_bot, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_bot.setLayout(new BoxLayout(panel_bot, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_bot.add(scrollPane);
		
		tblConsulta = new JTable();
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"cod_chale", "capacidade", "localizacao", "valor_alta_estacao", "valor_baixa_estacao"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(1).setResizable(false);
		tblConsulta.getColumnModel().getColumn(2).setResizable(false);
		tblConsulta.getColumnModel().getColumn(3).setResizable(false);
		tblConsulta.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(tblConsulta);
		
		JLabel lblCodChale = new JLabel("C\u00F3digo do Chal\u00E9");
		lblCodChale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblLocalizao = new JLabel("Localiza\u00E7\u00E3o");
		lblLocalizao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblValorNaAlta = new JLabel("Valor na Alta Esta\u00E7\u00E3o");
		lblValorNaAlta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblValorNaBaixa = new JLabel("Valor na Baixa Esta\u00E7\u00E3o");
		lblValorNaBaixa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblMensagem = new JLabel("Mensagem");
		lblMensagem.setVerticalAlignment(SwingConstants.TOP);
		lblMensagem.setForeground(Color.BLUE);
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtCodChale = new JTextField();
		txtCodChale.setColumns(10);
		
		txtLocalizacao = new JTextField();
		txtLocalizacao.setColumns(10);
		
		txtValorAltaEstacao = new JTextField();
		txtValorAltaEstacao.setColumns(10);
		
		txtValorBaixaEstacao = new JTextField();
		txtValorBaixaEstacao.setColumns(10);
		
		JLabel lblCapacidade = new JLabel("Capacidade");
		lblCapacidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtCapacidade = new JTextField();
		txtCapacidade.setColumns(10);
		GroupLayout gl_panel_top = new GroupLayout(panel_top);
		gl_panel_top.setHorizontalGroup(
			gl_panel_top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_top.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_top.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMensagem, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
						.addGroup(gl_panel_top.createSequentialGroup()
							.addGroup(gl_panel_top.createParallelGroup(Alignment.LEADING)
								.addComponent(lblValorNaAlta)
								.addComponent(lblLocalizao, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodChale))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_top.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_top.createSequentialGroup()
									.addComponent(txtCodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(82)
									.addComponent(lblCapacidade, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addGap(43)
									.addComponent(txtCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtLocalizacao, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
								.addGroup(gl_panel_top.createSequentialGroup()
									.addComponent(txtValorAltaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(84)
									.addComponent(lblValorNaBaixa)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtValorBaixaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_panel_top.setVerticalGroup(
			gl_panel_top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_top.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_top.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodChale)
						.addComponent(lblCapacidade, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_top.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocalizao, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLocalizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_top.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorNaAlta, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValorNaBaixa, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtValorAltaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtValorBaixaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMensagem, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
		);
		panel_top.setLayout(gl_panel_top);
		contentPane.setLayout(gl_contentPane);
	}
}
