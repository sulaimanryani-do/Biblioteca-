import java.util.ArrayList;
import java.util.List;
import java.text.Normalizer;

/**
 * classe biblioteca 
 * Nos permite afegir y agafar llibres de la biblioteca 
 */
public class Biblioteca {
	private List<Llibre> llibres;

	public Biblioteca() {
		this.llibres = new ArrayList<>();
	}

	/**
	 * Method para afegir llibre a la biblioteca 
	 * @param llibre 
	 */
	public void afegirLlibre(Llibre llibre) { llibres.add(llibre); }

	/**
	 * Method para buscar lebro por su titol 
	 * @param titol
	 * @return el llibre si existe y null si no existe 
	 */
	public Llibre buscarLlibre(String titol) {

		/**
		 * boocle para buscar el llibre 
		 * si encuentra el llibre lo retorna 
		 * si no acaba el boocle y retorna null 
		 */
		for (int i = 0 ; i < this.llibres.size() ; i++) {
			if (this.llibres.get(i).getTitol().equalsIgnoreCase(titol)) {
				return this.llibres.get(i); 
			}
		}
		return null; 
	}

	
	/**
	 * @param llibres the llibres to set
	 */
	public void setLlibres(List<Llibre> llibres) {
		this.llibres = llibres;
	}

	public List<Llibre> getLlibres() { return llibres; }
}