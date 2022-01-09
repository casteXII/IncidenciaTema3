import java.time.LocalDate;

public class Incidencia {
    // Atributos
    private int id;
    private String comentarios;
    private String prioridad;
    private LocalDate fecha;
    private boolean resuelta;
    public String nombre="";
    public String apellido="";
    public String tecnico;
    private String ComentarioTecnico;

    //Getters y Setters
    public int getId() {return id;}
    public LocalDate getFecha() {return fecha;}
    public String getComentarios() {return comentarios;}
    public String getPrioridad() {return prioridad;}
    public boolean getResuelta() {return resuelta;}
    public String getApellido() {return apellido;}
    public String getNombre() {return nombre;}
    public String getTecnico() {return tecnico;}
    public String getComentarioTecnico() {return ComentarioTecnico;}

    public void setComentarios(String comentarios) {this.comentarios = comentarios;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
    public void setId(int id) {this.id = id;}
    public void setPrioridad(String prioridad) {this.prioridad = prioridad;}
    public void setResuelta(boolean resuelta) {this.resuelta = resuelta;}
    public void setAbre(Login login){       // Utilizado para expresar que usuario a abierto una incidencia
        this.nombre=login.getName();
        this.apellido=login.getSubname();
    }
    public void setTecnico(Login login){ //Utilizado para asigar el tecnico para resolver la incidencia
        this.tecnico=login.getName()+" "+login.getSubname();
    }
    public void setComentarioTecnico(String ComentarioTecnico){this.ComentarioTecnico=ComentarioTecnico;}

    // Concstructor
    public Incidencia(int id, String comentarios, String prioridad, LocalDate fecha){
        this.id=id;
        this.comentarios=comentarios;
        this.prioridad=prioridad;
        this.fecha=fecha;
        resuelta=false;
        tecnico="";
        ComentarioTecnico="";
    }

    // Muestra que nos recoge información de la incidencia con detalles y variables posibles a tener en cuenta
    public void muestra (){
        System.out.println("------------------------------------------");
        System.out.println("Incidencia con ID: "+id);
        System.out.println("Abierta por: "+nombre+" "+apellido);
        System.out.println("Se abrió el "+fecha);
        if (!resuelta){
            System.out.println("Asignada al técnico: "+tecnico);
        }else{
            System.out.println("Comentarios del técnico: "+ComentarioTecnico);
        }
        System.out.println("Comentarios del usuario: "+comentarios);
        System.out.println("Prioridad: "+getPrioridad());
        if (!resuelta){
            System.out.println("NO RESUELTA");
        }else{
            System.out.println("RESUELTA");
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    }
}
