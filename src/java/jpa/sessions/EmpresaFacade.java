/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.entities.Empresa;
import jpa.entities.Empresa_;


/**
 *
 * @author leoandresm
 */
@Stateless
public class EmpresaFacade extends AbstractFacade<Empresa> {

    @PersistenceContext(unitName = "AgefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpresaFacade() {
        super(Empresa.class);
    }

    public List<Empresa> findEmpresa(Empresa empresa) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Empresa> cq = cb.createQuery(Empresa.class);
        Root<Empresa> u = cq.from(Empresa.class);
        cq.where(cb.or(
                cb.equal(u.get(Empresa_.idEmpresa), empresa.getIdEmpresa()),
                cb.like(u.get(Empresa_.razonSocialEmp), "%" + empresa.getRazonSocialEmp() + "%")));
        TypedQuery<Empresa> q = getEntityManager().createQuery(cq);
        List<Empresa> results = q.getResultList();
        return results;
    }
}
