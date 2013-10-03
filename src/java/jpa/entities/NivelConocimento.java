/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MAURICIO
 */
@Entity
@Table(name = "nivel_conocimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelConocimento.findAll", query = "SELECT n FROM NivelConocimento n"),
    @NamedQuery(name = "NivelConocimento.findByIdNivelConocimento", query = "SELECT n FROM NivelConocimento n WHERE n.idNivelConocimento = :idNivelConocimento"),
    @NamedQuery(name = "NivelConocimento.findByDescrNivelConocimento", query = "SELECT n FROM NivelConocimento n WHERE n.descrNivelConocimento = :descrNivelConocimento")})
public class NivelConocimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nivel_conocimento")
    private Short idNivelConocimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "descr_nivel_conocimento")
    private String descrNivelConocimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelConocimentoInformatica")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelConocimentoIngles")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelConocimentoInformatica")
    private List<MatrizCaracterizacion> matrizCaracterizacionList1;

    public NivelConocimento() {
    }

    public NivelConocimento(Short idNivelConocimento) {
        this.idNivelConocimento = idNivelConocimento;
    }

    public NivelConocimento(Short idNivelConocimento, String descrNivelConocimento) {
        this.idNivelConocimento = idNivelConocimento;
        this.descrNivelConocimento = descrNivelConocimento;
    }

    public Short getIdNivelConocimento() {
        return idNivelConocimento;
    }

    public void setIdNivelConocimento(Short idNivelConocimento) {
        this.idNivelConocimento = idNivelConocimento;
    }

    public String getDescrNivelConocimento() {
        return descrNivelConocimento;
    }

    public void setDescrNivelConocimento(String descrNivelConocimento) {
        this.descrNivelConocimento = descrNivelConocimento;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList() {
        return matrizCaracterizacionList;
    }

    public void setMatrizCaracterizacionList(List<MatrizCaracterizacion> matrizCaracterizacionList) {
        this.matrizCaracterizacionList = matrizCaracterizacionList;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList1() {
        return matrizCaracterizacionList1;
    }

    public void setMatrizCaracterizacionList1(List<MatrizCaracterizacion> matrizCaracterizacionList1) {
        this.matrizCaracterizacionList1 = matrizCaracterizacionList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelConocimento != null ? idNivelConocimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelConocimento)) {
            return false;
        }
        NivelConocimento other = (NivelConocimento) object;
        if ((this.idNivelConocimento == null && other.idNivelConocimento != null) || (this.idNivelConocimento != null && !this.idNivelConocimento.equals(other.idNivelConocimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.NivelConocimento[ idNivelConocimento=" + idNivelConocimento + " ]";
    }
    
}
