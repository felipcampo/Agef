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
@Table(name = "guia_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GuiaAprendizaje.findAll", query = "SELECT g FROM GuiaAprendizaje g"),
    @NamedQuery(name = "GuiaAprendizaje.findByIdGuiaAprendizaje", query = "SELECT g FROM GuiaAprendizaje g WHERE g.idGuiaAprendizaje = :idGuiaAprendizaje"),
    @NamedQuery(name = "GuiaAprendizaje.findByGlosario", query = "SELECT g FROM GuiaAprendizaje g WHERE g.glosario = :glosario")})
public class GuiaAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_guia_aprendizaje")
    private Integer idGuiaAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "introduccion_guia")
    private String introduccionGuia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "actividad_reflexion_inicial")
    private String actividadReflexionInicial;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "actividad_contextualizacion")
    private String actividadContextualizacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "actividad_apropiacion_pro")
    private String actividadApropiacionPro;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "actividad_transferencia_conoci")
    private String actividadTransferenciaConoci;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "bibliografia")
    private String bibliografia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "glosario")
    private String glosario;
    @JoinTable(name = "alistamiento_guia_aprendizaje", joinColumns = {
        @JoinColumn(name = "id_guia_aprendizaje", referencedColumnName = "id_guia_aprendizaje")}, inverseJoinColumns = {
        @JoinColumn(name = "id_alistamiento", referencedColumnName = "id_alistamiento")})
    @ManyToMany
    private List<Alistamiento> alistamientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGuiaAprendizaje")
    private List<EvaluacionSeguimiento> evaluacionSeguimientoList;
    @JoinColumn(name = "id_proyecto_formativo", referencedColumnName = "id_proyecto_formativo")
    @ManyToOne(optional = false)
    private ProyectoFormativo idProyectoFormativo;
    @JoinColumn(name = "id_ambiente", referencedColumnName = "id_ambiente")
    @ManyToOne(optional = false)
    private Ambiente idAmbiente;
    @JoinColumn(name = "id_actividad_proyecto", referencedColumnName = "id_actividad_proyecto")
    @ManyToOne(optional = false)
    private ActividadProyecto idActividadProyecto;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne(optional = false)
    private FichaCaracterizacion idFichaCaracterizacion;
    @OneToMany(mappedBy = "idGuiaAprendizaje")
    private List<Alistamiento> alistamientoList1;

    public GuiaAprendizaje() {
    }

    public GuiaAprendizaje(Integer idGuiaAprendizaje) {
        this.idGuiaAprendizaje = idGuiaAprendizaje;
    }

    public GuiaAprendizaje(Integer idGuiaAprendizaje, String introduccionGuia, String actividadReflexionInicial, String actividadContextualizacion, String actividadApropiacionPro, String actividadTransferenciaConoci, String bibliografia, String glosario) {
        this.idGuiaAprendizaje = idGuiaAprendizaje;
        this.introduccionGuia = introduccionGuia;
        this.actividadReflexionInicial = actividadReflexionInicial;
        this.actividadContextualizacion = actividadContextualizacion;
        this.actividadApropiacionPro = actividadApropiacionPro;
        this.actividadTransferenciaConoci = actividadTransferenciaConoci;
        this.bibliografia = bibliografia;
        this.glosario = glosario;
    }

    public Integer getIdGuiaAprendizaje() {
        return idGuiaAprendizaje;
    }

    public void setIdGuiaAprendizaje(Integer idGuiaAprendizaje) {
        this.idGuiaAprendizaje = idGuiaAprendizaje;
    }

    public String getIntroduccionGuia() {
        return introduccionGuia;
    }

    public void setIntroduccionGuia(String introduccionGuia) {
        this.introduccionGuia = introduccionGuia;
    }

    public String getActividadReflexionInicial() {
        return actividadReflexionInicial;
    }

    public void setActividadReflexionInicial(String actividadReflexionInicial) {
        this.actividadReflexionInicial = actividadReflexionInicial;
    }

    public String getActividadContextualizacion() {
        return actividadContextualizacion;
    }

    public void setActividadContextualizacion(String actividadContextualizacion) {
        this.actividadContextualizacion = actividadContextualizacion;
    }

    public String getActividadApropiacionPro() {
        return actividadApropiacionPro;
    }

    public void setActividadApropiacionPro(String actividadApropiacionPro) {
        this.actividadApropiacionPro = actividadApropiacionPro;
    }

    public String getActividadTransferenciaConoci() {
        return actividadTransferenciaConoci;
    }

    public void setActividadTransferenciaConoci(String actividadTransferenciaConoci) {
        this.actividadTransferenciaConoci = actividadTransferenciaConoci;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    public String getGlosario() {
        return glosario;
    }

    public void setGlosario(String glosario) {
        this.glosario = glosario;
    }

    @XmlTransient
    public List<Alistamiento> getAlistamientoList() {
        return alistamientoList;
    }

    public void setAlistamientoList(List<Alistamiento> alistamientoList) {
        this.alistamientoList = alistamientoList;
    }

    @XmlTransient
    public List<EvaluacionSeguimiento> getEvaluacionSeguimientoList() {
        return evaluacionSeguimientoList;
    }

    public void setEvaluacionSeguimientoList(List<EvaluacionSeguimiento> evaluacionSeguimientoList) {
        this.evaluacionSeguimientoList = evaluacionSeguimientoList;
    }

    public ProyectoFormativo getIdProyectoFormativo() {
        return idProyectoFormativo;
    }

    public void setIdProyectoFormativo(ProyectoFormativo idProyectoFormativo) {
        this.idProyectoFormativo = idProyectoFormativo;
    }

    public Ambiente getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Ambiente idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public ActividadProyecto getIdActividadProyecto() {
        return idActividadProyecto;
    }

    public void setIdActividadProyecto(ActividadProyecto idActividadProyecto) {
        this.idActividadProyecto = idActividadProyecto;
    }

    public FichaCaracterizacion getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(FichaCaracterizacion idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    @XmlTransient
    public List<Alistamiento> getAlistamientoList1() {
        return alistamientoList1;
    }

    public void setAlistamientoList1(List<Alistamiento> alistamientoList1) {
        this.alistamientoList1 = alistamientoList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGuiaAprendizaje != null ? idGuiaAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaAprendizaje)) {
            return false;
        }
        GuiaAprendizaje other = (GuiaAprendizaje) object;
        if ((this.idGuiaAprendizaje == null && other.idGuiaAprendizaje != null) || (this.idGuiaAprendizaje != null && !this.idGuiaAprendizaje.equals(other.idGuiaAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.GuiaAprendizaje[ idGuiaAprendizaje=" + idGuiaAprendizaje + " ]";
    }
    
}
