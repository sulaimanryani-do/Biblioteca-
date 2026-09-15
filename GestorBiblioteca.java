import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * Classe GestorBiblioteca 
 * Te permite prestar llibre 
 * Consultar historia del usuari y les llibres que tienes prestat con la fecha y informacion del llibre 
 * Mostrar el estado del llibre si esta prestat , disponible o agotado  
 * Controla el maxim del llibres que el usuari pod prestar
 */
public class GestorBiblioteca {
	
    private List<Prestec> prestecs;
    private final int MAX_LLIBRES = 3;

    public GestorBiblioteca() {
        this.prestecs = new ArrayList<>();
    }

    /**
     * Method para prestar llibre al usuari coresponen 
     * @param usuari : el id del usuari que quiere prestar 
     * @param llibre : el titol del llibre que va prestar 
     */
    public void prestarLlibre(Usuari usuari, Llibre llibre) {
    	
    	/**
    	 * si el libre ya prestado avisem al usuari que esta prestat y no es pod prestarlo 
    	 */
        if (llibre.esPrestat()) {
            System.out.println("Aquest llibre ja està prestat.");
        }

        int llibresQueTeLUsuari = 0;
        /**
         * boocle para contar el nombre del libres que ha prestat el usuari 
         * si ancara no pasa el max es pod prestar mas , si ha egat al max no es dejara prestar el llibre 
         */
        for (int i = 0; i < prestecs.size(); i++) {
            Prestec p = prestecs.get(i);
            if (p.getUsuari().getId() == usuari.getId()) {
                llibresQueTeLUsuari++;
            }
        }

        /**
         * si la cantitat del llibros que el usuari ha presat encima o igual del max 
         * mostrem una mensaja que no es pod prestar mes 
         * si no la cantitat esta abajo del max el prestem el llibre 
         * y lo agregamos como llibre prestat 
         */
        if (llibresQueTeLUsuari >= MAX_LLIBRES) {
            System.out.println("L'usuari " + usuari.getNom() + " ja té el màxim de " + MAX_LLIBRES + " llibres.");
        }else {
        	
        	llibre.prestar();
        	Prestec nouPrestec = new Prestec(usuari, llibre, LocalDate.now());
        	prestecs.add(nouPrestec);
        	
        	System.out.println(usuari.getNom() + " ha agafat el llibre: " + llibre.getTitol());
        	
        }

    }

    /**
     * Mehod muestra la historia del usuari con la biblioteca 
     * @param usuari : el id del usuari 
     */
    public void consultarHistorial(Usuari usuari) {
        System.out.println("Historial de préstecs de " + usuari.getNom() + ":");
        boolean tePrestecs = false;

        /**
         * boocle para buscar les libres que el usuari ha prestat si te .
         */
        for (int i = 0; i < prestecs.size(); i++) {
            Prestec p = prestecs.get(i);
            if (p.getUsuari().getId() == usuari.getId()) {
                System.out.println("- " + p.getLlibre().getTitol() + " (Retornar el: " + p.getDataRetorn() + ")");
                tePrestecs = true;
            }
        }

        /**
         * si el usuari no ha prestat ningun llibre 
         * mostrem la mensaja que no te cap llibre prestat
         */
        if (!tePrestecs) {
            System.out.println("Aquest usuari no té cap préstec registrat.");
        }
    }

    /**
     * Method para mostrar el estadistiques de tots les llibres y cuantas vezes ha sido prestat 
     * @param llibres les libres de la biblioteca 
     */
    public void mostrarEstadistiques(List<Llibre> llibres) {
        System.out.println("\n--- ESTADÍSTIQUES DE PRÉSTECS ---");
        for (int i = 0; i < llibres.size(); i++) {
            Llibre l = llibres.get(i);
            System.out.println("- " + l.getTitol() + ": s'ha prestat " + l.getCopsPrestat() + " vegades.");
        }
    }
}
