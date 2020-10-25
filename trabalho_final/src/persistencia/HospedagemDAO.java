package persistencia;

import java.util.List;
import model.Hospedagem;

public interface HospedagemDAO {
	public String inserir(Hospedagem h);
	public String alterar(Hospedagem h);
	public String excluir(Hospedagem h);
	public List<Hospedagem> listarTodos();
	public Hospedagem pesquisarPorCodigo(int cod);
}
