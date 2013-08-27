/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.CriterioEvaluacion;

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
    
}
