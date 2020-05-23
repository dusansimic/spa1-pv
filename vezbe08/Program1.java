import org.svetovid.io.SvetovidReader;
import org.svetovid.io.SvetovidWriter;

class Program1 {
	public static void main(String[] args) {
		if (!Svetovid.testIn("r1.txt")) {
			return;
		}

		Red<String> red = new Red<String>();

		// Ucitavanje stringova iz fajla u red
		SvetovidReader fajl = Svetovid.in("r1.txt");
		while (fajl.hasMore()) {
			red.naKraj(fajl.readLine());
		}
		fajl.close();

		// Brisanje stringova kracih od 6 sa pocetka reda
		while (!red.jePrazan() && red.prvi().length() < 6) {
			red.izbaciPrvi();
		}

		// Ispisivanje elemenata u fajl
		String filename = Svetovid.in.readToken("U koji fajl zelite da ispisete red:");
		if (!Svetovid.testOut(filename)) {
			return;
		}
		SvetovidWriter fajlOut = Svetovid.out(filename);
		while (!red.jePrazan()) {
			fajlOut.println(red.izbaciPrvi());
		}
		fajlOut.close();
	}
}