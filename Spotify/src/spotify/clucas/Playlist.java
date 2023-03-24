package spotify.clucas;


import java.util.ArrayList;

import java.util.List;


import spotify.exception.DatosInvalidosException;

/** Esta clase lleva los atrivutos del nombre del artista, un arrayList que contiene todas sus canciones y la duracion total en segundo de las canciones
 * @author clucas@educa.madrid.org 
 * @version 1.5
 */


//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5
public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	/**
	 * @param este metodo obtenerDuracionTotal 
	 * @return el total de los segundos pasados a minutos
	 */
	
	// Poner descripcion, valor de retorno.
	//En los comentarios describir cómo se obtienen los minutos y a partir de qué dato de la clase.
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
	
	/**@apiNote este metodo agrega canciones al ArrayList de las canciones el artista 
	 * 
	 * @param nueva es la cancion que se va a agregar a las playlist del artista 
	 * @return devuelve exito si la cansion ha sido añadida 
	 * @throws DatosInvalidosException
	 */
		
		
	// Poner descripcion, parametros de entrada, valor de retorno, y excepción. Además que pueda
	// referenciar tanto a las clases Cancion y DatosInvalidosException
	//Existe desde la version 1.0
	public boolean agregarCancion(Cancion nueva) throws DatosInvalidosException {

		boolean exito = false;
		if (canciones == null) {
			this.canciones = new ArrayList<>();
		}
		if (nueva == null || nueva.getNombre() == null) {
			throw new DatosInvalidosException("La cancion o su nombre es vacía");
		}

		boolean existeCancion = this.encontrarCancionPorNombre(nueva.getNombre());
		if (!existeCancion) {
			exito = canciones.add(nueva);
		}

		return exito;
	}

	/**
	 * @apiNote con esta clase , introducimos una palabra o parte de ella , dando igual si es mayusculas o minusculas y bsuca en el arrayList el nombre de la cancion, hasta encontrarla, siempre que haya canciones en el arraylist
	 * @param nombre es el dato string que vamos a comparar con los distintos string que hay en el array
	 * @return devuelve "encontrado" que es true o false dependiendo de si encuentra o no 
	 */
	
	// Poner descripcion, parametros de entrada, valor de retorno, y excepción.
	//Existe desde la version 1.5
	public boolean encontrarCancionPorNombre(String nombre) {
		boolean encontrado = false;
		int contador = 0;
		while (!encontrado && contador < canciones.size()) {

			// Si el nombre de la cancion obtenida en cada vuelta es igual a la que se
			// quiere
			if (canciones.get(contador).getNombre().equalsIgnoreCase(nombre)) {
				encontrado = true;
			}

			contador++;
		}

		return encontrado;
	}
	
	
	
	/**@deprecated este metodo ha pasado a mejor vida, ahora se utiliza mas otro metodo {@link} encontrarCancionPorNombre(String nombre)
	 * 
	 * @param nombreCancion el dato nombreCancion verificaba si habia ese nombre de cancion 
	 * @return encontrado , que podia ser true si lo encontraba o false si no daba con ello
	 * 
	 */
	// Este metodo está deprecado porque se ha hecho uno mejor, y el que lo sustituye es el
	// encontrarCancionPorNombre(String nombre)
	//Existe desde la version 1.0
	public boolean encontrarCancion(String nombreCancion) {
		boolean encontrado = false;

		for (int cont = 0; cont < canciones.size(); cont++) {
			Cancion cancionExtraida = this.canciones.get(cont);
			if (cancionExtraida.getNombre().equals(nombreCancion)) {
				encontrado = true;
				break;
			}
			
		}
		return encontrado;
	}

	


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTotalSegundos() {
		return totalSegundos;
	}

	public void setTotalSegundos(int totalSegundos) {
		this.totalSegundos = totalSegundos;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	//////////////////////  METODOS PRIVADOS ////////////////////////////


//	private void comprobarErroresEliminar(String nombreCancion)
//			throws DatosInvalidosException, OperacionNoPermitidaException {
//		if (nombreCancion == null || nombreCancion.isEmpty()) {
//			throw new DatosInvalidosException("La cancion o su nombre es vacía");
//		}
//
//		if (canciones == null) {
//			throw new OperacionNoPermitidaException(
//					"No es posible eliminar la cancion. La lista de canciones está vacía");
//		}
//	}
//	

//	// Poner parametros de entrada, valor de retorno, y excepción. Además que pueda
//		// referenciar a la clase DatosInvalidosException
//	//Existe desde la version 1.0
//	public boolean eliminarCancion(String nombreCancion) throws DatosInvalidosException, OperacionNoPermitidaException {
//		boolean exito = false;
//
//		comprobarErroresEliminar(nombreCancion);
//		
//		boolean existeCancion = this.encontrarCancionPorNombre(nombreCancion);
//		if (existeCancion) {
//			Cancion eliminar = new Cancion();
//			eliminar.setNombre(nombreCancion);
//			exito = this.canciones.remove(eliminar);
//		}
//
//		return exito;
//	}
	
	

	
	
}