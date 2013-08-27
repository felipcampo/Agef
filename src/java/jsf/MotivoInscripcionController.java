package jsf;

import jpa.entities.MotivoInscripcion;
import jsf.util.JsfUtil;
import jpa.sessions.MotivoInscripcionFacade;

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

@ManagedBean(name = "motivoInscripcionController")
@SessionScoped
public class MotivoInscripcionController implements Serializable {

    private MotivoInscripcion current;
    private LazyDataModel<MotivoInscripcion> lazyModel = null;
    @EJB
    private jpa.sessions.MotivoInscripcionFacade ejbFacade;

    public MotivoInscripcionController() {
    }

    public MotivoInscripcion getSelected() {
        if (current == null) {
            current = new MotivoInscripcion();
        }
        return current;
    }

    public void setSelected(MotivoInscripcion entity) {
        current = entity;
    }

    private MotivoInscripcionFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<MotivoInscripcion> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<MotivoInscripcion>() {
                @Override
                public List<MotivoInscripcion> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<MotivoInscripcion> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(MotivoInscripcion entity) {
                    return entity.getIdMotivoInscripcion();
                }

                @Override
                public MotivoInscripcion getRowData(String rowKey) {
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
        current = (MotivoInscripcion) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new MotivoInscripcion();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("MotivoInscripcionCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (MotivoInscripcion) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("MotivoInscripcionUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("MotivoInscripcionDeleted"));
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

    @FacesConverter(forClass = MotivoInscripcion.class)
    public static class MotivoInscripcionControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MotivoInscripcionController controller = (MotivoInscripcionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "motivoInscripcionController");
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
            if (object instanceof MotivoInscripcion) {
                MotivoInscripcion o = (MotivoInscripcion) object;
                return getStringKey(o.getIdMotivoInscripcion());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + MotivoInscripcion.class.getName());
            }
        }
    }
}
