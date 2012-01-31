package kwic.utwente.cs.se.kwicadt;


import java.util.Vector;
import java.util.Enumeration;
import kwic.utwente.cs.se.kwicadt.Word;
/**
/**
 * Insert the type's description here.
 * Creation date: (1-10-2002 15:27:10)
 * @author: 
 */
public class Line {
	private Vector words = new Vector();
/**
 * Insert the method's description here.
 * Creation date: (1-10-2002 15:33:20)
 * @param word utwente.cs.se.kwicsimple.Word
 */
public void add(Word word) {
	words.addElement(word);
	}
/**
 * Insert the method's description here.
 * Creation date: (1-10-2002 16:59:53)
 * @return boolean
 * @param line utwente.cs.se.kwicsimple.Line
 */
public boolean before(Line line) {
    if (words.size() == 0)
        return false;
    if (line.words.size() == 0)
        return true;
    if (((Word) words.elementAt(0)).equals((Word) line.words.elementAt(0))) {
        Line line1 = this.copy();
        Line line2 = line.copy();
        line1.words.removeElementAt(0);
        line2.words.removeElementAt(0);
        return line1.before(line2);
    }
    return ((Word) words.elementAt(0)).before((Word) line.words.elementAt(0));
}
/**
 * Insert the method's description here.
 * Creation date: (2-10-2002 9:50:05)
 * @return utwente.cs.se.kwicsimple.Line
 */
public Line copy() {
    Line line = new Line();
    Enumeration elements = words.elements();
    while (elements.hasMoreElements()) {
        line.add((Word) elements.nextElement());
    }
    return line;
}
/**
 * Insert the method's description here.
 * Creation date: (2-10-2002 10:08:07)
 * @return java.util.Vector
 */
public Vector getWords() {
	return words;
}
/**
 * Insert the method's description here.
 * Creation date: (1-10-2002 16:16:18)
 */
public Line shift() {
    Line line = new Line();
    Word word0 = (Word) words.elementAt(0);
    for (int i = 1; i < words.size(); i = i + 1) {
        Word word = (Word) words.elementAt(i);
        line.add(word);
    }
    line.add(word0);
    return line;
}
/*
 * Insert the method's description here.
 * Creation date: (1-10-2002 15:47:45)
 * @return java.lang.String
 */
public String toString() {
    String out = new String();
    Enumeration elements = words.elements();
    if (elements.hasMoreElements()) {
        out = ((Word) elements.nextElement()).toString();
    }
    while (elements.hasMoreElements()) {
        out = out + " " + elements.nextElement();
    }
    return out + "\n";
}
}
