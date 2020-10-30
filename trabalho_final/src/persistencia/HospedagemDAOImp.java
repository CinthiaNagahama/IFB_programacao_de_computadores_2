package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Hospedagem;

public class HospedagemDAOImp implements HospedagemDAO{
	@Override
	public String inserir(Hospedagem h) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into hospedagens(cod_hospedagem, cod_chale, estado, data_inicio, data_fim, quantidade_pessoas, desconto, valor_final) values(?,?,?,?,?,?,?,?)");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, h.getCodHospedagem());
			pst.setInt(2, h.getCodChale());
			pst.setString(3, h.getEstado());
			pst.setObject(4, h.getDataInicio());
			pst.setObject(5, h.getDataFim());
			pst.setInt(6, h.getQtdPessoas());
			pst.setDouble(7, h.getDesconto());
			pst.setDouble(8, h.getValorFinal());
			int res = pst.executeUpdate();
			if(res > 0) return "Inserido com sucesso!!!";
			else return "Erro ao inserir";
		}
		catch (SQLException e){
			return e.getMessage();
		}
		finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String alterar(Hospedagem h) {
		StringBuilder sql = new StringBuilder();
		sql.append("update hospedagens set cod_chale=?, estado=?, data_inicio=?, data_fim=?, quantidade_pessoas=?, desconto=?, valor_final=? where cod_hospedagem=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(8, h.getCodHospedagem());
			pst.setInt(1, h.getCodChale());
			pst.setString(2, h.getEstado());
			pst.setObject(3, h.getDataInicio());
			pst.setObject(4, h.getDataFim());
			pst.setInt(5, h.getQtdPessoas());
			pst.setDouble(6, h.getDesconto());
			pst.setDouble(7, h.getValorFinal());
			int res = pst.executeUpdate();
			if(res > 0) return "Alterado com sucesso!!!";
			else return "Erro ao alterar";
		}
		catch (SQLException e){
			return e.getMessage();
		}
		finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String excluir(Hospedagem h) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from hospedagens where cod_hospedagem=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, h.getCodHospedagem());
			
			int res = pst.executeUpdate();
			if(res > 0) return "Excluído com sucesso!!!";
			else return "Erro ao excluir";
		}
		catch (SQLException e){
			return e.getMessage();
		}
		finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public List<Hospedagem> listarTodos() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from hospedagens order by cod_hospedagem");
		Connection con = ConnectionFactory.getConnection();
		List <Hospedagem> lista = new ArrayList<Hospedagem>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet res = pst.executeQuery();
			if(res != null) {
				while(res.next()) {
					Hospedagem h = new Hospedagem();
					
					h.setCodHospedagem(res.getInt(1));
					h.setCodChale(res.getInt(2));
					h.setEstado(res.getString(3));
					h.setDataInicio(res.getObject(4, LocalDate.class));
					h.setDataFim(res.getObject(5, LocalDate.class));
					h.setQtdPessoas(res.getInt(6));
					h.setDesconto(res.getDouble(7));
					h.setValorFinal(res.getDouble(8));
					
					lista.add(h);
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
	public Hospedagem pesquisarPorCodigo(int cod) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from hospedagens where cod_hospedagem=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, cod);
			ResultSet res = pst.executeQuery();
			Hospedagem h = new Hospedagem();
			if(res != null) {
				while(res.next()) {
					h.setCodHospedagem(res.getInt(1));
					h.setCodChale(res.getInt(2));
					h.setEstado(res.getString(3));
					h.setDataInicio(res.getObject(4, LocalDate.class));
					h.setDataFim(res.getObject(5, LocalDate.class));
					h.setQtdPessoas(res.getInt(6));
					h.setDesconto(res.getDouble(7));
					h.setValorFinal(res.getDouble(8));
				}
				return h;
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
