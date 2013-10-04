package jsf;

import jpa.entities.VerificacionAmbienteTitulado;
import jsf.util.JsfUtil;
import jpa.sessions.VerificacionAmbienteTituladoFacade;
import jpa.entities.ListaVerificacion;
import jsf.VerificacionAmbienteTituladoController;
import jpa.sessions.ListaVerificacionFacade;
import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import jpa.entities.FichaCaracterizacion;
import jpa.entities.Programa;
import jpa.sessions.FichaCaracterizacionFacade;
import jpa.entities.Usuario;
import jpa.sessions.UsuarioFacade;
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

@ManagedBean(name = "verificacionAmbienteTituladoController")
@SessionScoped
public class VerificacionAmbienteTituladoController implements Serializable {

    private FichaCaracterizacion currentFicha;
    private ListaVerificacion currentListaveri;
    private List<ListaVerificacion> listListas;
    private Usuario usuarioActual;
    private Programa currentPrograma;
    private List<FichaCaracterizacion> listBusquedaFicha;
    private List<Usuario> listBusquedaUsuarios;
    private VerificacionAmbienteTitulado current;
    private LazyDataModel<VerificacionAmbienteTitulado> lazyModel = null;
    @EJB
    private jpa.sessions.VerificacionAmbienteTituladoFacade ejbFacade;
    @EJB
    private jpa.sessions.FichaCaracterizacionFacade ejbFacadeFicha;
    @EJB
    private jpa.sessions.UsuarioFacade usuarioFacade;
    @EJB
    private jpa.sessions.ListaVerificacionFacade ejbFacadeListaverifica;
    private VerificacionAmbienteTitulado idVerificacionAmbienteTitulado;

    public VerificacionAmbienteTituladoController() {
    }

    public VerificacionAmbienteTitulado getSelected() {
        if (current == null) {
            current = new VerificacionAmbienteTitulado();
        }
        return current;
    }

    public void setSelected(VerificacionAmbienteTitulado entity) {
        current = entity;
    }

    public void setIdVerificacionAmbienteTitulado(VerificacionAmbienteTitulado idVerificacionAmbienteTitulado) {
        this.idVerificacionAmbienteTitulado = idVerificacionAmbienteTitulado;
    }
   
    public Usuario getUsuarioActual() {
        if (usuarioActual == null) {
            usuarioActual = new Usuario();
        }
        return usuarioActual;
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

    public void setUsuarioActual(Usuario usuario) {
        usuarioActual = usuario;
    }

    public Programa getSelectedPrograma() {
        if (currentPrograma == null) {
            currentPrograma = new Programa();
        }
        return currentPrograma;
    }

    private ListaVerificacionFacade getFacadeListaveri() {
        return ejbFacadeListaverifica;
    }

    private UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void buscarUsuario() {
        if (usuarioActual.getNumeroDocumento().equals("")
                && usuarioActual.getNomUsu().equals("") && usuarioActual.getApeUsu().equals("")) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("propierties/Bundle").getString("CriteriosVacios"));
        } else {
            try {
                listBusquedaUsuarios = getUsuarioFacade().findUsuario(usuarioActual);
            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("propierties/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public void agregarUsuario() {
        current.setIdUsuario(usuarioActual);
        usuarioActual = new Usuario();
        listBusquedaUsuarios = new ArrayList<>();
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

    public void agregarListaVerificacion() {
        listListas.add(currentListaveri);
        currentListaveri = new ListaVerificacion();
    }

    public void agregarFicha() {
        current.setIdFichaCaracterizacion(currentFicha);
        currentFicha = new FichaCaracterizacion();
        listBusquedaFicha = new ArrayList<>();
    }

    public List<FichaCaracterizacion> getListBusquedaFicha() {
        return listBusquedaFicha;
    }

    public List<ListaVerificacion> getListaVerificacion() {
        return listListas;
    }
    
    
    public ListaVerificacionFacade getFacadeListaVerificacion() {
        return ejbFacadeListaverifica;
    }

    public List<ListaVerificacion> getListListaVerificacion() {
        return listListas;
    }

    public ListaVerificacion getSelectedListaVerificacion() {
        if (currentListaveri == null) {
            currentListaveri = new ListaVerificacion();
        }
        return currentListaveri;
    }

    public List<Usuario> getListBusquedaUsuarios() {
        return listBusquedaUsuarios;
    }

    private VerificacionAmbienteTituladoFacade getFacade() {
        return ejbFacade;
    }

    private FichaCaracterizacionFacade getFacadeFicha() {

        return ejbFacadeFicha;
    }

    public LazyDataModel<VerificacionAmbienteTitulado> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<VerificacionAmbienteTitulado>() {
                @Override
                public List<VerificacionAmbienteTitulado> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<VerificacionAmbienteTitulado> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(VerificacionAmbienteTitulado entity) {
                    return entity.getIdVerificacionAmbienteTitulado();
                }

                @Override
                public VerificacionAmbienteTitulado getRowData(String rowKey) {
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
        current = (VerificacionAmbienteTitulado) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        currentFicha = new FichaCaracterizacion();
        usuarioActual = new Usuario();
        currentPrograma = new Programa();
        listBusquedaFicha = new ArrayList<>();
        listBusquedaUsuarios = new ArrayList<>();
        currentListaveri = new ListaVerificacion();
        listListas = new ArrayList<>();
        current = new VerificacionAmbienteTitulado();


        return "Create";
    }

    public String create() {
        try {

            

            getFacade().create(current);

            for (ListaVerificacion verificacion : listListas) {
                verificacion.setIdVerificacionAmbienteTitulado(current);
                getFacadeListaVerificacion().create(verificacion);
            }

            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("VerificacionAmbienteTituladoCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (VerificacionAmbienteTitulado) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("VerificacionAmbienteTituladoUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("VerificacionAmbienteTituladoDeleted"));
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

    @FacesConverter(forClass = VerificacionAmbienteTitulado.class)
    public static class VerificacionAmbienteTituladoControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VerificacionAmbienteTituladoController controller = (VerificacionAmbienteTituladoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "verificacionAmbienteTituladoController");
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
            if (object instanceof VerificacionAmbienteTitulado) {
                VerificacionAmbienteTitulado o = (VerificacionAmbienteTitulado) object;
                return getStringKey(o.getIdVerificacionAmbienteTitulado());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + VerificacionAmbienteTitulado.class.getName());
            }
        }
    }
}
