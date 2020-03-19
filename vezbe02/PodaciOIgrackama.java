import org.svetovid.io.SvetovidReader;
import org.svetovid.io.SvetovidWriter;

class PodaciOIgrackama {
	final static int MAX_IGRACAKA = 100;

	Igracka[] igracke = new Igracka[100];
	int count = 0;

	public boolean dodaj(Igracka igracka) {
		if (this.count >= MAX_IGRACAKA) {
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
			this.dodaj(new Igracka(fIgracke.readToken(), fIgracke.readToken(), fIgracke.readDouble()));
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
}