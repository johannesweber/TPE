package mutanten;

import metropolis.Einwohner;

/**
 * Diese abstrakte Klasse repraesentiert einen Mutanten. Mutanten besitzen
 * zusaetzlich zu den Attributen eines Einwohners ein eigenes Attribute:
 * der Name der Mutation
 * 
 * Zusaetzlich besitzt jeder Mutant die abstrakte Methode kampfe() und die
 * Methoden superkraftErmitteln und mutationErmitteln().
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public abstract class Mutanten extends Einwohner {

	protected String mutation;

	/**
	 * 
	 * Konstruktor fuer ein Mutanten Objekt. Der Konstruktor uebertraegt den
	 * Namen des Mutanten, ueberweisst ihm sofort 5000 metro-dollar und
	 * ermittelt seine Mutation.
	 * 
	 * @param name
	 *            Name des Mutanten
	 */
	public Mutanten(String name) {
		super(name);
		mutationErmitteln();
	}

	/**
	 * Methode um die Superkraft des Mutanten, per Zufallsprinzip, zu ermitteln.
	 */
	protected String superkraftFestlegen() {
		double superEnum = ((Math.random() * 5) + 1);
		Math.round(superEnum);
		String superkraft = null;

		switch ((int)superEnum) {
		case 1:
			superkraft = Superkraft.FLIEGEN.toString();
			break;
		case 2:
			superkraft = Superkraft.GUMMIARTIG.toString();
			break;
		case 3:
			superkraft = Superkraft.HOCHINTELLIGENT.toString();
			break;
		case 4:
			superkraft = Superkraft.SUPERSCHNELL.toString();
			break;
		case 5:
			superkraft = Superkraft.ULTRASTARK.toString();
			break;
		}
		return superkraft;
	}

	/**
	 * Methode um die Mutation eines jeden Mutanten, per Zufallsprinzip, zu
	 * ermitteln.
	 */
	private void mutationErmitteln() {
		double mutationEnum = (double) ((Math.random() * 5) + 1);
		Math.round(mutationEnum);

		switch ((int)mutationEnum) {
		case 1:
			this.mutation = Mutation.GROSSERKOPF.toString();
			break;
		case 2:
			this.mutation = Mutation.GRUENEHAUT.toString();
			break;
		case 3:
			this.mutation = Mutation.KLEINEFUESSE.toString();
			break;
		case 4:
			this.mutation = Mutation.KURZEARME.toString();
			break;
		case 5:
			this.mutation = Mutation.ULTRAGGRESSIV.toString();
			break;
		}
	}

	/**
	 * Methode, welche nur zum testen dient. Wird nur in JUnit gebraucht.
	 * 
	 * @return liefert die Mutation des Mutanten
	 */
	public String getMutation() {
		return this.mutation.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((mutation == null) ? 0 : mutation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mutanten other = (Mutanten) obj;
		if (mutation == null) {
			if (other.mutation != null)
				return false;
		} else if (!mutation.equals(other.mutation))
			return false;
		return true;
	}
}
