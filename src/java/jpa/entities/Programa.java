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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "programa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programa.findAll", query = "SELECT p FROM Programa p"),
    @NamedQuery(name = "Programa.findByIdPrograma", query = "SELECT p FROM Programa p WHERE p.idPrograma = :idPrograma"),
    @NamedQuery(name = "Programa.findByVersion", query = "SELECT p FROM Programa p WHERE p.version = :version"),
    @NamedQuery(name = "Programa.findByDurPrgLec", query = "SELECT p FROM Programa p WHERE p.durPrgLec = :durPrgLec"),
    @NamedQuery(name = "Programa.findByDurPrgPrac", query = "SELECT p FROM Programa p WHERE p.durPrgPrac = :durPrgPrac"),
    @NamedQuery(name = "Programa.findByDuracionTotalProg", query = "SELECT p FROM Programa p WHERE p.duracionTotalProg = :duracionTotalProg"),
    @NamedQuery(name = "Programa.findByNomPrg", query = "SELECT p FROM Programa p WHERE p.nomPrg = :nomPrg"),
    @NamedQuery(name = "Programa.findByNumTotCom", query = "SELECT p FROM Programa p WHERE p.numTotCom = :numTotCom"),
    @NamedQuery(name = "Programa.findByNumTotResApr", query = "SELECT p FROM Programa p WHERE p.numTotResApr = :numTotResApr")})
public class Programa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_programa")
    private String idPrograma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private short version;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dur_prg_lec")
    private short durPrgLec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dur_prg_prac")
    private short durPrgPrac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "duracion_total_prog")
    private String duracionTotalProg;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "jus_prg")
    private String jusPrg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_prg")
    private String nomPrg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_tot_com")
    private short numTotCom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_tot_res_apr")
    private short numTotResApr;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "req_ing_prg")
    private String reqIngPrg;
    @JoinTable(name = "programa_version", joinColumns = {
        @JoinColumn(name = "id_programa", referencedColumnName = "id_programa")}, inverseJoinColumns = {
        @JoinColumn(name = "version_id_version", referencedColumnName = "id_version")})
    @ManyToMany
    private List<Version> versionList;
    @JoinTable(name = "programa_competencia", joinColumns = {
        @JoinColumn(name = "id_programa", referencedColumnName = "id_programa")}, inverseJoinColumns = {
        @JoinColumn(name = "id_competencia", referencedColumnName = "id_competencia")})
    @ManyToMany
    private List<Competencia> competenciaList;
    @JoinColumn(name = "id_centro_formacion", referencedColumnName = "id_centro_formacion")
    @ManyToOne(optional = false)
    private CentroFormacion idCentroFormacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrograma")
    private List<FichaCaracterizacion> fichaCaracterizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrograma")
    private List<Competencia> competenciaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrograma")
    private List<ProyectoFormativo> proyectoFormativoList;

    public Programa() {
    }

    public Programa(String idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Programa(String idPrograma, short version, short durPrgLec, short durPrgPrac, String duracionTotalProg, String jusPrg, String nomPrg, short numTotCom, short numTotResApr, String reqIngPrg) {
        this.idPrograma = idPrograma;
        this.version = version;
        this.durPrgLec = durPrgLec;
        this.durPrgPrac = durPrgPrac;
        this.duracionTotalProg = duracionTotalProg;
        this.jusPrg = jusPrg;
        this.nomPrg = nomPrg;
        this.numTotCom = numTotCom;
        this.numTotResApr = numTotResApr;
        this.reqIngPrg = reqIngPrg;
    }

    public String getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(String idPrograma) {
        this.idPrograma = idPrograma;
    }

    public short getVersion() {
        return version;
    }

    public void setVersion(short version) {
        this.version = version;
    }

    public short getDurPrgLec() {
        return durPrgLec;
    }

    public void setDurPrgLec(short durPrgLec) {
        this.durPrgLec = durPrgLec;
    }

    public short getDurPrgPrac() {
        return durPrgPrac;
    }

    public void setDurPrgPrac(short durPrgPrac) {
        this.durPrgPrac = durPrgPrac;
    }

    public String getDuracionTotalProg() {
        return duracionTotalProg;
    }

    public void setDuracionTotalProg(String duracionTotalProg) {
        this.duracionTotalProg = duracionTotalProg;
    }

    public String getJusPrg() {
        return jusPrg;
    }

    public void setJusPrg(String jusPrg) {
        this.jusPrg = jusPrg;
    }

    public String getNomPrg() {
        return nomPrg;
    }

    public void setNomPrg(String nomPrg) {
        this.nomPrg = nomPrg;
    }

    public short getNumTotCom() {
        return numTotCom;
    }

    public void setNumTotCom(short numTotCom) {
        this.numTotCom = numTotCom;
    }

    public short getNumTotResApr() {
        return numTotResApr;
    }

    public void setNumTotResApr(short numTotResApr) {
        this.numTotResApr = numTotResApr;
    }

    public String getReqIngPrg() {
        return reqIngPrg;
    }

    public void setReqIngPrg(String reqIngPrg) {
        this.reqIngPrg = reqIngPrg;
    }

    @XmlTransient
    public List<Version> getVersionList() {
        return versionList;
    }

    public void setVersionList(List<Version> versionList) {
        this.versionList = versionList;
    }

    @XmlTransient
    public List<Competencia> getCompetenciaList() {
        return competenciaList;
    }

    public void setCompetenciaList(List<Competencia> competenciaList) {
        this.competenciaList = competenciaList;
    }

    public CentroFormacion getIdCentroFormacion() {
        return idCentroFormacion;
    }

    public void setIdCentroFormacion(CentroFormacion idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    @XmlTransient
    public List<FichaCaracterizacion> getFichaCaracterizacionList() {
        return fichaCaracterizacionList;
    }

    public void setFichaCaracterizacionList(List<FichaCaracterizacion> fichaCaracterizacionList) {
        this.fichaCaracterizacionList = fichaCaracterizacionList;
    }

    @XmlTransient
    public List<Competencia> getCompetenciaList1() {
        return competenciaList1;
    }

    public void setCompetenciaList1(List<Competencia> competenciaList1) {
        this.competenciaList1 = competenciaList1;
    }

    @XmlTransient
    public List<ProyectoFormativo> getProyectoFormativoList() {
        return proyectoFormativoList;
    }

    public void setProyectoFormativoList(List<ProyectoFormativo> proyectoFormativoList) {
        this.proyectoFormativoList = proyectoFormativoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrograma != null ? idPrograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.idPrograma == null && other.idPrograma != null) || (this.idPrograma != null && !this.idPrograma.equals(other.idPrograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Programa[ idPrograma=" + idPrograma + " ]";
    }
    
}
