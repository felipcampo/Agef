/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.TipoFormacion;

/**
 *
 * @author leoandresm
 */
@Stateless
public class TipoFormacionFacade extends AbstractFacade<TipoFormacion> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoFormacionFacade() {
        super(TipoFormacion.class);
    }
    
}
