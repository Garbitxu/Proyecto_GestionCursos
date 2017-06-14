package com.ipartek.formacion.domain;

/**
 * Gestion de mensajes para el usuario.<br>
 * Basado en el componente Alerts de Bootstrap3.<br>
 *
 * @see: http://getbootstrap.com/components/#alerts
 * @author ur00
 *
 */
public class Mensajes {

	public static final String CLASE_SUCCESS = "alert-success";
	public static final String CLASE_INFO = "alert-info";
	public static final String CLASE_WARNING = "alert-warning";
	public static final String CLASE_DANGER = "alert-danger";

	private String descripcion;
	private String clase;

	/**
	 * Constructor de la clase mensaje
	 */
	public Mensajes() {
		super();
		this.clase = CLASE_DANGER;
		this.descripcion = "Error!!! Upsss algo esta fallando";
	}

	/**
	 *
	 * @param descripcion
	 *            descripcion del mensaje
	 * @param clase
	 *            tipo de mensaje
	 */
	public Mensajes(String descripcion, String clase) {
		super();
		this.descripcion = descripcion;
		this.clase = clase;
	}

	/**
	 *
	 * @return String la descrpcion del mensaje
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 *
	 * @param descripcion
	 *            la descrpcion del mensaje
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 *
	 * @return String la clase del mensaje
	 */
	public String getClase() {
		return this.clase;
	}

	/**
	 *
	 * @param clase
	 *            la clase del mensaje
	 */
	public void setClase(String clase) {
		this.clase = clase;
	}

	@Override()
	public String toString() {
		return "Mensaje [descripcion=" + this.descripcion + ", clase=" + this.clase + "]";
	}

}