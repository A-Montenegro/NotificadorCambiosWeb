package NotificadorCambiosWeb;

import java.util.ArrayList;

/**
 * @author Alberto Martínez Montenegro
 * 
 */
public class HiloDemonio extends Thread {
	private ArrayList<Objetivo> listaObjetivos;
	
	public HiloDemonio(ArrayList<Objetivo> listaObjetivos) {
		this.listaObjetivos = listaObjetivos;
	}
	
    @Override
    public void run() {
        try {
            while (true) {
            	for(Objetivo objetivo: listaObjetivos) {
            		objetivo.comprobarUrl();
            	}
            	int segundosEntreComprobaciones = Integer.valueOf(CreadorListaObjetivos.propiedadesConfiguracion.getProperty("segundosEntreComprobaciones"));
                Thread.sleep(segundosEntreComprobaciones * 1000);
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            System.out.println("Deteniendo demonio.");
        }
    }
 
}

