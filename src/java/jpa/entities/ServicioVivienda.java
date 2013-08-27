/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "servicio_vivienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicioVivienda.findAll", query = "SELECT s FROM ServicioVivienda s"),
    @NamedQuery(name = "ServicioVivienda.findByIdServicioVivienda", query = "SELECT s FROM ServicioVivienda s WHERE s.idServicioVivienda = :idServicioVivienda"),
    @NamedQuery(name = "ServicioVivienda.findByDescrServicioVivienda", query = "SELECT s FROM ServicioVivienda s WHERE s.descrServicioVivienda = :descrServicioVivienda")})
public class ServicioVivienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_servicio_vivienda")
    private Short idServicioVivienda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descr_servicio_vivienda")
    private String descrServicioVivienda;
    @JoinTable(name = "servicio_matriz", joinColumns = {
        @JoinColumn(name = "id_servicio_vivienda", referencedColumnName = "id_servicio_vivienda")}, inverseJoinColumns = {
        @JoinColumn(name = "id_matriz_caracterizacion", referencedColumnName = "id_matriz_caracterizacion")})
    @ManyToMany
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public ServicioVivienda() {
    }

    public ServicioVivienda(Short idServicioVivienda) {
        this.idServicioVivienda = idServicioVivienda;
    }

    public ServicioVivienda(Short idServicioVivienda, String descrServicioVivienda) {
        this.idServicioVivienda = idServicioVivienda;
        this.descrServicioVivienda = descrServicioVivienda;
    }

    public Short getIdServicioVivienda() {
        return idServicioVivienda;
    }

    public void setIdServicioVivienda(Short idServicioVivienda) {
        this.idServicioVivienda = idServicioVivienda;
    }

    public String getDescrServicioVivienda() {
        return descrServicioVivienda;
    }

    public void setDescrServicioVivienda(String descrServicioVivienda) {
        this.descrServicioVivienda = descrServicioVivienda;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList() {
        return matrizCaracterizacionList;
    }

    public void setMatrizCaracterizacionList(List<MatrizCaracterizacion> matrizCaracterizacionList) {
        this.matrizCaracterizacionList = matrizCaracterizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicioVivienda != null ? idServicioVivienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioVivienda)) {
            return false;
        }
        ServicioVivienda other = (ServicioVivienda) object;
        if ((this.idServicioVivienda == null && other.idServicioVivienda != null) || (this.idServicioVivienda != null && !this.idServicioVivienda.equals(other.idServicioVivienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ServicioVivienda[ idServicioVivienda=" + idServicioVivienda + " ]";
    }
    
}
