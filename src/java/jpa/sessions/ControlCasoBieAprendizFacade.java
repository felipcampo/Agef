/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ControlCasoBieAprendiz;

/**
 *
 * @author leoandresm
 */
@Stateless
public class ControlCasoBieAprendizFacade extends AbstractFacade<ControlCasoBieAprendiz> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ControlCasoBieAprendizFacade() {
        super(ControlCasoBieAprendiz.class);
    }
    
}
