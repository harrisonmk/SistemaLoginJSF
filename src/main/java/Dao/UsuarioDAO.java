package Dao;

import modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class UsuarioDAO {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuarios");
    private EntityManager em = factory.createEntityManager();

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public Usuario getUsuario(String nomeUsuario, String senha) {

        try {
            Usuario usuario = (Usuario) em.createQuery("SELECT u from Usuario u where u.nomeUsuario = :name and u.senha = :senha").setParameter("name", nomeUsuario).setParameter("senha", senha).getSingleResult();

            return usuario;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean inserirUsuario(Usuario usuario) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
            
        }

    }

    public boolean deletarUsuario(Usuario usuario) {
        try {
            em.remove(usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
