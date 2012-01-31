package kwic.utwente.cs.se.kwicadt;


import java.util.Vector;
import java.util.Enumeration;
import java.io.*;
/**
 * Insert the type's description here.
 * Creation date: (1-10-2002 15:26:57)
 * @author: 
 */
public class Document {
	private Vector lines = new Vector();
/**
 * Insert the method's description here.
 * Creation date: (1-10-2002 15:31:34)
 * @param line utwente.cs.se.kwicsimple.Line
 */
public void add(Line line) {
	lines.addElement(line);
	
}
/**
 * Insert the method's description here.
 * Creation date: (2-10-2002 14:36:56)
 * @return java.util.Vector
 */
public Vector getLines() {
	return lines;
}
/**
 * Insert the method's description here.
 * Creation date: (2-10-2002 9:25:49)
 */
public void read() {
	// should read lines from some input source
	
	// example document
	Line line1 = new Line();
    line1.add(new Word("j"));
    line1.add(new Word("i"));
    line1.add(new Word("h"));
    line1.add(new Word("g"));
    add(line1);
    Line line2 = new Line();
    line2.add(new Word("f"));
    line2.add(new Word("e"));
    line2.add(new Word("d"));
    add(line2);
    Line line3 = new Line();
    add(line3);
    Line line4 = new Line();
    line4.add(new Word("c"));
    line4.add(new Word("b"));
    line4.add(new Word("a"));
    add(line4);
}
	
	/**
	 * Copied and adjusted read file method from Blackboard.
	 */
	public void read(String filename) {
		File file = new File(filename);
		// Controleer of opgegeven filename bestaat en of het een file is
		if ( file.exists() && file.isFile() ) {
			try {
				RandomAccessFile r = new RandomAccessFile( filename, "r" );
				String line;
				// Lees alle regels uit de file en maak de KwicDocument data aan
				int index, wordindex;
				while ( (line = r.readLine()) != null ) {
					wordindex = 0;
					// Met java 1.4.0 kan dit veel makkelijker met de methode 'split'
					// van String, e.g. line.split(" ");
					Line aLine = new Line();
					while ( line.length() > 0 ) {
						index = line.indexOf(" ");
						if (index > 0) {
							aLine.add(new Word(line.substring(0, index)));
							line = line.substring(index+1);
						} else {
							aLine.add(new Word(line)); line = "";
						}
					}
					add(aLine);
				}
			}
			catch ( IOException io ) {
				System.out.println("Fout bij het lezen van de file '" + filename + "'");
				System.exit(1);
			}
		}
		else {
			System.out.println("File '" + filename + "' niet gevonden");
			System.exit(1);
		}
	}
	
	
/**
 * Insert the method's description here.
 * Creation date: (1-10-2002 15:54:55)
 */
public void shift() {
    Enumeration elements = getLines().elements();
    int sizeDoc = getLines().size();
    for (int i = 0; i < sizeDoc; i = i+1) {
        Line line = (Line) elements.nextElement();
        int sizeLine = line.getWords().size();
        for (int j = 0; j < sizeLine - 1; j = j + 1) {
            line = line.shift();
            add(line);
         }

    }
}
/**
 * Insert the method's description here.
 * Creation date: (1-10-2002 15:55:24)
 */
public void sort() {
    int n = getLines().size();
    for (int i = 0; i < n - 1; i = i + 1) {
        int m = i;
        for (int j = i + 1; j < n; j = j + 1) {
            if (((Line) getLines().elementAt(j)).before((Line) getLines().elementAt(m))) {
                m = j;
            }
        }
        if (i != m) { // swap lines
            Line line = (Line) getLines().elementAt(m);
            getLines().setElementAt(getLines().elementAt(i), m);
            getLines().setElementAt(line, i);
        }
    }
}
/*
 * Insert the method's description here.
 * Creation date: (1-10-2002 15:47:45)
 * @return java.lang.String
 */
public String toString() {
	String out = new String();
	Enumeration elements = lines.elements();
	while (elements.hasMoreElements()){
		out = out + elements.nextElement();}
	return out;
}
/**
 * Insert the method's description here.
 * Creation date: (2-10-2002 9:33:45)
 */
public void write() {
    System.out.print(this);
	System.out.println();
}
}
