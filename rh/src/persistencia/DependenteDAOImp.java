package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Dependente;

public class DependenteDAOImp implements DependenteDAO{
	@Override
	public String inserir(Dependente dep) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into dependente (cpf_empregado,nome,grau_parentesco,data_nascimento) values (?,?,?,?)");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, dep.getCpfEmpregado());
			pst.setString(2, dep.getNome());
			pst.setString(3, dep.getGrauParentesco());
			pst.setObject(4, dep.getDataNascimento());
			
			int res = pst.executeUpdate();
			if(res > 0) return "Inserido com sucesso!!!";
			else return "Erro ao inserir";
			
		} catch(SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String alterar(Dependente dep) {
		StringBuilder sql = new StringBuilder();
		sql.append("update dependente set grau_parentesco=?, data_nascimento=? where nome=? and cpf_empregado=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, dep.getGrauParentesco());
			pst.setObject(2, dep.getDataNascimento());
			pst.setString(3, dep.getNome());
			pst.setString(4, dep.getCpfEmpregado());
			
			int res = pst.executeUpdate();
			if(res > 0) return "Alterado com sucesso!!!";
			else return "Erro ao alterar";
			
		} catch(SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String excluir(Dependente dep) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from dependente where nome=? and cpf_empregado=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, dep.getNome());
			pst.setString(2, dep.getCpfEmpregado());
			
			int res = pst.executeUpdate();
			if(res > 0) return "Excluído com sucesso!!!";
			else return "Erro ao excluir";
			
		} catch(SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public List<Dependente> listarTodos() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from dependente order by nome");
		Connection con = ConnectionFactory.getConnection();
		List <Dependente> lista = new ArrayList<Dependente>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet res = pst.executeQuery();
			if(res != null) {
				while(res.next()) {
					Dependente dep = new Dependente();
					dep.setCpfEmpregado(res.getString(1));
					dep.setNome(res.getString(2));
					dep.setGrauParentesco(res.getString(3));
					dep.setDataNascimento(res.getObject(4, LocalDate.class));
					lista.add(dep);
				}
				return lista;
			}
			else return null;
				
		} catch(SQLException e) {
			e.getMessage();
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public List<Dependente> pesquisarPorEmpregado(String cpf) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from dependente where cpf_empregado=? order by nome");
		Connection con = ConnectionFactory.getConnection();
		List <Dependente> lista = new ArrayList<Dependente>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, cpf);
			ResultSet res = pst.executeQuery();
			
			if(res != null) {
				while(res.next()) {
					Dependente dep = new Dependente();
					dep.setCpfEmpregado(res.getString(1));
					dep.setNome(res.getString(2));
					dep.setGrauParentesco(res.getString(3));
					dep.setDataNascimento(res.getObject(4, LocalDate.class));
					lista.add(dep);
				}
				return lista;
			}
			else return null;
				
		} catch(SQLException e) {
			e.getMessage();
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}
}
