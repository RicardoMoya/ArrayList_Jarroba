package ArrayList_String;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListString {


	public static void main(String[] args) {
		
		// Declaración el ArrayList
		System.out.println("... Creamos un ArrayList de Strings ...");
		ArrayList<String> nombreArrayList = new ArrayList<String>();
		
		// Añadimos 10 Elementos en el ArrayList
		System.out.println("\n... Añadimos 10 elementos al ArratList ...");
		for (int i=1; i<=10; i++){
			nombreArrayList.add("Elemento "+i); 
		}
		
		// Añadimos un nuevo elemento al ArrayList en la posición 2
		System.out.println("\n... Añadimos 1 elemento (\"Elemento 3\") al ArrayList en la posición 2 ...");
		nombreArrayList.add(2, "Elemento 3");
		
		// Declaramos el Iterador e imprimimos los Elementos del ArrayList
		System.out.println("\nImprimimos los elementos del ArrayList: ");
		Iterator<String> nombreIterator = nombreArrayList.iterator();
		while(nombreIterator.hasNext()){
			String elemento = nombreIterator.next();
			System.out.print(elemento+" / ");
		}
		
		// Recordar que previamente ya hemos declarado el ArrayList y el Iterator de la siguiente forma:
		// ArrayList<String> nombreArrayList = new ArrayList<String>();
		// Iterator<String> nombreIterator = nombreArrayList.iterator();
		
		// Obtenemos el numero de elementos del ArrayList
		int numElementos = nombreArrayList.size();
		System.out.println("\n\nEl ArrayList tiene "+numElementos+" elementos");
		
		// Eliminamos el primer elemento del ArrayList, es decir el que ocupa la posición '0'
		System.out.println("\n... Eliminamos el primer elemento del ArrayList ("+nombreArrayList.get(0)+")...");
		nombreArrayList.remove(0);
		
		// Eliminamos los elementos de ArrayList que sean iguales a "Elemento 3"
		System.out.println("\n... Eliminamos los elementos de ArrayList que sean iguales a \"Elemento 3\" ...");
		nombreIterator = nombreArrayList.iterator();
		while(nombreIterator.hasNext()){
			String elemento = nombreIterator.next();
			if(elemento.equals("Elemento 3"))
				nombreIterator.remove();	// Eliminamos el Elemento que hemos obtenido del Iterator
		}
		
		// Imprimimos el ArrayList despues de eliminar los elementos iguales a "Elemento 3"
		System.out.println("\nImprimimos los elementos del ArrayList tras realizar las eliminaciones: ");
		nombreIterator = nombreArrayList.iterator();
		while(nombreIterator.hasNext()){
			String elemento = nombreIterator.next();
			System.out.print(elemento+" / ");
		}
		
		// Mostramos el numero de elementos que tiene el ArrayList tras las eliminaciones:
		numElementos = nombreArrayList.size();
		System.out.println("\n\nNumero de elementos del ArrayList tras las eliminaciones = "+numElementos);

	}

}
