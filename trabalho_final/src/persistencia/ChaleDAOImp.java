package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Chale;

public class ChaleDAOImp implements ChaleDAO{
	@Override
	public String inserir(Chale c) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into chale (localizacao, capacidade, valor_alta_estacao, valor_baixa_estacao) values (?,?,?,?)");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, c.getLocalizacao());
			pst.setInt(2, c.getCapacidade());
			pst.setDouble(3, c.getValorAltaEstacao());
			pst.setDouble(4, c.getValorBaixaEstacao());
			
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
	public String alterar(Chale c) {
		StringBuilder sql = new StringBuilder();
		sql.append("update chale set localizacao=?, capacidade=?, valor_alta_estacao=?, valor_baixa_estacao=? where cod_chale=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, c.getLocalizacao());
			pst.setInt(2, c.getCapacidade());
			pst.setDouble(3, c.getValorAltaEstacao());
			pst.setDouble(4, c.getValorBaixaEstacao());
			pst.setInt(5, c.getCodChale());
			
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
	public String excluir(Chale c) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from chale where cod_chale=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, c.getCodChale());
			
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
	public List<Chale> listarTodos() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from chale order by cod_chale");
		Connection con = ConnectionFactory.getConnection();
		List <Chale> lista = new ArrayList<Chale>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet res = pst.executeQuery();
			if(res != null) {
				while(res.next()) {
					Chale c = new Chale();
					c.setCodChale(res.getInt(1));
					c.setLocalizacao(res.getString(2));
					c.setCapacidade(res.getInt(3));
					c.setValorAltaEstacao(res.getDouble(4));
					c.setValorBaixaEstacao(res.getDouble(4));
					lista.add(c);
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