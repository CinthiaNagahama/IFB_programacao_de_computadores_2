package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import model.Cliente;
import util.Util;

public class FrmCliente extends JFrame {

	private JPanel contentPane;
	private JLabel lblMensagem;
	private JTextField txtCodCliente;
	private JTextField txtRgCliente;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JFormattedTextField txtCep;
	private JFormattedTextField txtNascimento;
	private JTable tblConsulta;
	private MaskFormatter mascara = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void pesquisar() {
		List<Cliente> lista = new ArrayList<Cliente>();
		ClienteController cc = new ClienteController();
		lista = cc.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		
		int i;
		for(i = tbm.getRowCount() - 1; i >= 0; i--) tbm.removeRow(i);
		
		i = 0;
		for(Cliente c : lista) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(c.getCodCliente(), i, 0);
			tblConsulta.setValueAt(c.getNomeCliente(), i, 1);
			tblConsulta.setValueAt(c.getRgCliente(), i, 2);
			tblConsulta.setValueAt(c.getEnderecoCliente(), i, 3);
			tblConsulta.setValueAt(c.getBairroCliente(), i, 4);
			tblConsulta.setValueAt(c.getCEPCliente(), i, 5);
			tblConsulta.setValueAt(Util.formatarDataDeLocalDateParaGui(c.getNascimentoCliente()), i, 6);
			i++;
		}
	}	

	private void inserir() {
		Cliente c = new Cliente();
		ClienteController cc = new ClienteController();
		
		c.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
		c.setNomeCliente(txtNome.getText());
		c.setRgCliente(txtRgCliente.getText());
		c.setEnderecoCliente(txtEndereco.getText());
		c.setBairroCliente(txtBairro.getText());
		c.setCEPCliente(txtCep.getText());
		
		int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtNascimento.getText());
		c.setNascimentoCliente(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
		
		lblMensagem.setText(cc.inserir(c));
	}
	
	private void alterar() {
		Cliente c = new Cliente();
		ClienteController cc = new ClienteController();
		
		c.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
		c.setNomeCliente(txtNome.getText());
		c.setRgCliente(txtRgCliente.getText());
		c.setEnderecoCliente(txtEndereco.getText());
		c.setBairroCliente(txtBairro.getText());
		c.setCEPCliente(txtCep.getText());
		
		int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtNascimento.getText());
		c.setNascimentoCliente(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
		
		lblMensagem.setText(cc.alterar(c));
	}
	
	private void excluir() {
		Cliente c = new Cliente();
		ClienteController cc = new ClienteController();
		
		c.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
		Object[] opcoes = {"Sim", "Não"};
		int i = JOptionPane.showOptionDialog(
			null, 
			"Deseja excluir o cliente de código: " + txtCodCliente.getText() + "?",
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
		txtCodCliente.setText("");
		txtNome.setText("");
		txtRgCliente.setText("");
		txtEndereco.setText("");
		txtBairro.setText("");
		txtCep.setText("");
		txtNascimento.setText("");
		
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for(int i = tbm.getRowCount() - 1; i >= 0; i--) tbm.removeRow(i);
	}

	
	/**
	 * Create the frame.
	 */
	public FrmCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel_top = new JPanel();
		
		JPanel panel_bot = new JPanel();
		
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
			public void mouseClicked(MouseEvent arg0) {
				FrmCliente.this.dispose();
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_top, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_bot, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_mid, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_top, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_mid, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(panel_bot, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
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
				"cod_cliente", "nome", "RG", "endereco", "bairro", "CEP", "data_nascimento"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
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
		tblConsulta.getColumnModel().getColumn(5).setResizable(false);
		tblConsulta.getColumnModel().getColumn(6).setResizable(false);
		scrollPane.setViewportView(tblConsulta);
		
		JLabel lblCodCliente = new JLabel("C\u00F3digo do Cliente");
		lblCodCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblRgCliente = new JLabel("RG do Cliente");
		lblRgCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNomeCliente = new JLabel("Nome do Cliente");
		lblNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNascimentoCliente = new JLabel("Data de Nascimento");
		lblNascimentoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblEnderecoCliente = new JLabel("Endereco do Cliente");
		lblEnderecoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtCodCliente = new JTextField();
		txtCodCliente.setColumns(10);
		
		txtRgCliente = new JTextField();
		txtRgCliente.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		try{
			mascara = new MaskFormatter("#####-###");
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		txtCep = new JFormattedTextField(mascara);
		txtCep.setText("     -   ");
		txtCep.setColumns(10);
		
		try{
			mascara = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		txtNascimento = new JFormattedTextField(mascara);
		txtNascimento.setText("  /  /    ");
		
		lblMensagem = new JLabel("Mensagem");
		lblMensagem.setForeground(Color.BLUE);
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel_top = new GroupLayout(panel_top);
		gl_panel_top.setHorizontalGroup(
			gl_panel_top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_top.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_top.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMensagem, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
						.addGroup(gl_panel_top.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_top.createSequentialGroup()
								.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
								.addGap(206)
								.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))
							.addGroup(gl_panel_top.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel_top.createSequentialGroup()
									.addComponent(lblEnderecoCliente)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtEndereco))
								.addGroup(Alignment.LEADING, gl_panel_top.createSequentialGroup()
									.addGroup(gl_panel_top.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCodCliente)
										.addComponent(lblNomeCliente, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel_top.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_top.createSequentialGroup()
											.addComponent(txtCodCliente, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblRgCliente, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtRgCliente, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblNascimentoCliente, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtNascimento, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap())
		);
		gl_panel_top.setVerticalGroup(
			gl_panel_top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_top.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_top.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodCliente)
						.addComponent(txtCodCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNascimentoCliente, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRgCliente, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtRgCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_top.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeCliente, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_top.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnderecoCliente, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_top.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addComponent(lblMensagem, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
		);
		panel_top.setLayout(gl_panel_top);
		contentPane.setLayout(gl_contentPane);
	}
}
