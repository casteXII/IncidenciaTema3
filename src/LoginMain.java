import java.time.LocalDate;
import java.util.Scanner;
public class LoginMain {
    public static void main(String[]args){
        //Creamos el scanner y asignamos dia a las incidencias
        Scanner s= new Scanner(System.in);
        LocalDate hoy= LocalDate.now();
    // Creamos tanto los perfiles como las inicidencias a seguir
    Login pablo = new Login("Pablo","Castellano", "pablo", "pablo", "admin");
    Login manolo = new Login("Manolo","Lopez","manu","manu","tecnico");
    Login ana = new Login("Ana", "Gomez", "ana", "ana", "normal");


    Incidencia tele = new Incidencia(1,"La televisón no funciona","alta", hoy);
    Incidencia movil = new Incidencia(2,"El telefono tienes fallos de memoria", "media", hoy);
    Incidencia lapiz = new Incidencia(3, "Nos hemos quedado sín lápices en la sala de ordenadores", "baja", hoy);


    boolean acceso = false;
    do {
        System.out.println("----------------------------");
        System.out.println("INSERTE USUARIO Y CONTRASEÑA");
        System.out.println("----------------------------");
        System.out.println("Usuario");
        String usu = s.nextLine();
        System.out.println("Contraseña");
        String contra = s.nextLine();
        if (usu.equals(pablo.user) & contra.equals(pablo.password)) {
            acceso = true; //Menús diferentes dependiendo del tipo de usuario que tengan
            if (pablo.type.equals("admin")) {
                int num;
                do {
                    System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
                    System.out.println("Bienvenido Pablo, tiene usted perfil de adminsitrador");
                    System.out.println("Menú:");
                    System.out.println("1.- Consultar todas las incidencias");
                    System.out.println("2.- Consultar todos los usuarios");
                    System.out.println("3.- Consultar todos los técnicos");
                    System.out.println("4.- Asignar una incidencia a un técnico");
                    System.out.println("5.- Dar de alta a un técnico");
                    System.out.println("6.- Borrar un técnico");
                    System.out.println("7.- Cerrar sesión");
                    num = Integer.parseInt(s.nextLine());
                    switch (num) {
                        case 1:
                            tele.muestra();
                            movil.muestra();
                            lapiz.muestra();
                            break;
                        case 2:
                            if (manolo.type.equals("normal")) {
                                manolo.muestra();
                            }
                            if (ana.type.equals("normal")) {
                                ana.muestra();
                            }
                            break;
                        case 3:
                            if (manolo.type.equals("tecnico")) {
                                manolo.muestra();
                            }
                            if (ana.type.equals("tecnico")) {
                                ana.muestra();
                            }
                            break;
                        case 4:
                            System.out.println("¿A qué tecnico le deseas encargar la incidencia?");
                            if (manolo.type.equals("tecnico")) {
                                System.out.println("Manolo");
                            }
                            if (ana.type.equals("tecnico")) {
                                System.out.println("Ana");
                            }
                            System.out.println("Elige una opción");
                            String elige = (s.nextLine());
                            if (elige.equalsIgnoreCase("Manolo")) {
                                System.out.println("Elige una incidencia");
                                if (!tele.getResuelta()) {
                                    System.out.println("Televisión");
                                }
                                if (!movil.getResuelta()) {
                                    System.out.println("Movil");
                                }
                                if (!lapiz.getResuelta()) {
                                    System.out.println("Lapiz");
                                }
                                String incidencia = (s.nextLine());
                                if (incidencia.equalsIgnoreCase("Television")) {
                                    tele.setTecnico(manolo);
                                }
                                if (incidencia.equalsIgnoreCase("Movil")) {
                                    movil.setTecnico(manolo);
                                }
                                if (incidencia.equalsIgnoreCase("Lapiz")) {
                                    lapiz.setTecnico(manolo);
                                }
                            }
                            if (elige.equalsIgnoreCase("Ana")) {
                                System.out.println("Elige una incidencia");
                                if (!tele.getResuelta()) {
                                    System.out.println("Televisión");
                                }
                                if (!movil.getResuelta()) {
                                    System.out.println("Movil");
                                }
                                if (!lapiz.getResuelta()) {
                                    System.out.println("Lapiz");
                                }
                                String incidencia = (s.nextLine());
                                if (incidencia.equalsIgnoreCase("Television")) {
                                    tele.setTecnico(ana);
                                }
                                if (incidencia.equalsIgnoreCase("Movil")) {
                                    movil.setTecnico(ana);
                                }
                                if (incidencia.equalsIgnoreCase("Lapiz")) {
                                    lapiz.setTecnico(ana);
                                }
                            }
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 5:
                            System.out.println("¿A qué usuario deseas dar de alta para que sea tecnico?");
                            if (manolo.type.equals("normal")) {
                                System.out.println("Manolo");
                            }
                            if (ana.type.equals("normal")) {
                                System.out.println("Ana");
                            }
                            System.out.println("Elige una opción");
                            String normal = (s.nextLine());
                            if (normal.equalsIgnoreCase("manolo")) {
                                manolo.setType("tecnico");
                            }
                            if (normal.equalsIgnoreCase("ana")) {
                                ana.setType("tecnico");
                            }
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 6:
                            System.out.println("¿A qué tecnico deseas borrar?");
                            if (manolo.type.equals("tecnico")) {
                                System.out.println("Manolo");
                            }
                            if (ana.type.equals("tecnico")) {
                                System.out.println("Ana");
                            }
                            System.out.println("Elige una opción");
                            String tecnico = (s.nextLine());
                            if (tecnico.equalsIgnoreCase("manolo")) {
                                manolo.setType("normal");
                            }
                            if (tecnico.equalsIgnoreCase("ana")) {
                                ana.setType("normal");
                            }
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 7:
                            acceso = false;
                    }
                } while (num != 7);
            }
            if (pablo.type.equals("tecnico")) {
                int num;
                do {
                    System.out.println("Bienvenido Pablo, tiene usted perfil de técnico");
                    System.out.println("Menú:");
                    System.out.println("1.- Consultar las incidencias que tengo asignadas");
                    System.out.println("2.- Marcar una incidencia como cerrada");
                    System.out.println("3.- Consultar las incidencias que he resuelto");
                    System.out.println("4.- Mostrar mi perfil");
                    System.out.println("5.- Cambiar clave de acceso");
                    System.out.println("6.- Cerrar sesión");
                    num = Integer.parseInt(s.nextLine());
                    switch (num) {
                        case 1:
                            if (tele.tecnico.equalsIgnoreCase("Pablo Castellano")) {
                                tele.muestra();
                            }
                            if (movil.tecnico.equalsIgnoreCase("Pablo Castellano")) {
                                movil.muestra();
                            }
                            if (lapiz.tecnico.equalsIgnoreCase("Pablo Castellano")) {
                                lapiz.muestra();
                            }
                            break;
                        case 2:
                            if (tele.tecnico.equalsIgnoreCase("Pablo Castellano")) {
                                System.out.println("Televisión");
                            }
                            if (movil.tecnico.equalsIgnoreCase("Pablo Castellano")) {
                                System.out.println("Movil");
                            }
                            if (lapiz.tecnico.equalsIgnoreCase("Pablo Castellano")) {
                                System.out.println("Lapiz");
                            }
                            System.out.println("Elige una incidencia");
                            String inci = (s.nextLine());
                            if (inci.equalsIgnoreCase("Television")) {
                                tele.setResuelta(true);
                                System.out.println("Debe de comentar como resolución de la incidencia");
                                String comentele = (s.nextLine());
                                tele.setComentarioTecnico(comentele);
                            }
                            if (inci.equalsIgnoreCase("Movil")) {
                                movil.setResuelta(true);
                                System.out.println("Debe de comentar como resolución de la incidencia");
                                String comentele = (s.nextLine());
                                movil.setComentarioTecnico(comentele);
                            }
                            if (inci.equalsIgnoreCase("Lapiz")) {
                                lapiz.setResuelta(true);
                                System.out.println("Debe de comentar como resolución de la incidencia");
                                String comentele = (s.nextLine());
                                lapiz.setComentarioTecnico(comentele);
                            }
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 3:
                            if (tele.getResuelta()) {
                                if (tele.tecnico.equalsIgnoreCase("Pablo Castellano")) {
                                    tele.muestra();
                                }
                            }
                            if (movil.getResuelta()) {
                                if (movil.tecnico.equalsIgnoreCase("Pablo Castellano")) {
                                    movil.muestra();
                                }
                            }
                            if (lapiz.getResuelta()) {
                                if (lapiz.tecnico.equalsIgnoreCase("Pablo Castellano")) {
                                    lapiz.muestra();
                                }
                            }
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 4:
                            pablo.muestra();
                            break;
                        case 5:
                            System.out.println("ESCRIBA SU NUEVA CONTRASEÑA");
                            String contranew = (s.nextLine());
                            pablo.setPassword(contranew);
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 6:
                            acceso = false;
                    }
                } while (num != 6);
            }
            if (pablo.type.equals("normal")) {
                int num;
                do {
                    System.out.println("Bienvenido Pablo, tiene usted perfil de Usuario");
                    System.out.println("Menú:");
                    System.out.println("1.- Registrar una nueva incidencia");
                    System.out.println("2.- Consultar mis incidencias abiertas");
                    System.out.println("3.- Consultar mis incidencias cerradas");
                    System.out.println("4.- Mostrar mi perfil");
                    System.out.println("5.- Cambiar clave de acceso");
                    System.out.println("6.- Cerrar sesión");
                    num = Integer.parseInt(s.nextLine());
                    switch (num) {
                        case 1:
                            System.out.println("Pon una ID a la incidencia");
                            int id = Integer.parseInt(s.nextLine());
                            System.out.println("Pon comentarios detallados del problema");
                            String com = s.nextLine();
                            System.out.println("Defina prioridad: ALTA, BAJA, MEDIA");
                            String prio = s.nextLine();
                            Incidencia inci4 = new Incidencia(id, com, prio, hoy);
                            inci4.setAbre(pablo);
                            inci4.muestra();
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 2:
                            if (tele.nombre.equals("Pablo")) {
                                if (!tele.getResuelta()) {
                                    tele.muestra();
                                }
                            }
                            if (movil.nombre.equals("Pablo")) {
                                if (!movil.getResuelta()) {
                                    movil.muestra();
                                }
                            }
                            if (lapiz.nombre.equals("Pablo")) {
                                if (!lapiz.getResuelta()) {
                                    lapiz.muestra();
                                }
                            }
                            break;
                        case 3:
                            if (tele.nombre.equals("Pablo")) {
                                if (tele.getResuelta()) {
                                    tele.muestra();
                                }
                            }
                            if (movil.nombre.equals("Pablo")) {
                                if (movil.getResuelta()) {
                                    movil.muestra();
                                }
                            }
                            if (lapiz.nombre.equals("Pablo")) {
                                if (lapiz.getResuelta()) {
                                    lapiz.muestra();
                                }
                            }
                            break;
                        case 4:
                            pablo.muestra();
                            break;
                        case 5:
                            System.out.println("ESCRIBA SU NUEVA CONTRASEÑA");
                            String contranew = (s.nextLine());
                            pablo.setPassword(contranew);
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 6:
                            acceso = false;
                    }
                } while (num != 7);
            }
        }
        if (usu.equals(manolo.user) & contra.equals(manolo.password)) {
            acceso = true; //Menús diferentes dependiendo del tipo de usuario que tengan
            if (manolo.type.equals("admin")) {
                int num;
                do {
                    System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
                    System.out.println("Bienvenido Manolo, tiene usted perfil de adminsitrador");
                    System.out.println("Menú:");
                    System.out.println("1.- Consultar todas las incidencias");
                    System.out.println("2.- Consultar todos los usuarios");
                    System.out.println("3.- Consultar todos los técnicos");
                    System.out.println("4.- Asignar una incidencia a un técnico");
                    System.out.println("5.- Dar de alta a un técnico");
                    System.out.println("6.- Borrar un técnico");
                    System.out.println("7.- Cerrar sesión");
                    num = Integer.parseInt(s.nextLine());
                    switch (num) {
                        case 1:
                            tele.muestra();
                            movil.muestra();
                            lapiz.muestra();
                            break;
                        case 2:
                            if (pablo.type.equals("normal")) {
                                pablo.muestra();
                            }
                            if (ana.type.equals("normal")) {
                                ana.muestra();
                            }
                            break;
                        case 3:
                            if (pablo.type.equals("tecnico")) {
                                pablo.muestra();
                            }
                            if (ana.type.equals("tecnico")) {
                                ana.muestra();
                            }
                            break;
                        case 4:
                            System.out.println("¿A qué tecnico le deseas encargar la incidencia?");
                            if (pablo.type.equals("tecnico")) {
                                System.out.println("Pablo");
                            }
                            if (ana.type.equals("tecnico")) {
                                System.out.println("Ana");
                            }
                            System.out.println("Elige una opción");
                            String elige = (s.nextLine());
                            if (elige.equalsIgnoreCase("Pablo")) {
                                System.out.println("Elige una incidencia");
                                if (!tele.getResuelta()) {
                                    System.out.println("Televisión");
                                }
                                if (!movil.getResuelta()) {
                                    System.out.println("Movil");
                                }
                                if (!lapiz.getResuelta()) {
                                    System.out.println("Lapiz");
                                }
                                String incidencia = (s.nextLine());
                                if (incidencia.equalsIgnoreCase("Television")) {
                                    tele.setTecnico(pablo);
                                }
                                if (incidencia.equalsIgnoreCase("Movil")) {
                                    movil.setTecnico(pablo);
                                }
                                if (incidencia.equalsIgnoreCase("Lapiz")) {
                                    lapiz.setTecnico(pablo);
                                }
                            }
                            if (elige.equalsIgnoreCase("Ana")) {
                                System.out.println("Elige una incidencia");
                                if (!tele.getResuelta()) {
                                    System.out.println("Televisión");
                                }
                                if (!movil.getResuelta()) {
                                    System.out.println("Movil");
                                }
                                if (!lapiz.getResuelta()) {
                                    System.out.println("Lapiz");
                                }
                                String incidencia = (s.nextLine());
                                if (incidencia.equalsIgnoreCase("Television")) {
                                    tele.setTecnico(ana);
                                }
                                if (incidencia.equalsIgnoreCase("Movil")) {
                                    movil.setTecnico(ana);
                                }
                                if (incidencia.equalsIgnoreCase("Lapiz")) {
                                    lapiz.setTecnico(ana);
                                }
                            }
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 5:
                            System.out.println("¿A qué usuario deseas dar de alta para que sea tecnico?");
                            if (pablo.type.equals("normal")) {
                                System.out.println("Pablo");
                            }
                            if (ana.type.equals("normal")) {
                                System.out.println("Ana");
                            }
                            System.out.println("Elige una opción");
                            String normal = (s.nextLine());
                            if (normal.equalsIgnoreCase("pablo")) {
                                pablo.setType("tecnico");
                            }
                            if (normal.equalsIgnoreCase("ana")) {
                                ana.setType("tecnico");
                            }
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 6:
                            System.out.println("¿A qué tecnico deseas borrar?");
                            if (pablo.type.equals("tecnico")) {
                                System.out.println("pablo");
                            }
                            if (ana.type.equals("tecnico")) {
                                System.out.println("Ana");
                            }
                            System.out.println("Elige una opción");
                            String tecnico = (s.nextLine());
                            if (tecnico.equalsIgnoreCase("pablo")) {
                                pablo.setType("normal");
                            }
                            if (tecnico.equalsIgnoreCase("ana")) {
                                ana.setType("normal");
                            }
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 7:
                            acceso = false;
                    }
                } while (num != 7);
            }
            if (manolo.type.equals("tecnico")) {
                int num;
                do {
                    System.out.println("Bienvenido Manolo, tiene usted perfil de técnico");
                    System.out.println("Menú:");
                    System.out.println("1.- Consultar las incidencias que tengo asignadas");
                    System.out.println("2.- Marcar una incidencia como cerrada");
                    System.out.println("3.- Consultar las incidencias que he resuelto");
                    System.out.println("4.- Mostrar mi perfil");
                    System.out.println("5.- Cambiar clave de acceso");
                    System.out.println("6.- Cerrar sesión");
                    num = Integer.parseInt(s.nextLine());
                    switch (num) {
                        case 1:
                            if (tele.tecnico.equalsIgnoreCase("Manolo Lopez")) {
                                tele.muestra();
                            }
                            if (movil.tecnico.equalsIgnoreCase("Manolo Lopez")) {
                                movil.muestra();
                            }
                            if (lapiz.tecnico.equalsIgnoreCase("Manolo Lopez")) {
                                lapiz.muestra();
                            }
                            break;
                        case 2:
                            if (tele.tecnico.equalsIgnoreCase("Manolo Lopez")) {
                                System.out.println("Televisión");
                            }
                            if (movil.tecnico.equalsIgnoreCase("Manolo Lopez")) {
                                System.out.println("Movil");
                            }
                            if (lapiz.tecnico.equalsIgnoreCase("Manolo Lopez")) {
                                System.out.println("Lapiz");
                            }
                            System.out.println("Elige una incidencia");
                            String inci = (s.nextLine());
                            if (inci.equalsIgnoreCase("Television")) {
                                tele.setResuelta(true);
                                System.out.println("Debe de comentar como resolución de la incidencia");
                                String comentele = (s.nextLine());
                                tele.setComentarioTecnico(comentele);
                            }
                            if (inci.equalsIgnoreCase("Movil")) {
                                movil.setResuelta(true);
                                System.out.println("Debe de comentar como resolución de la incidencia");
                                String comentele = (s.nextLine());
                                movil.setComentarioTecnico(comentele);
                            }
                            if (inci.equalsIgnoreCase("Lapiz")) {
                                lapiz.setResuelta(true);
                                System.out.println("Debe de comentar como resolución de la incidencia");
                                String comentele = (s.nextLine());
                                lapiz.setComentarioTecnico(comentele);
                            }
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 3:
                            if (tele.getResuelta()) {
                                if (tele.tecnico.equalsIgnoreCase("Manolo Lopez")) {
                                    tele.muestra();
                                }
                            }
                            if (movil.getResuelta()) {
                                if (movil.tecnico.equalsIgnoreCase("Manolo Lopez")) {
                                    movil.muestra();
                                }
                            }
                            if (lapiz.getResuelta()) {
                                if (lapiz.tecnico.equalsIgnoreCase("Manolo Lopez")) {
                                    lapiz.muestra();
                                }
                            }
                            break;
                        case 4:
                            manolo.muestra();
                            break;
                        case 5:
                            System.out.println("ESCRIBA SU NUEVA CONTRASEÑA");
                            String contranew = (s.nextLine());
                            manolo.setPassword(contranew);
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 6:
                            acceso = false;
                    }
                } while (num != 6);
            }
            if (manolo.type.equals("normal")) {
                int num;
                do {
                    System.out.println("Bienvenido Manolo, tiene usted perfil de Usuario");
                    System.out.println("Menú:");
                    System.out.println("1.- Registrar una nueva incidencia");
                    System.out.println("2.- Consultar mis incidencias abiertas");
                    System.out.println("3.- Consultar mis incidencias cerradas");
                    System.out.println("4.- Mostrar mi perfil");
                    System.out.println("5.- Cambiar clave de acceso");
                    System.out.println("6.- Cerrar sesión");
                    num = Integer.parseInt(s.nextLine());
                    switch (num) {
                        case 1:
                            System.out.println("Pon una ID a la incidencia");
                            int id = Integer.parseInt(s.nextLine());
                            System.out.println("Pon comentarios detallados del problema");
                            String com = s.nextLine();
                            System.out.println("Defina prioridad: ALTA, BAJA, MEDIA");
                            String prio = s.nextLine();
                            Incidencia inci4 = new Incidencia(id, com, prio, hoy);
                            inci4.setAbre(manolo);
                            inci4.muestra();
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 2:
                            if (tele.nombre.equals("Manolo")) {
                                if (!tele.getResuelta()) {
                                    tele.muestra();
                                }
                            }
                            if (movil.nombre.equals("Manolo")) {
                                if (!movil.getResuelta()) {
                                    movil.muestra();
                                }
                            }
                            if (lapiz.nombre.equals("Manolo")) {
                                if (!lapiz.getResuelta()) {
                                    lapiz.muestra();
                                }
                            }
                            break;
                        case 3:
                            if (tele.nombre.equals("Manolo")) {
                                if (tele.getResuelta()) {
                                    tele.muestra();
                                }
                            }
                            if (movil.nombre.equals("Manolo")) {
                                if (movil.getResuelta()) {
                                    movil.muestra();
                                }
                            }
                            if (lapiz.nombre.equals("Manolo")) {
                                if (lapiz.getResuelta()) {
                                    lapiz.muestra();
                                }
                            }
                            break;
                        case 4:
                            manolo.muestra();
                            break;
                        case 5:
                            System.out.println("ESCRIBA SU NUEVA CONTRASEÑA");
                            String contranew = (s.nextLine());
                            manolo.setPassword(contranew);
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 6:
                            acceso = false;
                    }
                } while (num != 6);
            }
        }
        if (usu.equals(ana.user) & contra.equals(ana.password)) {
            acceso = true; //Menús diferentes dependiendo del tipo de usuario que tengan
            if (ana.type.equals("admin")) {
                int num;
                do {
                    System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
                    System.out.println("Bienvenido Ana, tiene usted perfil de adminsitrador");
                    System.out.println("Menú:");
                    System.out.println("1.- Consultar todas las incidencias");
                    System.out.println("2.- Consultar todos los usuarios");
                    System.out.println("3.- Consultar todos los técnicos");
                    System.out.println("4.- Asignar una incidencia a un técnico");
                    System.out.println("5.- Dar de alta a un técnico");
                    System.out.println("6.- Borrar un técnico");
                    System.out.println("7.- Cerrar sesión");
                    num = Integer.parseInt(s.nextLine());
                    switch (num) {
                        case 1:
                            tele.muestra();
                            movil.muestra();
                            lapiz.muestra();
                            break;
                        case 2:
                            if (pablo.type.equals("normal")) {
                                pablo.muestra();
                            }
                            if (manolo.type.equals("normal")) {
                                manolo.muestra();
                            }
                            break;
                        case 3:
                            if (pablo.type.equals("tecnico")) {
                                pablo.muestra();
                            }
                            if (manolo.type.equals("tecnico")) {
                                manolo.muestra();
                            }
                            break;
                        case 4:
                            System.out.println("¿A qué tecnico le deseas encargar la incidencia?");
                            if (pablo.type.equals("tecnico")) {
                                System.out.println("Pablo");
                            }
                            if (manolo.type.equals("tecnico")) {
                                System.out.println("Manolo");
                            }
                            System.out.println("Elige una opción");
                            String elige = (s.nextLine());
                            if (elige.equalsIgnoreCase("Pablo")) {
                                System.out.println("Elige una incidencia");
                                if (!tele.getResuelta()) {
                                    System.out.println("Televisión");
                                }
                                if (!movil.getResuelta()) {
                                    System.out.println("Movil");
                                }
                                if (!lapiz.getResuelta()) {
                                    System.out.println("Lapiz");
                                }
                                String incidencia = (s.nextLine());
                                if (incidencia.equalsIgnoreCase("Television")) {
                                    tele.setTecnico(pablo);
                                }
                                if (incidencia.equalsIgnoreCase("Movil")) {
                                    movil.setTecnico(pablo);
                                }
                                if (incidencia.equalsIgnoreCase("Lapiz")) {
                                    lapiz.setTecnico(pablo);
                                }
                            }
                            if (elige.equalsIgnoreCase("Manolo")) {
                                System.out.println("Elige una incidencia");
                                if (!tele.getResuelta()) {
                                    System.out.println("Televisión");
                                }
                                if (!movil.getResuelta()) {
                                    System.out.println("Movil");
                                }
                                if (!lapiz.getResuelta()) {
                                    System.out.println("Lapiz");
                                }
                                String incidencia = (s.nextLine());
                                if (incidencia.equalsIgnoreCase("Television")) {
                                    tele.setTecnico(manolo);
                                }
                                if (incidencia.equalsIgnoreCase("Movil")) {
                                    movil.setTecnico(manolo);
                                }
                                if (incidencia.equalsIgnoreCase("Lapiz")) {
                                    lapiz.setTecnico(manolo);
                                }
                            }
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 5:
                            System.out.println("¿A qué usuario deseas dar de alta para que sea tecnico?");
                            if (pablo.type.equals("normal")) {
                                System.out.println("Pablo");
                            }
                            if (manolo.type.equals("normal")) {
                                System.out.println("Manolo");
                            }
                            System.out.println("Elige una opción");
                            String normal = (s.nextLine());
                            if (normal.equalsIgnoreCase("pablo")) {
                                pablo.setType("tecnico");
                            }
                            if (normal.equalsIgnoreCase("manolo")) {
                                manolo.setType("tecnico");
                            }
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 6:
                            System.out.println("¿A qué tecnico deseas borrar?");
                            if (pablo.type.equals("tecnico")) {
                                System.out.println("pablo");
                            }
                            if (manolo.type.equals("tecnico")) {
                                System.out.println("Manolo");
                            }
                            System.out.println("Elige una opción");
                            String tecnico = (s.nextLine());
                            if (tecnico.equalsIgnoreCase("pablo")) {
                                pablo.setType("normal");
                            }
                            if (tecnico.equalsIgnoreCase("manolo")) {
                                manolo.setType("normal");
                            }
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 7:
                            acceso = false;
                    }
                } while (num != 7);
            }
            if (ana.type.equals("tecnico")) {
                int num;
                do {
                    System.out.println("Bienvenido Ana, tiene usted perfil de técnico");
                    System.out.println("Menú:");
                    System.out.println("1.- Consultar las incidencias que tengo asignadas");
                    System.out.println("2.- Marcar una incidencia como cerrada");
                    System.out.println("3.- Consultar las incidencias que he resuelto");
                    System.out.println("4.- Mostrar mi perfil");
                    System.out.println("5.- Cambiar clave de acceso");
                    System.out.println("6.- Cerrar sesión");
                    num = Integer.parseInt(s.nextLine());
                    switch (num) {
                        case 1:
                            if (tele.tecnico.equalsIgnoreCase("Ana Gomez")) {
                                tele.muestra();
                            }
                            if (movil.tecnico.equalsIgnoreCase("Ana Gomez")) {
                                movil.muestra();
                            }
                            if (lapiz.tecnico.equalsIgnoreCase("Ana Gomez")) {
                                lapiz.muestra();
                            }
                            break;
                        case 2:
                            if (tele.tecnico.equalsIgnoreCase("Ana Gomez")) {
                                System.out.println("Televisión");
                            }
                            if (movil.tecnico.equalsIgnoreCase("Ana Gomez")) {
                                System.out.println("Movil");
                            }
                            if (lapiz.tecnico.equalsIgnoreCase("Ana Gomez")) {
                                System.out.println("Lapiz");
                            }
                            System.out.println("Elige una incidencia");
                            String inci = (s.nextLine());
                            if (inci.equalsIgnoreCase("Television")) {
                                tele.setResuelta(true);
                                System.out.println("Debe de comentar como resolución de la incidencia");
                                String comentele = (s.nextLine());
                                tele.setComentarioTecnico(comentele);
                            }
                            if (inci.equalsIgnoreCase("Movil")) {
                                movil.setResuelta(true);
                                System.out.println("Debe de comentar como resolución de la incidencia");
                                String comentele = (s.nextLine());
                                movil.setComentarioTecnico(comentele);
                            }
                            if (inci.equalsIgnoreCase("Lapiz")) {
                                lapiz.setResuelta(true);
                                System.out.println("Debe de comentar como resolución de la incidencia");
                                String comentele = (s.nextLine());
                                lapiz.setComentarioTecnico(comentele);
                            }
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 3:
                            if (tele.getResuelta()) {
                                if (tele.tecnico.equalsIgnoreCase("Ana Gomez")) {
                                    tele.muestra();
                                }
                            }
                            if (movil.getResuelta()) {
                                if (movil.tecnico.equalsIgnoreCase("Ana Gomez")) {
                                    movil.muestra();
                                }
                            }
                            if (lapiz.getResuelta()) {
                                if (lapiz.tecnico.equalsIgnoreCase("Ana Gomez")) {
                                    lapiz.muestra();
                                }
                            }
                            break;
                        case 4:
                            ana.muestra();
                            break;
                        case 5:
                            System.out.println("ESCRIBA SU NUEVA CONTRASEÑA");
                            String contranew = (s.nextLine());
                            ana.setPassword(contranew);
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 6:
                            acceso = false;
                    }
                } while (num != 6);
            }
            if (ana.type.equals("normal")) {
                int num;
                do {
                    System.out.println("Bienvenido Ana, tiene usted perfil de Usuario");
                    System.out.println("Menú:");
                    System.out.println("1.- Registrar una nueva incidencia");
                    System.out.println("2.- Consultar mis incidencias abiertas");
                    System.out.println("3.- Consultar mis incidencias cerradas");
                    System.out.println("4.- Mostrar mi perfil");
                    System.out.println("5.- Cambiar clave de acceso");
                    System.out.println("6.- Cerrar sesión");
                    num = Integer.parseInt(s.nextLine());
                    switch (num) {
                        case 1:
                            System.out.println("Pon una ID a la incidencia");
                            int id = Integer.parseInt(s.nextLine());
                            System.out.println("Pon comentarios detallados del problema");
                            String com = s.nextLine();
                            System.out.println("Defina prioridad: ALTA, BAJA, MEDIA");
                            String prio = s.nextLine();
                            Incidencia inci4 = new Incidencia(id, com, prio, hoy);
                            inci4.setAbre(ana);
                            inci4.muestra();
                            break;
                        case 2:
                            if (tele.nombre.equals("Ana")) {
                                if (!tele.getResuelta()) {
                                    tele.muestra();
                                }
                            }
                            if (movil.nombre.equals("Ana")) {
                                if (!movil.getResuelta()) {
                                    movil.muestra();
                                }
                            }
                            if (lapiz.nombre.equals("Ana")) {
                                if (!lapiz.getResuelta()) {
                                    lapiz.muestra();
                                }
                            }
                            break;
                        case 3:
                            if (tele.nombre.equals("Ana")) {
                                if (tele.getResuelta()) {
                                    tele.muestra();
                                }
                            }
                            if (movil.nombre.equals("Ana")) {
                                if (movil.getResuelta()) {
                                    movil.muestra();
                                }
                            }
                            if (lapiz.nombre.equals("Ana")) {
                                if (lapiz.getResuelta()) {
                                    lapiz.muestra();
                                }
                            }
                            break;
                        case 4:
                            ana.muestra();
                            break;
                        case 5:
                            System.out.println("ESCRIBA SU NUEVA CONTRASEÑA");
                            String contranew = (s.nextLine());
                            ana.setPassword(contranew);
                            System.out.println("CAMBIOS REALIZADOS CON EXITO");
                            System.out.println("////////////////////////////");
                            break;
                        case 6:
                            acceso = false;
                    }
                } while (num != 6);
            }
        }
    }
        while (!acceso) ;
    }
}