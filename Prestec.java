import java.time.LocalDate;

public class Prestec {
    private Usuari usuari; 
    private Llibre llibre;
    private LocalDate dataPrestec;
    private LocalDate dataRetorn;

    public Prestec(Usuari usuari, Llibre llibre, LocalDate dataPrestec) {
        this.usuari = usuari; 
        this.llibre = llibre;
        this.dataPrestec = dataPrestec;
        this.dataRetorn = dataPrestec.plusWeeks(2); 
    }

    public Usuari getUsuari() { return usuari; }
    public Llibre getLlibre() { return llibre; }
    public LocalDate getDataRetorn() { return dataRetorn; }

    @Override
    public String toString() {
        return "Llibre: " + llibre.getTitol() + " | Usuari: " + usuari.getNom() + " (ID: " + usuari.getId() + ") | Retorn: " + dataRetorn;
    }

	/**
	 * @return the dataPrestec
	 */
	public LocalDate getDataPrestec() {
		return dataPrestec;
	}

	/**
	 * @param dataPrestec the dataPrestec to set
	 */
	public void setDataPrestec(LocalDate dataPrestec) {
		this.dataPrestec = dataPrestec;
	}

	/**
	 * @param usuari the usuari to set
	 */
	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

	/**
	 * @param llibre the llibre to set
	 */
	public void setLlibre(Llibre llibre) {
		this.llibre = llibre;
	}

	/**
	 * @param dataRetorn the dataRetorn to set
	 */
	public void setDataRetorn(LocalDate dataRetorn) {
		this.dataRetorn = dataRetorn;
	}
}