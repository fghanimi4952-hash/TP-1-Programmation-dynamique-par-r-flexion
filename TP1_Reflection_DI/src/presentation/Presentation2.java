package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

// Classe principale de l'application (point d'entrée).
// Elle utilise la "réflexion" pour charger dynamiquement les classes
// et effectuer l'injection de dépendances.
public class Presentation2 {
    public static void main(String[] args) throws Exception {

        // Lecture du fichier de configuration "config.txt"
        // Ce fichier contient les noms des classes à charger
        Scanner scanner = new Scanner(new File("config.txt"));
        String daoClassName = scanner.nextLine().trim();     // Exemple : dao.DaoImpl
        String metierClassName = scanner.nextLine().trim();  // Exemple : metier.MetierImpl

        // Chargement dynamique de la classe DAO avec la réflexion
        Class<?> cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();

        // Chargement dynamique de la classe Metier avec la réflexion
        Class<?> cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();

        // Injection du DAO dans le Metier à l'aide de la méthode setDao()
        Method setDaoMethod = cMetier.getMethod("setDao", dao.IDao.class);
        setDaoMethod.invoke(metier, dao);

        // Exécution de la méthode calcul() et affichage du résultat
        System.out.println("Résultat = " + metier.calcul());

        // Fermeture du scanner
        scanner.close();
    }
}
