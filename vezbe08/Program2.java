import org.svetovid.io.SvetovidReader;
import org.svetovid.io.SvetovidWriter;

class Program2 {
	static boolean uporediPrvaDva(Stek<Integer> stek) {
		if (stek.jePrazan()) {
			return false;
		}

		int tmp = stek.skiniVrh();
		if (stek.jePrazan()) {
			stek.stavi(tmp);
			return false;
		}

		if (tmp <= stek.vrh()) {
			stek.stavi(tmp);
			return false;
		}

		return true;
	}
	public static void main(String[] args) {
		if (!Svetovid.testIn("p1.txt") || !Svetovid.testIn("p2.txt")) {
			return;
		}

		Stek<Integer> stek1 = new Stek<Integer>();
		Stek<Integer> stek2 = new Stek<Integer>();

		// Ucitavanje podataka iz p1.txt
		SvetovidReader fajl = Svetovid.in("p1.txt");
		while (fajl.hasMore()) {
			stek1.stavi(fajl.readInt());
		}
		fajl.close();

		// Ucitavanje podataka iz p2.txt
		fajl = Svetovid.in("p2.txt");
		while (fajl.hasMore()) {
			stek2.stavi(fajl.readInt());
		}
		fajl.close();

		// Uklanjanje elemenata cija je poslednja cifra 6 sa vrha prvog steka
		while (!stek1.jePrazan() && stek1.vrh() % 10 == 6) {
			stek1.skiniVrh();
		}

		// Uklanjanje elemenata koji su veci od sledbenika sa vrha drugog steka
		while (uporediPrvaDva(stek2));

		// Spajanje stekova u jedan
		Stek<Integer> stek3 = new Stek<Integer>();
		while (!stek1.jePrazan() || !stek2.jePrazan()) {
			if (!stek1.jePrazan()) {
				stek3.stavi(stek1.skiniVrh());
			}
			if (!stek2.jePrazan()) {
				stek3.stavi(stek2.skiniVrh());
			}
		}

		// Ispisivanje spojenih stekova u fajl
		if (!Svetovid.testOut("pp.txt")) {
			return;
		}
		SvetovidWriter fajlpp = Svetovid.out("pp.txt");
		while (!stek3.jePrazan()) {
			fajlpp.print(String.format("%d ", stek3.skiniVrh()));
		}
		fajlpp.close();
	}
}