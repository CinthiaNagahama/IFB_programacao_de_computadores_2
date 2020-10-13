package persistencia;

import model.Dependente;
import java.util.List;

public interface DependenteDAO {
	public String inserir(Dependente dep);
	public String alterar(Dependente dep);
	public String excluir(Dependente dep);
	public List<Dependente> listarTodos();
	public List<Dependente> pesquisarPorEmpregado(String cpf);
}
