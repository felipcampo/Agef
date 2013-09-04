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
import jpa.entities.Regional;

/**
 *
 * @author leoandresm
 */
@Stateless
public class CentroFormacionFacade extends AbstractFacade<CentroFormacion> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CentroFormacionFacade() {
        super(CentroFormacion.class);
    }
    
     public List<CentroFormacion> findByRegional(Regional regional) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<CentroFormacion> cq = cb.createQuery(CentroFormacion.class);
        Root<CentroFormacion> centro = cq.from(CentroFormacion.class);
        cq.where(cb.equal(centro.get(CentroFormacion_.idRegional), regional));
        TypedQuery<CentroFormacion> q = getEntityManager().createQuery(cq);        
        return q.getResultList();
    }
    
}
