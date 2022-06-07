package nttdata.javat3.business.student;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase centro educativo
 * 
 * @author nandi
 *
 */
public class School implements Comparable<School> {

	/** Nombre del centro educativo */
	private String name;

	/** Mapa donde se guardan los alumnos en su modalidad correspondiente */
	private Map<Modality, Set<Student>> modalityStudents;

	/** Logger para las trazas */
	private static final Logger SCHOOLLOG = LoggerFactory.getLogger(School.class);

	/**
	 * Constructor para el centro educativo
	 * 
	 * @param name
	 */
	public School(String name) {
		super();

		SCHOOLLOG.info("Generando el centro educativo: {}", name);

		this.name = name;
		modalityStudents = new TreeMap<>();
	}

	/**
	 * Método que devuelve el nombre del centro educativo
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Método que actualiza el nombre del centro educativo
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Método que devuelve el mapa que contiene los estudiantes en su modalidad
	 * 
	 * @return Map
	 */
	public Map<Modality, Set<Student>> getStudents() {
		return modalityStudents;
	}

	/**
	 * Método que actualiza el mapa que contiene los estudiantes en su modalidad
	 * 
	 * @param students
	 */
	public void setStudents(Map<Modality, Set<Student>> students) {
		this.modalityStudents = students;
	}

	/**
	 * Añade el estudiante pasado por parametro a su modalidad
	 * 
	 * @param student
	 */
	public void addStudent(Student student) {

		// Primero se comprueba si el mapa contiene la modalidad como clave, si no es
		// así entra en la condicion,
		// Si ya contiene la modalidad como clave no estra en la conndicion y lo añade a
		// la modalidad
		if (!modalityStudents.containsKey(student.getModality())) {

			modalityStudents.put(student.getModality(), new TreeSet<Student>());

		}

		modalityStudents.get(student.getModality()).add(student);
	}

	/**
	 * Devuelve el numero de estudiantes que tiene el centro educativo
	 * 
	 * @return Integer
	 */
	public Integer numberOfStudent() {

		int num = 0;

		// Recorre los conjuntos del mapa y suma en una variable su tamaño
		for (Set<Student> s : modalityStudents.values()) {

			num += s.size();

		}

		return num;
	}

	/**
	 * Devuelve un booleano indicando si el estudiante pasado por parametro existe o
	 * no
	 * 
	 * @param s
	 * @return boolean
	 */
	public boolean containStudent(Student s) {

		SCHOOLLOG.info("ENTRADA MÉTODO");
		// Genera un booleano para indicar si existe o no
		boolean exist = Boolean.FALSE;

		// Genera un iterador para recorrer los conjuntos del mapa
		Iterator<Set<Student>> it = modalityStudents.values().iterator();

		// Mientras exist sea false y el iterador tenga valor siguiente entra en el
		// bucle
		while (!exist && it.hasNext()) {

			Set<Student> students = it.next();

			// Recorre los alumnos del conjunto
			for (Student student : students) {

				// Si el alumno que indica student es igual al pasado por parametro entra en la
				// condicion y exist = true eso indica que existe ya el estudiante pasado por
				// parámetro (dos alumnos son iguales si sus DNIs lo son )
				if (student.equals(s)) {

					exist = Boolean.TRUE;
					SCHOOLLOG.info("El dni del estudiante esta registrado");

				}

			}

		}

		SCHOOLLOG.info("FIN MÉTODO");
		return exist;

	}

	/**
	 * Devuelve un String con los estudiantes del centro educativo
	 * 
	 * @return String
	 */
	public String showStudents() {

		SCHOOLLOG.info("ENTRADA MÉTODO");

		StringBuilder list = new StringBuilder();

		list.append("Centro educativo: ");
		list.append(this.name);
		list.append("\n");
		list.append("Alumnos: ");
		list.append("\n");
		SCHOOLLOG.info("Mostrando los alumnos del centro educativo: {}", this.name);

		// Recorre los conjuntos del mapa
		for (Set<Student> stu : modalityStudents.values()) {

			// Recorre los estudiantes del conjunto y los va añadiendo al StringBuilder
			for (Student s : stu) {

				list.append(s);
				list.append("\n");

			}

		}

		list.append("\n");

		SCHOOLLOG.info("FIN MÉTODO");

		return list.toString();

	}

	/**
	 * Genera el hashCode de los centros educativos por el nombre
	 * 
	 * @return Integer
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	/**
	 * Dos centros educativos son iguales si sus nombres lo son
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
		School other = (School) obj;
		return Objects.equals(name, other.name);
	}

	/**
	 * Devuelve un String con los datos del centro educativo
	 * 
	 * @return String
	 */
	@Override
	public String toString() {

		StringBuilder school = new StringBuilder();

		school.append("Nombre del centro educativo: ");
		school.append(name);
		school.append("\n");
		school.append("Número de estudiantes: ");
		school.append(this.numberOfStudent());
		school.append("\n");

		return school.toString();
	}

	/**
	 * Compara los centros educativos por el nombre
	 * 
	 * @return Integer
	 */
	@Override
	public int compareTo(School o) {

		return this.name.compareTo(o.name);
	}

}
