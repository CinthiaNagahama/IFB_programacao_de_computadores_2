package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAOImp implements ClienteDAO{
	@Override
	public String inserir(Cliente c) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into clientes(cod_cliente, nome_cliente, rg_cliente, endereco_cliente, bairro_cliente, cep_cliente, nascimento_cliente) values(?,?,?,?,?,?,?)");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, c.getCodCliente());
			pst.setString(2, c.getNomeCliente());
			pst.setString(3, c.getRgCliente());
			pst.setString(4, c.getEnderecoCliente());
			pst.setString(5, c.getBairroCliente());
			pst.setString(6, c.getCEPCliente());
			pst.setObject(7, c.getNascimentoCliente());

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
	public String alterar(Cliente c) {
		StringBuilder sql = new StringBuilder();
		sql.append("update clientes set nome_cliente=?, rg_cliente=?, endereco_cliente=?, bairro_cliente=?, cep_cliente=?, nascimento_cliente=? where cod_cliente=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(7, c.getCodCliente());
			pst.setString(1, c.getNomeCliente());
			pst.setString(2, c.getRgCliente());
			pst.setString(3, c.getEnderecoCliente());
			pst.setString(4, c.getBairroCliente());
			pst.setString(5, c.getCEPCliente());
			pst.setObject(6, c.getNascimentoCliente());

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
	public String excluir(Cliente c) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from clientes where cod_cliente=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setInt(1, c.getCodCliente());
			
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
	public List<Cliente> listarTodos() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from clientes order by cod_cliente");
		Connection con = ConnectionFactory.getConnection();
		List <Cliente> lista = new ArrayList<Cliente>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet res = pst.executeQuery();
			if(res != null) {
				while(res.next()) {
					Cliente c = new Cliente();
					c.setCodCliente(res.getInt(1));
					c.setNomeCliente(res.getString(2));
					c.setRgCliente(res.getString(3));
					c.setEnderecoCliente(res.getString(4));
					c.setBairroCliente(res.getString(5));
					c.setCEPCliente(res.getString(6));
					c.setNascimentoCliente(res.getObject(7, LocalDate.class));
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

	@Override
	public Cliente pesquisarPorRG(String rg) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from clientes where rg_cliente=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, rg);
			ResultSet res = pst.executeQuery();
			Cliente c = new Cliente();
			if(res != null) {
				while(res.next()) {
					c.setCodCliente(res.getInt(1));
					c.setNomeCliente(res.getString(2));
					c.setRgCliente(res.getString(3));
					c.setEnderecoCliente(res.getString(4));
					c.setBairroCliente(res.getString(5));
					c.setCEPCliente(res.getString(6));
					c.setNascimentoCliente(res.getObject(7, LocalDate.class));
				}
				return c;
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
	public List<Cliente> pesquisarPorNome(String nome) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from clientes where nome_cliente=? order by nome_cliente");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, nome);
			ResultSet res = pst.executeQuery();
			List<Cliente> lista = new ArrayList<Cliente>();
			if(res != null) {
				while(res.next()) {
					Cliente c = new Cliente();
					c.setCodCliente(res.getInt(1));
					c.setNomeCliente(res.getString(2));
					c.setRgCliente(res.getString(3));
					c.setEnderecoCliente(res.getString(4));
					c.setBairroCliente(res.getString(5));
					c.setCEPCliente(res.getString(6));
					c.setNascimentoCliente(res.getObject(7, LocalDate.class));
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
