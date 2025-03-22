package Paquete_principal;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class File_data_extractor {
	private String path_pelicula;
	File pelicula;
	
	public File_data_extractor(String path_pelicula) {
		this.path_pelicula = path_pelicula;
		this.pelicula = new File(this.path_pelicula);
	}
	
	public String extractNombrePelicula() {
		String nombre = pelicula.getName();
		int primera_aparicion_parentesis = nombre.indexOf("("); 
		nombre = nombre.substring(0, primera_aparicion_parentesis-1); 
		return nombre;
	}
	
	public double extractTamanioCarpeta () {
		long tamanio = 0;
		File[] archivos = pelicula.listFiles();
		for (int i=0; i<archivos.length; i++) {
			if (archivos[i].isFile())
				tamanio =+ archivos[i].length();
		}
		return Math.floor(((double)tamanio/(1024*1024))*100)/100;
	}
	
	public String extractAnioPelicula() {
		String nombre = pelicula.getName();
		String anio = "NOT FOUND";
		Pattern pattern = Pattern.compile("[(][0-9]{4}[)]");
		Matcher matcher = pattern.matcher(nombre);
		if (matcher.find()) {
			anio = nombre.substring(matcher.start()+1, matcher.end()-1);
		}
		return anio;
	}
	
	public String extractResolucionPelicula() {
		String nombre = pelicula.getName();
		String resolucion = "NOT FOUND";
		Pattern pattern = Pattern.compile("[0-9]{4}[p]");
		Matcher matcher = pattern.matcher(nombre);
		if (matcher.find()) {
			resolucion = nombre.substring(matcher.start(), matcher.end()-1);
		}
		return resolucion;
	}
		
	public boolean extractTieneSubtitulo () {
		return false;
	}
	
	public boolean extractTienePoster() {
		return false;
	}
	
}
