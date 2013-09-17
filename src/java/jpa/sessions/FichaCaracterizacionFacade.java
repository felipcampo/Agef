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
import jpa.entities.FichaCaracterizacion;
import jpa.entities.FichaCaracterizacion_;
import jpa.entities.Programa;


/**
 *
 * @author leoandresm
 */
@Stateless
public class FichaCaracterizacionFacade extends AbstractFacade<FichaCaracterizacion> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FichaCaracterizacionFacade() {
        super(FichaCaracterizacion.class);
    }
    
public List<FichaCaracterizacion> findByPrograma(Programa programa) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<FichaCaracterizacion> cq = cb.createQuery(FichaCaracterizacion.class);
        Root<FichaCaracterizacion> ficha = cq.from(FichaCaracterizacion.class);
        cq.where(cb.equal(ficha.get(FichaCaracterizacion_.idPrograma), programa));
        TypedQuery<FichaCaracterizacion> q = getEntityManager().createQuery(cq);        
        return q.getResultList();
    }

}
