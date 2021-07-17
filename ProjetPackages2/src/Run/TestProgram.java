package Run;
import InOUT.IO;
import Manager.Account;
import Manager.Customer;

public class TestProgram {

    public static boolean connection(String username,String password){
        if (username.compareTo(password)!=0)
        return true;
        else
        return false;
    }
//
    static void Menu(){
        System.out.print("*======================*\n");
        System.out.print("*"+"1.Se connecter       "+" *\n");
        System.out.print("*"+"2.S'inscrire         "+" *\n");
        System.out.print("*"+"3.Quitter le logiciel"+" *\n");
        System.out.print("*======================*");

        switch (IO.setINT("\n\nVeuillez une action à executer :")) {
            case 1:
                String username="ultra";
                String password="123456";
                String userverify = "";
                String passverify = "";
                System.out.println("\nReseigner Votre nom d'utilisateur et  votre Mot de passe\n");
                do {
                    userverify = IO.setString("\nUsername :");
                    passverify = IO.setString("\nPassword:");
                    boolean u=connection(username,userverify);
                    boolean p=connection(password,passverify);
                  if (u && p) {
                      System.err.print("\nNom d'utilisateur Ou Mot de Passe incorrect \n");
                      System.out.print("\n1.Pour reesayer");
                      System.out.print("\n2.Pour vous inscrire");
                      switch (IO.setINT("\n\nChoisir parmi l'une action ci dessus :")){
                          case 1:
                              break;
                          case 2:
                              System.out.print("\nVeuillez saisir vos Informations Personnelles ci-dessus\n");
                              Customer c1=new Customer(IO.setINT("\nDefinir votre id_client:"),IO.setString("\nVotre nom:"),IO.setString("\nVotre Prenom:"));
                              System.out.print("\nVeuillez saisir vos Informations de votre Compte ci-dessus\n");
                              Account a1=new Account(IO.setINT("\nDefinir id compte :"),IO.setString("\nDefinir Le numero de compte :"),0,c1);
                              break;
                      }
                  }

                } while (connection(username, userverify) && connection(password, passverify));

                System.out.print("\n\n*******W E L C O M E*******\n\n");
                System.out.print("\nBienvenue " + username + " sur votre compte\n");

                break;

        }
    }

    public static void main(String[] args) {
                Menu();
    }
}