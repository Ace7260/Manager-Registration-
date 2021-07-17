package Manager;

import InOUT.IO;

import java.util.ArrayList;
import java.util.List;

public class Login {
    private String username;/**le nom d utlisateur de l'agent**/
    private String password;/**le mot de passe de l'agent**/
    private static List<Login>liste_des_agents=new ArrayList<Login>();/**va contenir la liste des agents de la banque**/

    public static List<Login> getListe_des_agents() {
        return liste_des_agents;
    }

    /**le constructeur du login pour l agent**/
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
        liste_des_agents.add(this);
    }
   // Login.getListe_des_agents().get(i).getUsername()//explain
    public static void display_all_agents(){
        if (liste_des_agents.size()>0){
            for (int i = 0; i < liste_des_agents.size(); i++) {
                System.out.print("\n"+(i+1)+".Username --->"+Login.liste_des_agents.get(i).getUsername()+"--"
                        +"Password --->"+Login.liste_des_agents.get(i).getPassword());
            }
        }else
            System.err.print("\nPAS D'AGENT INSCRIPT");

    }
    public Login(){}/**le constructeur vide par defaut**/

    /**la methode qui sera appelée dans le main pour se connecter**/
    public static void connect_user(){
        Login login=new Login(IO.setString("\nVotre Nom d'utilisateur:"),IO.setString("\nDefinir votre mot de passe :"));
    }
    /**les Setters et les Getters**/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public static boolean connection(String username,String password){
        if (username.compareTo(password)!=0)
            return true;
        else
            return false;
    }
}
