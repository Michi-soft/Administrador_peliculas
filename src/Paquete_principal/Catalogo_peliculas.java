package Paquete_principal;

import java.io.File;
import java.util.Vector;

public class Catalogo_peliculas {	
	private String ruta_carpeta_peliculas;
	private Vector<Pelicula> catalogo_peliculas;
	
	public Catalogo_peliculas (String ruta) {
		this.ruta_carpeta_peliculas = ruta;
		this.catalogo_peliculas = new Vector<Pelicula>();
		this.setVideoteca();
	}
	
	private void setVideoteca () {
		File carpeta_base = new File(this.ruta_carpeta_peliculas);
		File[] subcarpetas = carpeta_base.listFiles();
		for (int i=0; i<subcarpetas.length; i++) {
			System.out.println("Agregando pelicula: " + subcarpetas[i].toString());
			Pelicula aux = new Pelicula(subcarpetas[i].toString());
			catalogo_peliculas.add(aux);
		}
	}
	
	private int getTamanioVideoteca () {
		return this.catalogo_peliculas.size();
	}

}
