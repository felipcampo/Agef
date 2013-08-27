/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.FichaCaracterizacion;

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
    
}
