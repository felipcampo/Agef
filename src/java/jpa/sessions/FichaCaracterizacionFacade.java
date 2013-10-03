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
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import jpa.entities.FichaCaracterizacion;
import jpa.entities.FichaCaracterizacion_;
import jpa.entities.Programa;
import jpa.entities.Programa_;

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

    public List<FichaCaracterizacion> findByIdAndPrograma(FichaCaracterizacion ficha, Programa programa) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<FichaCaracterizacion> cq = cb.createQuery(FichaCaracterizacion.class);
        Root<FichaCaracterizacion> root = cq.from(FichaCaracterizacion.class);
        Join<FichaCaracterizacion, Programa> tirso = root.join(FichaCaracterizacion_.idPrograma);
        cq.where(cb.or(cb.equal(root.get(FichaCaracterizacion_.idFichaCaracterizacion), ficha.getIdFichaCaracterizacion()),
                cb.like(tirso.get(Programa_.nomPrg), "%" + programa.getNomPrg() + "%")));
        TypedQuery<FichaCaracterizacion> q = getEntityManager().createQuery(cq);
        List<FichaCaracterizacion> results = q.getResultList();
        return results;
    }
}
