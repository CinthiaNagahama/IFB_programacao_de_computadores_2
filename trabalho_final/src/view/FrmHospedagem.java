package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.HospedagemController;
import model.Hospedagem;
import util.Util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FrmHospedagem extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodHospedagem;
	private JTextField txtCodChale;
	private JTextField txtEstado;
	private JTextField txtQuantidadePessoas;
	private JTextField txtDesconto;
	private JTextField txtValor;
	private JFormattedTextField txtDataInicio;
	private JFormattedTextField txtDataFim;
	private JTable tblConsulta;
	private JLabel lblMensagem;
	private MaskFormatter mascaraData = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHospedagem frame = new FrmHospedagem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void pesquisar() {
		List<Hospedagem> lista = new ArrayList<Hospedagem>();
		HospedagemController hc = new HospedagemController();
		lista = hc.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		
		int i;
		for(i = tbm.getRowCount() - 1; i >= 0; i--) tbm.removeRow(i);
		
		i = 0;
		for(Hospedagem h : lista) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(h.getCodHospedagem(), i, 0);
			tblConsulta.setValueAt(h.getCodChale(), i, 1);
			tblConsulta.setValueAt(h.getEstado(), i, 2);
			tblConsulta.setValueAt(Util.formatarDataDeLocalDateParaGui(h.getDataInicio()), i, 3);
			tblConsulta.setValueAt(Util.formatarDataDeLocalDateParaGui(h.getDataFim()), i, 4);
			tblConsulta.setValueAt(h.getQtdPessoas(), i, 5);
			tblConsulta.setValueAt(h.getDesconto(), i, 6);
			tblConsulta.setValueAt(h.getValorFinal(), i, 7);
			i++;
		}	
	}
	
	private void inserir() {
		Hospedagem h = new Hospedagem();
		HospedagemController hc = new HospedagemController();
		
		h.setCodHospedagem(Integer.parseInt(txtCodHospedagem.getText()));
		h.setCodChale(Integer.parseInt(txtCodChale.getText()));
		h.setEstado(txtEstado.getText());
		
		int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataInicio.getText());
		h.setDataInicio(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
		
		dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataFim.getText());
		h.setDataFim(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
		
		h.setQtdPessoas(Integer.parseInt(txtQuantidadePessoas.getText()));
		h.setDesconto(Double.parseDouble(txtDesconto.getText()));
		h.setValorFinal(Double.parseDouble(txtValor.getText()));
		
		/*
		Hospedagem query = hc.pesquisarPorCodigo(h.getCodHospedagem());
		if(query != null) {
			txtCodHospedagem.setText(Integer.toString(query.getCodHospedagem()));
			txtCodChale.setText(Integer.toString(query.getCodChale()));
			txtDataFim.setText(Util.formatarDataDeLocalDateParaGui(query.getDataFim()));
			txtDataInicio.setText(Util.formatarDataDeLocalDateParaGui(query.getDataInicio()));
			txtDesconto.setText(Double.toString(query.getDesconto()));
			txtEstado.setText(query.getEstado());
			txtQuantidadePessoas.setText(Integer.toString(query.getQtdPessoas()));
			txtValor.setText(Double.toString(query.getValorFinal() / (1 - query.getDesconto())));
			
			JOptionPane.showMessageDialog(null, "Já existe uma hospedagem com esse código.");
		}
		else 
		*/
		
		lblMensagem.setText(hc.inserir(h));
	}
	
	private void alterar() {
		Hospedagem h = new Hospedagem();
		HospedagemController hc = new HospedagemController();
		
		h.setCodHospedagem(Integer.parseInt(txtCodHospedagem.getText()));
		h.setCodChale(Integer.parseInt(txtCodChale.getText()));
		h.setEstado(txtEstado.getText());
		
		int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataInicio.getText());
		h.setDataInicio(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
		
		dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataFim.getText());
		h.setDataFim(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
		
		h.setQtdPessoas(Integer.parseInt(txtQuantidadePessoas.getText()));
		h.setDesconto(Double.parseDouble(txtDesconto.getText()));
		h.setValorFinal(Double.parseDouble(txtValor.getText()));
		
		lblMensagem.setText(hc.alterar(h));
	}
	
	private void excluir() {
		Hospedagem h = new Hospedagem();
		HospedagemController hc = new HospedagemController();
		
		h.setCodHospedagem(Integer.parseInt(txtCodHospedagem.getText()));
		Object[] opcoes = {"Sim", "Não"};
		int i = JOptionPane.showOptionDialog(
			null, 
			"Deseja excluir a hospedagem de código: " + txtCodHospedagem.getText() + "?",
			"Exclusão",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			opcoes, 
			opcoes[0]
		);
		
		if(JOptionPane.YES_OPTION == i) lblMensagem.setText(hc.excluir(h));
	}
	
	public void limpar() {
		txtCodHospedagem.setText("");
		txtCodChale.setText("");
		txtDataFim.setText("");
		txtDataInicio.setText("");
		txtDesconto.setText("");
		txtEstado.setText("");
		txtQuantidadePessoas.setText("");
		txtValor.setText("");
		
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for(int i = tbm.getRowCount() - 1; i >= 0; i--) tbm.removeRow(i);
	}

	/**
	 * Create the frame.
	 */
	public FrmHospedagem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel_sup = new JPanel();
		
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
				FrmHospedagem.this.dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel_mid = new GroupLayout(panel_mid);
		gl_panel_mid.setHorizontalGroup(
			gl_panel_mid.createParallelGroup(Alignment.LEADING)
				.addGap(0, 547, Short.MAX_VALUE)
				.addGroup(gl_panel_mid.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnInserir)
					.addGap(14)
					.addComponent(btnAlterar)
					.addGap(18)
					.addComponent(btnExcluir)
					.addGap(18)
					.addComponent(btnPesquisar)
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
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
						.addComponent(panel_sup, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 606, Short.MAX_VALUE)
						.addComponent(panel_bot, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
						.addComponent(panel_mid, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_sup, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_mid, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_bot, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_bot = new GroupLayout(panel_bot);
		gl_panel_bot.setHorizontalGroup(
			gl_panel_bot.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
		);
		gl_panel_bot.setVerticalGroup(
			gl_panel_bot.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
		);
		
		tblConsulta = new JTable();
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"cod_hospedagem", "cod_chale", "estado", "data_inicio", "data_fim", "quantidade_pessoas", "desconto", "valor_final"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Object.class, Object.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
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
		tblConsulta.getColumnModel().getColumn(7).setResizable(false);
		scrollPane.setViewportView(tblConsulta);
		panel_bot.setLayout(gl_panel_bot);
		
		JLabel lblCodHospedagem = new JLabel("C\u00F3digo da Hospedagem");
		lblCodHospedagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblCodChale = new JLabel("C\u00F3digo do Chal\u00E9");
		lblCodChale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblEstado = new JLabel("UF");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblQuantidadePessoas = new JLabel("Quantidade de Pessoas");
		lblQuantidadePessoas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDatanicio = new JLabel("Data de In\u00EDcio");
		lblDatanicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDataFim = new JLabel("Data de Fim");
		lblDataFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDesconto = new JLabel("Desconto em Porcentagem");
		lblDesconto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblMensagem = new JLabel("Mensagem");
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensagem.setForeground(Color.BLUE);
		
		txtCodHospedagem = new JTextField();
		txtCodHospedagem.setColumns(10);
		
		txtCodChale = new JTextField();
		txtCodChale.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		
		txtQuantidadePessoas = new JTextField();
		txtQuantidadePessoas.setColumns(10);
		
		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		
		try{
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		
		txtDataInicio = new JFormattedTextField(mascaraData);
		txtDataInicio.setText("  /  /    ");
		
		txtDataFim = new JFormattedTextField(mascaraData);
		txtDataFim.setText("  /  /    ");
		GroupLayout gl_panel_sup = new GroupLayout(panel_sup);
		gl_panel_sup.setHorizontalGroup(
			gl_panel_sup.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_sup.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_sup.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMensagem, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
						.addGroup(gl_panel_sup.createSequentialGroup()
							.addGroup(gl_panel_sup.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_sup.createSequentialGroup()
									.addComponent(lblCodHospedagem)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtCodHospedagem, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_sup.createSequentialGroup()
									.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_sup.createSequentialGroup()
									.addComponent(lblDatanicio, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_sup.createSequentialGroup()
									.addComponent(lblDesconto)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_panel_sup.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_sup.createSequentialGroup()
									.addComponent(lblDataFim, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDataFim, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_sup.createSequentialGroup()
									.addComponent(lblQuantidadePessoas, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtQuantidadePessoas, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
								.addGroup(gl_panel_sup.createSequentialGroup()
									.addComponent(lblCodChale, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtCodChale, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
								.addGroup(gl_panel_sup.createSequentialGroup()
									.addComponent(lblValor, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtValor, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		gl_panel_sup.setVerticalGroup(
			gl_panel_sup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_sup.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_sup.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodHospedagem)
						.addComponent(lblCodChale)
						.addComponent(txtCodHospedagem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_sup.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantidadePessoas, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtQuantidadePessoas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_sup.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDatanicio, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDataFim, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_sup.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDesconto, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValor, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMensagem, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_sup.setLayout(gl_panel_sup);
		contentPane.setLayout(gl_contentPane);
	}
}
