import java.util.*;
import java.util.stream.Collectors;

public class Options2 extends Livre2{
    Scanner scan = new Scanner(System.in);
    private LinkedHashMap<Integer,Livre2> depot = new LinkedHashMap<>();
    int counter = 1000;
    public void menu(){
        System.out.println("Bienvenue..\nVeuiller choisir une operation\n1.Ajouter le livre\n2.Afficher le livre avec le numero" +
                "\n3.Afficher le livre avec une information\n4.Effacer le livre\n5.Lister toutes les livres\n6.Sorti.");
        int choix=0;
        try{
            choix = scan.nextInt();
            if(!(choix>0||choix<7)){
                throw new IllegalArgumentException("Entrez un des chiffres suivant 1,2,3,4,5,6");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            menu();
        }catch (InputMismatchException e){
            System.out.println("Operation invalable.Reessayez..");
            scan.nextLine();
            menu();
        }
        switch (choix){
            case 1:
                ajouterLivre();
                break;
            case 2:
                afficherLivreAvecNumero();
                break;
            case 3:
                afficherLivreAvecInfo();
                break;
            case 4:
                effacerLivre();
                break;
            case 5:
                listerToutesLivres();
                break;
            case 6:
                sorti();
                break;
            default:
                System.out.println("Operation invalable.Reessayez.");
                menu();
        }
    }
    private void ajouterLivre() {
        System.out.println("Entrez le nom de livre:");
        scan.nextLine();
        setNomDeLivre(scan.nextLine());
        System.out.println("Entrez le nom d'Auteur:");
        setNomDAuteur(scan.nextLine());
        System.out.println("Entrez le type de Livre:");
        setTypeDeLivre(scan.nextLine());
        System.out.println("Entrez le prix de Livre:");
        setPrixDeLivre(scan.nextDouble());
        counter++;
        depot.put(counter,new Livre2(getNomDeLivre(),getNomDAuteur(),getTypeDeLivre(),getPrixDeLivre()));
        System.out.println("Le livre numéro "+counter+ " a été inscrit");
        continuerOupasPourAjouter();
    }
    private void continuerOupasPourAjouter() {
        System.out.println("Voulez vous continuer à ajouter le livre?Oui/Non");
        String choix = scan.next();
        if(choix.equalsIgnoreCase("oui")){
            ajouterLivre();
        } else if (choix.equalsIgnoreCase("non")) {
            System.out.println("Vous êtes redirigé à la page principale\n");
            scan.nextLine();
            menu();
        }else {
            System.out.println("Choix invalable.Reessayez.");
            continuerOupasPourAjouter();
        }
    }
    private void afficherLivreAvecNumero() {
        System.out.println("Entrez le numero de livre à chercher:");
        int numero = scan.nextInt();
        if (depot.containsKey(numero)){
            System.out.println(depot.get(numero).toString());
        } else {
            System.out.println("il n'a pas été trouvé le livre qui appartient le numero saisi");
        }
        continuerOupasPourAfficherAvecNumero();
    }
    private void continuerOupasPourAfficherAvecNumero() {
        System.out.println("Voulez vous continuer à afficher le livre?Oui/Non");
        String choix = scan.next();
        if(choix.equalsIgnoreCase("oui")){
            afficherLivreAvecNumero();
        } else if (choix.equalsIgnoreCase("non")) {
            System.out.println("Vous êtes redirigé à la page principale");
            menu();
        }else {
            System.out.println("Choix invalable.Reessayez.");
            continuerOupasPourAfficherAvecNumero();
        }
    }
    private void afficherLivreAvecInfo() {
        System.out.println("Veuiller saisir une operation.\n1.Nom de Livre\n2.Auteur de Livre\n3.Prix de Livre\n4.Type De Livre");
        String choix= scan.next();
        switch (choix){
            case "1":
                avecNomInfo();
                break;
            case "2":
                avecAuteurInfo();
                break;
            case "3":
                avecPrixInfo();
                break;
            case "4":
                avecTypeInfo();
                break;
            default:
                System.out.println("Vous avez mal saisi.Entrez un des chifres suivant 1,2,3,4");
        }
        continuerOupasPourAfficherAvecInfo();
    }
    private void avecTypeInfo() {
        System.out.println("Veuiller saisir le type de livre:");
        scan.nextLine();
        String type = scan.nextLine();
        int count = 0;
        for (Map.Entry<Integer,Livre2> w : depot.entrySet()) {
            if (w.getValue().getTypeDeLivre().equalsIgnoreCase(type)){
                System.out.println(w);
                count++;
            }
        }
        if(count==0){
            System.out.println("il n'a pas été trouvé le type saisi..");
        }
        continuerOupasPourAfficherAvecInfo();
    }
    private void avecPrixInfo() {
        System.out.println("Veuiller saisir le prix:");
        double prixLivre = scan.nextDouble();
        int count = 0;
        for (Map.Entry<Integer,Livre2> w : depot.entrySet()) {
            if (w.getValue().getPrixDeLivre()==prixLivre){
                System.out.println(w);
                count++;
            }
        }
        if(count==0){
            System.out.println("il n'a pas été trouvé le prix saisi..");
        }
        continuerOupasPourAfficherAvecInfo();
    }
    private void avecAuteurInfo() {
        System.out.println("Veuiller saisir le nom de l'Auteur:");
        scan.nextLine();
        String nomAuteur = scan.nextLine();
        System.out.println(depot.values().stream().anyMatch(t->t.getNomDAuteur().equalsIgnoreCase(nomAuteur)) ?
                fonc(nomAuteur): "il n'a pas été trouvé l'auteur saisi..");
       /*
        int count = 0;
        for (Map.Entry<Integer,Livre2> w : depot.entrySet()) {
            if (w.getValue().getNomDAuteur().equalsIgnoreCase(nomAuteur)){
                System.out.println(w);
                count++;
            }
        }
        if(count==0){
            System.out.println("il n'a pas été trouvé l'auteur saisi..");
        }
        */
        continuerOupasPourAfficherAvecInfo();
    }
    private List<Livre2> fonc(String nomAuteur) {
        return depot.values().stream().filter(t->t.getNomDAuteur().equalsIgnoreCase(nomAuteur)).collect(Collectors.toList());
    }
    private void avecNomInfo() {
        System.out.println("Veuiller saisir le nom de livre:");
        scan.nextLine();
        String nomLivre = scan.nextLine();
        int count = 0;
        for (Map.Entry<Integer,Livre2> w : depot.entrySet()) {
            if (w.getValue().getNomDeLivre().equalsIgnoreCase(nomLivre)){
                System.out.println(w);
                count++;
            }
        }
        if(count==0){
            System.out.println("il n'a pas été trouvé le livre saisi");
        }
        continuerOupasPourAfficherAvecInfo();
    }
    private void continuerOupasPourAfficherAvecInfo() {
        System.out.println("Voulez vous continuer à afficher le livre?Oui/Non");
        String choix = scan.next();
        if(choix.equalsIgnoreCase("oui")){
            afficherLivreAvecInfo();
        } else if (choix.equalsIgnoreCase("non")) {
            System.out.println("Vous êtes redirigé à la page principale");
            menu();
        }else {
            System.out.println("Choix invalable.Reessayez.");
            continuerOupasPourAfficherAvecInfo();
        }
    }
    private void effacerLivre() {
        if(depot.size()!=0){
            System.out.println("Veuiller saisir le numero de livre à effacer");
            int numeroLivre= scan.nextInt();
            if(depot.containsKey(numeroLivre)){
                depot.remove(numeroLivre);
                System.out.println("le livre numéro " +numeroLivre+" a été éffacé avec succes");
                continuerOupasPourEffecerLivre();
            }else {
                System.out.println("il n'a pas été trouvé le numero de livre saisi");
                continuerOupasPourEffecerLivre();
            }
        }else{
            System.out.println("Il n'y a pas de livre dans le base de donnée..");
            depotVide();
        }
    }
    private void depotVide() {
        System.out.println("Voulez vous faire quelle operation?\n1.Ajouter le livre\n2.Retourner à la page principale");
        String choix= scan.next();
        if(choix.equalsIgnoreCase("1")){
            ajouterLivre();
        }else if(choix.equalsIgnoreCase("2")){
            menu();
        }else {
            System.out.println("Veiller choisir un choix valable!! ");
            depotVide();
        }
    }
    private void continuerOupasPourEffecerLivre() {
        System.out.println("Voulez vous continuer à effacer le livre?Oui/Non");
        String choix = scan.next();
        if(choix.equalsIgnoreCase("oui")){
            effacerLivre();
        } else if (choix.equalsIgnoreCase("non")) {
            System.out.println("Vous êtes redirigé à la page principale");
            menu();
        }else {
            System.out.println("Choix invalable.Reessayez.");
            continuerOupasPourEffecerLivre();
        }
    }
    private void listerToutesLivres() {
        if (depot.size()==0){
            System.out.println("il n'y a pas de livre à lister.Voulez vous ajouter le livre?Oui/Non");
            String choix = scan.next();
            if (choix.equalsIgnoreCase("oui")) {
                ajouterLivre();
            }else {
                System.out.println("Vous êtes redirigé à la page principale");
                menu();
            }
        }else{
            System.out.println(depot);
            menu();
        }
    }
    private void sorti(){
        System.out.println("Merci beaucoup..");
    }

}
