package kwic.utwente.cs.se.kwicadt;

/**
 * Insert the type's description here.
 * Creation date: (1-10-2002 15:29:34)
 * @author: 
 */
public class TestKwic {

/**
 * Insert the method's description here.
 * Creation date: (1-10-2002 15:29:43)
 * @param args java.lang.String[]
 */
public static void main(String[] args) {
	
	if(args.length == 0) {
		System.out.println("Invalid input. Please specify an input file as the first parameter.");
		System.exit(1);
	}
	
    Document doc = new Document();
    
    doc.read(args[0]);
    System.out.println("read");
    doc.write();
    
    doc.shift();
    System.out.println("shift");
    doc.write();
    
    doc.sort();
    System.out.println("sort");
    doc.write();

    System.out.println("end of test");
}
}
