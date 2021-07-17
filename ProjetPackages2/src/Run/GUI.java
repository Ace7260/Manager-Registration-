package Run;

import InOUT.IO;
import Manager.Account;
import Manager.Customer;
import Manager.Login;
import Manager.Operation;
import java.util.Date;
import java.util.Random;

public class GUI {
    public static void main(String[] args) {
        do {
            try {
                menu();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(NullPointerException ex){}
        } while (true);
    }
    /**la methode qui va nous generer un nombre aleatoire**/
    public static int Random_number(){
        Random random = new Random();
        int nb;
        nb = random.nextInt(1000);
        return nb;
    }
    /**la methode qui va nous generer un string aleatoire**/
    public static String Random_string(){
        String chars = "695101443298ABcdefGHIJKLMXWKDE";
        String pass = "";
        for(int x=0;x<15;x++)
        {
            int i = (int)Math.floor(Math.random() * 10);
            pass += chars.charAt(i);
        }
        return pass;
    }
    static void menu() throws InterruptedException {

        System.out.print("\n*****     WELCOME   TO    BRADLET   DYNAMICS    *****\n");
        System.out.print("\n1.Se Connecter A Votre Compte Agent");
        System.out.print("\n2.Se faire inscire en tant qu'agent");
        System.out.print("\n3.Quitter et Fermer Le Logiciel");



        switch (IO.setINT("\n\nVeuillez Choisir une action :")){
            case 1:
                if (Login.getListe_des_agents().size()>0){
                    String Username=IO.setString("\nVotre Nom d' utilisateur :");
                    String password=IO.setString("\nSaisir Votre mot de passe :");
                    for (int i = 0; i < Login.getListe_des_agents().size(); i++) {
                    if (Username.contentEquals(Login.getListe_des_agents().get(i).getUsername()) && password.contentEquals(Login.getListe_des_agents().get(i).getPassword())){
                        System.out.print("\n-------->>>Verifiaction De vos Identifiants......Patientez");
                        Thread.sleep(2000);
                        System.out.print("\n-------->>>"+Username+"BIENVENUE Sur Notre PlateForme");
                        Thread.sleep(5000);
                        System.out.print("\n-------->>>Chargement Des Informations Sur Votre Compte\n");
                        Thread.sleep(10000);
                        System.out.print("\n        1.Enregistrer un nouveau client");
                        System.out.print("\n        2.Effectuer une Operation Bancaire");
                        System.out.print("\n        3.Afficher la liste des clients de la banque");
                        System.out.print("\n        4.Afficher l'Historique des Transcations");
                        switch (IO.setINT("\n\n     Choisir une Action svp :")){
                            case 1:
                                System.out.print("\nDEFINIR LES INFORMATIONS PERSONNELLES DU CLIENT\n");
                                Customer new_customer= new Customer(IO.setINT("\nDefinir identifiant Client:"),IO.setString("\nSaisir Nom Client :"),IO.setString("\nSaisir Prenom Client :"));
                                System.out.print("\n\n-------->>>LA CREACTION DU COMPTE EST EN COURS...");
                                Thread.sleep(10000);
                                System.out.print("\n\n-------->>>SAUVEGARDE DES DONNEES EN COURS...");
                                Account new_account=new Account(Random_number(),Random_string(),0,new_customer);
                                Thread.sleep(10000);
                                System.out.print("\n\n~~~~~~~~LE COMPTE A ETE CREE AVEC SUCCES~~~~~~~~\n\n");
                                System.out.print("Identifiant du client -->"+new_account.getId_account()+"\nNom du client -->"+new_customer.getName()+"\nPrenom du client -->"
                                        +new_customer.getPost_name()+"\nNumero de compte -->"+new_account.getNumber_account()+"\n");
                                break;
                            case 2:
                                /**System.out.print("\nPreciser Les Informations Du Client\n");
                                Customer current_customer=new Customer(IO.setINT("\nId Client :"),IO.setString("\nNom Client :"),IO.setString("\nPrenom Client :"));
                                Account current_account=new Account(Random_number(),Random_string(),0,current_customer);**/
                                break;
                            case 3:
                                Account.display_all_account();
                                break;
                            case 4:
                                Operation.display_all_operations();
                                break;
                            default:
                                System.err.print("\n***** Erreur De La Saisie *****\n");
                        }
                    }
                }
                }else
                    System.err.print("\nPas d'Agent inscrit pour ce Pour ce compte\n");
                    break;
            case 2:
                System.out.print("\nVOUS DEVEZ DEFINIR VOS INFORMATIONS DE CONNECTION");
                Login new_login =new Login(IO.setString("\nVotre Nom d'utilisateur:"),IO.setString("\nDefinir votre mot de passe :"));
                String passverify;
                /*pour retester le mot de passe*/
                do {
                    passverify = IO.setString("\nConfirmez votre Mot de Passe :");
                    if(new_login.connection(passverify,new_login.getPassword())==true)
                        System.err.print("Veuillez saisir le mot de passe saisi auparavant");
                } while(new_login.connection(passverify,new_login.getPassword())==true);
                /*----------------------------------------------------------------------*/
                if (passverify.contentEquals(new_login.getPassword())){
                    System.out.print("\nEnregistrement de Votre Compte Dans Le Système\n");
                    Thread.sleep(6500);
                    System.out.print("\nVos Identifiant pour la connexion sont\n\n");
                    System.out.print("\nNom de L'agent --->"+new_login.getUsername()+"\nVotre Mot de Passe --->"+ new_login.getPassword()+"\n");
                }else
                    System.err.print("\n****Erreur Lors de La verification de votre Mot de Passe****\n");
                break;
            case 3:
                System.out.print("\n\nPLEASE WAIT THE SYSTEM WILL DISCONNECT YOU\n");
                Thread.sleep(10000);
                System.out.print("\n\n---------->>>>THANK YOU<<<<----------\n\n");
                System.exit(0);
                break;
            default:
                System.err.print("\n*****ERREUR DE SAISIE*****\n");
    }
}
}