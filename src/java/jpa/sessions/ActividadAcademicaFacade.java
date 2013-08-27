/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.ActividadAcademica;

/**
 *
 * @author leoandresm
 */
@Stateless
public class ActividadAcademicaFacade extends AbstractFacade<ActividadAcademica> {
    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadAcademicaFacade() {
        super(ActividadAcademica.class);
    }
    
}
