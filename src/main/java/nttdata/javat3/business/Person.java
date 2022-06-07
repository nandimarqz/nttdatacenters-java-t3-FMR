package nttdata.javat3.business;

import java.util.Objects;

/**
 * Clase Persona
 * 
 * @author nandi
 *
 */
public abstract class Person {

	/** DNI de la persona */
	protected String dni;

	/** Nombre de la persona */
	protected String name;

	/** Apellido de la persona */
	protected String surname;

	/**
	 * Constructor de la persona
	 * 
	 * @param dni
	 * @param name
	 * @param surname
	 */
	protected Person(String dni, String name, String surname) {
		super();

		this.dni = dni;
		this.name = name;
		this.surname = surname;
	}

	/**
	 * Método que devuelve el DNI de la persona
	 * 
	 * @return String
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Método que actualiza el DNI de la persona
	 * 
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Método que devuelve el nombre de la persona
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método que actualiza el nombre de la persona
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Método que devuelve el apellido de la persona
	 * 
	 * @return String
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Método que actualiza el apellido de la persona
	 * 
	 * @param surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Muestra los detalles de la persona
	 * 
	 * @return String
	 */
	protected String showDetails() {

		StringBuilder details = new StringBuilder();

		details.append("DNI: ");
		details.append(dni);
		details.append("\n");
		details.append("Nombre y apellido: ");
		details.append(name);
		details.append(" ");
		details.append(surname);

		return details.toString();

	}

	/**
	 * Genera el codigo hash de la persona por el nombre
	 * 
	 *  @return Integer
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	/**
	 * Dos personas son iguales si sus DNI lo son
	 * 
	 *  @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(dni, other.dni);
	}

	/**
	 * Muestra a la persona
	 * 
	 *  @return String
	 */
	@Override
	public String toString() {
		return "DNI: " + dni + " Nombre y Apellido: " + name + " " + surname;
	}

}
