package jsf;

import jpa.entities.SeguimientoProductiva;
import jsf.util.JsfUtil;
import jpa.sessions.SeguimientoProductivaFacade;
import jpa.sessions.UsuarioFacade;
import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
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
import jpa.entities.CentroFormacion;
import jpa.entities.Empresa;
import jpa.entities.FichaCaracterizacion;
import jpa.entities.Programa;
import jpa.entities.Regional;
import jpa.entities.Usuario;
import jpa.sessions.CentroFormacionFacade;
import jpa.sessions.EmpresaFacade;
import jpa.sessions.FichaCaracterizacionFacade;
import jpa.sessions.ProgramaFacade;
import jpa.sessions.RegionalFacade;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "seguimientoProductivaController")
@SessionScoped
public class SeguimientoProductivaController implements Serializable {

    private Empresa empresaActual;
    private Usuario usuarioActual;
    private List<Empresa> listBusquedaEmpresas;
    private List<Usuario> listBusquedaUsuarios;
    private SeguimientoProductiva current;
    private Regional currentRegional;    
    private CentroFormacion currentCentroFormacion;
    private FichaCaracterizacion currentFichaCaracterizacion;
    private Programa currentPrograma; 
    private LazyDataModel<SeguimientoProductiva> lazyModel = null;
    @EJB
    private jpa.sessions.SeguimientoProductivaFacade ejbFacade;
    @EJB
    private jpa.sessions.RegionalFacade ejbFacadeRegional;
    @EJB
    private jpa.sessions.CentroFormacionFacade ejbFacadeCentroFormacion;
    @EJB
    private jpa.sessions.UsuarioFacade usuarioFacade;
    @EJB
    private jpa.sessions.EmpresaFacade empresaFacade;
    @EJB
    private jpa.sessions.FichaCaracterizacionFacade ejbFacadeFichaCaracterizacion;
    @EJB
    private jpa.sessions.ProgramaFacade ejbFacadePrograma;

    public SeguimientoProductivaController() {
    }

    public Usuario getUsuarioActual() {
        if (usuarioActual == null) {
            usuarioActual = new Usuario();
        }
        return usuarioActual;
    }
    
    public Empresa getEmpresaActual() {
        if (empresaActual == null) {
            empresaActual = new Empresa();
        }
        return empresaActual;
    }

    public void setUsuarioActual(Usuario usuario) {
        usuarioActual = usuario;
    }
    
    public void setEmpresaActual(Empresa empresa) {
        empresaActual = empresa;
    }

    private UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }
    
    private EmpresaFacade getEmpresaFacade() {
        return empresaFacade;
    }

    public List<Usuario> getListBusquedaUsuarios() {
        return listBusquedaUsuarios;
    }
    
    public List<Empresa> getListBusquedaEmpresas() {
        return listBusquedaEmpresas;
    }

    public SeguimientoProductiva getSelected() {
        if (current == null) {
            current = new SeguimientoProductiva();
        }
        return current;
    }

    public Regional getSelectedRegional() {
        if (currentRegional == null) {
            currentRegional = new Regional();
        }
        return currentRegional;
    }
    
    public Programa getSelectedPrograma() {
        if (currentPrograma == null) {
            currentPrograma = new Programa();
        }
        return currentPrograma;
    }
    

    public CentroFormacion getSelectedCentroFormacion() {
        if (currentCentroFormacion == null) {
            currentCentroFormacion = new CentroFormacion();
        }
        return currentCentroFormacion;
    }
    
    public FichaCaracterizacion getSelectedFichaCaracterizacion() {
        if (currentFichaCaracterizacion == null) {
            currentFichaCaracterizacion = new FichaCaracterizacion();
        }
        return currentFichaCaracterizacion;
    }    

    public void setSelected(SeguimientoProductiva entity) {
        current = entity;
    }

    public void setSelectedRegional(Regional regional) {
        currentRegional = regional;
    }
    
    public void setSelectedPrograma(Programa programa) {
        currentPrograma = programa;
    }
    
    private SeguimientoProductivaFacade getFacade() {
        return ejbFacade;
    }

    public RegionalFacade getFacadeRegional() {
        return ejbFacadeRegional;
    }
    
    public ProgramaFacade getFacadePrograma() {
        return ejbFacadePrograma;
    }
    

    public CentroFormacionFacade getFacadeCentroFormacion() {
        return ejbFacadeCentroFormacion;
    }
    
    public FichaCaracterizacionFacade getFacadeFichaCaracterizacion() {
        return ejbFacadeFichaCaracterizacion;
    }
    

    public LazyDataModel<SeguimientoProductiva> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<SeguimientoProductiva>() {
                @Override
                public List<SeguimientoProductiva> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<SeguimientoProductiva> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(SeguimientoProductiva entity) {
                    return entity.getIdSeguimientoProductiva();
                }

                @Override
                public SeguimientoProductiva getRowData(String rowKey) {
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
        current = (SeguimientoProductiva) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new SeguimientoProductiva();
        currentRegional = new Regional();
        currentCentroFormacion = new CentroFormacion();
        currentPrograma = new Programa();
        currentFichaCaracterizacion = new FichaCaracterizacion();        
        usuarioActual = new Usuario();
        empresaActual = new Empresa();
        listBusquedaUsuarios = new ArrayList<>();
        listBusquedaEmpresas = new ArrayList<>();
        return "Create";
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
    
    public void buscarEmpresa() {
        if (empresaActual.getIdEmpresa()==null && empresaActual.getRazonSocialEmpresa().equals("")) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("propierties/Bundle").getString("CriteriosVacios"));
        } else {
            try {
                listBusquedaEmpresas = getEmpresaFacade().findEmpresa(empresaActual);
            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("propierties/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }
    
    public void agregarEmpresa (){
        current.setIdEmpresa(empresaActual);
        empresaActual = new Empresa();
        listBusquedaEmpresas = new ArrayList<>();
    }
    
    public void agregarUsuario (){
        current.setIdUsuario(usuarioActual);
        usuarioActual = new Usuario();
        listBusquedaUsuarios = new ArrayList<>();
    }
    

    public String create() {
        try {
            current.setIdUsuario(usuarioActual);
            current.setIdEmpresa(empresaActual);
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientoProductivaCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (SeguimientoProductiva) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientoProductivaUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientoProductivaDeleted"));
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

    public SelectItem[] getItemsAvailableSelectOneRegional() {
        return JsfUtil.getSelectItems(ejbFacadeRegional.findAll(), true);
    }

    public SelectItem[] getItemsAvailableSelectOneCentroByRegional() {
        return JsfUtil.getSelectItems(ejbFacadeCentroFormacion.findByRegional(getSelectedRegional()), true);
    }   
    
    public SelectItem[] getItemsAvailableSelectOneFichaCaracterizacionByPrograma() {
        return JsfUtil.getSelectItems(ejbFacadeFichaCaracterizacion.findByPrograma(getSelectedPrograma()), true);
    }  
    

    @FacesConverter(forClass = SeguimientoProductiva.class)
    public static class SeguimientoProductivaControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SeguimientoProductivaController controller = (SeguimientoProductivaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "seguimientoProductivaController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
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
            if (object instanceof SeguimientoProductiva) {
                SeguimientoProductiva o = (SeguimientoProductiva) object;
                return getStringKey(o.getIdSeguimientoProductiva());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + SeguimientoProductiva.class.getName());
            }
        }
    }
}
