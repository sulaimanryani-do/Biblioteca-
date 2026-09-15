/**
 * classe libre 
 * Nos permite agafar els dades del llibre , titol , autor y categoria 
 * Podemos agafar el estado del llibre si esta prestat o no 
 * 
 */
public class Llibre {
	
	/**
	 * Atributos del llibre 
	 */
    private String titol;
    private String autor;
    private String categoria; 
    private boolean prestat;
    private int copsPrestat; 

    public Llibre(String titol, String autor, String categoria) {
        this.titol = titol;
        this.autor = autor;
        this.categoria = categoria;
        this.prestat = false;
        this.copsPrestat = 0;
    }

    public String getTitol() { return titol; }
    public String getCategoria() { return categoria; }
    public boolean esPrestat() { return prestat; }
    public int getCopsPrestat() { return copsPrestat; }

    /**
     * Method para cambiar el estado del llibre a prestat y incrementa el numero de la vezes que le han prestat 
     */
    public void prestar() { 
        this.prestat = true; 
        this.copsPrestat++; 
    }
    
    /**
     * method para cambiar el estado del llibre a disponible cuando el usuari retorna el llibe 
     */
    public void retornar() { this.prestat = false; }

    @Override
    public String toString() {
        return titol + " de " + autor + " [" + categoria + "]" + (prestat ? " (En préstec)" : " (Disponible)");
    }
}