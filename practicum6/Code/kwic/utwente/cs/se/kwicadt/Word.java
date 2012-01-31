package kwic.utwente.cs.se.kwicadt;

/**
 * Insert the type's description here.
 * Creation date: (1-10-2002 15:27:21)
 * @author: 
 */
public class Word {
	private String value = new String();
/**
 * Word constructor comment.
 */
public Word(String s) {
	value = s;
}
/**
 * Insert the method's description here.
 * Creation date: (1-10-2002 16:56:51)
 * @return boolean
 * @param w utwente.cs.se.kwicsimple.Word
 */
public boolean before(Word w) {
	return value.compareTo(w.value) < 0;
}
/**
 * Insert the method's description here.
 * Creation date: (1-10-2002 16:56:51)
 * @return boolean
 * @param w utwente.cs.se.kwicsimple.Word
 */
public boolean equals(Word w) {
	return value.compareTo(w.value) == 0;
}
/**
 * Insert the method's description here.
 * Creation date: (1-10-2002 15:46:42)
 * @return java.lang.String
 */
public String toString() {
	return value;
}
}
