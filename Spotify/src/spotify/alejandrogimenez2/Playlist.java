package spotify.alejandrogimenez2;

import java.util.ArrayList;
import java.util.List;

import spotify.exception.DatosInvalidosException;

/**
 * Clase que maneja todas las funciones de la playlist, con esta podremos obtener info de nuestra playlist, agregar y buscar
 * canciones tan por nombre como buscar en general.
 * @author alejandro.gimenez2@educa.madrid.org
 * @version 1.5
 */
public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	
	/**
	 * Recibimos la duracion total que se obtiene con todas las canciones que han sido añadidas a nuestra playlist
	 * Esto se obtiene ya que usamos el total de segundo de la cancion y lo dividimos entre 60 para obtener dicha duración
	 * 
	 * @return numero total de duracion de la playlist
	 */
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		
		
	/**
	 * Con esta función agregamos una cancion a nuestra playlist, comprobando si el nombre de cancion buscado existe
	 * si esta existe se introduce a la playlist, si no, lanza un error.	
	 * 
	 * @param nueva refiriendose a la cancion que se añade 
	 * @return devuelve si ha sido exitosa la accion de agragar una cancion a la playlist
	 * @throws DatosInvalidosException
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
	 * Funcion que busca el nombre de la cancion dentro de la playlist, recibiendo una respuesta de si es encontrada o no.
	 * 
	 * @param nombre
	 * @return si encuentra dicha cancion o no
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
	 * @deprecated usar mejor otro metodo, este está anticuado 
	 * @param nombreCancion
	 * @return si la cancion ha sido o no encontrada
	 * @since 1.0
	 * @see encontrarCancionPorNombre{@link encontrarCancionPorNombre}
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