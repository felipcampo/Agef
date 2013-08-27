/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "ficha_caracterizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FichaCaracterizacion.findAll", query = "SELECT f FROM FichaCaracterizacion f"),
    @NamedQuery(name = "FichaCaracterizacion.findByIdFichaCaracterizacion", query = "SELECT f FROM FichaCaracterizacion f WHERE f.idFichaCaracterizacion = :idFichaCaracterizacion"),
    @NamedQuery(name = "FichaCaracterizacion.findByFecIniEtaLec", query = "SELECT f FROM FichaCaracterizacion f WHERE f.fecIniEtaLec = :fecIniEtaLec"),
    @NamedQuery(name = "FichaCaracterizacion.findByFecFinEtaLec", query = "SELECT f FROM FichaCaracterizacion f WHERE f.fecFinEtaLec = :fecFinEtaLec"),
    @NamedQuery(name = "FichaCaracterizacion.findByFecIniEtaPro", query = "SELECT f FROM FichaCaracterizacion f WHERE f.fecIniEtaPro = :fecIniEtaPro"),
    @NamedQuery(name = "FichaCaracterizacion.findByFecFinEtaPro", query = "SELECT f FROM FichaCaracterizacion f WHERE f.fecFinEtaPro = :fecFinEtaPro"),
    @NamedQuery(name = "FichaCaracterizacion.findByNumCupFic", query = "SELECT f FROM FichaCaracterizacion f WHERE f.numCupFic = :numCupFic"),
    @NamedQuery(name = "FichaCaracterizacion.findByNumCupIns", query = "SELECT f FROM FichaCaracterizacion f WHERE f.numCupIns = :numCupIns")})
public class FichaCaracterizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ficha_caracterizacion")
    private Integer idFichaCaracterizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ini_eta_lec")
    @Temporal(TemporalType.DATE)
    private Date fecIniEtaLec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_fin_eta_lec")
    @Temporal(TemporalType.DATE)
    private Date fecFinEtaLec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ini_eta_pro")
    @Temporal(TemporalType.DATE)
    private Date fecIniEtaPro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_fin_eta_pro")
    @Temporal(TemporalType.DATE)
    private Date fecFinEtaPro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_cup_fic")
    private int numCupFic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_cup_ins")
    private int numCupIns;
    @JoinTable(name = "ficha_estado", joinColumns = {
        @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")}, inverseJoinColumns = {
        @JoinColumn(name = "id_estado_ficha", referencedColumnName = "id_estado_ficha")})
    @ManyToMany
    private List<EstadoFicha> estadoFichaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichaCaracterizacion")
    private List<FichaUsuario> fichaUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaCaracterizacion")
    private List<EvaluacionSeguimiento> evaluacionSeguimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaCaracterizacion")
    private List<ReporteNovedad> reporteNovedadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaCaracterizacion")
    private List<PlaneacionClase> planeacionClaseList;
    @JoinColumn(name = "id_proyecto_formativo", referencedColumnName = "id_proyecto_formativo")
    @ManyToOne(optional = false)
    private ProyectoFormativo idProyectoFormativo;
    @JoinColumn(name = "id_sede_centro", referencedColumnName = "id_sede_centro")
    @ManyToOne(optional = false)
    private SedeCentro idSedeCentro;
    @JoinColumn(name = "id_programa", referencedColumnName = "id_programa")
    @ManyToOne(optional = false)
    private Programa idPrograma;
    @JoinColumn(name = "id_tipo_formacion", referencedColumnName = "id_tipo_formacion")
    @ManyToOne(optional = false)
    private TipoFormacion idTipoFormacion;
    @JoinColumn(name = "id_nivel_formacion", referencedColumnName = "id_nivel_formacion")
    @ManyToOne(optional = false)
    private NivelFormacion idNivelFormacion;
    @JoinColumn(name = "id_tipo_oferta", referencedColumnName = "id_tipo_oferta")
    @ManyToOne(optional = false)
    private TipoOferta idTipoOferta;
    @JoinColumn(name = "id_jornada_formacion", referencedColumnName = "id_jornada_formacion")
    @ManyToOne(optional = false)
    private JornadaFormacion idJornadaFormacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaCaracterizacion")
    private List<GuiaAprendizaje> guiaAprendizajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaCaracterizacion")
    private List<PlanMejoramiento> planMejoramientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaCaracterizacion")
    private List<Comite> comiteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaCaracterizacion")
    private List<SeguimientoInstructor> seguimientoInstructorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaCaracterizacion")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaCaracterizacion")
    private List<LlamadoAtencionVerbal> llamadoAtencionVerbalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaCaracterizacion")
    private List<SeguimientoProductiva> seguimientoProductivaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaCaracterizacion")
    private List<Alistamiento> alistamientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFichaCaracterizacion")
    private List<ControlAsistencia> controlAsistenciaList;
    @OneToMany(mappedBy = "idFichaCaracterizacion")
    private List<SeguimientoProyecto> seguimientoProyectoList;

    public FichaCaracterizacion() {
    }

    public FichaCaracterizacion(Integer idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public FichaCaracterizacion(Integer idFichaCaracterizacion, Date fecIniEtaLec, Date fecFinEtaLec, Date fecIniEtaPro, Date fecFinEtaPro, int numCupFic, int numCupIns) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
        this.fecIniEtaLec = fecIniEtaLec;
        this.fecFinEtaLec = fecFinEtaLec;
        this.fecIniEtaPro = fecIniEtaPro;
        this.fecFinEtaPro = fecFinEtaPro;
        this.numCupFic = numCupFic;
        this.numCupIns = numCupIns;
    }

    public Integer getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(Integer idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public Date getFecIniEtaLec() {
        return fecIniEtaLec;
    }

    public void setFecIniEtaLec(Date fecIniEtaLec) {
        this.fecIniEtaLec = fecIniEtaLec;
    }

    public Date getFecFinEtaLec() {
        return fecFinEtaLec;
    }

    public void setFecFinEtaLec(Date fecFinEtaLec) {
        this.fecFinEtaLec = fecFinEtaLec;
    }

    public Date getFecIniEtaPro() {
        return fecIniEtaPro;
    }

    public void setFecIniEtaPro(Date fecIniEtaPro) {
        this.fecIniEtaPro = fecIniEtaPro;
    }

    public Date getFecFinEtaPro() {
        return fecFinEtaPro;
    }

    public void setFecFinEtaPro(Date fecFinEtaPro) {
        this.fecFinEtaPro = fecFinEtaPro;
    }

    public int getNumCupFic() {
        return numCupFic;
    }

    public void setNumCupFic(int numCupFic) {
        this.numCupFic = numCupFic;
    }

    public int getNumCupIns() {
        return numCupIns;
    }

    public void setNumCupIns(int numCupIns) {
        this.numCupIns = numCupIns;
    }

    @XmlTransient
    public List<EstadoFicha> getEstadoFichaList() {
        return estadoFichaList;
    }

    public void setEstadoFichaList(List<EstadoFicha> estadoFichaList) {
        this.estadoFichaList = estadoFichaList;
    }

    @XmlTransient
    public List<FichaUsuario> getFichaUsuarioList() {
        return fichaUsuarioList;
    }

    public void setFichaUsuarioList(List<FichaUsuario> fichaUsuarioList) {
        this.fichaUsuarioList = fichaUsuarioList;
    }

    @XmlTransient
    public List<EvaluacionSeguimiento> getEvaluacionSeguimientoList() {
        return evaluacionSeguimientoList;
    }

    public void setEvaluacionSeguimientoList(List<EvaluacionSeguimiento> evaluacionSeguimientoList) {
        this.evaluacionSeguimientoList = evaluacionSeguimientoList;
    }

    @XmlTransient
    public List<ReporteNovedad> getReporteNovedadList() {
        return reporteNovedadList;
    }

    public void setReporteNovedadList(List<ReporteNovedad> reporteNovedadList) {
        this.reporteNovedadList = reporteNovedadList;
    }

    @XmlTransient
    public List<PlaneacionClase> getPlaneacionClaseList() {
        return planeacionClaseList;
    }

    public void setPlaneacionClaseList(List<PlaneacionClase> planeacionClaseList) {
        this.planeacionClaseList = planeacionClaseList;
    }

    public ProyectoFormativo getIdProyectoFormativo() {
        return idProyectoFormativo;
    }

    public void setIdProyectoFormativo(ProyectoFormativo idProyectoFormativo) {
        this.idProyectoFormativo = idProyectoFormativo;
    }

    public SedeCentro getIdSedeCentro() {
        return idSedeCentro;
    }

    public void setIdSedeCentro(SedeCentro idSedeCentro) {
        this.idSedeCentro = idSedeCentro;
    }

    public Programa getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Programa idPrograma) {
        this.idPrograma = idPrograma;
    }

    public TipoFormacion getIdTipoFormacion() {
        return idTipoFormacion;
    }

    public void setIdTipoFormacion(TipoFormacion idTipoFormacion) {
        this.idTipoFormacion = idTipoFormacion;
    }

    public NivelFormacion getIdNivelFormacion() {
        return idNivelFormacion;
    }

    public void setIdNivelFormacion(NivelFormacion idNivelFormacion) {
        this.idNivelFormacion = idNivelFormacion;
    }

    public TipoOferta getIdTipoOferta() {
        return idTipoOferta;
    }

    public void setIdTipoOferta(TipoOferta idTipoOferta) {
        this.idTipoOferta = idTipoOferta;
    }

    public JornadaFormacion getIdJornadaFormacion() {
        return idJornadaFormacion;
    }

    public void setIdJornadaFormacion(JornadaFormacion idJornadaFormacion) {
        this.idJornadaFormacion = idJornadaFormacion;
    }

    @XmlTransient
    public List<GuiaAprendizaje> getGuiaAprendizajeList() {
        return guiaAprendizajeList;
    }

    public void setGuiaAprendizajeList(List<GuiaAprendizaje> guiaAprendizajeList) {
        this.guiaAprendizajeList = guiaAprendizajeList;
    }

    @XmlTransient
    public List<PlanMejoramiento> getPlanMejoramientoList() {
        return planMejoramientoList;
    }

    public void setPlanMejoramientoList(List<PlanMejoramiento> planMejoramientoList) {
        this.planMejoramientoList = planMejoramientoList;
    }

    @XmlTransient
    public List<Comite> getComiteList() {
        return comiteList;
    }

    public void setComiteList(List<Comite> comiteList) {
        this.comiteList = comiteList;
    }

    @XmlTransient
    public List<SeguimientoInstructor> getSeguimientoInstructorList() {
        return seguimientoInstructorList;
    }

    public void setSeguimientoInstructorList(List<SeguimientoInstructor> seguimientoInstructorList) {
        this.seguimientoInstructorList = seguimientoInstructorList;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList() {
        return matrizCaracterizacionList;
    }

    public void setMatrizCaracterizacionList(List<MatrizCaracterizacion> matrizCaracterizacionList) {
        this.matrizCaracterizacionList = matrizCaracterizacionList;
    }

    @XmlTransient
    public List<LlamadoAtencionVerbal> getLlamadoAtencionVerbalList() {
        return llamadoAtencionVerbalList;
    }

    public void setLlamadoAtencionVerbalList(List<LlamadoAtencionVerbal> llamadoAtencionVerbalList) {
        this.llamadoAtencionVerbalList = llamadoAtencionVerbalList;
    }

    @XmlTransient
    public List<SeguimientoProductiva> getSeguimientoProductivaList() {
        return seguimientoProductivaList;
    }

    public void setSeguimientoProductivaList(List<SeguimientoProductiva> seguimientoProductivaList) {
        this.seguimientoProductivaList = seguimientoProductivaList;
    }

    @XmlTransient
    public List<Alistamiento> getAlistamientoList() {
        return alistamientoList;
    }

    public void setAlistamientoList(List<Alistamiento> alistamientoList) {
        this.alistamientoList = alistamientoList;
    }

    @XmlTransient
    public List<ControlAsistencia> getControlAsistenciaList() {
        return controlAsistenciaList;
    }

    public void setControlAsistenciaList(List<ControlAsistencia> controlAsistenciaList) {
        this.controlAsistenciaList = controlAsistenciaList;
    }

    @XmlTransient
    public List<SeguimientoProyecto> getSeguimientoProyectoList() {
        return seguimientoProyectoList;
    }

    public void setSeguimientoProyectoList(List<SeguimientoProyecto> seguimientoProyectoList) {
        this.seguimientoProyectoList = seguimientoProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFichaCaracterizacion != null ? idFichaCaracterizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaCaracterizacion)) {
            return false;
        }
        FichaCaracterizacion other = (FichaCaracterizacion) object;
        if ((this.idFichaCaracterizacion == null && other.idFichaCaracterizacion != null) || (this.idFichaCaracterizacion != null && !this.idFichaCaracterizacion.equals(other.idFichaCaracterizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.FichaCaracterizacion[ idFichaCaracterizacion=" + idFichaCaracterizacion + " ]";
    }
    
}
