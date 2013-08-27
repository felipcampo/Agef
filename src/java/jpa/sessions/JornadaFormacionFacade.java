/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.JornadaFormacion;

/**
 *
 * @author leoandresm
 */
@Stateless
public class JornadaFormacionFacade extends AbstractFacade<JornadaFormacion> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JornadaFormacionFacade() {
        super(JornadaFormacion.class);
    }
    
}
