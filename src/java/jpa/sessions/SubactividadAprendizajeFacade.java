/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.SubactividadAprendizaje;

/**
 *
 * @author ADSI
 */
@Stateless
public class SubactividadAprendizajeFacade extends AbstractFacade<SubactividadAprendizaje> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubactividadAprendizajeFacade() {
        super(SubactividadAprendizaje.class);
    }
    
}
