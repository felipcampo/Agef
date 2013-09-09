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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADSI
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNumeroDocumento", query = "SELECT u FROM Usuario u WHERE u.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Usuario.findByNomUsu", query = "SELECT u FROM Usuario u WHERE u.nomUsu = :nomUsu"),
    @NamedQuery(name = "Usuario.findByApeUsu", query = "SELECT u FROM Usuario u WHERE u.apeUsu = :apeUsu"),
    @NamedQuery(name = "Usuario.findByInicialesUsu", query = "SELECT u FROM Usuario u WHERE u.inicialesUsu = :inicialesUsu"),
    @NamedQuery(name = "Usuario.findByDirUsu", query = "SELECT u FROM Usuario u WHERE u.dirUsu = :dirUsu"),
    @NamedQuery(name = "Usuario.findByFechaNacimiento", query = "SELECT u FROM Usuario u WHERE u.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Usuario.findByEmailMisenaUsu", query = "SELECT u FROM Usuario u WHERE u.emailMisenaUsu = :emailMisenaUsu"),
    @NamedQuery(name = "Usuario.findByEmailPersonalUsu", query = "SELECT u FROM Usuario u WHERE u.emailPersonalUsu = :emailPersonalUsu"),
    @NamedQuery(name = "Usuario.findByTelUsu", query = "SELECT u FROM Usuario u WHERE u.telUsu = :telUsu"),
    @NamedQuery(name = "Usuario.findByGenero", query = "SELECT u FROM Usuario u WHERE u.genero = :genero"),
    @NamedQuery(name = "Usuario.findByEstadoCivil", query = "SELECT u FROM Usuario u WHERE u.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_usu")
    private String nomUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ape_usu")
    private String apeUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "iniciales_usu")
    private String inicialesUsu;
    @Size(max = 200)
    @Column(name = "dir_usu")
    private String dirUsu;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 150)
    @Column(name = "email_misena_usu")
    private String emailMisenaUsu;
    @Size(max = 45)
    @Column(name = "email_personal_usu")
    private String emailPersonalUsu;
    @Size(max = 20)
    @Column(name = "tel_usu")
    private String telUsu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "genero")
    private char genero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "password")
    private String password;
    @ManyToMany(mappedBy = "usuarioList")
    private List<ProgramacionProyecto> programacionProyectoList;
    @JoinTable(name = "usuario_rol", joinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")})
    @ManyToMany
    private List<Rol> rolList;
    @JoinTable(name = "usuarios_controles", joinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "id_control_operativo", referencedColumnName = "id_control_operativo")})
    @ManyToMany
    private List<ControlOperativo> controlOperativoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<FichaUsuario> fichaUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<EstadoAprendiz> estadoAprendizList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario1")
    private List<EvaluacionSeguimiento> evaluacionSeguimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<EvaluacionSeguimiento> evaluacionSeguimientoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<ContratoProyecto> contratoProyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<ReporteNovedad> reporteNovedadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioInstructor")
    private List<PlaneacionClase> planeacionClaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioGestor")
    private List<PlaneacionClase> planeacionClaseList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<PlaneacionPedagogica> planeacionPedagogicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Remision> remisionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario2")
    private List<PlanMejoramiento> planMejoramientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<PlanMejoramiento> planMejoramientoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Comite> comiteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<SeguimientoInstructor> seguimientoInstructorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<VerificacionAmbienteTitulado> verificacionAmbienteTituladoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<AspiranteFicha> aspiranteFichaList;
    @JoinColumn(name = "id_estado_aspirante", referencedColumnName = "id_estado_aspirante")
    @ManyToOne(optional = false)
    private EstadoAspirante idEstadoAspirante;
    @JoinColumn(name = "id_situacion_militar", referencedColumnName = "id_situacion_militar")
    @ManyToOne(optional = false)
    private SituacionMilitar idSituacionMilitar;
    @JoinColumn(name = "id_tipo_contrato", referencedColumnName = "id_tipo_contrato")
    @ManyToOne(optional = false)
    private TipoContrato idTipoContrato;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    @ManyToOne(optional = false)
    private TipoDocumento idTipoDocumento;
    @JoinColumn(name = "id_barrio", referencedColumnName = "id_barrio")
    @ManyToOne(optional = false)
    private Barrio idBarrio;
    @JoinColumn(name = "id_ciudad_nacimiento", referencedColumnName = "id_ciudad")
    @ManyToOne(optional = false)
    private Ciudad idCiudadNacimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<LlamadoAtencionVerbal> llamadoAtencionVerbalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<SeguimientoProductiva> seguimientoProductivaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<PraxisPedagogica> praxisPedagogicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Alistamiento> alistamientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<ProyectoFormativo> proyectoFormativoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario2")
    private List<ControlAsistencia> controlAsistenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario1")
    private List<ControlAsistencia> controlAsistenciaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<ControlAsistencia> controlAsistenciaList2;
    @OneToMany(mappedBy = "idUsuario")
    private List<SeguimientoProyecto> seguimientoProyectoList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String numeroDocumento, String nomUsu, String apeUsu, String inicialesUsu, char genero, String estadoCivil, String password) {
        this.idUsuario = idUsuario;
        this.numeroDocumento = numeroDocumento;
        this.nomUsu = nomUsu;
        this.apeUsu = apeUsu;
        this.inicialesUsu = inicialesUsu;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.password = password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNomUsu() {
        return nomUsu;
    }

    public void setNomUsu(String nomUsu) {
        this.nomUsu = nomUsu;
    }

    public String getApeUsu() {
        return apeUsu;
    }

    public void setApeUsu(String apeUsu) {
        this.apeUsu = apeUsu;
    }

    public String getInicialesUsu() {
        return inicialesUsu;
    }

    public void setInicialesUsu(String inicialesUsu) {
        this.inicialesUsu = inicialesUsu;
    }

    public String getDirUsu() {
        return dirUsu;
    }

    public void setDirUsu(String dirUsu) {
        this.dirUsu = dirUsu;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmailMisenaUsu() {
        return emailMisenaUsu;
    }

    public void setEmailMisenaUsu(String emailMisenaUsu) {
        this.emailMisenaUsu = emailMisenaUsu;
    }

    public String getEmailPersonalUsu() {
        return emailPersonalUsu;
    }

    public void setEmailPersonalUsu(String emailPersonalUsu) {
        this.emailPersonalUsu = emailPersonalUsu;
    }

    public String getTelUsu() {
        return telUsu;
    }

    public void setTelUsu(String telUsu) {
        this.telUsu = telUsu;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<ProgramacionProyecto> getProgramacionProyectoList() {
        return programacionProyectoList;
    }

    public void setProgramacionProyectoList(List<ProgramacionProyecto> programacionProyectoList) {
        this.programacionProyectoList = programacionProyectoList;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<ControlOperativo> getControlOperativoList() {
        return controlOperativoList;
    }

    public void setControlOperativoList(List<ControlOperativo> controlOperativoList) {
        this.controlOperativoList = controlOperativoList;
    }

    @XmlTransient
    public List<FichaUsuario> getFichaUsuarioList() {
        return fichaUsuarioList;
    }

    public void setFichaUsuarioList(List<FichaUsuario> fichaUsuarioList) {
        this.fichaUsuarioList = fichaUsuarioList;
    }

    @XmlTransient
    public List<EstadoAprendiz> getEstadoAprendizList() {
        return estadoAprendizList;
    }

    public void setEstadoAprendizList(List<EstadoAprendiz> estadoAprendizList) {
        this.estadoAprendizList = estadoAprendizList;
    }

    @XmlTransient
    public List<EvaluacionSeguimiento> getEvaluacionSeguimientoList() {
        return evaluacionSeguimientoList;
    }

    public void setEvaluacionSeguimientoList(List<EvaluacionSeguimiento> evaluacionSeguimientoList) {
        this.evaluacionSeguimientoList = evaluacionSeguimientoList;
    }

    @XmlTransient
    public List<EvaluacionSeguimiento> getEvaluacionSeguimientoList1() {
        return evaluacionSeguimientoList1;
    }

    public void setEvaluacionSeguimientoList1(List<EvaluacionSeguimiento> evaluacionSeguimientoList1) {
        this.evaluacionSeguimientoList1 = evaluacionSeguimientoList1;
    }

    @XmlTransient
    public List<ContratoProyecto> getContratoProyectoList() {
        return contratoProyectoList;
    }

    public void setContratoProyectoList(List<ContratoProyecto> contratoProyectoList) {
        this.contratoProyectoList = contratoProyectoList;
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

    @XmlTransient
    public List<PlaneacionClase> getPlaneacionClaseList1() {
        return planeacionClaseList1;
    }

    public void setPlaneacionClaseList1(List<PlaneacionClase> planeacionClaseList1) {
        this.planeacionClaseList1 = planeacionClaseList1;
    }

    @XmlTransient
    public List<PlaneacionPedagogica> getPlaneacionPedagogicaList() {
        return planeacionPedagogicaList;
    }

    public void setPlaneacionPedagogicaList(List<PlaneacionPedagogica> planeacionPedagogicaList) {
        this.planeacionPedagogicaList = planeacionPedagogicaList;
    }

    @XmlTransient
    public List<Remision> getRemisionList() {
        return remisionList;
    }

    public void setRemisionList(List<Remision> remisionList) {
        this.remisionList = remisionList;
    }

    @XmlTransient
    public List<PlanMejoramiento> getPlanMejoramientoList() {
        return planMejoramientoList;
    }

    public void setPlanMejoramientoList(List<PlanMejoramiento> planMejoramientoList) {
        this.planMejoramientoList = planMejoramientoList;
    }

    @XmlTransient
    public List<PlanMejoramiento> getPlanMejoramientoList1() {
        return planMejoramientoList1;
    }

    public void setPlanMejoramientoList1(List<PlanMejoramiento> planMejoramientoList1) {
        this.planMejoramientoList1 = planMejoramientoList1;
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
    public List<VerificacionAmbienteTitulado> getVerificacionAmbienteTituladoList() {
        return verificacionAmbienteTituladoList;
    }

    public void setVerificacionAmbienteTituladoList(List<VerificacionAmbienteTitulado> verificacionAmbienteTituladoList) {
        this.verificacionAmbienteTituladoList = verificacionAmbienteTituladoList;
    }

    @XmlTransient
    public List<AspiranteFicha> getAspiranteFichaList() {
        return aspiranteFichaList;
    }

    public void setAspiranteFichaList(List<AspiranteFicha> aspiranteFichaList) {
        this.aspiranteFichaList = aspiranteFichaList;
    }

    public EstadoAspirante getIdEstadoAspirante() {
        return idEstadoAspirante;
    }

    public void setIdEstadoAspirante(EstadoAspirante idEstadoAspirante) {
        this.idEstadoAspirante = idEstadoAspirante;
    }

    public SituacionMilitar getIdSituacionMilitar() {
        return idSituacionMilitar;
    }

    public void setIdSituacionMilitar(SituacionMilitar idSituacionMilitar) {
        this.idSituacionMilitar = idSituacionMilitar;
    }

    public TipoContrato getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(TipoContrato idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public TipoDocumento getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Barrio getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Barrio idBarrio) {
        this.idBarrio = idBarrio;
    }

    public Ciudad getIdCiudadNacimiento() {
        return idCiudadNacimiento;
    }

    public void setIdCiudadNacimiento(Ciudad idCiudadNacimiento) {
        this.idCiudadNacimiento = idCiudadNacimiento;
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
    public List<PraxisPedagogica> getPraxisPedagogicaList() {
        return praxisPedagogicaList;
    }

    public void setPraxisPedagogicaList(List<PraxisPedagogica> praxisPedagogicaList) {
        this.praxisPedagogicaList = praxisPedagogicaList;
    }

    @XmlTransient
    public List<Alistamiento> getAlistamientoList() {
        return alistamientoList;
    }

    public void setAlistamientoList(List<Alistamiento> alistamientoList) {
        this.alistamientoList = alistamientoList;
    }

    @XmlTransient
    public List<ProyectoFormativo> getProyectoFormativoList() {
        return proyectoFormativoList;
    }

    public void setProyectoFormativoList(List<ProyectoFormativo> proyectoFormativoList) {
        this.proyectoFormativoList = proyectoFormativoList;
    }

    @XmlTransient
    public List<ControlAsistencia> getControlAsistenciaList() {
        return controlAsistenciaList;
    }

    public void setControlAsistenciaList(List<ControlAsistencia> controlAsistenciaList) {
        this.controlAsistenciaList = controlAsistenciaList;
    }

    @XmlTransient
    public List<ControlAsistencia> getControlAsistenciaList1() {
        return controlAsistenciaList1;
    }

    public void setControlAsistenciaList1(List<ControlAsistencia> controlAsistenciaList1) {
        this.controlAsistenciaList1 = controlAsistenciaList1;
    }

    @XmlTransient
    public List<ControlAsistencia> getControlAsistenciaList2() {
        return controlAsistenciaList2;
    }

    public void setControlAsistenciaList2(List<ControlAsistencia> controlAsistenciaList2) {
        this.controlAsistenciaList2 = controlAsistenciaList2;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
