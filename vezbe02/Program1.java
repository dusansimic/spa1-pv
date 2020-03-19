import org.svetovid.io.SvetovidReader;

class Program1 {
	static void ucitaj(String filename) {
		if (!Svetovid.testIn(filename)) {
			return;
		}

		SvetovidReader fIgracke = Svetovid.in(filename);

		while (fIgracke.hasMore()) {
			String tip = fIgracke.readToken();
			String boja = fIgracke.readToken();
			double cena = fIgracke.readDouble();

			Svetovid.out.println(String.format("%s %s %.2f", tip, boja, cena));
		}

		fIgracke.close();
	}

	public static void main(String[] args) {
		String filename = Svetovid.in.readToken("Unesite ime fajla za citanje:");

		ucitaj(filename);
	}
}