package Manager;

public class Customer {
    private int id_customer;/**identifiant du client**/
    private String name;/**le nom du client**/
    private String post_name;/**le prenom du client**/

    /** cet attribut creee une relation entre un client et son compte**/
    private Account account;

    /**le constructeur pour initialiser les attributs de la classe**/
    public Customer(int id_customer, String name, String post_name) {
        this.id_customer = id_customer;
        this.name = name;
        this.post_name = post_name;
    }
    /**le constructeur par default**/
    public Customer(){

    }
    /**les setters et les getters**/
    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
