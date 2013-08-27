/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Remision;

/**
 *
 * @author leoandresm
 */
@Stateless
public class RemisionFacade extends AbstractFacade<Remision> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RemisionFacade() {
        super(Remision.class);
    }
    
}
