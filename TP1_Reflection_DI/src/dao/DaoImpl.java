package dao;

// Classe qui implémente l’interface IDao.
// Elle fournit une implémentation concrète de la méthode getValue().
public class DaoImpl implements IDao {
    @Override
    public double getValue() {
        // Retourne une valeur fixe (exemple : 100.0)
        // Dans une vraie application, cette valeur pourrait venir d'une base de données ou d'une API.
        return 100.0;
    }
}
