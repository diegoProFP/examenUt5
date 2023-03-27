package spotify.diegodi1;

import java.util.ArrayList;
import java.util.List;

import spotify.exception.DatosInvalidosException;

/**
 * Clase que representa una playlist de un reproducto (spotify).
 * Contiene funcionalidades para agregar canciones a la lista, eliminar, buscar por nombre, etc.
 * @author alumno
 * @version 1.5
 */
public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	
	// Poner descripcion, valor de retorno.
	//En los comentarios describir cómo se obtienen los minutos y a partir de qué dato de la clase.
	
	/**
	 * Obtiene la duracion de la playlist en minutos.
	 * Para ello, coge el total de segundos y lo transforma a minutos (diviendo entre 60)
	 * @return La duracion de la playlist en minutos (por ej 2.2)
	 */
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		
		
		
	// Poner descripcion, parametros de entrada, valor de retorno, y excepción. Además que pueda
	// referenciar tanto a las clases Cancion y DatosInvalidosException
	//Existe desde la version 1.0
	/**
	 * Se agrega una nueva cancion a la playlist. Para ello, se comprueba
	 * si existe ya por nombre. Es decir, se busca la canción dentro de la playlist,
	 * y si no está, se añade.
	 * @param nueva El objeto Cancion que se quiere añadir
	 * @return True si la canción no existe previamente y se ha podido añadir. False en caso contrario
	 * @throws DatosInvalidosException Se lanza esta excepción si la cancion es nula o no tiene nombre
	 * @since 1.0
	 */
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
	 * Se busca una canción por nombre dentro de la playist. Para ello, busca dentro de la lista 
	 * de canciones aquella que coincida por nombre.
	 * @param nombre El nombre de la canción a buscar
	 * @return True si se encuentra una canción con ese nombre, false en caso contrario.
	 * @since 1.5
	 */
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

	/**
	  * Se busca una canción por nombre dentro de la playist. Para ello, busca dentro de la lista 
	 * de canciones aquella que coincida por nombre.
	 * @deprecated No usar, mejor utilizar el método {@link #encontrarCancionPorNombre(String nombre)}
	 * @param nombre El nombre de la canción a buscar
	 * @return True si se encuentra una canción con ese nombre, false en caso contrario.
	 * @since 1.0
	 * @see encontrarCancionPorNombre(String nombre)
	 */
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