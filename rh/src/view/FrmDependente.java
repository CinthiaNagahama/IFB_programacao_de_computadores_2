package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.DependenteController;
import controller.EmpregadoController;
import model.Dependente;
import model.Empregado;
import util.Util;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmDependente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTable tblConsulta;
	private JComboBox<String> cbxEmpregado;
	private JLabel lblMensagem;
	private JComboBox<String> cbxGrau;
	private List<Empregado> lista; // Não utilizado ainda
	private MaskFormatter mascaraData = null;
	private JFormattedTextField txtDataNasc;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDependente frame = new FrmDependente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void pesquisar() {
		List<Dependente> listaDep = new ArrayList<>();
		DependenteController dc = new DependenteController();
		listaDep = dc.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for (int i = tbm.getRowCount() - 1; i >= 0; i--) tbm.removeRow(i);

		int i = 0;
		for (Dependente dp : listaDep) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(dp.getCpfEmpregado(), i, 0);
			tblConsulta.setValueAt(dp.getNome(), i, 1);
			tblConsulta.setValueAt(dp.getGrauParentesco(), i, 2);
			tblConsulta.setValueAt(Util.formatarDataDeLocalDateParaGui(dp.getDataNascimento()), i, 3);
			i++;
		}
	}
	
	private void inserir() {
		Dependente dep = new Dependente();
		DependenteController dc = new DependenteController();
		Integer pos = 0;
		
		/*Recuperando o cpf do empregado selecionado*/
		for (Empregado e1 : lista) {
			if (e1.getNome().equals(cbxEmpregado.getSelectedItem())) pos = lista.indexOf(e1);
		}
		
		dep.setCpfEmpregado(lista.get(pos).getCpf());
		dep.setNome(txtNome.getText());
		dep.setGrauParentesco(cbxGrau.getSelectedItem().toString());
	
		int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataNasc.getText());
		dep.setDataNascimento(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
		
		lblMensagem.setText(dc.inserir(dep));
	}
	
	private void alterar() {
		Dependente dep = new Dependente();
		DependenteController dc = new DependenteController();
		Integer pos = 0;
		
		/* Recuperando o cpf do empregado selecionado */
		for (Empregado e1 : lista) {
			if (e1.getNome().equals(cbxEmpregado.getSelectedItem())) pos = lista.indexOf(e1);
		}
		
		dep.setCpfEmpregado(lista.get(pos).getCpf());
		dep.setNome(txtNome.getText());
		dep.setGrauParentesco(cbxGrau.getSelectedItem().toString());
		int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataNasc.getText());
		dep.setDataNascimento(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
		
		lblMensagem.setText(dc.alterar(dep));
	}
	
	private void excluir() {
		Dependente dep = new Dependente();
		DependenteController dc = new DependenteController();
		Integer pos = 0;
		
		/* Recuperando o cpf do empregado selecionado */
		for (Empregado e1 : lista) {
			if (e1.getNome().equals(cbxEmpregado.getSelectedItem())) pos = lista.indexOf(e1);
		}
		
		dep.setCpfEmpregado(lista.get(pos).getCpf());
		dep.setNome(txtNome.getText());
		Object[] opcoes = { "Sim", "Não" };
		int i = JOptionPane.showOptionDialog(
			null, 
			"Deseja excluir esse dependente: " + txtNome.getText() + "?", 
			"Exclusão", 
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE, 
			null, 
			opcoes, 
			opcoes[0]);
		
		if (JOptionPane.YES_OPTION == i) lblMensagem.setText(dc.excluir(dep));
	}

	public void limpar() {
		txtNome.setText("");
		txtDataNasc.setText("");
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
		for(int i = tbm.getRowCount() - 1; i >= 0; i--) tbm.removeRow(i);
	}
	
	/**
	 * Create the frame.
	 */
	public FrmDependente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
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
			public void mouseClicked(MouseEvent arg0) {
				alterar();
				pesquisar();
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				excluir();
				pesquisar();
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pesquisar();
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmDependente.this.dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 547, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
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
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 29, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnLimpar)
						.addComponent(btnInserir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnPesquisar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				// String cpfEmpregado = tblConsulta.getValueAt(linha, 0).toString();
				String nome = tblConsulta.getValueAt(linha, 1).toString();
				String grauParente = tblConsulta.getValueAt(linha, 2).toString();
				String dataNasc = tblConsulta.getValueAt(linha, 3).toString();
				
				txtNome.setText(nome);
				cbxGrau.setSelectedItem(grauParente);
				txtDataNasc.setText(dataNasc);
				
				Integer pos = 0;
				for (Empregado e1 : lista) {
					if (e1.getCpf().equals(tblConsulta.getValueAt(linha, 0).toString())) pos = lista.indexOf(e1);
				}
				cbxEmpregado.setSelectedItem(lista.get(pos).getNome());
			}
		});
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {}, 
			new String[] {"Empregado", "Nome", "Grau de Parentesco", "Data de Nascimento"}) {
			
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(2).setResizable(false);
		tblConsulta.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Empregado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblGrauDeParentesco = new JLabel("Grau de Parentesco:");
		lblGrauDeParentesco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setVerticalAlignment(SwingConstants.TOP);
		lblMensagem.setForeground(Color.BLUE);
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		EmpregadoController ec = new EmpregadoController();
		lista = ec.listarTodos();
		cbxEmpregado = new JComboBox<String>();
		cbxEmpregado.addItem("");
		for(Empregado e : lista) cbxEmpregado.addItem(e.getNome());
		
		cbxGrau = new JComboBox<String>();
		cbxGrau.setModel(new DefaultComboBoxModel(new String[] {"", "Filho(a)", "Enteado(a)", "Pai", "M\u00E3e", "Agregado(a)"}));
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		try{
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		txtDataNasc = new JFormattedTextField(mascaraData);
		
		JLabel lblNewLabel_1 = new JLabel("dd/mm/aaaa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(Color.RED);
		
		JButton btnVaiPraEmpregado = new JButton("..");
		btnVaiPraEmpregado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmEmpregado fe = new FrmEmpregado();
				fe.setVisible(true);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMensagem, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblDataDeNascimento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblGrauDeParentesco, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtNome)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtDataNasc, Alignment.LEADING)
										.addComponent(cbxGrau, Alignment.LEADING, 0, 183, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1))
								.addComponent(cbxEmpregado, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnVaiPraEmpregado)))
					.addGap(15))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(cbxEmpregado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVaiPraEmpregado))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGrauDeParentesco, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxGrau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataDeNascimento, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDataNasc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMensagem, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	
}
