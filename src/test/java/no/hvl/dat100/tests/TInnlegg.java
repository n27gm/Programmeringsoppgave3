package no.hvl.dat100.tests;

import no.hvl.dat100.oppgave1.Innlegg;

public class TInnlegg extends Innlegg {
	
	public TInnlegg(int id, String bruker, String dato) { 
		super(id, bruker,dato);
	}

	public TInnlegg(int id, String bruker, String dato, int likes) {
		super(id, bruker,dato,likes);
	}

    @Override
    public String toString() {
        return getId() + "\n" + getBruker() + "\n" + getDato() + "\n" + getLikes() + "\n";
    }
}
<<<<<<< HEAD

=======
>>>>>>> bdada424aa49ce2cdda34ad66197c194bc376890
