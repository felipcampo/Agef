package jsf;

import jpa.entities.PlaneacionClase;
import jsf.util.JsfUtil;
import jpa.sessions.PlaneacionClaseFacade;

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

@ManagedBean(name = "planeacionClaseController")
@SessionScoped
public class PlaneacionClaseController implements Serializable {

    private PlaneacionClase current;
    private LazyDataModel<PlaneacionClase> lazyModel = null;
    @EJB
    private jpa.sessions.PlaneacionClaseFacade ejbFacade;

    public PlaneacionClaseController() {
    }

    public PlaneacionClase getSelected() {
        if (current == null) {
            current = new PlaneacionClase();
        }
        return current;
    }

    public void setSelected(PlaneacionClase entity) {
        current = entity;
    }

    private PlaneacionClaseFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<PlaneacionClase> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<PlaneacionClase>() {
                @Override
                public List<PlaneacionClase> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<PlaneacionClase> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(PlaneacionClase entity) {
                    return entity.getIdPlaneacionClase();
                }

                @Override
                public PlaneacionClase getRowData(String rowKey) {
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
        current = (PlaneacionClase) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new PlaneacionClase();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("PlaneacionClaseCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (PlaneacionClase) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("PlaneacionClaseUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("PlaneacionClaseDeleted"));
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

    @FacesConverter(forClass = PlaneacionClase.class)
    public static class PlaneacionClaseControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PlaneacionClaseController controller = (PlaneacionClaseController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "planeacionClaseController");
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
            if (object instanceof PlaneacionClase) {
                PlaneacionClase o = (PlaneacionClase) object;
                return getStringKey(o.getIdPlaneacionClase());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + PlaneacionClase.class.getName());
            }
        }
    }
}
