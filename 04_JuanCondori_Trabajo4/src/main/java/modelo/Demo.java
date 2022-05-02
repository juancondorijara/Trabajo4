package modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import lombok.Data;

@Data

public class Demo {

    //Campos para registrar en la tabla DEMO de la Base de Datos
    private int IDDEM;
    private Boolean CAMPO1 = false;
    private Boolean CAMPO2 = false;
    private Date CAMPO3;
    private Date CAMPO4;
    private Date CAMPO5;
    private Date CAMPO6;
    private Date CAMPO7;
    private Date CAMPO8;

    //Campos para registrar en la tabla FECHA_HORA de la Base de Datos la FECHA, FECHA_HORA y HORA Actual
    private int IDFEC;
    private Date FECHA = Calendar.getInstance().getTime();
    private Date FECHA_HORA = Calendar.getInstance().getTime();
    private Date HORA = Calendar.getInstance().getTime();
    
    public Demo() {
    }

}
