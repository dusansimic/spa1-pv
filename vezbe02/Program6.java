class Program6 {
	public static void main(String[] args) {
		String filename = Svetovid.in.readToken("Unesite ime fajla za citanje:");

		PodaciOIgrackama podaci = new PodaciOIgrackama();
		podaci.ucitajIgracke(filename);

		final double minimalnaCena = Svetovid.in.readDouble("Minimalna cena:");

		Svetovid.out.println(String.format("Ima %d igracaka cije su cene vece od %.2f.", podaci.skupljeOdCene(minimalnaCena), minimalnaCena));
	}
}