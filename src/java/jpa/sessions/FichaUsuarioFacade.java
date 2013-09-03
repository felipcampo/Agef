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
import jpa.entities.EstadoAprendiz;
import jpa.entities.FichaCaracterizacion;
import jpa.entities.FichaUsuario;
import jpa.entities.FichaUsuario_;
import jpa.entities.Usuario;
import jpa.entities.Usuario_;

/**
 *
 * @author leoandresm
 */
@Stateless
public class FichaUsuarioFacade extends AbstractFacade<FichaUsuario> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FichaUsuarioFacade() {
        super(FichaUsuario.class);
    }
    
     public List<FichaUsuario> findByEstado(EstadoAprendiz estado, FichaCaracterizacion ficha) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<FichaUsuario> cq = cb.createQuery(FichaUsuario.class);
        Root<FichaUsuario> fichaUsuario = cq.from(FichaUsuario.class);        
        cq.where(cb.and(cb.equal(fichaUsuario.get(FichaUsuario_.fichaCaracterizacion), ficha), 
                (cb.equal(fichaUsuario.get(FichaUsuario_.idEstadoAprendiz), estado))));
        TypedQuery<FichaUsuario> q = getEntityManager().createQuery(cq);
        List<FichaUsuario> results = q.getResultList();
        return results;
    }
}
