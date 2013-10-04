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
import jpa.entities.AspiranteFicha;
import jpa.entities.AspiranteFicha_;
import jpa.entities.EstadoAspirante;
import jpa.entities.FichaCaracterizacion;
import jpa.entities.FichaCaracterizacion_;
import jpa.entities.NivelFormacion;
import jpa.entities.TipoFormacion;

/**
 *
 * @author ADSI
 */
@Stateless
public class AspiranteFichaFacade extends AbstractFacade<AspiranteFicha> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AspiranteFichaFacade() {
        super(AspiranteFicha.class);
    }
    
      public List<AspiranteFicha> findByFichasEstados(FichaCaracterizacion ficha, EstadoAspirante estado) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<AspiranteFicha> cq = cb.createQuery(AspiranteFicha.class);
        Root<AspiranteFicha> aspirante = cq.from(AspiranteFicha.class);
        cq.where(cb.and(cb.equal(aspirante.get(AspiranteFicha_.fichaCaracterizacion), ficha), cb.equal(aspirante.get(AspiranteFicha_.estadoAspirante), estado)));
        TypedQuery<AspiranteFicha> q = getEntityManager().createQuery(cq);
        List<AspiranteFicha> results = q.getResultList();
        return results;
    }
      
      public List<AspiranteFicha> findByNivelEstados(NivelFormacion nivel, EstadoAspirante estado, TipoFormacion tipo) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<AspiranteFicha> cq = cb.createQuery(AspiranteFicha.class);
        Root<AspiranteFicha> aspirante = cq.from(AspiranteFicha.class);
        Join<AspiranteFicha, FichaCaracterizacion> join = aspirante.join(AspiranteFicha_.fichaCaracterizacion);
        cq.where(cb.and(
                cb.equal(join.get(FichaCaracterizacion_.idNivelFormacion), nivel), 
                cb.equal(aspirante.get(AspiranteFicha_.estadoAspirante), estado),
                cb.equal(join.get(FichaCaracterizacion_.idTipoFormacion), tipo)));
        TypedQuery<AspiranteFicha> q = getEntityManager().createQuery(cq);
        List<AspiranteFicha> results = q.getResultList();
        return results;
    }
    
}
