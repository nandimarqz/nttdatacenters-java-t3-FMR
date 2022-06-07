package nttdata.javat3.business.employee;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase Proyecto
 * 
 * @author nandi
 *
 */
public class Project implements Comparable<Project> {

	/** Nombre del proyecto */
	private String name;

	/** Conjunto de los empleados del proyecto */
	private Set<Employee> employees;

	/** Logger para las trazas */
	private static final Logger PROJECTLOG = LoggerFactory.getLogger(Project.class);

	/**
	 * Constructor del proyecto
	 * 
	 * @param name
	 */
	public Project(String name) {
		super();

		PROJECTLOG.info("Creando el proyecto: {}", name);

		this.name = name;
		this.employees = new TreeSet<>();

	}

	/**
	 * Método que devuelve el nombre del proyecto
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método que actualiza el nombre del proyecto
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Método que devuelve el conjunto de los empleados del proyecto
	 * 
	 * @return Set<Employee>
	 */
	public Set<Employee> getEmployee() {
		return employees;
	}

	/**
	 * Método que actualiza el conjunto de empleados del proyecto
	 * 
	 * @param employees
	 */
	public void setEmployee(Set<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * Método que añade el empleado pasado por parámetro al conjunto de empleados
	 * del proyecto
	 * 
	 * @param employee
	 */
	public void addEmployee(Employee employee) {

		// Se añade directamente el empleado ya que al ser un conjunto no se pueden
		// repetir los objetos que contiene
		employees.add(employee);

	}

	/**
	 * Método que devuelve un booleano indicando si el proyecto contiene al empleado
	 * pasado por parámetro
	 * 
	 * @param e
	 * @return
	 */
	public boolean containEmployee(Employee e) {

		PROJECTLOG.info("ENTRADA MÉTODO");
		// Genera un booleano para indicar si existe o no
		boolean exist = Boolean.FALSE;

		// Genera un iterador para recorrer los empleados del conjuntos
		Iterator<Employee> it = employees.iterator();

		// Mientras exist sea false y el iterador tenga valor siguiente entra en el
		// bucle
		while (!exist && it.hasNext()) {

			Employee employee = it.next();

			// Si el empleado que indica employee es igual al pasado por parametro entra en
			// la
			// condicion y exist = true eso indica que existe ya el empleado pasado por
			// parámetro (dos empleados son iguales si sus DNIs lo son )
			if (employee.equals(e)) {

				exist = Boolean.TRUE;
				System.out.println("El dni del empleado esta registrado");

			}

		}

		PROJECTLOG.info("FIN MÉTODO");

		return exist;
	}

	/**
	 * Método que devuelve un String con con los empleados del proyecto q
	 * 
	 * @return
	 */
	public String showEmployees() {

		PROJECTLOG.info("ENTRADA MÉTODO");

		StringBuilder list = new StringBuilder();

		list.append("Proyecto: ");
		list.append(this.name);
		list.append("\n");
		list.append("Empleados: ");
		list.append("\n");
		PROJECTLOG.info("Mostrando los empleados del proyecto: {}", this.name);

		// Recorre los empleados del conjunto y los va añadiendo al StringBuilder
		for (Employee e : employees) {

			list.append(e);
			list.append("\n");

		}

		list.append("\n");

		PROJECTLOG.info("FIN MÉTODO");

		return list.toString();

	}

	/**
	 * Método que genera el HashCode del proyecto por el nombre
	 * 
	 * @return Integer
	 * 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	/**
	 * Dos proyectos son iguales si sus nombres los son
	 * 
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(name, other.name);
	}

	/**
	 * Devuelve un string con el nombre del proyecto y el numero de empleados
	 * 
	 * @return String
	 */
	@Override
	public String toString() {

		StringBuilder project = new StringBuilder();

		project.append("Nombre del proyecto: ");
		project.append(name);
		project.append("\n");
		project.append("Número de empleados: ");
		project.append(employees.size());

		return project.toString();
	}

	/**
	 * Compara a los proyectos por el nombre
	 * 
	 * @return Integer
	 */
	@Override
	public int compareTo(Project o) {

		return this.name.compareTo(o.name);
	}

}
