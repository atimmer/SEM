package utwente.cs.se.kwicsimple;

import java.io.*;

public class KwicDocument {
    public String[][] data = new String[N][M];
    /** 
     * the maximum number of words in a line
     */
    public final static int N = 100;
    /** 
     * the maximum number of lines
     */
    public final static int M = 100;
    /** 
     * the actual number of lines
     */
    public int numberOfLines = 0;
public static void main(String[] args) {
    KwicDocument doc = new KwicDocument();
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
public void read() {
    numberOfLines = 4;
    data[0][0] = new String("k");
    data[0][1] = new String("j");
    data[0][2] = new String("i");
    data[0][3] = new String("h");
    data[1][0] = new String("g");
    data[1][1] = new String("f");
    data[1][2] = new String("e");
    // 3rd line is empty
    data[3][0] = new String("d");
    data[3][1] = new String("c");
    data[3][2] = new String("b");
    data[3][3] = new String("a"); 
}

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
                while ( line.length() > 0 ) {
                    index = line.indexOf(" ");
                    if (index > 0) {
                        data[numberOfLines][wordindex++] = line.substring(0, index);
                        line = line.substring(index+1);
                    }
                    else { data[numberOfLines][wordindex] = line; line = "";}
                }
                numberOfLines++;
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




public void shift() {
    int n = numberOfLines;
    for (int i = 0; i < n; i = i + 1) {
        int m = 0; // number of words in line i
        int j = 0; // index of word in line
        while (data[i][j] != null) {
            m = m + 1;
            j = j + 1;
        }
        int h = numberOfLines; // index of new line
        // first shift: copy line and place first word at the end
        if (m > 1) {
            data[h][m] = data[i][0];
            j = 0;
            while (j < m) {
                data[h][j] = data[i][j + 1];
                j = j + 1;
            }
            numberOfLines = numberOfLines + 1;
        }
        // remaining shifts 
        for (int k = 0; k < m - 2; k = k + 1) {
            h = numberOfLines; // index of new line
            // copy previous line and place first word at the end    
            data[h][m] = data[h - 1][0];
            j = 0;
            while (j < m) {
                data[h][j] = data[h - 1][j + 1];
                j = j + 1;
            }
            numberOfLines = numberOfLines + 1;
        }
    }
}
public void sort() {
	// insertion sort
    int n = numberOfLines;
    for (int i = 0; i < n - 1; i = i + 1) {
	    // m is index of minimum line after index i
        int m = i;
        for (int j = i + 1; j < n; j = j + 1) {
            if (data[m][0] == null) {
                m = j;
            } else
                if ((data[j][0] != null)
                    && (data[j][0].compareTo(data[m][0]) < 0)) {
                    m = j;
                }
        }
        if (i != m) { // swap line i and line m
            // copy line m into temporary line at index N-1
            int k = 0;
            while (k < M) {
                data[N - 1][k] = data[m][k];
                k = k + 1;
            }
            // copy line i into line m
            k = 0;
            while (k < M) {
                data[m][k] = data[i][k];
                k = k + 1;
            }
            // copy tempory line into line i
            k = 0;
            while (k < M) {
                data[i][k] = data[N - 1][k];
                k = k + 1;
            }
        }
    }
}
public void write() {
	for (int i = 0; i < numberOfLines; i = i + 1) {
		for (int j = 0; j < data[i].length; j = j + 1) {
			if (data[i][j] != null) {
				System.out.print(data[i][j] + " ");
			}
		}
		System.out.println();
	}
	System.out.println();
}
}
