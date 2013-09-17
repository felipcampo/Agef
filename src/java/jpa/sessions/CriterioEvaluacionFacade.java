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
import jpa.entities.CriterioEvaluacion;
import jpa.entities.CriterioEvaluacion_;
import jpa.entities.Regional;
import jpa.entities.TipoCriterio;

/**
 *
 * @author leoandresm
 */
@Stateless
public class CriterioEvaluacionFacade extends AbstractFacade<CriterioEvaluacion> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CriterioEvaluacionFacade() {
        super(CriterioEvaluacion.class);
    }
    
    public List<CriterioEvaluacion> findByTipo(TipoCriterio tipo) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<CriterioEvaluacion> cq = cb.createQuery(CriterioEvaluacion.class);
        Root<CriterioEvaluacion> criterio = cq.from(CriterioEvaluacion.class);
        cq.where(cb.equal(criterio.get(CriterioEvaluacion_.idTipoCriterio), tipo));
        TypedQuery<CriterioEvaluacion> q = getEntityManager().createQuery(cq);        
        return q.getResultList();
    }
    
}
