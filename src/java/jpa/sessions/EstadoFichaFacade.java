/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.EstadoFicha;

/**
 *
 * @author leoandresm
 */
@Stateless
public class EstadoFichaFacade extends AbstractFacade<EstadoFicha> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoFichaFacade() {
        super(EstadoFicha.class);
    }
    
}
