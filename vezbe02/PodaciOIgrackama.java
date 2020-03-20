import org.svetovid.io.SvetovidReader;
import org.svetovid.io.SvetovidWriter;

class PodaciOIgrackama {
	final static int MAX_IGRACAKA = 100;

	Igracka[] igracke = new Igracka[100];
	int count = 0;

	public boolean dodaj(Igracka igracka) {
		if (this.count >= MAX_IGRACAKA) {
			Svetovid.out.println(String.format("Niz sa podacima o igrackama je pun. Ima ukupno %d igracaka u nizu.", MAX_IGRACAKA));
			return false;
		}

		this.igracke[this.count++] = igracka;

		return true;
	}

	public void snimiIgracke(String filename) {
		if (!Svetovid.testOut(filename)) {
			return;
		}

		SvetovidWriter fIgracke = Svetovid.out(filename);

		for (int i = 0; i < this.count; i++) {
			fIgracke.println(String.format("%s %s %.2f", this.igracke[i].tip, this.igracke[i].boja, this.igracke[i].cena));
		}

		fIgracke.close();
	}

	public boolean ucitajIgracke(String filename) {
		if (!Svetovid.testIn(filename)) {
			return false;
		}

		this.count = 0;

		SvetovidReader fIgracke = Svetovid.in(filename);

		while (fIgracke.hasMore() && this.count < MAX_IGRACAKA) {
			this.igracke[this.count++] = new Igracka(fIgracke.readToken(), fIgracke.readToken(), fIgracke.readDouble());
		}

		if (fIgracke.hasMore()) {
			Svetovid.out.println(String.format("Previse igracaka u fajlu! Ucitano prvih %d igracaka.", MAX_IGRACAKA));
		}

		fIgracke.close();

		return true;
	}

	public void ispisiSaBojom(String boja) {
		for (int i = 0; i < this.count; i++) {
			if (this.igracke[i].boja.equals(boja)) {
				Svetovid.out.println(this.igracke[i]);
			}
		}
	}

	public int skupljeOdCene(double cena) {
		int br = 0;

		for (int i = 0; i < this.count; i++) {
			if (this.igracke[i].cena > cena) {
				br++;
			}
		}

		return br;
	}

	public String toString() {
		String output = "";

		for (int i = 0; i < this.count; i++) {
			output += String.format("%s\n", this.igracke[i]);
		}

		return output;
	}
}