package nttdata.javat3.business.employee;

import nttdata.javat3.business.Person;

/**
 * Clase Empleado
 * 
 * @author nandi
 *
 */
public class Employee extends Person implements Comparable<Employee> {

	/** Proyecto del empleado */
	private Project project;

	/** Categoria del empleado */
	private Category category;

	/**
	 * Constructor del empleado
	 * 
	 * @param dni
	 * @param name
	 * @param surname
	 * @param project
	 * @param category
	 */
	public Employee(String dni, String name, String surname, Project project, Category category) {
		super(dni, name, surname);

		this.project = project;
		this.category = category;
	}

	/**
	 * Método que devuelve el proyecto del empleado
	 * 
	 * @return Project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * Método que actualiza el proyecto del empleado
	 * 
	 * @param project
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * Método que devuelve la categoría del empleado
	 * 
	 * @return Category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Método que actualiza la categoría del empleado
	 * 
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String showDetails() {

		StringBuilder details = new StringBuilder();

		details.append(super.showDetails());
		details.append("\n");
		details.append("Proyecto: ");
		details.append("\n");
		details.append(project);
		details.append("\n");
		details.append("Categoria: ");
		details.append(category);
		details.append("\n");

		return details.toString();
	}

	/**
	 * Compara a los empleados por el nombre
	 * 
	 *  @return Integer
	 */
	@Override
	public int compareTo(Employee o) {

		return this.name.compareTo(o.name);
	}
}
