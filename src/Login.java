public class Login {
    //Atributos
    private String name;
    private String subname;
    public String user;
    public String password;
    public String type;
    private int numcuentas;
    public int incidencias;

    //Getters y settters

    public String getName() {return name;}
    public String getPassword() {return password;}
    public String getSubname() {return subname;}
    public String getType() {return type;}
    public String getUser() {return user;}
    public int getIncidencias() {return incidencias;}
    public int getNumcuentas() {return numcuentas;}

    public void setName(String name) {this.name = name;}
    public void setPassword(String password) {this.password = password;}
    public void setSubname(String subname) {this.subname = subname;}
    public void setType(String type) {this.type = type;}
    public void setUser(String user) {this.user = user;}
    public void setIncidencias(int incidencias) {this.incidencias = incidencias;}
    public void setNumcuentas(int numcuentas) {this.numcuentas = numcuentas;}

    //Constructor
    public Login(String name, String subname, String user, String password, String type) {
        this.name = name;
        this.subname = subname;
        this.user = user;
        this.password = password;
        this.type = type;
        numcuentas++;
        incidencias = 0;
    }

    //Un muestra para visión del perfil de usuario-..-
    public void muestra(){
        System.out.println("Nombre: "+name);
        System.out.println("Apellido: "+subname);
        System.out.println("Usuario: "+user);
        System.out.println("Tipo: "+type);
    }
}
