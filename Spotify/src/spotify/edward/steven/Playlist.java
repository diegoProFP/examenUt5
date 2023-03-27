package spotify.edward.steven;
import java.util.ArrayList;
import java.util.List;
import spotify.base.Cancion;
import spotify.exception.DatosInvalidosException;


// 
/**
 * The Class Playlist.
 * @author edward.castro
 */
public class Playlist {
	
	/** el nombre. */
	private String nombre;
	
	/** total segundos. */
	private int totalSegundos;
	
	/** lista canciones. */
	private List<Cancion> canciones;

	
	/**
	 *  Con este metodo obtenemos la  duracion total.
	 *
	 * @return nos devuelve un  double que es el total de segundo de dicha cancion
	 */
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		
		
		
	/**
	 * con este metodo podemos agrgar una cacion apartir de un public boolean y comprobamos si existe o no n
	 *
	 * @param nueva 
	 * @return true, exito 
	 * @throws DatosInvalidosException the datos invalidos exception la cancion o su nombre es vacia 
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
	 * Encontrar cancion por nombre en caso de ser true sera exitoso.
	 *@version 1.5
	 * @param nombre introducir nombre 
	 * @return true, encontrado
	 * 
	 */
	public boolean encontrarCancionPorNombre(String nombre) {
		boolean encontrado = false;
		int contador = 0;
		while (!encontrado && contador < canciones.size()) {

			if (canciones.get(contador).getNombre().equalsIgnoreCase(nombre)) {
				encontrado = true;
			}

			contador++;
		}

		return encontrado;
	}
	
	/**
	 * Este metodo se usa paara encontrar una cancion a partir de un String nimbreCancion
	 *
	 * @param nombreCancion el nombre de la  cancion
	 * @return true, encontrado
	 * @version 1.0
	 * @deprecated 
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
