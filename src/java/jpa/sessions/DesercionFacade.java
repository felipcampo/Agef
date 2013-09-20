/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Desercion;

/**
 *
 * @author ADSI
 */
@Stateless
public class DesercionFacade extends AbstractFacade<Desercion> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DesercionFacade() {
        super(Desercion.class);
    }
    
}