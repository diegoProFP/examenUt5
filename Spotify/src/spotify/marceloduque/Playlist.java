package spotify.marceloduque;

import java.util.ArrayList;
import java.util.List;

import spotify.exception.DatosInvalidosException;

//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5
/**
 * La clase Playlist funcionara a modo de playlist de canciones de modo que se podra ver el tiempo de duracion de la playlist 
 * añadir una canción o encontrar una canción por el nombre.
 * @author marcelo.duque@educa.madrid.org
 *@version 1.5
 */
public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	
	// Poner descripcion, valor de retorno.
	//En los comentarios describir cómo se obtienen los minutos y a partir de qué dato de la clase.
	/**
	 * En el metodo obtenerDuracionTotal() lo que se hace es pasarle un valor entero a dividir entre 60 para ver la duración de la playlist
	 * por la posibilidad de valores decimales se añadira un double
	 * @return double totalSegundos en esta clase devolvera el valor en double dado que la division que se realiza puede dar valores decimales.
	 */
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		
		
		
	// Poner descripcion, parametros de entrada, valor de retorno, y excepción. Además que pueda
	// referenciar tanto a las clases Cancion y DatosInvalidosException
	//Existe desde la version 1.0
	/**
	 * En la Clase agregarCancion enviamos un objeto Cancion que lo que hara es añadir este objeto a un Arraylist de canciones si no esta creado el Arraylist
	 * se creara, de modo que tambien hay un control de error en caso que la cancion o el nombre de la cancion sea nulo.
	 * @param nueva Se enviara el objeto Cancion para la adiccion de este a un Arraylist
	 * @return exito Devolvera un boolean de true o false para indicar si ha sido posible añadir la cancion
	 * @since 1.0 Existe desde la version 1.0
	 * @throws DatosInvalidosException
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


	
	// Poner descripcion, parametros de entrada, valor de retorno, y excepción.
	//Existe desde la version 1.5
	/**
	 * En este metodo se enviara un String con el fin de compararlo con los nombres de las canciones que ya estan en el Arraylist de canciones
	 * en caso de que el String coincida se envia un boolean true y en caso contrario un boolean false
	 * @param nombre el parametro nombre se usara para buscarlo en el Arraylist de canciones
	 * @return encontrado Este boolean se devuelve para indicar si ha sido posible encontrar la cancion o no
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
	
	// Este metodo está deprecado porque se ha hecho uno mejor, y el que lo sustituye es el
	// encontrarCancionPorNombre(String nombre)
	//Existe desde la version 1.0
	/**
	 * En el metodo encontrarCancion se usaba para buscar cancion con un String y hacia un equals entre un objeto cancion del arraylist y el objeto cancion
	 * @deprecated Este metodo esta obsoleto dado que se ha hecho uno mejor:  {@link #encontrarCancionPorNombre(String nombre)}
	 * @param nombreCancion Este String se usaba para compararlo con las canciones dentro del Arraylist
	 * @return encontrado se devolvera 
	 * @since 1.0
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