<<<<<<< HEAD
package com.dataStructures.PriorityVectores;

import java.util.*;
import java.lang.Comparable;

public class PriorityVectores extends Vector {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void AddElement(Comparable o) {
		int i = 0;
		int j = size();
		for (i = 0; i < j && (((Comparable) elementAt(i)).compareTo(o) < 0); i++);

		insertElementAt(o, i);
	}
}
=======
package com.dataStructures.PriorityVectores;

import java.util.*;
import java.lang.Comparable;

public class PriorityVectores extends Vector {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void AddElement(Comparable o) {
		int i = 0;
		int j = size();
		for (i = 0; i < j && (((Comparable) elementAt(i)).compareTo(o) < 0); i++);

		insertElementAt(o, i);
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
