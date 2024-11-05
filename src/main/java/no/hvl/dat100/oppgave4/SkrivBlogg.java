package no.hvl.dat100.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnavn) {
        PrintWriter writer = null;
        try {
            File file = new File(mappe + File.separator + filnavn);
            writer = new PrintWriter(file);
            
            writer.println(samling.getAntall());
            
            for (int i = 0; i < samling.getAntall(); i++) {
                writer.println(samling.getSamling()[i].toString());
            }
            
            return true; 
        } catch (FileNotFoundException e) {
            e.printStackTrace(); 
            return false; 
        } finally {
            if (writer != null) {
                writer.close(); 
            }
        }
    }
}

