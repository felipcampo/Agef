package jsf;

import jpa.entities.CaracterizacionPoblacion;
import jsf.util.JsfUtil;
import jpa.sessions.CaracterizacionPoblacionFacade;

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

@ManagedBean(name = "caracterizacionPoblacionController")
@SessionScoped
public class CaracterizacionPoblacionController implements Serializable {

    private CaracterizacionPoblacion current;
    private LazyDataModel<CaracterizacionPoblacion> lazyModel = null;
    @EJB
    private jpa.sessions.CaracterizacionPoblacionFacade ejbFacade;

    public CaracterizacionPoblacionController() {
    }

    public CaracterizacionPoblacion getSelected() {
        if (current == null) {
            current = new CaracterizacionPoblacion();
        }
        return current;
    }

    public void setSelected(CaracterizacionPoblacion entity) {
        current = entity;
    }

    private CaracterizacionPoblacionFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<CaracterizacionPoblacion> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<CaracterizacionPoblacion>() {
                @Override
                public List<CaracterizacionPoblacion> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<CaracterizacionPoblacion> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(CaracterizacionPoblacion entity) {
                    return entity.getIdCaracterizacionPoblacion();
                }

                @Override
                public CaracterizacionPoblacion getRowData(String rowKey) {
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
        current = (CaracterizacionPoblacion) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new CaracterizacionPoblacion();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CaracterizacionPoblacionCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (CaracterizacionPoblacion) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CaracterizacionPoblacionUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CaracterizacionPoblacionDeleted"));
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

    @FacesConverter(forClass = CaracterizacionPoblacion.class)
    public static class CaracterizacionPoblacionControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CaracterizacionPoblacionController controller = (CaracterizacionPoblacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "caracterizacionPoblacionController");
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
            if (object instanceof CaracterizacionPoblacion) {
                CaracterizacionPoblacion o = (CaracterizacionPoblacion) object;
                return getStringKey(o.getIdCaracterizacionPoblacion());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + CaracterizacionPoblacion.class.getName());
            }
        }
    }
}
