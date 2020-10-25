package persistencia;

import java.util.List;
import model.Chale;

public interface ChaleDAO {
	public String inserir(Chale c);
	public String alterar(Chale c);
	public String excluir(Chale c);
	public List<Chale> listarTodos();
}
