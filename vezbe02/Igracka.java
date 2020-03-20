class Igracka {
	String tip;
	String boja;
	double cena;

	public Igracka(String tip, String boja, double cena) {
		this.tip = tip;
		this.boja = boja;
		this.cena = cena;
	}

	public String toString() {
		return String.format("%s %s %.2f", this.tip, this.boja, this.cena);
	}
}