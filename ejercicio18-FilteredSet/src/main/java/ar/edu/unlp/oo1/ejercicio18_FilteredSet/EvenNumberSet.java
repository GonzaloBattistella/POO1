package ar.edu.unlp.oo1.ejercicio18_FilteredSet;

import java.util.HashSet;

public class EvenNumberSet extends HashSet<Integer> {
	
	private static final long serialVersionUID = 1L; //Para borrar un warning de Eclipse, relacionado con que HashSet implementa el comportamiento de la interface Serializable.

	@Override
	public boolean add(Integer num) {
		if(num % 2 == 0) {
			return super.add(num);
		}
		
		return false;
	}
}
