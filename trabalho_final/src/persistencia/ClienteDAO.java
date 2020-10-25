package persistencia;

import java.util.List;
import model.Cliente;

public interface ClienteDAO {
	public String inserir(Cliente c);
	public String alterar(Cliente c);
	public String excluir(Cliente c);
	public List<Cliente> listarTodos();
	public Cliente pesquisarPorRG(String rg);
	public List<Cliente> pesquisarPorNome(String nome);
}
