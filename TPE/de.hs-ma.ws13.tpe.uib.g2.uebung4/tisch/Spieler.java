package tisch;

public class Spieler {

	private String name;
	private String id;

    private int idInt = 0;
    private Integer idIntW = new Integer(idInt);

	int vermoegen;


    public Spieler(String name, int vermoegen){
        this.name = name;
        this.vermoegen = vermoegen;
        this.idInt++;
        this.id = idIntW.toString();
    }
	/**
	 * Methode, mit welcher der Spieler ein Betrag setzen kann. Das Vermoegen wird verringert.
	 * 
	 * @param betrag
	 *            der zu setzende Betrag
	 */
	public void setzen(int betrag) {
        this.vermoegen -= betrag;
	}

    /**
     * Methode die eingesetzt wird wenn der Spieler gewinnt.Das Vermoegen wird erhoeht.
     *
     * @param betrag   Der Betrag um welchen das Vermoegen erhoeht wird.
     */
    public void gewonnen(int betrag){
        this.vermoegen += betrag;
    }

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

}
