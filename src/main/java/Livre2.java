public class Livre2 {


    private String nomDeLivre;
    private String nomDAuteur;
    private String typeDeLivre;
    private double prixDeLivre;


    public Livre2 (){
    }
    public Livre2(String nomDeLivre, String nomDAuteur, String typeDeLivre, Double prixDeLivre) {
        this.nomDeLivre = nomDeLivre;
        this.nomDAuteur = nomDAuteur;
        this.typeDeLivre = typeDeLivre;
        this.prixDeLivre = prixDeLivre;
    }
    @Override
    public String toString() {
        return "{" +
                "nomDeLivre='" + nomDeLivre + '\'' +
                ", nomDAuteur='" + nomDAuteur + '\'' +
                ", typeDeLivre='" + typeDeLivre + '\'' +
                ", prixDeLivre=" + prixDeLivre +
                '}';
    }
    public String getTypeDeLivre() {
        return typeDeLivre;
    }
    public void setTypeDeLivre(String typeDeLivre) {
        this.typeDeLivre = typeDeLivre;
    }
    public String getNomDeLivre() {
        return nomDeLivre;
    }
    public void setNomDeLivre(String nomDeLivre) {
        this.nomDeLivre = nomDeLivre;
    }
    public String getNomDAuteur() {
        return nomDAuteur;
    }
    public void setNomDAuteur(String nomDAuteur) {
        this.nomDAuteur = nomDAuteur;
    }
    public double getPrixDeLivre() {
        return prixDeLivre;
    }
    public void setPrixDeLivre(double prixDeLivre) {
        this.prixDeLivre = prixDeLivre;
    }
}

