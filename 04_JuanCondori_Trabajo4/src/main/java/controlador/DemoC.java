package controlador;

import dao.DemoImpl;
import modelo.Demo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.enterprise.context.SessionScoped;
import lombok.Data;

@Data

//Notación CDI
@Named(value = "demoC")
//@Dependent
@SessionScoped
public class DemoC implements Serializable {

    private Demo demo;
    private DemoImpl dao;
    private List<Demo> listadoDemo;
    private List<Demo> listadoFechaHora;

    public DemoC() {
        demo = new Demo();
        dao = new DemoImpl();
        listadoDemo = new ArrayList<>();
        listadoFechaHora = new ArrayList<>();
    }

    public void registrar() throws Exception {
        try {
            dao.registrar(demo);
            limpiar();
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registrado con Éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Al Registrar"));
            System.out.println("Error en registrar_C " + e.getMessage());
        }
    }
    
    public void registrarFechaHora() throws Exception {
        try {
            dao.registrarFechaHora(demo);
            listarFechaHora();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registrado con Éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Al Registrar"));
            System.out.println("Error en registrar_C " + e.getMessage());
        }
    }
    
    public void limpiar() {
        demo = new Demo();
    }

    public void listar() {
        try {
            listadoDemo = dao.listarTodos();
        } catch (Exception e) {
            System.out.println("Error en Listar_C " + e.getMessage());
        }
    }
    
    public void listarFechaHora() {
        try {
            listadoFechaHora = dao.listarFechaHora();
        } catch (Exception e) {
            System.out.println("Error en ListarFechaHora_C " + e.getMessage());
        }
    }
    
    public void mensaje1() {
        String mensaje1 = demo.getCAMPO1() ? "Activado" : "Desactivado";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensaje1));
    }
    
    public void mensaje2() {
        String mensaje2 = demo.getCAMPO2() ? "Activado" : "Desactivado";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensaje2));
    }

    @PostConstruct
    public void construir() {
        listar();
        listarFechaHora();
    }

}
