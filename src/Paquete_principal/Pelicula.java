package Paquete_principal;

public class Pelicula {
	private String ruta_pelicula;
	private String nombre_pelicula;
	private String anio_pelicula;
	private double tamanio_pelicula;
	private String resolucion_pelicula;
	private boolean tiene_subtitulo;
	private boolean tiene_poster;
	
	public Pelicula (String path_pelicula) {
		this.ruta_pelicula = path_pelicula;
		File_data_extractor fde = new File_data_extractor(this.ruta_pelicula);
		this.nombre_pelicula = fde.extractNombrePelicula();
		this.anio_pelicula = fde.extractAnioPelicula();
		this.tamanio_pelicula = fde.extractTamanioCarpeta();
		this.resolucion_pelicula = fde.extractResolucionPelicula();
		this.tiene_subtitulo = fde.extractTieneSubtitulo();
		this.tiene_poster = fde.extractTienePoster();
	}

	public String getRuta_pelicula() {
		return ruta_pelicula;
	}

	public String getNombre_pelicula() {
		return nombre_pelicula;
	}

	public String getAnio_pelicula() {
		return anio_pelicula;
	}

	public double getTamanio_pelicula() {
		return tamanio_pelicula;
	}

	public String getResolucion_pelicula() {
		return resolucion_pelicula;
	}

	public boolean getTiene_subtitulo() {
		return tiene_subtitulo;
	}

	public boolean getTiene_poster() {
		return tiene_poster;
	}
	
	public String toString () {
		return this.getNombre_pelicula() + ", " +
			   this.getAnio_pelicula() + "\n";
	}
	
	
	
}
