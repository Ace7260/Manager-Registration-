package Manager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Operation {

    private Date date;/**attributs qui va recuperer la date de l'operation**/
    private String type_of_operation;/**le type d'operation versement ou retrait**/
    private double amount;/**le montant de l'operation**/
    private Account account;/**la navigation de reference**/
    private static List<Operation>liste_des_operations=new ArrayList<Operation>();/**liste qui va contenir l'historique des transactions**/

    /**le constructeur pour initier les attributs de la classe**/
    public Operation(Date date, String type_of_operation, double amount, Account account) {
        this.date = date;
        this.type_of_operation = type_of_operation;
        this.amount = amount;
        this.account = account;
        liste_des_operations.add(this);/**ajoute l'operation courante**/
    }

    /**le constructeur par defaut**/
    public Operation(){}

    /**methode qui va nous aider à lister toutes les oprations déjà faites par l'agent**/
    public static void display_all_operations(){
        if (liste_des_operations.size()>0){
            for (int i = 0; i < liste_des_operations.size(); i++) {
                System.out.print("\n"+(i+1)+"."+"Date -->"+new Date()+"--"+"Type d'Operation -->"+ liste_des_operations.get(i).type_of_operation
                +"--"+"\nMontant -->"+liste_des_operations.get(i).getAmount()+"--"+"Compte Client -->"+liste_des_operations.get(i).account);
            }
        }else
            System.err.print("\n*****   PAS D'OPERATION   *****");
    }

    /**les setters et les getters**/
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getType_of_operation() {
        return type_of_operation;
    }
    public void setType_of_operation(String type_of_operation) {
        this.type_of_operation = type_of_operation;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
}
