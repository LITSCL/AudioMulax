package cl.inacap.audiomulaxmodelo.dao;
import java.util.ArrayList;
import java.util.List;
import cl.inacap.audiomulaxmodelo.dto.InstrumentoMusical;

public class InstrumentoMusicalDAO {
	private static List<InstrumentoMusical> instrumentos = new ArrayList<>(); //Lista de tipo InstrumentoMusical llamada Instrumentos.
	
	public void save(InstrumentoMusical im) { //Este m�todo al ser llamado recibe por default una variable de tipo InstrumentoMusical llamada im.
		instrumentos.add(im); //A�ade a la lista llamada Instrumentos lo que se le entrega en el par�metro.
	}
	
	public List<InstrumentoMusical> getAll() { //Este m�todo retorna la lista llamada Instrumentos.
		return instrumentos;
	}
}
