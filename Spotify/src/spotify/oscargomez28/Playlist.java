package spotify.oscargomez28;

import java.util.ArrayList;
import java.util.List;

import spotify.exception.DatosInvalidosException;
/**
 * 
 * @author oscar.gomez28@educamadrid.org
 *
 *@version 1.5   24/03/23
 */


/**
 * La clase Spotify podrá obtener la duracion total de una canción,agregarla, y encontrarla por nombre o sin nombre
 *
 */
public class Playlist {
/**
 * @param nombre  almacena el nombre de la cancion mediante el tipo de dato String
 * @param totalSegundos se almacena mediante un Integer y sirve para saber los segundos que dura la cancion
 * @param canciones es una lista que almacena un grupo de canciones
 */
	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		/**
		 * Para la obtención de los minutos , se obtienen los segundos totales y se dividen entre 60.
		 * @return retorna un valor double ,que serían los minutos totales que dura la canción
		 * @throws DatosInvalidosException
		 */
		
		
	
	public boolean agregarCancion(Cancion nueva) throws DatosInvalidosException {
		/**
		 * El objetivo de esta clase es agregar canciones, esto lo hace mediante la introduccion del usuario de una cancion
		 * Si canciones = null , es decir que no tiene valor el nombre , no se añadirá a la lista canciones y se mostrará un mensaje de 
		 * "La cancion o su nombre es vacía
		 * @param el valor exito almacena si se ha añadido o no la cancion con un true o un false
		 * @version 1.0
		 * @throws DatosInvalidosException 
		 */
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
		/**
		 * @return retorna el valor booleano exito que será true o false
		 */
	}


	

	public boolean encontrarCancionPorNombre(String nombre) {
		/**
		 * @version 1.5
		 * 
		 * El objetivo de esta clase es buscar una cancion por su nombre 
		 * @param , el parametro encontrado tiene valor booleano y está igualado a false , en caso de encontrarla será true
		 */
		boolean encontrado = false;
		int contador = 0;
		while (!encontrado && contador < canciones.size()) {
/**
 * Si la cancion es igual a la que se busca ,se buscaba y el booleano se iguala a true
 */
	
			if (canciones.get(contador).getNombre().equalsIgnoreCase(nombre)) {
				encontrado = true;
			}

			contador++;
		}

		return encontrado;
		
		/**
		 * @return encontrado con el valor del booleano igual a true si lo ha encontrado , y false si no lo ha hecho
		 */
	}
	
	// Este metodo está deprecado porque se ha hecho uno mejor, y el que lo sustituye es el
	// encontrarCancionPorNombre(String nombre)
	//Existe desde la version 1.0
	public boolean encontrarCancion(String nombreCancion) {
		/**
		 * @version 1.0
		 * @deprecated , el metodo está anticuado , a su vez se ha hecho uno mejor 
		 */
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