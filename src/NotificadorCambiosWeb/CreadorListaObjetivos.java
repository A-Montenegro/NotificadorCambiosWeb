package NotificadorCambiosWeb;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class CreadorListaObjetivos {
	
	protected static Properties propiedadesConfiguracion = new Properties();
    
	public static ArrayList<Objetivo> crearListaObjetivos(String rutaFicheroConfiguracion) {
		ArrayList<Objetivo> listaObjetivos = new ArrayList<Objetivo>();
    	try {
    		InputStream inputStreamConfiguracion = CreadorListaObjetivos.class.getResourceAsStream(rutaFicheroConfiguracion); 
    		propiedadesConfiguracion.load(inputStreamConfiguracion);
    		String url ="url";
    		String cadenaDeTextoABuscar = "cadenaDeTextoABuscar";
    		String debeEncontrarseCadena = "debeEncontrarseCadena";
    		int indice = 1;
    		while(propiedadesConfiguracion.containsKey(url + String.valueOf(indice))) {
    			String stringIndice = String.valueOf(indice);
    			String iteracionUrl = url + stringIndice;
    			String iteracionCadenaDeTextoABuscar = cadenaDeTextoABuscar + stringIndice;
    			String iteracionDebeEncontrarseCadena = debeEncontrarseCadena + stringIndice;
    			iteracionUrl = propiedadesConfiguracion.getProperty(iteracionUrl);
    			iteracionCadenaDeTextoABuscar = propiedadesConfiguracion.getProperty(iteracionCadenaDeTextoABuscar);
    			iteracionDebeEncontrarseCadena = propiedadesConfiguracion.getProperty(iteracionDebeEncontrarseCadena);
    			Objetivo objetivo = new Objetivo(iteracionUrl, iteracionCadenaDeTextoABuscar, Boolean.valueOf(iteracionDebeEncontrarseCadena));
    			listaObjetivos.add(objetivo);
    			indice += 1;
    		}
		} catch (IOException e) {
			System.out.println("No se ha podido acceder al fichero de configuración del sistema('" + 
			rutaFicheroConfiguracion + "'), la ejecución no puede continuar.");
			e.printStackTrace();
		}
    	return listaObjetivos;
	}
}