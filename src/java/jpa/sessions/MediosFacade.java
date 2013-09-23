/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Medios;

/**
 *
 * @author ADSI
 */
@Stateless
public class MediosFacade extends AbstractFacade<Medios> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MediosFacade() {
        super(Medios.class);
    }
    
}
