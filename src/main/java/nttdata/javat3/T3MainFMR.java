package nttdata.javat3;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdata.javat3.business.ManagmentServiceI;
import nttdata.javat3.business.ManagmentServiceImpl;
import nttdata.javat3.business.employee.Category;
import nttdata.javat3.business.employee.Project;
import nttdata.javat3.business.student.Modality;
import nttdata.javat3.business.student.School;
import nttdata.javat3.exceptions.EqualPerson;

/**
 * Clase Main
 * 
 * @author nandi
 *
 */
public class T3MainFMR {

	/** Menu de opciones */
	private static final String MENU = "1.- Añadir un alumno a un instituto" + "\n2.- Añadir un empleado a un proyecto"
			+ "\n3.- Mostrar a todas las personas" + "\n4.- Comprobar si existe un alumno"
			+ "\n5.- Comprobar si existe un empleado" + "\n6.- Salir" + "\nSeleccione el numero de la opción";

	/** Opcion incorrecta */
	private static final String WRONGOPTION = "La opcion seleccionada no pertenece a ninguna del menú"
			+ "\nEscoja una opción del menú";

	/** Peticion de apellido */
	private static final String SURNAMEREQUEST = "Introduzca el apellido";

	/** Peticion de nombre */
	private static final String NAMEREQUEST = "Introduzca el nombre";

	/** Peticion de DNI */
	private static final String DNIREQUEST = "Introduzca el DNI";

	/** Logger para las trazas */
	private static final Logger MAINLOG = LoggerFactory.getLogger(T3MainFMR.class);

	/** Modalidad seleccionada */
	private static final String SELECTEDMODALITY = "Modalidad seleccionada: {}";

	/** Categoría seleccionada */
	private static final String SELECTEDCATEGORY = "Categoria seleccionada: {}";

	/** Opción seleccionada no existe */
	private static final String OPTIONNOTEXIST = "La opción escogida no exsite";

	/** Fin del método */
	private static final String OUTPUTMETHOD = "FIN MÉTODO";

	/** Entrada al método */
	private static final String INPUTMETHOD = "ENTRADA MÉTODO";

	/**
	 * Método pricipal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/** DNI de la persona */
		String dni = "";

		/** Name de la persona */
		String name = "";

		/** Surname de la persona */
		String surname = "";

		/** Proyecto Naturgy */
		Project p1 = new Project("Naturgy");
		/** Proyecto Banco Popular */
		Project p2 = new Project("Banco Popular");
		/** Proyecto DUAL */
		Project p3 = new Project("DUAL");

		MAINLOG.info("Generando proyectos");

		/** Centro educativo IES Hermanos Machado */
		School s1 = new School("IES Hermanos Machado");
		/** Centro educativo CESUR Sevilla */
		School s2 = new School("CESUR Sevilla");
		/** Centro educativo CESUR Málaga */
		School s3 = new School("CESUS Málaga");
		/** Centro educativo Pablo Picasso Málaga */
		School s4 = new School("Pablo Picasso Málaga");
		/** Centro educativo IES Alixar */
		School s5 = new School("IES Alixar");

		MAINLOG.info("Generando centros educativos");

		/** Servicio de gestion */
		ManagmentServiceI ms = new ManagmentServiceImpl();

		MAINLOG.info("Inyectando servicio de gestión");

		MAINLOG.info("Añadiendo proyectos");

		// Añade proyectos
		ms.addProject(p1);
		ms.addProject(p2);
		ms.addProject(p3);

		MAINLOG.info("Añadiendo centros educativos");

		// Añade centros educativos
		ms.addSchool(s1);
		ms.addSchool(s2);
		ms.addSchool(s3);
		ms.addSchool(s4);
		ms.addSchool(s5);

		try (Scanner sc = new Scanner(System.in)) {

			MAINLOG.info("Generando menú");

			// Da la bienvenida y muestra el menú
			System.out.println("Bienvenido al Servicio de Gestión de empleados y estudiantes de NTTDATA");
			System.out.println(MENU);

			// Guarda la opción en una variable
			int option = sc.nextInt();

			// Mientras que la opcion sea distinta a 6 entra en el bucle
			while (option != 6) {

				// Genera un bloque try para recoger las excepcionea que salten
				try {

					switch (option) {
					case 1:

						MAINLOG.info("ENTRADA CASO 1");

						// Pide el apellido y lo guarda en una variable
						System.out.println(DNIREQUEST);
						dni = sc.next();

						// Pide el nombre y lo guarda en una variable
						System.out.println(NAMEREQUEST);
						name = sc.next();

						// Pide el apellido y lo guarda en una variable
						System.out.println(SURNAMEREQUEST);
						surname = sc.next();

						// Llama al método showSchools y guarda en una variable el centro educativo
						// seleccionado
						School s = showSchools(sc, s1, s2, s3, s4, s5);

						// Llama al método showModalities y guarda en una variable la modalidad
						// seleccionada
						Modality m = showModalities(sc);

						// Llama al método addPerson del servico y añade la persona en este caso un
						// estudiante
						ms.addPerson("S", name, surname, dni, s, m, null, null);

						MAINLOG.info("FIN CASO 1");
						break;
					case 2:

						MAINLOG.info("ENTRADA CASO 2");

						// Pide el apellido y lo guarda en una variable
						System.out.println(DNIREQUEST);
						dni = sc.next();

						// Pide el nombre y lo guarda en una variable
						System.out.println(NAMEREQUEST);
						name = sc.next();

						// Pide el apellido y lo guarda en una variable
						System.out.println(SURNAMEREQUEST);
						surname = sc.next();

						// Llama al método showProjects y guarda en una variable el proyecto
						// seleccionado
						Project p = showProjects(sc, p1, p2, p3);

						// Llama al método showCategories y guarda en una variable la categoría
						// seleccionado
						Category c = showCategories(sc);

						// Llama al método addPerson del servico y añade la persona en este caso un
						// empleado
						ms.addPerson("E", name, surname, dni, null, null, p, c);

						MAINLOG.info("FIN CASO 2");
						break;
					case 3:

						MAINLOG.info("ENTRADA CASO 3");

						// Llama al método showPeople del servicio y los muestra por consola
						System.out.println(ms.showPeople());

						MAINLOG.info("FIN CASO 3");
						break;
					case 4:

						MAINLOG.info("ENTRADA CASO 4");

						// Pide el apellido y lo guarda en una variable
						System.out.println(DNIREQUEST);
						dni = sc.next();

						// Pide el nombre y lo guarda en una variable
						System.out.println(NAMEREQUEST);
						name = sc.next();

						// Pide el apellido y lo guarda en una variable
						System.out.println(SURNAMEREQUEST);
						surname = sc.next();

						// Llama al método checkStudent del servivio y devuelve un boolean indicando si
						// existe o no por consola
						System.out.println(ms.checkStudent(name, surname, dni));

						MAINLOG.info("FIN CASO 4");
						break;
					case 5:

						MAINLOG.info("ENTRADA CASO 5");

						// Pide el apellido y lo guarda en una variable
						System.out.println(DNIREQUEST);
						dni = sc.next();

						// Pide el nombre y lo guarda en una variable
						System.out.println(NAMEREQUEST);
						name = sc.next();

						// Pide el apellido y lo guarda en una variable
						System.out.println(SURNAMEREQUEST);
						surname = sc.next();

						// Llama al método checkEmployee del servivio y devuelve un boolean indicando si
						// existe o no por consola
						System.out.println(ms.checkEmployee(name, surname, dni));

						MAINLOG.info("FIN CASO 5");
						break;
					default:

						// Si escoge una opcion que no existe lo muestra por consola
						MAINLOG.warn(OPTIONNOTEXIST);
						System.out.println(WRONGOPTION);

						break;
					}

					// Se captura la excepcion EqualPerson
				} catch (EqualPerson e) {
					// Muestra por consola el mensaje de la excepcion
					System.out.println(e.getMessage());
					MAINLOG.warn(e.getMessage());

				}

				// Se vuelve a mostrar el menú
				System.out.println(MENU);
				option = sc.nextInt();
			}

		}
	}

	/**
	 * Devuelve el centro educativo seleccionado
	 * 
	 * @param sc
	 * @param schools
	 * @return School
	 */
	public static School showSchools(Scanner sc, School... schools) {

		MAINLOG.info(INPUTMETHOD);

		System.out.println("Seleccione la escuela: " + "\n");

		// Muestra las escuelas pasadas por parámetro
		for (int i = 0; i < schools.length; i++) {

			System.out.println(i + 1);
			System.out.println(schools[i]);

		}

		// Selecciona el número del índice de las escuelas y lo guarda en una variable
		System.out.println("Seleccione el número de la escuela");
		int option = sc.nextInt();

		// Genera un booleano para la condicion del bucle
		boolean selected = Boolean.FALSE;

		School s = null;
		// Mientras que selected sea false entra en el bucle
		while (!selected) {

			// Si la opcion escogida esta entre el 1 y el 5 entra en la condicion y s pasa a
			// ser la escuela escogida y selected se pone a true
			// Si no existe la opcion si es menor a 1 o mayor a 5 muestra option not exist
			if (option == 1 || option == 2 || option == 3 || option == 4 || option == 5) {

				MAINLOG.info("Centro educativo seleccionado: {}", schools[option - 1].getName());
				s = schools[option - 1];
				selected = Boolean.TRUE;

			} else {

				MAINLOG.warn(OPTIONNOTEXIST);
				System.out.println(WRONGOPTION);

			}

		}

		MAINLOG.info(OUTPUTMETHOD);
		return s;

	}

	/**
	 * Devuelve la modalidad seleccionada
	 * 
	 * @param sc
	 * @return Modality
	 */
	public static Modality showModalities(Scanner sc) {

		MAINLOG.info(INPUTMETHOD);

		Modality m = null;
		boolean selected = Boolean.FALSE;

		// Miestras que selected sea falso entra en bucle
		while (!selected) {

			// Muestra las modalidades y guarda en una variable la opcion escogida
			System.out.println("Seleccione la modalidad en la que quiere inscribirse: ");
			System.out.println("\n1.- DAM" + "\n2.- DAW" + "\nSeleccione el numero de la modalidad");
			int option = sc.nextInt();

			switch (option) {
			case 1:
				// Si la opcion es igual 1 m pasa a ser DAM y selected = true
				MAINLOG.info(SELECTEDMODALITY, Modality.DAM);
				m = Modality.DAM;
				selected = Boolean.TRUE;
				break;

			case 2:
				// Si la opcion es igual 2 m pasa a ser DAM y selected = true
				MAINLOG.info(SELECTEDMODALITY, Modality.DAW);
				m = Modality.DAW;
				selected = Boolean.TRUE;
				break;

			default:
				// Si la opcion no esta en ninguno de los casos muestra option not exist
				MAINLOG.warn(OPTIONNOTEXIST);
				System.out.println(WRONGOPTION);
				break;
			}

		}

		MAINLOG.info(OUTPUTMETHOD);

		return m;

	}

	/**
	 * Devuelve la categoria seleccionada
	 * 
	 * @param sc
	 * @return Category
	 */
	public static Category showCategories(Scanner sc) {

		MAINLOG.info(INPUTMETHOD);

		Category c = null;
		boolean selected = Boolean.FALSE;

		// Mientras que selected sea false entra en el bucle
		while (!selected) {

			// Muestra las categorías y guarda en una variable la opcion escogida
			System.out.println("Seleccione la categoria en la que quiere inscribirse: ");
			System.out.println("\n1.- Junior" + "\n2.- Developer" + "\n3.- Analyst Developer" + "\n4.- Analyst"
					+ "\n5.- Project Manager" + "\n6.- Architect" + "\nSeleccione el numero de la categoría");
			int option = sc.nextInt();

			switch (option) {
			case 1:
				// Si la opción es igual a 1, c es igual a JUNIOR y selected = true
				MAINLOG.info(SELECTEDCATEGORY, Category.JUNIOR);
				c = Category.JUNIOR;
				selected = Boolean.TRUE;
				break;

			case 2:
				// Si la opción es igual a 2, c es igual a DEVELOPER y selected = true
				MAINLOG.info(SELECTEDCATEGORY, Category.DEVELOPER);
				c = Category.DEVELOPER;
				selected = Boolean.TRUE;
				break;

			case 3:
				// Si la opción es igual a 3, c es igual a ANALYST_DEVELOPER y selected = true
				MAINLOG.info(SELECTEDCATEGORY, Category.ANALYST_DEVELOPER);
				c = Category.ANALYST_DEVELOPER;
				selected = Boolean.TRUE;
				break;

			case 4:
				// Si la opción es igual a 4, c es igual a ANALYST y selected = true
				MAINLOG.info(SELECTEDCATEGORY, Category.ANALYST);
				c = Category.ANALYST;
				selected = Boolean.TRUE;
				break;

			case 5:
				// Si la opción es igual a 5, c es igual a PROJECT_MANAGER y selected = true
				MAINLOG.info(SELECTEDCATEGORY, Category.PROJECT_MANAGER);
				c = Category.PROJECT_MANAGER;
				selected = Boolean.TRUE;
				break;

			case 6:
				// Si la opción es igual a 6, c es igual a ARCHITECT y selected = true
				MAINLOG.info(SELECTEDCATEGORY, Category.ARCHITECT);
				c = Category.ARCHITECT;
				selected = Boolean.TRUE;
				break;
			default:
				// Si la opcion no esta en ninguno de los casos muestra option not exist
				MAINLOG.warn(OPTIONNOTEXIST);
				System.out.println(WRONGOPTION);
				break;
			}

		}

		MAINLOG.info(OUTPUTMETHOD);

		return c;

	}

	/**
	 * Devuelve el proyecto seleccionado
	 * 
	 * @param sc
	 * @param projects
	 * @return Proyect
	 */
	public static Project showProjects(Scanner sc, Project... projects) {

		MAINLOG.info(INPUTMETHOD);

		Project p = null;
		boolean selected = Boolean.FALSE;

		// Mientras que selected sea false entra en el bucle
		while (!selected) {

			// Muestra los proyectos pasados por parámetro y guarda la opcion en una
			// variable
			System.out.println("Seleccione el proyecto en la que quiere inscribirse: ");
			System.out.println(
					"\n1.- Naturgy" + "\n2.- Banco Popular" + "\n3.- DUAL" + "\nSeleccione el numero del proyecto");
			int option = sc.nextInt();

			// Si la opción esta entre 1 y 3 entra en la condicion y p pasa a ser el
			// proeycto seleccionado y selected = true, si no esta entre 1 y 3 muestra
			// wrong option
			if (option == 1 || option == 2 || option == 3) {

				MAINLOG.info("Projecto seleccionado: {}", projects[option - 1].getName());
				p = projects[option - 1];
				selected = Boolean.TRUE;

			} else {

				
				System.out.println(WRONGOPTION);
				MAINLOG.warn(OPTIONNOTEXIST);

			}

		}

		MAINLOG.info(OUTPUTMETHOD);

		return p;

	}
}
