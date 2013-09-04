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
import jpa.entities.SeguimientoProyecto;
import jpa.entities.Usuario;

/**
 *
 * @author leoandresm
 */
@Stateless
public class SeguimientoProyectoFacade extends AbstractFacade<SeguimientoProyecto> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeguimientoProyectoFacade() {
        super(SeguimientoProyecto.class);
    }
    
}
