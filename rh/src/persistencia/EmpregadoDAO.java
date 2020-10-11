package persistencia;

import java.util.List;
import model.Empregado;

public interface EmpregadoDAO {
	public String inserir(Empregado emp);
	public String alterar(Empregado emp);
	public String excluir(Empregado emp);
	public List<Empregado> listarTodos();
	public Empregado pesquisarCpf(String cpf);
}
