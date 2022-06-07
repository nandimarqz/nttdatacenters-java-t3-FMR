package nttdata.javat3.business;

import nttdata.javat3.business.employee.Category;
import nttdata.javat3.business.employee.Employee;
import nttdata.javat3.business.employee.Project;
import nttdata.javat3.business.student.Modality;
import nttdata.javat3.business.student.School;
import nttdata.javat3.business.student.Student;
import nttdata.javat3.exceptions.EqualPerson;


public interface ManagmentServiceI {

	/**
	 * Método que añade a la persona pasada por parametro en su tipo especifico
	 * 
	 * @param type
	 * @param name
	 * @param surname
	 * @param dni
	 * @param school
	 * @param modality
	 * @param project
	 * @param category
	 * @throws EqualPerson
	 */
	public void addPerson(String type, String name, String surname, String dni, School school, Modality modality,
			Project project, Category category) throws EqualPerson;

	/**
	 * Añade el estudiante que se le pasa por parámetro a su centro educativo
	 * 
	 * @param p
	 * @throws EqualPerson
	 */
	public void addStudent(Student p) throws EqualPerson;

	/**
	 * Añade el centro educativo pasado por parámetro
	 * 
	 * @param s
	 */
	public void addSchool(School s);

	/**
	 * Añade el empleado que se le pasa por parámetro a su proyecto
	 * 
	 * @param e
	 */
	public void addEmployee(Employee e);

	/**
	 * Añade el proyecto pasado por parámetro
	 * 
	 * @param p
	 */
	public void addProject(Project p);
	
	/**
	 * Devuelve un booleano indicando si la persona pasada por parámetro existe o no
	 * 
	 * @param name
	 * @param surname
	 * @param dni
	 * @return boolean
	 */
	public boolean checkPerson(String name, String surname, String dni);
	
	/**
	 * Devuelve un booleano indicando si el empleado pasado por parámetro existe o no
	 * 
	 * @param name
	 * @param surname
	 * @param dni
	 * @return boolean
	 */
	public boolean checkEmployee(String name, String surname, String dni);

	/**
	 * Devuelve un booleano indicando si el estudiante pasado por parámetro existe o no 
	 * 
	 * @param name
	 * @param surname
	 * @param dni
	 * @return boolean
	 */
	public boolean checkStudent(String name, String surname, String dni);
	
	/**
	 * Devuelve un String con las personas guardadas en los conjuntos
	 * 
	 * @return String
	 */
	public String showPeople();

}
