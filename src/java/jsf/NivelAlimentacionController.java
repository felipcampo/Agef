package jsf;

import jpa.entities.NivelAlimentacion;
import jsf.util.JsfUtil;
import jpa.sessions.NivelAlimentacionFacade;

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

@ManagedBean(name = "nivelAlimentacionController")
@SessionScoped
public class NivelAlimentacionController implements Serializable {

    private NivelAlimentacion current;
    private LazyDataModel<NivelAlimentacion> lazyModel = null;
    @EJB
    private jpa.sessions.NivelAlimentacionFacade ejbFacade;

    public NivelAlimentacionController() {
    }

    public NivelAlimentacion getSelected() {
        if (current == null) {
            current = new NivelAlimentacion();
        }
        return current;
    }

    public void setSelected(NivelAlimentacion entity) {
        current = entity;
    }

    private NivelAlimentacionFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<NivelAlimentacion> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<NivelAlimentacion>() {
                @Override
                public List<NivelAlimentacion> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<NivelAlimentacion> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(NivelAlimentacion entity) {
                    return entity.getIdNivelAlimentacion();
                }

                @Override
                public NivelAlimentacion getRowData(String rowKey) {
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
        current = (NivelAlimentacion) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new NivelAlimentacion();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("NivelAlimentacionCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (NivelAlimentacion) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("NivelAlimentacionUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("NivelAlimentacionDeleted"));
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

    @FacesConverter(forClass = NivelAlimentacion.class)
    public static class NivelAlimentacionControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            NivelAlimentacionController controller = (NivelAlimentacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "nivelAlimentacionController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Short getKey(String value) {
            java.lang.Short key;
            key = Short.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Short value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof NivelAlimentacion) {
                NivelAlimentacion o = (NivelAlimentacion) object;
                return getStringKey(o.getIdNivelAlimentacion());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + NivelAlimentacion.class.getName());
            }
        }
    }
}
