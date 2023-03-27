package spotify.manuel.jimenez16;

import java.util.ArrayList;
import java.util.List;

import spotify.exception.DatosInvalidosException;

/**
 * 
 * @author manuel.jimenez16@educa.madrid.org
 * @version 1.5
 * La clase tiene cuatro metodos: {@link #obtenerDuracionTotal()} obtiene la duracion de una canción en minutos, {@link #agregarCancion(Cancion)} nos permite agregar canciones al ArrayList de canciones, {@link #encontrarCancionPorNombre(String)} 
 */

public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	/**
	 * El método obtiene la duracion total en minutos apartir de los segundos totales entre 60 (60 segundos = 1 minuto).
	 * @return Devuelve la duración total en minutos.
	 */
	
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		
	/**
	 * El método sirve para agregar canciones al Arraylist de canciones. En base a tres condiciones determina si se agrara con exito o no. 
	 * La primera condición sería que en caso de que canciones sea nulo (null), en caso de cumplirse se creará un ArrayList. 
	 * La segunda condición se basa en que el parámetro nueva se nulo (null) o que en base a la obtencion del nombre con {@link #getCanciones()}, en caso de cumplirse una o la otra nos devolverá un mensaje. 
	 * La tercera condición en base al boolean existecancion que obtendra el valor de {@link #encontrarCancionPorNombre(String)}, en caso de que la canción no exista, la variable exito obtendra el valor de {@link #agregarCancion(Cancion)}.
	 * @param nueva
	 * @return Devuelve true o false según el valor de la variable exito.
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
	 * El método en base al parametro nombre que recibe, con la condición while recorrera el ArrayList hasta que la variable encontrado y el valor de la variable contador sea menor que la longitud del ArrayList.
	 * Dentro del while se encuentra la condición que si {@link #getNombre()} es igual al nombre de la canción que le pso al método el valor de encontrado será true y será lo que se devolverá.
	 * @param nombre
	 * @return Devuelve el valor de la variable booleana encontrado.
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
	 * El método recorre el ArrayList canciones con un for y en caso de que {@link #getNombre()} sea igual al valor de nombre.
	 * @param nombreCancion
	 * @return Devuelve el valor de la variable booleana encontrado.
	 * @deprecated Este método esta dejando de utilizar para ello esta.
	 * @see #encontrarCancionPorNombre(String)
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