package NotificadorCambiosWeb;

import java.util.ArrayList;

public class Main {
	private static final String rutaFicheroConfiguracion = "/config.properties";
	
	public static void main(String[] args) {
		ArrayList<Objetivo> listaObjetivos = CreadorListaObjetivos.crearListaObjetivos(rutaFicheroConfiguracion);
		HiloDemonio hiloDemonio= new HiloDemonio(listaObjetivos);
		hiloDemonio.start();
	}
}
