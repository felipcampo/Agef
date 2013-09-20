package jsf;

import jpa.entities.GuiaAprendizaje;
import jsf.util.JsfUtil;
import jpa.sessions.GuiaAprendizajeFacade;

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
import javax.faces.model.SelectItem;
import jpa.entities.FichaCaracterizacion;
import jpa.entities.Programa;
import jpa.sessions.FichaCaracterizacionFacade;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "guiaAprendizajeController")
@SessionScoped
public class GuiaAprendizajeController implements Serializable {

    private GuiaAprendizaje current;
    private FichaCaracterizacion currentFicha;
    private Programa currentPrograma;
    private List<FichaCaracterizacion> listBusquedaFicha;
    private LazyDataModel<GuiaAprendizaje> lazyModel = null;
    @EJB
    private jpa.sessions.GuiaAprendizajeFacade ejbFacade;
    @EJB
    private jpa.sessions.FichaCaracterizacionFacade ejbFacadeFicha;

    public GuiaAprendizajeController() {
    }

    public GuiaAprendizaje getSelected() {
        if (current == null) {
            current = new GuiaAprendizaje();
        }
        return current;
    }

    public void setSelected(GuiaAprendizaje entity) {
        current = entity;
    }
    
     public FichaCaracterizacion getSelectedFicha() {
        if (currentFicha == null) {
            currentFicha = new FichaCaracterizacion();
        }
        return currentFicha;
    }

    public void setSelectedFicha(FichaCaracterizacion entity) {
        currentFicha = entity;
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
                listBusquedaFicha = getFacadeFicha().findByIdAndPrograma(currentFicha, currentPrograma);
            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("propierties/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }
    
    public void agregarFicha(){
        current.setIdFichaCaracterizacion(currentFicha);
        currentFicha = new FichaCaracterizacion();
        listBusquedaFicha = new ArrayList<>();
    }
            
    public List<FichaCaracterizacion> getListBusquedaFicha() {
        return listBusquedaFicha;
    }
    
    private GuiaAprendizajeFacade getFacade() {
        return ejbFacade;
    }
    
    private FichaCaracterizacionFacade getFacadeFicha() {
        return ejbFacadeFicha;
    }

    public LazyDataModel<GuiaAprendizaje> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<GuiaAprendizaje>() {
                @Override
                public List<GuiaAprendizaje> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<GuiaAprendizaje> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(GuiaAprendizaje entity) {
                    return entity.getIdGuiaAprendizaje();
                }

                @Override
                public GuiaAprendizaje getRowData(String rowKey) {
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

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (GuiaAprendizaje) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new GuiaAprendizaje();
        currentFicha = new FichaCaracterizacion();
        currentPrograma = new Programa();
        listBusquedaFicha = new ArrayList<>();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("GuiaAprendizajeCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (GuiaAprendizaje) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("GuiaAprendizajeUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("GuiaAprendizajeDeleted"));
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

    @FacesConverter(forClass = GuiaAprendizaje.class)
    public static class GuiaAprendizajeControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            GuiaAprendizajeController controller = (GuiaAprendizajeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "guiaAprendizajeController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof GuiaAprendizaje) {
                GuiaAprendizaje o = (GuiaAprendizaje) object;
                return getStringKey(o.getIdGuiaAprendizaje());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + GuiaAprendizaje.class.getName());
            }
        }
    }
}
