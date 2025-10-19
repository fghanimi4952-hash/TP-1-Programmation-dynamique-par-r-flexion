package metier;

import dao.IDao;

// Classe qui implémente l'interface IMetier.
// Elle dépend de IDao pour récupérer une valeur et effectuer un calcul.
public class MetierImpl implements IMetier {
    // Référence vers un objet de type IDao (dépendance)
    private IDao dao;

    // Méthode "setter" utilisée pour injecter la dépendance (le DAO)
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    // Implémentation de la méthode calcul()
    @Override
    public double calcul() {
        // Récupère la valeur depuis le DAO et la multiplie par 2
        return dao.getValue() * 2;
    }
}
