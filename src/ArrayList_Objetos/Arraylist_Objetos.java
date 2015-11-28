package ArrayList_Objetos;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Arraylist_Objetos {
	
	private static final String nombreFichero = "partidos.txt";
	
	public static void main (String args[]){
		
		// Nos creamos un ArrayList de objetos de la Clase "PartidoFutbol"
		System.out.println("... Nos creamos un ArrayList de objetos de la Clase \"PartidoFutbol\" ...");
		ArrayList<PartidoFutbol> partidos = new ArrayList<PartidoFutbol>();
		
		// Instanciamos el fichero donde estan los datos
		File fichero = new File(nombreFichero);
		Scanner s = null;
		
		try {
			// Leemos el contenido del fichero
			System.out.println("... Leemos el contenido del fichero ...");
			s = new Scanner(fichero);
			// Obtengo los datos de los partidos de fútbol del fichero
			while (s.hasNextLine()){
				String linea = s.nextLine();	// Obtengo una linea del fichero (un partido de fútbol)
				String [] cortarString = linea.split("::");		// Obtengo los datos del partido de futbol
				PartidoFutbol partido = new PartidoFutbol();	// Creo un objeto de la clase "PartidoFutbol"
				
				// Pongo los atributos al objeto "partido"
				partido.setEquipoLocal(cortarString[0]);
				partido.setEquipoVisitante(cortarString[1]);
				partido.setGolesLocal(Integer.parseInt(cortarString[2]));
				partido.setGolesVisitante(Integer.parseInt(cortarString[3]));
				
				// Añadimos el objeto "partido" al ArrayList
				partidos.add(partido);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if (s != null)
					s.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		System.out.println("... Guardados "+partidos.size()+" partidos de fútbol  ...");
		
		// Imprimimos los elementos del ArrayList
		System.out.println("\n... Resultados de los partidos de Futbol ...");
		Iterator<PartidoFutbol> itrPartidos = partidos.iterator();
		while(itrPartidos.hasNext()){
			PartidoFutbol partido = itrPartidos.next();
			System.out.println(partido.getEquipoLocal() + " "
					+ partido.getGolesLocal() + "-"
					+ partido.getGolesVisitante() + " "
					+ partido.getEquipoVisitante());
		}
		
		// Eliminamos los partidos de futbol del ArrayList, cuyo resultado
		// no sea un empate
		System.out.println("\n... Tamaño del ArrayList antes de eliminar partidos de futbol = "+partidos.size()+" ...");
		System.out.println("\n... Eliminamos los partidos de futbol cuyo resultado no sea un empate ...");
		itrPartidos = partidos.iterator();
		while(itrPartidos.hasNext()){
			PartidoFutbol partido = itrPartidos.next();
			// Si los goles no son iguale, eliminamos el partido
			if(partido.getGolesLocal() != partido.getGolesVisitante())
				itrPartidos.remove();
		}
				
		// Imprimimos los elementos del ArrayList
		System.out.println("\n... Tamaño del ArrayList despues de eliminar partidos de futbol = "+partidos.size()+" ...");
		System.out.println("\n... Resultados de los partidos de Futbol con empate ...");
		itrPartidos = partidos.iterator();
		while(itrPartidos.hasNext()){
			PartidoFutbol partido = itrPartidos.next();
			System.out.println(partido.getEquipoLocal() + " "
					+ partido.getGolesLocal() + "-"
					+ partido.getGolesVisitante() + " "
					+ partido.getEquipoVisitante());
		}
	}

}
