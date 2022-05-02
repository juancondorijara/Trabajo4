package dao;

import modelo.Demo;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DemoImpl extends Conexion implements ICRUD<Demo> {

    //Formateo de fecha para registrar
    DateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
    //Formateo de fecha y hora para registrar
    DateFormat fecha_hora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    //Formateo de hora para registrar
    DateFormat hora = new SimpleDateFormat("HH:mm:ss");
    
    //Método registrar para la tabla DEMO de la Base de Datos
    @Override
    public void registrar(Demo demo) throws Exception {
        String sql = "insert into DEMO (CAMPO1, CAMPO2, CAMPO3, CAMPO4, CAMPO5, CAMPO6, CAMPO7, CAMPO8) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setBoolean(1, demo.getCAMPO1());
            ps.setBoolean(2, demo.getCAMPO2());
            ps.setString(3, fecha.format(demo.getCAMPO3()));
            ps.setString(4, fecha.format(demo.getCAMPO4()));
            ps.setString(5, fecha.format(demo.getCAMPO5()));
            ps.setString(6, fecha.format(demo.getCAMPO6()));
            ps.setString(7, fecha_hora.format(demo.getCAMPO7()));
            ps.setString(8, hora.format(demo.getCAMPO8()));
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en Registrar_D " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    //Método registrar para la tabla FECHA_HORA de la Base de Datos
    public void registrarFechaHora(Demo demo) throws Exception {
        String sql = "insert into FECHA_HORA (CAMPO1, CAMPO2, CAMPO3) values (?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, fecha.format(demo.getFECHA()));
            ps.setString(2, fecha_hora.format(demo.getFECHA_HORA()));
            ps.setString(3, hora.format(demo.getHORA()));
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en Registrar_D " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Demo demo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Demo demo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void restaurar(Demo demo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Método listar para la tabla DEMO de la Base de Datos
    @Override
    public List<Demo> listarTodos() throws Exception {
        List<Demo> listado = null;
        Demo demo;
        String sql = "select * from DEMO order by IDDEM desc";
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                demo = new Demo();
                demo.setIDDEM(rs.getInt("IDDEM"));
                demo.setCAMPO1(rs.getBoolean("CAMPO1"));
                demo.setCAMPO2(rs.getBoolean("CAMPO2"));
                demo.setCAMPO3(rs.getDate("CAMPO3"));
                demo.setCAMPO4(rs.getDate("CAMPO4"));
                demo.setCAMPO5(rs.getDate("CAMPO5"));
                demo.setCAMPO6(rs.getDate("CAMPO6"));
                demo.setCAMPO7(rs.getTimestamp("CAMPO7"));
                demo.setCAMPO8(rs.getTime("CAMPO8"));
                listado.add(demo);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en ListarTodos_D " + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listado;
    }
    
    //Método listar para la tabla FECHA_HORA de la Base de Datos
    public List<Demo> listarFechaHora() throws Exception {
        List<Demo> listado = null;
        Demo demo;
        String sql = "select * from FECHA_HORA order by IDFEC desc";
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                demo = new Demo();
                demo.setIDFEC(rs.getInt("IDFEC"));
                demo.setFECHA(rs.getDate("CAMPO1"));
                demo.setFECHA_HORA(rs.getTimestamp("CAMPO2"));
                demo.setHORA(rs.getTime("CAMPO3"));
                listado.add(demo);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en ListarFechaHora_D " + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listado;
    }

}
