class Program4 {

	public static void main(String[] args) {
		String filename1 = Svetovid.in.readToken("Unesite ime fajla za citanje:");

		PodaciOIgrackama podaci = new PodaciOIgrackama();

		podaci.ucitajIgracke(filename1);

		boolean inputMore = true;
		while(inputMore) {
			String unetiTip = Svetovid.in.readToken("Unesite tip:");
			String unetaBoja = Svetovid.in.readToken("Unesite boju:");
			double unetaCena = Svetovid.in.readDouble("Unesite cenu:");

			podaci.dodaj(new Igracka(unetiTip, unetaBoja, unetaCena));

			inputMore = Svetovid.in.readToken("Da li zelite da unosite opet? (da/ne):").equals("da");
		}

		String filename2 = Svetovid.in.readToken("Unesite ime fajla za pisanje:");

		podaci.snimiIgracke(filename2);
	}
}