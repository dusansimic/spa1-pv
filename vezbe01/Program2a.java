class Program2a {
	static String ucitajIme() {
		return Svetovid.in.readToken("Unesite ime fajla:");
	}

	static void procitajFajlIIspisi(String filename) {
		if (Svetovid.testIn(filename)) {
			System.out.println(Svetovid.in(filename).readAll());
			Svetovid.in(filename).close();
		}
	}

	public static void main(String[] args) {
		String filename = ucitajIme();
		procitajFajlIIspisi(filename);
	}
}
