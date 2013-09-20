/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.EventoBienestar;

/**
 *
 * @author ADSI
 */
@Stateless
public class EventoBienestarFacade extends AbstractFacade<EventoBienestar> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventoBienestarFacade() {
        super(EventoBienestar.class);
    }
    
}
