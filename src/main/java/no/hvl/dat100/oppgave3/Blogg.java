package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

    private Innlegg[] innleggtabell;  
    private int nesteledig;
    
    
	public Blogg() {
        this.innleggtabell = new Innlegg[20];
        this.nesteledig = 0;  
	}

	public Blogg(int lengde) {
        this.innleggtabell = new Innlegg[lengde]; 
        this.nesteledig = 0;
    }

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
        return innleggtabell;
    }
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++) {
            if (innleggtabell[i].erLik(innlegg)) {
                return i;
            }
        }
        return -1;  
	}

	public boolean finnes(Innlegg innlegg) {
        return finnInnlegg(innlegg) >= 0;
    }

	public boolean ledigPlass() {
        return nesteledig < innleggtabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (finnes(innlegg)) {
            return false;
        }
        if (ledigPlass()) {
            innleggtabell[nesteledig] = innlegg;
            nesteledig++;
            return true;
        }
        return false;
	}
	
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nesteledig).append("\n"); 
        for (int i = 0; i < nesteledig; i++) {
            sb.append(innleggtabell[i].toString());  
        }
        return sb.toString();
    }

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
        Innlegg[] newTabell = new Innlegg[innleggtabell.length * 2];
        System.arraycopy(innleggtabell, 0, newTabell, 0, nesteledig);
        innleggtabell = newTabell; 
   }
	
	public boolean leggTilUtvid(Innlegg innlegg) {
        if (finnes(innlegg)) {
            return false; 
        }
        if (ledigPlass()) {
            return leggTil(innlegg); 
        } else {
            utvid();
            return leggTil(innlegg); 
        }		
	}
	
	public boolean slett(Innlegg innlegg) {
        int index = finnInnlegg(innlegg);
        if (index < 0) {
            return false; 
        }
        for (int i = index; i < nesteledig - 1; i++) {
            innleggtabell[i] = innleggtabell[i + 1];
        }
        innleggtabell[nesteledig - 1] = null; 
        nesteledig--;
        return true;
	}
	
	public int[] search(String keyword) {
        int[] result = new int[nesteledig];
        int count = 0;

        for (int i = 0; i < nesteledig; i++) {
            if (innleggtabell[i].toString().contains(keyword)) { 
                result[count] = i; 
                count++;
            }
        }
        return java.util.Arrays.copyOf(result, count);
    }
}