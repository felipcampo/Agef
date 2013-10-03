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
 * @author ADSI
 */
@Entity
@Table(name = "ambiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ambiente.findAll", query = "SELECT a FROM Ambiente a"),
    @NamedQuery(name = "Ambiente.findByIdAmbiente", query = "SELECT a FROM Ambiente a WHERE a.idAmbiente = :idAmbiente"),
    @NamedQuery(name = "Ambiente.findByDescrNomAmb", query = "SELECT a FROM Ambiente a WHERE a.descrNomAmb = :descrNomAmb"),
    @NamedQuery(name = "Ambiente.findByTipoAmbiente", query = "SELECT a FROM Ambiente a WHERE a.tipoAmbiente = :tipoAmbiente")})
public class Ambiente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ambiente")
    private Short idAmbiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descr_nom_amb")
    private String descrNomAmb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_ambiente")
    private char tipoAmbiente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAmbiente")
    private List<GuiaAprendizaje> guiaAprendizajeList;

    public Ambiente() {
    }

    public Ambiente(Short idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public Ambiente(Short idAmbiente, String descrNomAmb, char tipoAmbiente) {
        this.idAmbiente = idAmbiente;
        this.descrNomAmb = descrNomAmb;
        this.tipoAmbiente = tipoAmbiente;
    }

    public Short getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Short idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public String getDescrNomAmb() {
        return descrNomAmb;
    }

    public void setDescrNomAmb(String descrNomAmb) {
        this.descrNomAmb = descrNomAmb;
    }

    public char getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(char tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }

    @XmlTransient
    public List<GuiaAprendizaje> getGuiaAprendizajeList() {
        return guiaAprendizajeList;
    }

    public void setGuiaAprendizajeList(List<GuiaAprendizaje> guiaAprendizajeList) {
        this.guiaAprendizajeList = guiaAprendizajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAmbiente != null ? idAmbiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ambiente)) {
            return false;
        }
        Ambiente other = (Ambiente) object;
        if ((this.idAmbiente == null && other.idAmbiente != null) || (this.idAmbiente != null && !this.idAmbiente.equals(other.idAmbiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Ambiente[ idAmbiente=" + idAmbiente + " ]";
    }
    
}
