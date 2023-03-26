package spotify.stelianpatrut;

import java.util.ArrayList;
import java.util.List;

import spotify.exception.DatosInvalidosException;



/**
 * 
 * @author stelian
 * @version 1.5
 *
 */
public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	

	
	/**
	 * lo que hace esta clase obtener la duracion total de la cancion
	 * @return retorna un double que es el total de los segundos dividido entre 60 
	 * los segundos se optienen dividiendo los segundos totales de la cancion entre 60 
	 */
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		
		

	/**
	 * En esa clase lo que hacemos en agregar una cancion nueva 
	 * @param nueva le pasamos una cancion nueva 
	 * @return retorna un true si ha tenido exito añadir la cancion al ArrayList
	 * @throws DatosInvalidosException 
	 * @see DatosInvalidosExepcion Cancion
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
	 * Lo que hacemos con esta clase en encontrar una cancion por su nombre 
	 * @param nombre recibe el nombre de la cancion
	 * @return true si la cancion esta encontrada y false sino esta encontrada 
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
	 * @deprecated {@link encontrarCancionPorNombre}
	 * @param nombreCancion
	 * @return
	 * @version 1.0
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