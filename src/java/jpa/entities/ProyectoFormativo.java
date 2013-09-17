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
@Table(name = "proyecto_formativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoFormativo.findAll", query = "SELECT p FROM ProyectoFormativo p"),
    @NamedQuery(name = "ProyectoFormativo.findByIdProyectoFormativo", query = "SELECT p FROM ProyectoFormativo p WHERE p.idProyectoFormativo = :idProyectoFormativo"),
    @NamedQuery(name = "ProyectoFormativo.findByNombreProyecto", query = "SELECT p FROM ProyectoFormativo p WHERE p.nombreProyecto = :nombreProyecto"),
    @NamedQuery(name = "ProyectoFormativo.findByNumResAprBasicos", query = "SELECT p FROM ProyectoFormativo p WHERE p.numResAprBasicos = :numResAprBasicos"),
    @NamedQuery(name = "ProyectoFormativo.findByNumResAprEspecifico", query = "SELECT p FROM ProyectoFormativo p WHERE p.numResAprEspecifico = :numResAprEspecifico"),
    @NamedQuery(name = "ProyectoFormativo.findByNumResAprTransversal", query = "SELECT p FROM ProyectoFormativo p WHERE p.numResAprTransversal = :numResAprTransversal"),
    @NamedQuery(name = "ProyectoFormativo.findByFichaAsociada", query = "SELECT p FROM ProyectoFormativo p WHERE p.fichaAsociada = :fichaAsociada"),
    @NamedQuery(name = "ProyectoFormativo.findByTiempoProyecto", query = "SELECT p FROM ProyectoFormativo p WHERE p.tiempoProyecto = :tiempoProyecto"),
    @NamedQuery(name = "ProyectoFormativo.findByNumeroTotalResultados", query = "SELECT p FROM ProyectoFormativo p WHERE p.numeroTotalResultados = :numeroTotalResultados"),
    @NamedQuery(name = "ProyectoFormativo.findByResuelveNecSectorProd", query = "SELECT p FROM ProyectoFormativo p WHERE p.resuelveNecSectorProd = :resuelveNecSectorProd"),
    @NamedQuery(name = "ProyectoFormativo.findByMejoraProcesoProd", query = "SELECT p FROM ProyectoFormativo p WHERE p.mejoraProcesoProd = :mejoraProcesoProd"),
    @NamedQuery(name = "ProyectoFormativo.findByInvolucraNvTec", query = "SELECT p FROM ProyectoFormativo p WHERE p.involucraNvTec = :involucraNvTec"),
    @NamedQuery(name = "ProyectoFormativo.findByProductoFinSusc", query = "SELECT p FROM ProyectoFormativo p WHERE p.productoFinSusc = :productoFinSusc"),
    @NamedQuery(name = "ProyectoFormativo.findByProductoObtPro", query = "SELECT p FROM ProyectoFormativo p WHERE p.productoObtPro = :productoObtPro"),
    @NamedQuery(name = "ProyectoFormativo.findByDesarrolloProSatis", query = "SELECT p FROM ProyectoFormativo p WHERE p.desarrolloProSatis = :desarrolloProSatis"),
    @NamedQuery(name = "ProyectoFormativo.findByViabilidadProPlan", query = "SELECT p FROM ProyectoFormativo p WHERE p.viabilidadProPlan = :viabilidadProPlan"),
    @NamedQuery(name = "ProyectoFormativo.findByIntructoresReq", query = "SELECT p FROM ProyectoFormativo p WHERE p.intructoresReq = :intructoresReq"),
    @NamedQuery(name = "ProyectoFormativo.findByAprendicesReq", query = "SELECT p FROM ProyectoFormativo p WHERE p.aprendicesReq = :aprendicesReq")})
public class ProyectoFormativo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_proyecto_formativo")
    private String idProyectoFormativo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_proyecto")
    private String nombreProyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_res_apr_basicos")
    private int numResAprBasicos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_res_apr_especifico")
    private int numResAprEspecifico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_res_apr_transversal")
    private int numResAprTransversal;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "programa_formacion_respuesta")
    private String programaFormacionRespuesta;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "benficiario_proyecto")
    private String benficiarioProyecto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "imp_social")
    private String impSocial;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "imp_economico")
    private String impEconomico;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "impacto_ambiental")
    private String impactoAmbiental;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "imp_tecnologico")
    private String impTecnologico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ficha_asociada")
    private int fichaAsociada;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "plateamiento_problema")
    private String plateamientoProblema;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "justificacion_proyecto")
    private String justificacionProyecto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "obj_general")
    private String objGeneral;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "obj_especifico")
    private String objEspecifico;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "riesgos_asociados")
    private String riesgosAsociados;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "resultado_proyecto")
    private String resultadoProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tiempo_proyecto")
    private String tiempoProyecto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "palabras_claves")
    private String palabrasClaves;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_total_resultados")
    private short numeroTotalResultados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resuelve_nec_sector_prod")
    private boolean resuelveNecSectorProd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mejora_proceso_prod")
    private boolean mejoraProcesoProd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "involucra_nv_tec")
    private boolean involucraNvTec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "producto_fin_susc")
    private boolean productoFinSusc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "producto_obt_pro")
    private boolean productoObtPro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desarrollo_pro_satis")
    private boolean desarrolloProSatis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "viabilidad_pro_plan")
    private boolean viabilidadProPlan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intructores_req")
    private short intructoresReq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aprendices_req")
    private short aprendicesReq;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descr_amb_apr")
    private String descrAmbApr;
    @JoinTable(name = "proyecto_formativo_fase", joinColumns = {
        @JoinColumn(name = "id_proyecto_formativo", referencedColumnName = "id_proyecto_formativo")}, inverseJoinColumns = {
        @JoinColumn(name = "id_fase_proyecto", referencedColumnName = "id_fase_proyecto")})
    @ManyToMany
    private List<FaseProyecto> faseProyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyectoFormativo")
    private List<FichaCaracterizacion> fichaCaracterizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyectoFormativo")
    private List<PlaneacionPedagogica> planeacionPedagogicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyectoFormativo")
    private List<GuiaAprendizaje> guiaAprendizajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyectoFormativo")
    private List<VerificacionAmbienteTitulado> verificacionAmbienteTituladoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyectoFormativo")
    private List<PraxisPedagogica> praxisPedagogicaList;
    @OneToMany(mappedBy = "idProyectoFormativo")
    private List<Alistamiento> alistamientoList;
    @JoinColumn(name = "id_evidencia_aprendizaje", referencedColumnName = "id_evidencia_aprendizaje")
    @ManyToOne
    private EvidenciaAprendizaje idEvidenciaAprendizaje;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_datalle_recurso", referencedColumnName = "id_datalle_recurso")
    @ManyToOne(optional = false)
    private DetalleRecurso idDatalleRecurso;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id_resultado_aprendizaje")
    @ManyToOne(optional = false)
    private ResultadoAprendizaje idResultadoAprendizaje;
    @JoinColumn(name = "id_actividad_proyecto", referencedColumnName = "id_actividad_proyecto")
    @ManyToOne(optional = false)
    private ActividadProyecto idActividadProyecto;
    @JoinColumn(name = "id_programa", referencedColumnName = "id_programa")
    @ManyToOne(optional = false)
    private Programa idPrograma;
    @JoinColumn(name = "id_estado_proyecto", referencedColumnName = "id_estado_proyecto")
    @ManyToOne(optional = false)
    private EstadoProyecto idEstadoProyecto;
    @OneToMany(mappedBy = "idProyectoFormativo")
    private List<SeguimientoProyecto> seguimientoProyectoList;

    public ProyectoFormativo() {
    }

    public ProyectoFormativo(String idProyectoFormativo) {
        this.idProyectoFormativo = idProyectoFormativo;
    }

    public ProyectoFormativo(String idProyectoFormativo, String nombreProyecto, int numResAprBasicos, int numResAprEspecifico, int numResAprTransversal, String programaFormacionRespuesta, String benficiarioProyecto, String impSocial, String impEconomico, String impactoAmbiental, String impTecnologico, int fichaAsociada, String plateamientoProblema, String justificacionProyecto, String objGeneral, String objEspecifico, String riesgosAsociados, String resultadoProyecto, String tiempoProyecto, String palabrasClaves, short numeroTotalResultados, boolean resuelveNecSectorProd, boolean mejoraProcesoProd, boolean involucraNvTec, boolean productoFinSusc, boolean productoObtPro, boolean desarrolloProSatis, boolean viabilidadProPlan, short intructoresReq, short aprendicesReq, String descrAmbApr) {
        this.idProyectoFormativo = idProyectoFormativo;
        this.nombreProyecto = nombreProyecto;
        this.numResAprBasicos = numResAprBasicos;
        this.numResAprEspecifico = numResAprEspecifico;
        this.numResAprTransversal = numResAprTransversal;
        this.programaFormacionRespuesta = programaFormacionRespuesta;
        this.benficiarioProyecto = benficiarioProyecto;
        this.impSocial = impSocial;
        this.impEconomico = impEconomico;
        this.impactoAmbiental = impactoAmbiental;
        this.impTecnologico = impTecnologico;
        this.fichaAsociada = fichaAsociada;
        this.plateamientoProblema = plateamientoProblema;
        this.justificacionProyecto = justificacionProyecto;
        this.objGeneral = objGeneral;
        this.objEspecifico = objEspecifico;
        this.riesgosAsociados = riesgosAsociados;
        this.resultadoProyecto = resultadoProyecto;
        this.tiempoProyecto = tiempoProyecto;
        this.palabrasClaves = palabrasClaves;
        this.numeroTotalResultados = numeroTotalResultados;
        this.resuelveNecSectorProd = resuelveNecSectorProd;
        this.mejoraProcesoProd = mejoraProcesoProd;
        this.involucraNvTec = involucraNvTec;
        this.productoFinSusc = productoFinSusc;
        this.productoObtPro = productoObtPro;
        this.desarrolloProSatis = desarrolloProSatis;
        this.viabilidadProPlan = viabilidadProPlan;
        this.intructoresReq = intructoresReq;
        this.aprendicesReq = aprendicesReq;
        this.descrAmbApr = descrAmbApr;
    }

    public String getIdProyectoFormativo() {
        return idProyectoFormativo;
    }

    public void setIdProyectoFormativo(String idProyectoFormativo) {
        this.idProyectoFormativo = idProyectoFormativo;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public int getNumResAprBasicos() {
        return numResAprBasicos;
    }

    public void setNumResAprBasicos(int numResAprBasicos) {
        this.numResAprBasicos = numResAprBasicos;
    }

    public int getNumResAprEspecifico() {
        return numResAprEspecifico;
    }

    public void setNumResAprEspecifico(int numResAprEspecifico) {
        this.numResAprEspecifico = numResAprEspecifico;
    }

    public int getNumResAprTransversal() {
        return numResAprTransversal;
    }

    public void setNumResAprTransversal(int numResAprTransversal) {
        this.numResAprTransversal = numResAprTransversal;
    }

    public String getProgramaFormacionRespuesta() {
        return programaFormacionRespuesta;
    }

    public void setProgramaFormacionRespuesta(String programaFormacionRespuesta) {
        this.programaFormacionRespuesta = programaFormacionRespuesta;
    }

    public String getBenficiarioProyecto() {
        return benficiarioProyecto;
    }

    public void setBenficiarioProyecto(String benficiarioProyecto) {
        this.benficiarioProyecto = benficiarioProyecto;
    }

    public String getImpSocial() {
        return impSocial;
    }

    public void setImpSocial(String impSocial) {
        this.impSocial = impSocial;
    }

    public String getImpEconomico() {
        return impEconomico;
    }

    public void setImpEconomico(String impEconomico) {
        this.impEconomico = impEconomico;
    }

    public String getImpactoAmbiental() {
        return impactoAmbiental;
    }

    public void setImpactoAmbiental(String impactoAmbiental) {
        this.impactoAmbiental = impactoAmbiental;
    }

    public String getImpTecnologico() {
        return impTecnologico;
    }

    public void setImpTecnologico(String impTecnologico) {
        this.impTecnologico = impTecnologico;
    }

    public int getFichaAsociada() {
        return fichaAsociada;
    }

    public void setFichaAsociada(int fichaAsociada) {
        this.fichaAsociada = fichaAsociada;
    }

    public String getPlateamientoProblema() {
        return plateamientoProblema;
    }

    public void setPlateamientoProblema(String plateamientoProblema) {
        this.plateamientoProblema = plateamientoProblema;
    }

    public String getJustificacionProyecto() {
        return justificacionProyecto;
    }

    public void setJustificacionProyecto(String justificacionProyecto) {
        this.justificacionProyecto = justificacionProyecto;
    }

    public String getObjGeneral() {
        return objGeneral;
    }

    public void setObjGeneral(String objGeneral) {
        this.objGeneral = objGeneral;
    }

    public String getObjEspecifico() {
        return objEspecifico;
    }

    public void setObjEspecifico(String objEspecifico) {
        this.objEspecifico = objEspecifico;
    }

    public String getRiesgosAsociados() {
        return riesgosAsociados;
    }

    public void setRiesgosAsociados(String riesgosAsociados) {
        this.riesgosAsociados = riesgosAsociados;
    }

    public String getResultadoProyecto() {
        return resultadoProyecto;
    }

    public void setResultadoProyecto(String resultadoProyecto) {
        this.resultadoProyecto = resultadoProyecto;
    }

    public String getTiempoProyecto() {
        return tiempoProyecto;
    }

    public void setTiempoProyecto(String tiempoProyecto) {
        this.tiempoProyecto = tiempoProyecto;
    }

    public String getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(String palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    public short getNumeroTotalResultados() {
        return numeroTotalResultados;
    }

    public void setNumeroTotalResultados(short numeroTotalResultados) {
        this.numeroTotalResultados = numeroTotalResultados;
    }

    public boolean getResuelveNecSectorProd() {
        return resuelveNecSectorProd;
    }

    public void setResuelveNecSectorProd(boolean resuelveNecSectorProd) {
        this.resuelveNecSectorProd = resuelveNecSectorProd;
    }

    public boolean getMejoraProcesoProd() {
        return mejoraProcesoProd;
    }

    public void setMejoraProcesoProd(boolean mejoraProcesoProd) {
        this.mejoraProcesoProd = mejoraProcesoProd;
    }

    public boolean getInvolucraNvTec() {
        return involucraNvTec;
    }

    public void setInvolucraNvTec(boolean involucraNvTec) {
        this.involucraNvTec = involucraNvTec;
    }

    public boolean getProductoFinSusc() {
        return productoFinSusc;
    }

    public void setProductoFinSusc(boolean productoFinSusc) {
        this.productoFinSusc = productoFinSusc;
    }

    public boolean getProductoObtPro() {
        return productoObtPro;
    }

    public void setProductoObtPro(boolean productoObtPro) {
        this.productoObtPro = productoObtPro;
    }

    public boolean getDesarrolloProSatis() {
        return desarrolloProSatis;
    }

    public void setDesarrolloProSatis(boolean desarrolloProSatis) {
        this.desarrolloProSatis = desarrolloProSatis;
    }

    public boolean getViabilidadProPlan() {
        return viabilidadProPlan;
    }

    public void setViabilidadProPlan(boolean viabilidadProPlan) {
        this.viabilidadProPlan = viabilidadProPlan;
    }

    public short getIntructoresReq() {
        return intructoresReq;
    }

    public void setIntructoresReq(short intructoresReq) {
        this.intructoresReq = intructoresReq;
    }

    public short getAprendicesReq() {
        return aprendicesReq;
    }

    public void setAprendicesReq(short aprendicesReq) {
        this.aprendicesReq = aprendicesReq;
    }

    public String getDescrAmbApr() {
        return descrAmbApr;
    }

    public void setDescrAmbApr(String descrAmbApr) {
        this.descrAmbApr = descrAmbApr;
    }

    @XmlTransient
    public List<FaseProyecto> getFaseProyectoList() {
        return faseProyectoList;
    }

    public void setFaseProyectoList(List<FaseProyecto> faseProyectoList) {
        this.faseProyectoList = faseProyectoList;
    }

    @XmlTransient
    public List<FichaCaracterizacion> getFichaCaracterizacionList() {
        return fichaCaracterizacionList;
    }

    public void setFichaCaracterizacionList(List<FichaCaracterizacion> fichaCaracterizacionList) {
        this.fichaCaracterizacionList = fichaCaracterizacionList;
    }

    @XmlTransient
    public List<PlaneacionPedagogica> getPlaneacionPedagogicaList() {
        return planeacionPedagogicaList;
    }

    public void setPlaneacionPedagogicaList(List<PlaneacionPedagogica> planeacionPedagogicaList) {
        this.planeacionPedagogicaList = planeacionPedagogicaList;
    }

    @XmlTransient
    public List<GuiaAprendizaje> getGuiaAprendizajeList() {
        return guiaAprendizajeList;
    }

    public void setGuiaAprendizajeList(List<GuiaAprendizaje> guiaAprendizajeList) {
        this.guiaAprendizajeList = guiaAprendizajeList;
    }

    @XmlTransient
    public List<VerificacionAmbienteTitulado> getVerificacionAmbienteTituladoList() {
        return verificacionAmbienteTituladoList;
    }

    public void setVerificacionAmbienteTituladoList(List<VerificacionAmbienteTitulado> verificacionAmbienteTituladoList) {
        this.verificacionAmbienteTituladoList = verificacionAmbienteTituladoList;
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

    public EvidenciaAprendizaje getIdEvidenciaAprendizaje() {
        return idEvidenciaAprendizaje;
    }

    public void setIdEvidenciaAprendizaje(EvidenciaAprendizaje idEvidenciaAprendizaje) {
        this.idEvidenciaAprendizaje = idEvidenciaAprendizaje;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public DetalleRecurso getIdDatalleRecurso() {
        return idDatalleRecurso;
    }

    public void setIdDatalleRecurso(DetalleRecurso idDatalleRecurso) {
        this.idDatalleRecurso = idDatalleRecurso;
    }

    public ResultadoAprendizaje getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(ResultadoAprendizaje idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    public ActividadProyecto getIdActividadProyecto() {
        return idActividadProyecto;
    }

    public void setIdActividadProyecto(ActividadProyecto idActividadProyecto) {
        this.idActividadProyecto = idActividadProyecto;
    }

    public Programa getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Programa idPrograma) {
        this.idPrograma = idPrograma;
    }

    public EstadoProyecto getIdEstadoProyecto() {
        return idEstadoProyecto;
    }

    public void setIdEstadoProyecto(EstadoProyecto idEstadoProyecto) {
        this.idEstadoProyecto = idEstadoProyecto;
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
        hash += (idProyectoFormativo != null ? idProyectoFormativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoFormativo)) {
            return false;
        }
        ProyectoFormativo other = (ProyectoFormativo) object;
        if ((this.idProyectoFormativo == null && other.idProyectoFormativo != null) || (this.idProyectoFormativo != null && !this.idProyectoFormativo.equals(other.idProyectoFormativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ProyectoFormativo[ idProyectoFormativo=" + idProyectoFormativo + " ]";
    }
    
}
