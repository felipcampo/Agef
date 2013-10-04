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
import jpa.entities.EstadoAprendiz;
import jpa.entities.EstadoAspirante;
import jpa.entities.FichaCaracterizacion;
import jpa.entities.FichaCaracterizacion_;
import jpa.entities.FichaUsuario;
import jpa.entities.FichaUsuario_;
import jpa.entities.NivelFormacion;
import jpa.entities.TipoFormacion;

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
    
    
     public List<FichaUsuario> findByEstado(FichaCaracterizacion ficha, EstadoAprendiz estado) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<FichaUsuario> cq = cb.createQuery(FichaUsuario.class);
        Root<FichaUsuario> fichaUsuario = cq.from(FichaUsuario.class);        
        cq.where(cb.and(cb.equal(fichaUsuario.get(FichaUsuario_.fichaCaracterizacion), ficha), 
                cb.equal(fichaUsuario.get(FichaUsuario_.idEstadoAprendiz), estado)));
        TypedQuery<FichaUsuario> q = getEntityManager().createQuery(cq);
        List<FichaUsuario> results = q.getResultList();
        return results;
    }
           public List<FichaUsuario> findByNivelEstados(NivelFormacion nivel, EstadoAprendiz estado, TipoFormacion tipo) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<FichaUsuario> cq = cb.createQuery(FichaUsuario.class);
        Root<FichaUsuario> aspirante = cq.from(FichaUsuario.class);
        Join<FichaUsuario, FichaCaracterizacion> join = aspirante.join(FichaUsuario_.fichaCaracterizacion);
        cq.where(cb.and(
                cb.equal(join.get(FichaCaracterizacion_.idNivelFormacion), nivel), 
                cb.equal(aspirante.get(FichaUsuario_.idEstadoAprendiz), estado),
                cb.equal(join.get(FichaCaracterizacion_.idTipoFormacion), tipo)));
        TypedQuery<FichaUsuario> q = getEntityManager().createQuery(cq);
        List<FichaUsuario> results = q.getResultList();
        return results;
    }
           
   public List<FichaUsuario> findByTipoEstados(EstadoAprendiz estado, TipoFormacion tipo) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<FichaUsuario> cq = cb.createQuery(FichaUsuario.class);
        Root<FichaUsuario> aspirante = cq.from(FichaUsuario.class);
        Join<FichaUsuario, FichaCaracterizacion> join = aspirante.join(FichaUsuario_.fichaCaracterizacion);
        cq.where(cb.and( 
                cb.equal(aspirante.get(FichaUsuario_.idEstadoAprendiz), estado),
                cb.equal(join.get(FichaCaracterizacion_.idTipoFormacion), tipo)));
        TypedQuery<FichaUsuario> q = getEntityManager().createQuery(cq);
        List<FichaUsuario> results = q.getResultList();
        return results;
    }

    public List<FichaUsuario> findByEstado(EstadoAprendiz estado, FichaCaracterizacion idFichaCaracterizacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Number findByNivelEstados(NivelFormacion nivelFormacion, EstadoAspirante estadoAspirante, TipoFormacion tipoFormacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}