package nttdata.javat3.business.student;

import nttdata.javat3.business.Person;

/**
 * Clase estudiante
 * 
 * @author nandi
 *
 */
public class Student extends Person implements Comparable<Student> {

	/** Centro educativo del estudiante */
	private School school;

	/** Modalidad del estudiante */
	private Modality modality;

	/**
	 * Constructor del estudiante
	 * 
	 * @param dni
	 * @param name
	 * @param surname
	 * @param school
	 * @param modality
	 */
	public Student(String dni, String name, String surname, School school, Modality modality) {
		super(dni, name, surname);

		this.school = school;
		this.modality = modality;
	}

	/**
	 * Método que devuelve el centro educativo del estudiante
	 * 
	 * @return School
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * Método para actualizar el centro educativo del estudiante
	 * 
	 * @param school
	 */
	public void setSchool(School school) {
		this.school = school;
	}

	/**
	 * Método que devuelve la modalidad que cursa el estudiante
	 * 
	 * @return Modality
	 */
	public Modality getModality() {
		return modality;
	}

	/**
	 * Método para actualizar la modalidad del estudiante
	 * 
	 * @param modality
	 */
	public void setModality(Modality modality) {
		this.modality = modality;
	}

	@Override
	public String showDetails() {

		StringBuilder details = new StringBuilder();

		details.append(super.showDetails());
		details.append("\n");
		details.append("Centro educativo: ");
		details.append(school);
		details.append("\n");
		details.append("Modalidad: ");
		details.append(modality);
		details.append("\n");

		return details.toString();
	}

	/**
	 * Compara los estudiantes por el nombre
	 * 
	 * @return Integer
	 */
	@Override
	public int compareTo(Student o) {

		return this.name.compareTo(o.name);
	}

}
