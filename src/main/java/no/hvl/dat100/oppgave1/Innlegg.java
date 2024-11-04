package no.hvl.dat100.oppgave1;

import no.hvl.dat100.common.TODO;

public abstract class Innlegg {
	
    private int id;
    private String bruker;
    private String dato;
    private int likes;
	
	public Innlegg() {
		
	}
	
    public Innlegg(int id, String bruker, String dato) {
        this.id = id;
        this.bruker = bruker;
        this.dato = dato;
        this.likes = 0; // starter med 0 likes
    }

    public Innlegg(int id, String bruker, String dato, int likes) {
        this.id = id;
        this.bruker = bruker;
        this.dato = dato;
        this.likes = likes;
    }
	
	public String getBruker() {
		return bruker;
	}

	public void setBruker(String bruker) {
		this.bruker = bruker;
	}

	public String getDato() {
        return dato;		
	}

	public void setDato(String dato) {
        this.dato = dato;
	}

	public int getId() {
        return id;
	}

	public int getLikes() {
        return likes;
	}
	
	public void doLike () {
        this.likes++;
	}
	
	public boolean erLik(Innlegg innlegg) {
        return this.id == innlegg.getId();
	}
	
	@Override
	public String toString() {	
        return "Innlegg [id=" + id + ", bruker=" + bruker + ", dato=" + dato + ", likes=" + likes + "]";				
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
        return "<div class='innlegg'>" +
                "<p>Bruker: " + bruker + "</p>" +
                "<p>Dato: " + dato + "</p>" +
                "<p>Likes: " + likes + "</p>" +
                "</div>";		
	}
}
