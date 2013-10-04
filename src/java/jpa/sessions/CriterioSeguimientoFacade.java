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
import jpa.entities.CriterioSeguimiento;
import jpa.entities.CriterioSeguimiento_;
import jpa.entities.SeguimientoProductiva;

/**
 *
 * @author leoandresm
 */
@Stateless
public class CriterioSeguimientoFacade extends AbstractFacade<CriterioSeguimiento> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CriterioSeguimientoFacade() {
        super(CriterioSeguimiento.class);
    }
    
    
    public List<CriterioSeguimiento> findBySeguimiento(SeguimientoProductiva seguimiento) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<CriterioSeguimiento> cq = cb.createQuery(CriterioSeguimiento.class);
        Root<CriterioSeguimiento> criterio = cq.from(CriterioSeguimiento.class);
        cq.where(cb.equal(criterio.get(CriterioSeguimiento_.idSeguimientoProductiva), seguimiento));
        TypedQuery<CriterioSeguimiento> q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }
    
}
