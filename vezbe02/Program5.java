class Program5 {
	public static void main(String[] args) {
		String filename = Svetovid.in.readToken("Unesite ime fajla za citanje:");

		PodaciOIgrackama podaci = new PodaciOIgrackama();
		podaci.ucitajIgracke(filename);

		final String bojaZaIspis = Svetovid.in.readToken("Uneiste boju koju trazite:");

		podaci.ispisiSaBojom(bojaZaIspis);
	}
}