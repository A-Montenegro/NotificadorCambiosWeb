package NotificadorCambiosWeb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Objetivo {
	private URL url;
	private String cadenaDeTextoABuscar;
	private boolean debeEncontrarseCadena;
	
	public Objetivo(String url,	String cadenaDeTextoABuscar, boolean debeEncontrarseCadena) {
		try {
			this.url = new URL(url);
			this.cadenaDeTextoABuscar = cadenaDeTextoABuscar;
			this.debeEncontrarseCadena = debeEncontrarseCadena;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public URL getUrl() {
		return url;
	}
	
	public String getCadenaDeTextoABuscar() {
		return cadenaDeTextoABuscar;
	}
	
	public boolean getDebeEncontrarseCadena() {
		return debeEncontrarseCadena;
	}
	
	public void comprobarUrl() {
		try {
	        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	        String inputLine;
	        boolean cadenaEncontrada = false;
	        while ((inputLine = in.readLine()) != null) {
	        	if(inputLine.toUpperCase().contains(cadenaDeTextoABuscar)) {
	        		cadenaEncontrada = true;
	        	}
	        }
	        in.close();
	        if( (cadenaEncontrada && debeEncontrarseCadena) || (!cadenaEncontrada && !debeEncontrarseCadena) ) {
	        	EnvioEmails.enviarEmail(String.valueOf(url));
	        	System.exit(0);
	        }
		}
		catch (IOException iOException) {
			iOException.printStackTrace();
		}
	}
}
