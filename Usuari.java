public class Usuari {
    
    private int id;
    private String nom;
    private String email;

    /**
     * Constructor: crea un nou usuari amb id, nom i email.
     * @param id    Identificador únic de l'usuari
     * @param nom   Nom de l'usuari
     * @param email Correu electrònic de l'usuari
     */
    public Usuari(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    /**
     * Retorna l'identificador de l'usuari.
     * @return id de l'usuari
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna el nom de l'usuari.
     * @return nom de l'usuari
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retorna l'email de l'usuari.
     * @return email de l'usuari
     */
    public String getEmail() {
        return email;
    }

    /**
     * Modifica el nom de l'usuari.
     * No permet noms buits o nuls.
     * @param nouNom El nou nom de l'usuari
     */
    public void setNom(String nouNom) {
        if (nouNom != null && !nouNom.isBlank()) {
            this.nom = nouNom;
            System.out.println("Nom actualitzat a: " + nouNom);
        } else {
            System.out.println("El nom no pot estar buit.");
        }
    }

    /**
     * Modifica l'email de l'usuari.
     * Comprova que l'email contingui el símbol '@'.
     * @param nouEmail El nou email de l'usuari
     */
    public void setEmail(String nouEmail) {
        if (nouEmail != null && nouEmail.contains("@")) {
            this.email = nouEmail;
            System.out.println("Email actualitzat a: " + nouEmail);
        } else {
            System.out.println("Email no vàlid.");
        }
    }

    /**
     * Retorna una representació en text de l'usuari.
     * @return String amb les dades de l'usuari
     */
    @Override
    public String toString() {
        return "Usuari{id=" + id + ", nom='" + nom + "', email='" + email + "'}";
    }
}