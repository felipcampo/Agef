/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.entities.CentroFormacion;
import jpa.entities.CentroFormacion_;
import jpa.entities.Usuario;
import jpa.entities.Usuario_;

/**
 *
 * @author leoandresm
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
       
public List<Usuario> findUsuario(Usuario usuario){
CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
        Root<Usuario> u = cq.from(Usuario.class);
        cq.where(cb.or(                
                cb.equal(u.get(Usuario_.numeroDocumento), usuario.getNumeroDocumento()),
                cb.equal(u.get(Usuario_.nomUsu), usuario.getNomUsu()),
                cb.equal(u.get(Usuario_.apeUsu), usuario.getApeUsu())
                ));
        TypedQuery<Usuario> q = getEntityManager().createQuery(cq);        
        return q.getResultList();
}

}
