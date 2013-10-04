package jsf;

import jpa.entities.FichaUsuario;
import jsf.util.JsfUtil;
import jpa.sessions.FichaUsuarioFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.SelectItem;
import jpa.entities.AspiranteFicha;
import jpa.entities.EstadoAprendiz;
import jpa.entities.EstadoAspirante;
import jpa.entities.FichaUsuario;
import jpa.entities.FichaCaracterizacion;
import jpa.entities.NivelFormacion;
import jpa.entities.Programa;
import jpa.entities.TipoFormacion;
import jpa.sessions.AspiranteFichaFacade;
import jpa.sessions.FichaCaracterizacionFacade;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean(name = "fichaUsuarioController")
@SessionScoped
public class FichaUsuarioController implements Serializable {

    private FichaUsuario current;
    private FichaCaracterizacion ficha;
    private NivelFormacion nivel;
    private DataModel items = null;
    private PieChartModel pieModel;
    private LazyDataModel<FichaUsuario> lazyModel = null;
    private CartesianChartModel categoryModel;
    private Programa currentPrograma;
    private List<FichaCaracterizacion> listBusquedaFicha;
    @EJB
    private jpa.sessions.FichaUsuarioFacade ejbFacade;
    @EJB
    private FichaCaracterizacionFacade ejbFacadeFicha;
    @EJB
    private jpa.sessions.AspiranteFichaFacade ejbFacadeAspirante;

    public FichaUsuarioController() {
    }

    public String demandatecnologo() {
        pieModel = new PieChartModel();
        List<AspiranteFicha> listAspiranteFicha = getFacadeAspirante().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAspirante((short) 3), new TipoFormacion((short) 2));
        int cuposFichas = 0;
        for (AspiranteFicha aspiranteFicha : listAspiranteFicha) {
            cuposFichas += aspiranteFicha.getFichaCaracterizacion().getNumCupFic();
        }
        pieModel.set("Inscritos", listAspiranteFicha.size());
        pieModel.set("Capacidad", cuposFichas);
        return "Ind_demanda_torta_tecnologo";
    }

    public String efectividadtecnologo() {
        pieModel = new PieChartModel();
        pieModel.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());
        pieModel.set("Certificados", getFacade().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAprendiz((short) 2), new TipoFormacion((short) 2)).size());
        return "Ind_efectividad_torta_tecnologo";
    }

    public String deserciontecnologo() {
        pieModel = new PieChartModel();
        pieModel.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());
        pieModel.set("Cancelados", getFacade().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAprendiz((short) 3), new TipoFormacion((short) 2)).size());
        return "Ind_desercion_torta_tecnologo";
    }

    public String esfuerzotecnologo() {
        pieModel = new PieChartModel();
        pieModel.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());
        pieModel.set("Anulados", getFacade().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAprendiz((short) 7), new TipoFormacion((short) 2)).size());
        return "Ind_esfuerzo_torta_tecnologo";
    }

    public String eficienciatecnologo() {
        pieModel = new PieChartModel();
        pieModel.set("Inscritos", getFacadeAspirante().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAspirante((short) 3), new TipoFormacion((short) 2)).size());
        pieModel.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());
        return "Ind_eficiencia_torta_tecnologo";
    }

    public String demandatecnico() {
        pieModel = new PieChartModel();
        List<AspiranteFicha> listAspiranteFicha = getFacadeAspirante().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAspirante((short) 3), new TipoFormacion((short) 2));
        int cuposFichas = 0;
        for (AspiranteFicha aspiranteFicha : listAspiranteFicha) {
            cuposFichas += aspiranteFicha.getFichaCaracterizacion().getNumCupFic();
        }
        pieModel.set("Inscritos", listAspiranteFicha.size());
        pieModel.set("Capacidad", cuposFichas);
        return "Ind_demanda_torta_tecnico";
    }

    public String efectividadtecnico() {
        pieModel = new PieChartModel();
        pieModel.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());
        pieModel.set("Certificados", getFacade().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAprendiz((short) 2), new TipoFormacion((short) 2)).size());
        return "Ind_efectividad_torta_tecnico";
    }

    public String deserciontecnico() {
        pieModel = new PieChartModel();
        pieModel.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());
        pieModel.set("Cancelados", getFacade().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAprendiz((short) 3), new TipoFormacion((short) 2)).size());
        return "Ind_desercion_torta_tecnico";
    }

    public String esfuerzotecnico() {
        pieModel = new PieChartModel();
        pieModel.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());
        pieModel.set("Anulados", getFacade().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAprendiz((short) 7), new TipoFormacion((short) 2)).size());
        return "Ind_esfuerzo_torta_tecnico";
    }

    public String eficienciatecnico() {
        pieModel = new PieChartModel();
        pieModel.set("Inscritos", getFacadeAspirante().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAspirante((short) 3), new TipoFormacion((short) 2)).size());
        pieModel.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());
        return "Ind_eficiencia_torta_tecnico";
    }

    public String demandacomplementaria() {
        pieModel = new PieChartModel();
        List<AspiranteFicha> listAspiranteFicha = getFacadeAspirante().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAspirante((short) 3), new TipoFormacion((short) 2));
        int cuposFichas = 0;
        for (AspiranteFicha aspiranteFicha : listAspiranteFicha) {
            cuposFichas += aspiranteFicha.getFichaCaracterizacion().getNumCupFic();
        }
        pieModel.set("Inscritos", listAspiranteFicha.size());
        pieModel.set("Capacidad", cuposFichas);
        return "Ind_demanda_torta_complementaria";
    }

    public String efectividadcomplementaria() {
        pieModel = new PieChartModel();
        pieModel.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());
        pieModel.set("Certificados", getFacade().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAprendiz((short) 2), new TipoFormacion((short) 2)).size());
        return "Ind_efectividad_torta_complementaria";
    }

    public String desercioncomplementaria() {
        pieModel = new PieChartModel();
        pieModel.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());
        pieModel.set("Cancelados", getFacade().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAprendiz((short) 3), new TipoFormacion((short) 2)).size());
        return "Ind_desercion_torta_complementaria";
    }

    public String esfuerzocomplementaria() {
        pieModel = new PieChartModel();
        pieModel.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());
        pieModel.set("Anulados", getFacade().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAprendiz((short) 7), new TipoFormacion((short) 2)).size());
        return "Ind_esfuerzo_torta_complementaria";
    }

    public String eficienciacomplementaria() {
        pieModel = new PieChartModel();
        pieModel.set("Inscritos", getFacadeAspirante().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAspirante((short) 3), new TipoFormacion((short) 2)).size());
        pieModel.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());
        return "Ind_eficiencia_torta_complementaria";
    }

    public String demandavirtual() {
        pieModel = new PieChartModel();
        List<AspiranteFicha> listAspiranteFicha = getFacadeAspirante().findByTipoEstados(new EstadoAspirante((short) 3), new TipoFormacion((short) 1));
        int cuposFichas = 0;
        for (AspiranteFicha aspiranteFicha : listAspiranteFicha) {
            cuposFichas += aspiranteFicha.getFichaCaracterizacion().getNumCupFic();
        }
        pieModel.set("Inscritos", listAspiranteFicha.size());
        pieModel.set("Capacidad", cuposFichas);
        return "Ind_demanda_torta_virtual";
    }

    public String efectividadvirtual() {
        pieModel = new PieChartModel();
        pieModel.set("Matriculados", getFacade().findByTipoEstados(new EstadoAprendiz((short) 1), new TipoFormacion((short) 1)).size());
        pieModel.set("Certificados", getFacade().findByTipoEstados(new EstadoAprendiz((short) 2), new TipoFormacion((short) 1)).size());
        return "Ind_efectividad_torta_virtual";
    }

    public String desercionvirtual() {
        pieModel = new PieChartModel();
        pieModel.set("Matriculados", getFacade().findByTipoEstados(new EstadoAprendiz((short) 1), new TipoFormacion((short) 1)).size());
        pieModel.set("Cancelados", getFacade().findByTipoEstados(new EstadoAprendiz((short) 3), new TipoFormacion((short) 1)).size());
        return "Ind_desercion_torta_virtual";
    }

    public String esfuerzovirtual() {
        pieModel = new PieChartModel();
        pieModel.set("Matriculados", getFacade().findByTipoEstados(new EstadoAprendiz((short) 1), new TipoFormacion((short) 1)).size());
        pieModel.set("Anulados", getFacade().findByTipoEstados(new EstadoAprendiz((short) 7), new TipoFormacion((short) 1)).size());
        return "Ind_esfuerzo_torta_virtual";
    }

    public String eficienciavirtual() {
        pieModel = new PieChartModel();
        pieModel.set("Inscritos", getFacadeAspirante().findByTipoEstados(new EstadoAspirante((short) 3), new TipoFormacion((short) 1)).size());
        pieModel.set("Matriculados", getFacade().findByTipoEstados(new EstadoAprendiz((short) 1), new TipoFormacion((short) 1)).size());
        return "Ind_eficiencia_torta_virtual";
    }

    public String efectividadbarratecnologo() {

        categoryModel = new CartesianChartModel();

        ChartSeries matriculado = new ChartSeries();
        matriculado.setLabel("Matriculados");

        matriculado.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());

        ChartSeries certificado = new ChartSeries();
        certificado.setLabel("Certificados");

        certificado.set("Certificados", getFacade().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAprendiz((short) 2), new TipoFormacion((short) 2)).size());

        categoryModel.addSeries(matriculado);
        categoryModel.addSeries(certificado);
        return "Ind_efectividad_barra_tecnologo";

    }
    
        public String eficienciabarratecnologo() {

        categoryModel = new CartesianChartModel();
       ChartSeries inscritos = new ChartSeries();
        inscritos.setLabel("Inscritos");

        inscritos.set("Inscritos", getFacade().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAprendiz((short) 3), new TipoFormacion((short) 2)).size());

        ChartSeries matriculados = new ChartSeries();
        matriculados.setLabel("Matriculados");

        matriculados.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());

        categoryModel.addSeries(inscritos);
        categoryModel.addSeries(matriculados);
       
        return "Ind_eficiencia_barra_tecnologo";

    }

    public String demandabarratecnologo() {

        categoryModel = new CartesianChartModel();
        List<AspiranteFicha> listAspiranteFicha = getFacadeAspirante().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAspirante((short) 3), new TipoFormacion((short) 2));
        int cuposFichas = 0;
        for (AspiranteFicha aspiranteFicha : listAspiranteFicha) {
            cuposFichas += aspiranteFicha.getFichaCaracterizacion().getNumCupFic();
        }
        ChartSeries inscritos = new ChartSeries();
        inscritos.setLabel("Inscritos");

        inscritos.set("Inscritos", listAspiranteFicha.size());

        ChartSeries capacidad = new ChartSeries();
        capacidad.setLabel("Capacidad");

        capacidad.set("Capacidad", cuposFichas);

        categoryModel.addSeries(inscritos);
        categoryModel.addSeries(capacidad);
        return "Ind_demanda_barra_tecnologo";
    }
    
    public String desercionbarratecnologo() {

        categoryModel = new CartesianChartModel();
        ficha = current.getFichaCaracterizacion();

        ChartSeries matriculado = new ChartSeries();
        matriculado.setLabel("Matriculado");

        matriculado.set("Matriculado", getFacade().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());

        ChartSeries cancelado = new ChartSeries();
        cancelado.setLabel("Cancelados");

        cancelado.set("Cancelados", getFacade().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAprendiz((short) 3), new TipoFormacion((short) 2)).size());

        categoryModel.addSeries(matriculado);
        categoryModel.addSeries(cancelado);
        return "Ind_desercion_barra_tecnologo";

    }
    
       public String efuerzobarratecnologo() {

        categoryModel = new CartesianChartModel();
        ficha = current.getFichaCaracterizacion();

        ChartSeries matriculado = new ChartSeries();
        matriculado.setLabel("Matriculados");

        matriculado.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());

        ChartSeries anulado = new ChartSeries();
        anulado.setLabel("Anulados");

        anulado.set("Anulados", getFacade().findByNivelEstados(new NivelFormacion((short) 4), new EstadoAprendiz((short) 7), new TipoFormacion((short) 2)).size());

        categoryModel.addSeries(matriculado);
        categoryModel.addSeries(anulado);
        return "Ind_esfuerzo_barra_tecnologo";

    }
       public String efectividadbarratecnico() {

        categoryModel = new CartesianChartModel();

        ChartSeries matriculado = new ChartSeries();
        matriculado.setLabel("Matriculados");

        matriculado.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());

        ChartSeries certificado = new ChartSeries();
        certificado.setLabel("Certificados");

        certificado.set("Certificados", getFacade().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAprendiz((short) 2), new TipoFormacion((short) 2)).size());

        categoryModel.addSeries(matriculado);
        categoryModel.addSeries(certificado);
        return "Ind_efectividad_barra_tecnico";

    }
    
        public String eficienciabarratecnico() {

        categoryModel = new CartesianChartModel();
       ChartSeries inscritos = new ChartSeries();
        inscritos.setLabel("Inscritos");

        inscritos.set("Inscritos", getFacade().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAprendiz((short) 3), new TipoFormacion((short) 2)).size());

        ChartSeries matriculados = new ChartSeries();
        matriculados.setLabel("Matriculados");

        matriculados.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());

        categoryModel.addSeries(inscritos);
        categoryModel.addSeries(matriculados);
       
        return "Ind_eficiencia_barra_tecnico";

    }
        
         public String demandabarravirtual() {

        categoryModel = new CartesianChartModel();
        List<AspiranteFicha> listAspiranteFicha = getFacadeAspirante().findByTipoEstados(new EstadoAspirante((short) 3), new TipoFormacion((short) 1));
        int cuposFichas = 0;
        for (AspiranteFicha aspiranteFicha : listAspiranteFicha) {
            cuposFichas += aspiranteFicha.getFichaCaracterizacion().getNumCupFic();
        }
        ChartSeries inscritos = new ChartSeries();
        inscritos.setLabel("Inscritos");

        inscritos.set("Inscritos", listAspiranteFicha.size());

        ChartSeries capacidad = new ChartSeries();
        capacidad.setLabel("Capacidad");

        capacidad.set("Capacidad", cuposFichas);

        categoryModel.addSeries(inscritos);
        categoryModel.addSeries(capacidad);
        return "Ind_demanda_barra_virtual";
    }
    
    public String desercionbarravirtual() {

        categoryModel = new CartesianChartModel();
        ficha = current.getFichaCaracterizacion();

        ChartSeries matriculado = new ChartSeries();
        matriculado.setLabel("Matriculado");

        matriculado.set("Matriculado", getFacade().findByTipoEstados(new EstadoAprendiz((short) 1), new TipoFormacion((short) 1)).size());

        ChartSeries cancelado = new ChartSeries();
        cancelado.setLabel("Cancelados");

        cancelado.set("Cancelados", getFacade().findByTipoEstados(new EstadoAprendiz((short) 3), new TipoFormacion((short) 1)).size());

        categoryModel.addSeries(matriculado);
        categoryModel.addSeries(cancelado);
        return "Ind_desercion_barra_virtual";

    }
    
       public String efuerzobarravirtual() {

        categoryModel = new CartesianChartModel();
        ficha = current.getFichaCaracterizacion();

        ChartSeries matriculado = new ChartSeries();
        matriculado.setLabel("Matriculados");

        matriculado.set("Matriculados", getFacade().findByTipoEstados(new EstadoAprendiz((short) 1), new TipoFormacion((short) 1)).size());

        ChartSeries anulado = new ChartSeries();
        anulado.setLabel("Anulados");

        anulado.set("Anulados", getFacade().findByTipoEstados(new EstadoAprendiz((short) 7), new TipoFormacion((short) 1)).size());

        categoryModel.addSeries(matriculado);
        categoryModel.addSeries(anulado);
        return "Ind_esfuerzo_barra_virtual";

    }
       public String efectividadbarravitual() {

        categoryModel = new CartesianChartModel();

        ChartSeries matriculado = new ChartSeries();
        matriculado.setLabel("Matriculados");

        matriculado.set("Matriculados", getFacade().findByTipoEstados(new EstadoAprendiz((short) 1), new TipoFormacion((short) 1)).size());

        ChartSeries certificado = new ChartSeries();
        certificado.setLabel("Certificados");

        certificado.set("Certificados", getFacade().findByTipoEstados(new EstadoAprendiz((short) 2), new TipoFormacion((short) 1)).size());

        categoryModel.addSeries(matriculado);
        categoryModel.addSeries(certificado);
        return "Ind_efectividad_barra_virtual";

    }
    
        public String eficienciabarravirtual() {

        categoryModel = new CartesianChartModel();
       ChartSeries inscritos = new ChartSeries();
        inscritos.setLabel("Inscritos");

        inscritos.set("Inscritos", getFacade().findByTipoEstados(new EstadoAprendiz((short) 3), new TipoFormacion((short) 1)).size());

        ChartSeries matriculados = new ChartSeries();
        matriculados.setLabel("Matriculados");

        matriculados.set("Matriculados", getFacade().findByTipoEstados(new EstadoAprendiz((short) 1), new TipoFormacion((short) 1)).size());

        categoryModel.addSeries(inscritos);
        categoryModel.addSeries(matriculados);
       
        return "Ind_eficiencia_barra_virtual";

    }

    public String demandabarratecnico() {

        categoryModel = new CartesianChartModel();
        List<AspiranteFicha> listAspiranteFicha = getFacadeAspirante().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAspirante((short) 3), new TipoFormacion((short) 2));
        int cuposFichas = 0;
        for (AspiranteFicha aspiranteFicha : listAspiranteFicha) {
            cuposFichas += aspiranteFicha.getFichaCaracterizacion().getNumCupFic();
        }
        ChartSeries inscritos = new ChartSeries();
        inscritos.setLabel("Inscritos");

        inscritos.set("Inscritos", listAspiranteFicha.size());

        ChartSeries capacidad = new ChartSeries();
        capacidad.setLabel("Capacidad");

        capacidad.set("Capacidad", cuposFichas);

        categoryModel.addSeries(inscritos);
        categoryModel.addSeries(capacidad);
        return "Ind_demanda_barra_tecnico";
    }
    
    public String desercionbarratecnico() {

        categoryModel = new CartesianChartModel();
        ficha = current.getFichaCaracterizacion();

        ChartSeries matriculado = new ChartSeries();
        matriculado.setLabel("Matriculado");

        matriculado.set("Matriculado", getFacade().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());

        ChartSeries cancelado = new ChartSeries();
        cancelado.setLabel("Cancelados");

        cancelado.set("Cancelados", getFacade().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAprendiz((short) 3), new TipoFormacion((short) 2)).size());

        categoryModel.addSeries(matriculado);
        categoryModel.addSeries(cancelado);
        return "Ind_desercion_barra_tecnico";

    }
    
           public String efectividadbarracomplementaria() {

        categoryModel = new CartesianChartModel();

        ChartSeries matriculado = new ChartSeries();
        matriculado.setLabel("Matriculados");

        matriculado.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());

        ChartSeries certificado = new ChartSeries();
        certificado.setLabel("Certificados");

        certificado.set("Certificados", getFacade().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAprendiz((short) 2), new TipoFormacion((short) 2)).size());

        categoryModel.addSeries(matriculado);
        categoryModel.addSeries(certificado);
        return "Ind_efectividad_barra_complementaria";

    }
    
        public String eficienciabarracomplemetaria() {

        categoryModel = new CartesianChartModel();
       ChartSeries inscritos = new ChartSeries();
        inscritos.setLabel("Inscritos");

        inscritos.set("Inscritos", getFacade().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAprendiz((short) 3), new TipoFormacion((short) 2)).size());

        ChartSeries matriculados = new ChartSeries();
        matriculados.setLabel("Matriculados");

        matriculados.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());

        categoryModel.addSeries(inscritos);
        categoryModel.addSeries(matriculados);
       
        return "Ind_eficiencia_barra_complementaria";

    }

    public String demandabarracomplementaria() {

        categoryModel = new CartesianChartModel();
        List<AspiranteFicha> listAspiranteFicha = getFacadeAspirante().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAspirante((short) 3), new TipoFormacion((short) 2));
        int cuposFichas = 0;
        for (AspiranteFicha aspiranteFicha : listAspiranteFicha) {
            cuposFichas += aspiranteFicha.getFichaCaracterizacion().getNumCupFic();
        }
        ChartSeries inscritos = new ChartSeries();
        inscritos.setLabel("Inscritos");

        inscritos.set("Inscritos", listAspiranteFicha.size());

        ChartSeries capacidad = new ChartSeries();
        capacidad.setLabel("Capacidad");

        capacidad.set("Capacidad", cuposFichas);

        categoryModel.addSeries(inscritos);
        categoryModel.addSeries(capacidad);
        return "Ind_demanda_barra_complementaria";
    }
    
    public String desercionbarracomplementaria() {

        categoryModel = new CartesianChartModel();
        ficha = current.getFichaCaracterizacion();

        ChartSeries matriculado = new ChartSeries();
        matriculado.setLabel("Matriculado");

        matriculado.set("Matriculado", getFacade().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());

        ChartSeries cancelado = new ChartSeries();
        cancelado.setLabel("Cancelados");

        cancelado.set("Cancelados", getFacade().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAprendiz((short) 3), new TipoFormacion((short) 2)).size());

        categoryModel.addSeries(matriculado);
        categoryModel.addSeries(cancelado);
        return "Ind_desercion_barra_complementaria";

    }
    
       public String efuerzobarratecnico() {

        categoryModel = new CartesianChartModel();
        ficha = current.getFichaCaracterizacion();

        ChartSeries matriculado = new ChartSeries();
        matriculado.setLabel("Matriculados");

        matriculado.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());

        ChartSeries anulado = new ChartSeries();
        anulado.setLabel("Anulados");

        anulado.set("Anulados", getFacade().findByNivelEstados(new NivelFormacion((short) 3), new EstadoAprendiz((short) 7), new TipoFormacion((short) 2)).size());

        categoryModel.addSeries(matriculado);
        categoryModel.addSeries(anulado);
        return "Ind_esfuerzo_barra_tecnico";

    }
    
       public String efuerzobarracomplementaria() {

        categoryModel = new CartesianChartModel();
        ficha = current.getFichaCaracterizacion();

        ChartSeries matriculado = new ChartSeries();
        matriculado.setLabel("Matriculados");

        matriculado.set("Matriculados", getFacade().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAprendiz((short) 1), new TipoFormacion((short) 2)).size());

        ChartSeries anulado = new ChartSeries();
        anulado.setLabel("Anulados");

        anulado.set("Anulados", getFacade().findByNivelEstados(new NivelFormacion((short) 7), new EstadoAprendiz((short) 7), new TipoFormacion((short) 2)).size());

        categoryModel.addSeries(matriculado);
        categoryModel.addSeries(anulado);
        return "Ind_esfuerzo_barra_complementaria";

    }

    public String demanda() {
        pieModel = new PieChartModel();
        ficha = current.getFichaCaracterizacion();
        pieModel.set("Inscritos", getFacadeAspirante().findByFichasEstados(ficha, new EstadoAspirante((short) 3)).size());
        pieModel.set("Capacidad", ficha.getNumCupFic());
        return "cons_ficha_ind_demanda";
    }

    public String efectividad() {
        pieModel = new PieChartModel();
        ficha = current.getFichaCaracterizacion();
        pieModel.set("Matriculados", getFacade().findByEstado(ficha, new EstadoAprendiz((short) 1)).size());
        pieModel.set("Certificados", getFacade().findByEstado(ficha, new EstadoAprendiz((short) 2)).size());
        return "cons_ficha_ind_efectividad";
    }

    public String desercion() {
        pieModel = new PieChartModel();
        ficha = current.getFichaCaracterizacion();
        pieModel.set("Matriculados", getFacade().findByEstado(ficha, new EstadoAprendiz((short) 1)).size());
        pieModel.set("Cancelados", getFacade().findByEstado(ficha, new EstadoAprendiz((short) 3)).size());
        return "cons_ficha_ind_desercion";
    }

    public String esfuerzo() {
        pieModel = new PieChartModel();
        ficha = current.getFichaCaracterizacion();
        pieModel.set("Matriculados", getFacade().findByEstado(ficha, new EstadoAprendiz((short) 1)).size());
        pieModel.set("Anulados", getFacade().findByEstado(ficha, new EstadoAprendiz((short) 7)).size());
        return "cons_ficha_ind_esfuerzo";
    }

    public String eficiencia() {
        pieModel = new PieChartModel();
        ficha = current.getFichaCaracterizacion();
        pieModel.set("Inscritos", getFacadeAspirante().findByFichasEstados(ficha, new EstadoAspirante((short) 3)).size());
        pieModel.set("Matriculados", getFacade().findByEstado(ficha, new EstadoAprendiz((short) 1)).size());
        return "cons_ficha_ind_eficiencia";
    }

    public String desercionbarra() {

        categoryModel = new CartesianChartModel();
        ficha = current.getFichaCaracterizacion();

        ChartSeries matriculado = new ChartSeries();
        matriculado.setLabel("Matriculado");

        matriculado.set("Matriculado", getFacade().findByEstado(ficha, new EstadoAprendiz((short) 1)).size());

        ChartSeries cancelado = new ChartSeries();
        cancelado.setLabel("Cancelados");

        cancelado.set("Cancelados", getFacade().findByEstado(ficha, new EstadoAprendiz((short) 3)).size());

        categoryModel.addSeries(matriculado);
        categoryModel.addSeries(cancelado);
        return "cons_ficha_ind_desercion_barras";

    }

    public String demandabarra() {

        categoryModel = new CartesianChartModel();
        ficha = current.getFichaCaracterizacion();

        ChartSeries inscritos = new ChartSeries();
        inscritos.setLabel("Inscritos");

        inscritos.set("Inscritos", getFacadeAspirante().findByFichasEstados(ficha, new EstadoAspirante((short) 3)).size());

        ChartSeries capacidad = new ChartSeries();
        capacidad.setLabel("Capacidad");

        capacidad.set("Capacidad", ficha.getNumCupFic());

        categoryModel.addSeries(inscritos);
        categoryModel.addSeries(capacidad);
        return "cons_ficha_ind_demanda_barra";

    }

    public String efectividadbarra() {

        categoryModel = new CartesianChartModel();
        ficha = current.getFichaCaracterizacion();

        ChartSeries matriculado = new ChartSeries();
        matriculado.setLabel("Matriculados");

        matriculado.set("Matriculados", getFacade().findByEstado(ficha, new EstadoAprendiz((short) 1)).size());

        ChartSeries certificado = new ChartSeries();
        certificado.setLabel("Certificados");

        certificado.set("Certificados", getFacade().findByEstado(ficha, new EstadoAprendiz((short) 2)).size());

        categoryModel.addSeries(matriculado);
        categoryModel.addSeries(certificado);
        return "cons_ficha_ind_efectividad_barra";

    }

    public String eficienciabarra() {

        categoryModel = new CartesianChartModel();
        ficha = current.getFichaCaracterizacion();

        ChartSeries inscritos = new ChartSeries();
        inscritos.setLabel("Inscritos");

        inscritos.set("Inscritos", getFacadeAspirante().findByFichasEstados(ficha, new EstadoAspirante((short) 3)).size());

        ChartSeries matriculados = new ChartSeries();
        matriculados.setLabel("Matriculados");

        matriculados.set("Matriculados", getFacade().findByEstado(ficha, new EstadoAprendiz((short) 1)).size());

        categoryModel.addSeries(inscritos);
        categoryModel.addSeries(matriculados);
        return "cons_ficha_ind_eficiencia_barra";

    }

    public String efuerzobarra() {

        categoryModel = new CartesianChartModel();
        ficha = current.getFichaCaracterizacion();

        ChartSeries matriculado = new ChartSeries();
        matriculado.setLabel("Matriculados");

        matriculado.set("Matriculados", getFacade().findByEstado(ficha, new EstadoAprendiz((short) 1)).size());

        ChartSeries anulado = new ChartSeries();
        anulado.setLabel("Anulados");

        anulado.set("Anulados", getFacade().findByEstado(ficha, new EstadoAprendiz((short) 7)).size());

        categoryModel.addSeries(matriculado);
        categoryModel.addSeries(anulado);
        return "cons_ficha_ind_esfuerzo_barra";

    }

    public CartesianChartModel getChartModel() {
        return categoryModel;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public FichaUsuario getSelected() {
        if (current == null) {
            current = new FichaUsuario();
            current.setFichaUsuarioPK(new jpa.entities.FichaUsuarioPK());
        }
        return current;
    }

    public FichaCaracterizacion getSelectedFicha() {
        if (ficha == null) {
            ficha = new FichaCaracterizacion();
        }
        return ficha;
    }

    public void setSelected(FichaUsuario entity) {
        current = entity;
    }

    public void setSelectedFicha(FichaCaracterizacion entity) {
        ficha = entity;
    }

    public Programa getSelectedPrograma() {
        if (currentPrograma == null) {
            currentPrograma = new Programa();
        }
        return currentPrograma;
    }

    public void setSelectedPrograma(Programa entity) {
        currentPrograma = entity;
    }

    public void buscarFicha() {
        if (getSelectedFicha().getIdFichaCaracterizacion() == null && getSelectedPrograma().getNomPrg().equals("")) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("properties/Bundle").getString("CriteriosVacios"));
        } else {
            try {
                listBusquedaFicha = getFacadeFicha().findByIdAndPrograma(ficha, currentPrograma);
            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("properties/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public String agregarFicha() {
        current.setFichaCaracterizacion(ficha);
        ficha = new FichaCaracterizacion();
        listBusquedaFicha = new ArrayList<>();
        return "Consultaficha";
    }

    public List<FichaCaracterizacion> getListBusquedaFicha() {
        return listBusquedaFicha;
    }

    private FichaUsuarioFacade getFacade() {
        return ejbFacade;
    }

    private AspiranteFichaFacade getFacadeAspirante() {
        return ejbFacadeAspirante;
    }

    private FichaCaracterizacionFacade getFacadeFicha() {
        return ejbFacadeFicha;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public LazyDataModel<FichaUsuario> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<FichaUsuario>() {
                @Override
                public List<FichaUsuario> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<FichaUsuario> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(FichaUsuario entity) {
                    return entity.getFichaUsuarioPK();
                }

                @Override
                public FichaUsuario getRowData(String rowKey) {
                    try {
                        return getFacade().find(rowKey);
                    } catch (Exception e) {
                        return null;
                    }
                }
            };
            lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
        }
        return lazyModel;
    }

    public String prepareView() {
        current = (FichaUsuario) getLazyModel().getRowData();
        return "View";
    }

    public String prepareConsulta() {
        current = new FichaUsuario();
        current.setFichaUsuarioPK(new jpa.entities.FichaUsuarioPK());
        ficha = new FichaCaracterizacion();
        currentPrograma = new Programa();
        listBusquedaFicha = new ArrayList<>();
        return "formularioficha";
    }

    public String prepareCreate() {
        current = new FichaUsuario();
        current.setFichaUsuarioPK(new jpa.entities.FichaUsuarioPK());
        return "Create";
    }

    public String create() {
        try {
            current.getFichaUsuarioPK().setIdUsuario(current.getUsuario().getIdUsuario());
            current.getFichaUsuarioPK().setIdFichaCaracterizacion(current.getFichaCaracterizacion().getIdFichaCaracterizacion());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("FichaUsuarioCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (FichaUsuario) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            current.getFichaUsuarioPK().setIdUsuario(current.getUsuario().getIdUsuario());
            current.getFichaUsuarioPK().setIdFichaCaracterizacion(current.getFichaCaracterizacion().getIdFichaCaracterizacion());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("FichaUsuarioUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        performDestroy();
        recreateModel();
        return "List";
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("FichaUsuarioDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void recreateModel() {
        lazyModel = null;
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public SelectItem[] getItemsAvailableSelectOneFicha() {
        return JsfUtil.getSelectItems(ejbFacadeFicha.findAll(), true);
    }

    @FacesConverter(forClass = FichaUsuario.class)
    public static class FichaUsuarioControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FichaUsuarioController controller = (FichaUsuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "fichaUsuarioController");
            return controller.ejbFacade.find(getKey(value));
        }

        jpa.entities.FichaUsuarioPK getKey(String value) {
            jpa.entities.FichaUsuarioPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new jpa.entities.FichaUsuarioPK();
            key.setIdUsuario(Integer.parseInt(values[0]));
            key.setIdFichaCaracterizacion(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(jpa.entities.FichaUsuarioPK value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value.getIdUsuario());
            sb.append(SEPARATOR);
            sb.append(value.getIdFichaCaracterizacion());
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof FichaUsuario) {
                FichaUsuario o = (FichaUsuario) object;
                return getStringKey(o.getFichaUsuarioPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + FichaUsuario.class.getName());
            }
        }
    }
}
