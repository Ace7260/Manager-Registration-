package Manager;

import InOUT.IO;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id_account;/**identifiant du compte**/
    private String number_account;/**le numero de compte du client**/
    private double balance_account;/**le solde du client dans le compte**/

    /**cet attribut creee une relation entre le compte et un client**/
    private Customer customer;/**la reference de navigation**/
    private static List<Account>liste_des_comptes =new ArrayList<Account>();/**va contenir la liste de tous les comptes en banque**/

    /**le constructeur pour initialiser un compte**/
    public Account(int id_account, String number_account, double balance_account, Customer customer) {
        this.id_account = id_account;
        this.number_account = number_account;
        this.balance_account = 0;
        this.customer=customer;
        liste_des_comptes.add(this);/**va ajouter le compte courant**/
    }
    /**le Getter de la liste des comptes**/
    public static List<Account> getListe_des_comptes() {
        return liste_des_comptes;
    }

    /**le constructeur par defaut**/
    public Account(){

    }
    /**la methode qui va nous lister tous les comptes en banque**/
    public static void display_all_account(){
        if (liste_des_comptes.size()>0){
            for (int i = 0; i < liste_des_comptes.size(); i++) {
                System.out.print("\n"+(i+1)+"."+liste_des_comptes.get(i).getCustomer().getName()+"-"+liste_des_comptes.get(i).getCustomer().getPost_name()
                +" -"+liste_des_comptes.get(i).id_account+"\n");
            }
        }else
            System.out.print("\nPas de nouveau client enregistrés\tVeuillez les ajouter");
    }
    /**les setters et les getters**/
    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public String getNumber_account() {
        return number_account;
    }

    public void setNumber_account(String number_account) {
        this.number_account = number_account;
    }

    public double getBalance_account() {
        return balance_account;
    }

    public void setBalance_account(double balance_account) {
        this.balance_account = balance_account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
