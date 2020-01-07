package prestation.client;

public class ClientModel {

    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String contact;
    private String type;

    public ClientModel(int id, String nom, String prenom, String email, String contact, String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.contact = contact;
        this.type = type;
    }

    public ClientModel(String nom, String prenom, String email, String contact, String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.contact = contact;
        this.type = type;
    }

    public ClientModel(String nom, String prenom, String email, String contact, Integer type){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.contact = contact;
        if(type == 1){
            this.type = "Entreprise";
        }else{
            this.type = "Particulier";
        }
    }

    public Integer getId() {
        return id;
    }

    public ClientModel setId(int id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public ClientModel setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public ClientModel setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ClientModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public ClientModel setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public String getType() {
        return type;
    }

    public ClientModel setType(String type) {
        this.type = type;
        return this;
    }
}
