package nttdata.javat3.business;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdata.javat3.business.employee.Category;
import nttdata.javat3.business.employee.Employee;
import nttdata.javat3.business.employee.Project;
import nttdata.javat3.business.student.Modality;
import nttdata.javat3.business.student.School;
import nttdata.javat3.business.student.Student;
import nttdata.javat3.exceptions.EqualPerson;

/**
 * Clase para la gestión del servicio
 * 
 * @author nandi
 *
 */
public class ManagmentServiceImpl implements ManagmentServiceI {

	/** Conjunto de los proyectos */
	private Set<Project> projectEmployees;

	/** Conjunto de centros educativos */
	private Set<School> schoolStudent;

	/** Logger para las trazas */
	private static final Logger MSLOG = LoggerFactory.getLogger(ManagmentServiceImpl.class);

	/** Fin del método */
	private static final String OUTPUTMETHOD = "FIN MÉTODO";

	/** Entrada del método */
	private static final String INPUTMETHOD = "ENTRADA MÉTODO";

	/**
	 * Constructor del servicio
	 */
	public ManagmentServiceImpl() {
		super();

		MSLOG.info("Generando Servicio");

		projectEmployees = new TreeSet<>();

		schoolStudent = new TreeSet<>();

	}

	@Override
	public void addPerson(String type, String name, String surname, String dni, School school, Modality modality,
			Project project, Category category) throws EqualPerson {

		MSLOG.info(INPUTMETHOD);

		// Si el método checkPerson devuelve false entra en la condición, si no, lanza
		// la excepcion de EqualPerson
		if (!this.checkPerson(name, surname, dni)) {

			// Si el tipo es igual a S es que se quiere crear un alumno
			if (type.equalsIgnoreCase("S")) {

				MSLOG.info("Creando alumno");

				// llamamos al método addStudent para que lo añada
				this.addStudent(new Student(dni, name, surname, school, modality));

				MSLOG.info("Alumno creado");

				// Si el tipo es igual a E es que se quiere crear un empleado
			} else if (type.equalsIgnoreCase("E")) {

				MSLOG.info("Creando empleado");

				// llamamos al método addmployee para que lo añada
				this.addEmployee(new Employee(dni, name, surname, project, category));

				MSLOG.info("Empleado creado");

			}

		} else {

			throw new EqualPerson("La persona que se quiere crear ya existe");

		}

		MSLOG.info(OUTPUTMETHOD);

	}

	@Override
	public boolean checkPerson(String name, String surname, String dni) {

		MSLOG.info("Comprobando si la persona existe");

		// Si alguno de los dos métodos llamado devuelve true es que la persona ya
		// existe
		return checkEmployee(name, surname, dni) || checkStudent(name, surname, dni);

	}

	@Override
	public boolean checkEmployee(String name, String surname, String dni) {

		MSLOG.info(INPUTMETHOD);

		// Se genera un booleano para indicar si existe o no
		boolean exist = Boolean.FALSE;

		// Se genera un iterator para recorrer los proyectos ya que es más eficiente,
		// una
		// vez encontrado el empleado se sale del bucle
		Iterator<Project> itProjects = projectEmployees.iterator();

		// Mientras exist sea false y el Iterador tenga valor siguiente entra en el
		// bucle
		while (!exist && itProjects.hasNext()) {

			Project p = itProjects.next();

			// Si el proyecto que indica el iterador contiene el empleado pasado por
			// parámetro entra en la condición y exist = true
			if (p.containEmployee(new Employee(dni, name, surname, null, null))) {

				MSLOG.info("Existe la persona");

				exist = Boolean.TRUE;

			}

		}

		MSLOG.info(OUTPUTMETHOD);

		return exist;
	}

	@Override
	public boolean checkStudent(String name, String surname, String dni) {

		MSLOG.info(INPUTMETHOD);

		// Se genera un booleano para indicar si existe o no
		boolean exist = Boolean.FALSE;

		// Se genera un iterator para recorrer los centros educativos ya que es más
		// eficiente una
		// vez encontrado el alumno se sale del bucle
		Iterator<School> itSchools = schoolStudent.iterator();

		// Mientras exist sea false y el Iterador tenga valor siguiente entra en el
		// bucle
		while (!exist && itSchools.hasNext()) {

			School s = itSchools.next();

			// Si el centro educativo que indica el iterador contiene el alumno pasado por
			// parámetro entra en la condición y exist = true
			if (s.containStudent(new Student(dni, name, surname, null, null))) {

				MSLOG.info("Existe la persona");

				exist = Boolean.TRUE;

			}

		}

		MSLOG.info(OUTPUTMETHOD);

		return exist;
	}

	@Override
	public void addStudent(Student p) {

		MSLOG.info(INPUTMETHOD);

		// Genera un booleano para indicar cuando se ha añadido al estudiante y sea más
		// eficiente
		boolean added = Boolean.FALSE;

		// Comprueba si el centro educativo del estudiante lo contiene el conjunto,
		// Si lo contiene entra en la condición si no no se realiza nada
		if (schoolStudent.contains(p.getSchool())) {

			// Genera un iterador para recorrer los centros educativos
			Iterator<School> itSchools = schoolStudent.iterator();

			// Mientras added sea false y el Iterador tenga valor siguiente entra en el
			// bucle
			while (itSchools.hasNext() && !added) {

				School s = itSchools.next();
				// Si el centro educativo que indica el iterador es igual al del estudiante
				// pasado por parámetro, entra en la condición y lo añade y added se pone a true
				if (p.getSchool().equals(s)) {

					s.addStudent(p);
					added = Boolean.TRUE;

					MSLOG.info("Alumno añadido");
				}

			}

		}

		MSLOG.info(OUTPUTMETHOD);

	}

	@Override
	public void addSchool(School s) {

		MSLOG.info(INPUTMETHOD);

		// Si el conjunto no contiene el centro educativo pasado por parámetro
		// entra en la condición y lo añade si lo ya lo contenía no realiza nada
		if (!schoolStudent.contains(s)) {

			schoolStudent.add(s);
			MSLOG.info("Centro educativo añadido");

		}

		MSLOG.info(OUTPUTMETHOD);

	}

	@Override
	public void addEmployee(Employee e) {

		MSLOG.info(INPUTMETHOD);

		// Genera un booleano para indicar cuando se ha añadido al estudiante y sea más
		// eficiente
		boolean added = Boolean.FALSE;

		// Comprueba si el proyecto del empleado pasado por parámetro lo contiene el
		// conjunto,
		// Si lo contiene entra en la condición si no no se realiza nada
		if (projectEmployees.contains(e.getProject())) {

			// Genera un iterador para recorrer los proyectos
			Iterator<Project> itProjects = projectEmployees.iterator();

			// Mientras added sea false y el Iterador tenga valor siguiente entra en el
			// bucle
			while (!added && itProjects.hasNext()) {

				Project p = itProjects.next();

				// Si el proyecto que indica el iterador es igual al del empleado
				// pasado por parámetro, entra en la condición y lo añade y added se pone a true
				if (e.getProject().equals(p)) {

					p.addEmployee(e);
					added = Boolean.TRUE;
					MSLOG.info("Empleado añadido");

				}

			}

		}

		MSLOG.info(OUTPUTMETHOD);

	}

	@Override
	public void addProject(Project p) {

		MSLOG.info(INPUTMETHOD);

		// Si el conjunto no contiene el proyecto pasado por parámetro
		// entra en la condición y lo añade si lo ya lo contenía no realiza nada
		if (!projectEmployees.contains(p)) {

			projectEmployees.add(p);
			MSLOG.info("Proyecto añadido");

		}

		MSLOG.info(OUTPUTMETHOD);

	}

	@Override
	public String showPeople() {

		MSLOG.info(INPUTMETHOD);

		// Genera un StringBuilder para guardar los string de manera más eficiente y
		// luego mostrarlos
		StringBuilder list = new StringBuilder();

		list.append("Centros educativos: ");
		list.append("\n");
		MSLOG.info("Mostrando los centros educativos y sus alumnos");

		// Recorre los centros educativos y llama al método showStudents de la clase
		// School para mostrar los alumnos
		for (School s : schoolStudent) {

			list.append(s.showStudents());

		}

		list.append("Proyectos: ");
		list.append("\n");
		MSLOG.info("Mostrando los proyectos y sus empleados");

		// Recorre los proyectos y llama al método showEmployee de la clase
		// Proyect para mostrar los empleados
		for (Project p : projectEmployees) {

			list.append(p.showEmployees());

		}

		MSLOG.info(OUTPUTMETHOD);

		return list.toString();
	}

}
