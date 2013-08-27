package jsf;

import jpa.entities.TipoModalidadProductiva;
import jsf.util.JsfUtil;
import jpa.sessions.TipoModalidadProductivaFacade;

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

@ManagedBean(name = "tipoModalidadProductivaController")
@SessionScoped
public class TipoModalidadProductivaController implements Serializable {

    private TipoModalidadProductiva current;
    private LazyDataModel<TipoModalidadProductiva> lazyModel = null;
    @EJB
    private jpa.sessions.TipoModalidadProductivaFacade ejbFacade;

    public TipoModalidadProductivaController() {
    }

    public TipoModalidadProductiva getSelected() {
        if (current == null) {
            current = new TipoModalidadProductiva();
        }
        return current;
    }

    public void setSelected(TipoModalidadProductiva entity) {
        current = entity;
    }

    private TipoModalidadProductivaFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<TipoModalidadProductiva> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<TipoModalidadProductiva>() {
                @Override
                public List<TipoModalidadProductiva> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<TipoModalidadProductiva> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(TipoModalidadProductiva entity) {
                    return entity.getIdTipoModalidadProductiva();
                }

                @Override
                public TipoModalidadProductiva getRowData(String rowKey) {
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
        current = (TipoModalidadProductiva) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new TipoModalidadProductiva();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("TipoModalidadProductivaCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (TipoModalidadProductiva) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("TipoModalidadProductivaUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("TipoModalidadProductivaDeleted"));
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

    @FacesConverter(forClass = TipoModalidadProductiva.class)
    public static class TipoModalidadProductivaControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoModalidadProductivaController controller = (TipoModalidadProductivaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoModalidadProductivaController");
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
            if (object instanceof TipoModalidadProductiva) {
                TipoModalidadProductiva o = (TipoModalidadProductiva) object;
                return getStringKey(o.getIdTipoModalidadProductiva());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + TipoModalidadProductiva.class.getName());
            }
        }
    }
}
