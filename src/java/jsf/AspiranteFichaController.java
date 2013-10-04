package jsf;

import jpa.entities.AspiranteFicha;
import jsf.util.JsfUtil;
import jpa.sessions.AspiranteFichaFacade;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.SelectItem;
import jpa.entities.EstadoAspirante;
import jpa.entities.FichaCaracterizacion;
import jpa.entities.Programa;
import jpa.sessions.FichaCaracterizacionFacade;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean(name = "aspiranteFichaController")
@SessionScoped
public class AspiranteFichaController implements Serializable {

    private CartesianChartModel categoryModel;
    private AspiranteFicha current;
    private FichaCaracterizacion ficha;
    private DataModel items = null;
    private Integer preinscritos;
    private Programa currentPrograma;
    private List<FichaCaracterizacion> listBusquedaFicha;
    private PieChartModel pieModel;
    private LazyDataModel<AspiranteFicha> lazyModel = null;
    @EJB
    private jpa.sessions.AspiranteFichaFacade ejbFacade;
    private FichaCaracterizacionFacade ejbFacadeFicha;

    public AspiranteFichaController() {
    }

    public String demanda() {
        pieModel = new PieChartModel();
        ficha = current.getFichaCaracterizacion();
        pieModel.set("Inscritó", getFacade().findByFichasEstados(ficha, new EstadoAspirante((short) 3)).size());
        pieModel.set("Capacidad", ficha.getNumCupFic());
        return "cons_ficha_ind_demanda";
    }

    public String demandabarra() {
        categoryModel = new CartesianChartModel();
        ChartSeries inscrito = new ChartSeries();
        inscrito.setLabel("inscrito");
        inscrito.set("Inscritó", getFacade().findByFichasEstados(ficha, new EstadoAspirante((short) 3)).size());

        ChartSeries Capacidad = new ChartSeries();

        Capacidad.setLabel("Capacidad");
        Capacidad.set("Capacidad", getFacade().findByFichasEstados(ficha, new EstadoAspirante((short) 3)).size());
        return "Consultaficha";
    }

    public CartesianChartModel getChartModel() {
        return categoryModel;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public Integer getPreinscritos() {
        return preinscritos;
    }

    public AspiranteFicha getSelected() {
        if (current == null) {
            current = new AspiranteFicha();
            current.setAspiranteFichaPK(new jpa.entities.AspiranteFichaPK());
        }
        return current;
    }

    public FichaCaracterizacion getSelectedFicha() {
        if (ficha == null) {
            ficha = new FichaCaracterizacion();
        }
        return ficha;
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
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("propierties/Bundle").getString("CriteriosVacios"));
        } else {
            try {
                listBusquedaFicha = getFacadeFicha().findByIdAndPrograma(ficha, currentPrograma);
            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("propierties/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<FichaCaracterizacion> getListBusquedaFicha() {
        return listBusquedaFicha;
    }

    private AspiranteFichaFacade getFacade() {
        return ejbFacade;
    }

    private FichaCaracterizacionFacade getFacadeFicha() {
        return ejbFacadeFicha;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public LazyDataModel<AspiranteFicha> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<AspiranteFicha>() {
                @Override
                public List<AspiranteFicha> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<AspiranteFicha> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(AspiranteFicha entity) {
                    return entity.getAspiranteFichaPK();
                }

                @Override
                public AspiranteFicha getRowData(String rowKey) {
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

    public String prepareCreate() {
        current = new AspiranteFicha();
        current.setAspiranteFichaPK(new jpa.entities.AspiranteFichaPK());
        return "Create";
    }

    public String create() {
        try {
            current.getAspiranteFichaPK().setIdUsuario(current.getUsuario().getIdUsuario());
            current.getAspiranteFichaPK().setIdFichaCaracterizacion(current.getFichaCaracterizacion().getIdFichaCaracterizacion());
            current.getAspiranteFichaPK().setIdEstadoAspirante(current.getEstadoAspirante().getIdEstadoAspirante());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("properties/Bundle").getString("AspiranteFichaCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String update() {
        try {
            current.getAspiranteFichaPK().setIdUsuario(current.getUsuario().getIdUsuario());
            current.getAspiranteFichaPK().setIdFichaCaracterizacion(current.getFichaCaracterizacion().getIdFichaCaracterizacion());
            current.getAspiranteFichaPK().setIdEstadoAspirante(current.getEstadoAspirante().getIdEstadoAspirante());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("properties/Bundle").getString("AspiranteFichaUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    private void recreateModel() {
        items = null;
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public AspiranteFicha getAspiranteFicha(jpa.entities.AspiranteFichaPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = AspiranteFicha.class)
    public static class AspiranteFichaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AspiranteFichaController controller = (AspiranteFichaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "aspiranteFichaController");
            return controller.getAspiranteFicha(getKey(value));
        }

        jpa.entities.AspiranteFichaPK getKey(String value) {
            jpa.entities.AspiranteFichaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new jpa.entities.AspiranteFichaPK();
            key.setIdEstadoAspirante(Short.parseShort(values[0]));
            key.setIdFichaCaracterizacion(Integer.parseInt(values[1]));
            key.setIdUsuario(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(jpa.entities.AspiranteFichaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdEstadoAspirante());
            sb.append(SEPARATOR);
            sb.append(value.getIdFichaCaracterizacion());
            sb.append(SEPARATOR);
            sb.append(value.getIdUsuario());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof AspiranteFicha) {
                AspiranteFicha o = (AspiranteFicha) object;
                return getStringKey(o.getAspiranteFichaPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + AspiranteFicha.class.getName());
            }
        }
    }
}
