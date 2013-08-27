package jsf;

import jpa.entities.EvidenciaAprendizaje;
import jsf.util.JsfUtil;
import jpa.sessions.EvidenciaAprendizajeFacade;

import java.io.Serializable;
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
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "evidenciaAprendizajeController")
@SessionScoped
public class EvidenciaAprendizajeController implements Serializable {

    private EvidenciaAprendizaje current;
    private LazyDataModel<EvidenciaAprendizaje> lazyModel = null;
    @EJB
    private jpa.sessions.EvidenciaAprendizajeFacade ejbFacade;

    public EvidenciaAprendizajeController() {
    }

    public EvidenciaAprendizaje getSelected() {
        if (current == null) {
            current = new EvidenciaAprendizaje();
        }
        return current;
    }

    public void setSelected(EvidenciaAprendizaje entity) {
        current = entity;
    }

    private EvidenciaAprendizajeFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<EvidenciaAprendizaje> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<EvidenciaAprendizaje>() {
                @Override
                public List<EvidenciaAprendizaje> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<EvidenciaAprendizaje> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(EvidenciaAprendizaje entity) {
                    return entity.getIdEvidenciaAprendizaje();
                }

                @Override
                public EvidenciaAprendizaje getRowData(String rowKey) {
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
        current = (EvidenciaAprendizaje) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new EvidenciaAprendizaje();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EvidenciaAprendizajeCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (EvidenciaAprendizaje) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EvidenciaAprendizajeUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EvidenciaAprendizajeDeleted"));
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

    @FacesConverter(forClass = EvidenciaAprendizaje.class)
    public static class EvidenciaAprendizajeControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EvidenciaAprendizajeController controller = (EvidenciaAprendizajeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "evidenciaAprendizajeController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EvidenciaAprendizaje) {
                EvidenciaAprendizaje o = (EvidenciaAprendizaje) object;
                return getStringKey(o.getIdEvidenciaAprendizaje());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EvidenciaAprendizaje.class.getName());
            }
        }
    }
}
