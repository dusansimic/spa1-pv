import java.util.*;

import org.svetovid.io.SvetovidReader;
import org.svetovid.io.SvetovidWriter;

class Program1 {
	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<>();

		// Dodavanje 4 elementa
		for (int i = 0; i < 4; i++) {
			lista.add(Svetovid.in.readToken(String.format("Unesite %d. ime:", i + 1)));
			Svetovid.out.println(lista);
		}

		lista.add(1, Svetovid.in.readToken("Unesite jos neko ime na 2. mesto:"));
		Svetovid.out.println(lista);

		// Izmena elementa na 4. poziciji i ispisivanje onog koji je bio tu
		Svetovid.out.println(lista.set(4, "Milana"));

		// Ipisivanje elemenata na parnim indexima
		for (int i = 0; i < lista.size(); i++) {
			if (i % 2 == 0) {
				Svetovid.out.println(lista.get(i));
			}
		}

		// Ispisivanje elementa koji pocunju sa velikim slovom S
		for (String ime : lista) {
			if (ime.startsWith("S")) {
				Svetovid.out.println(ime);
			}
		}

		// Brisanje elementa sa indeksom 2
		lista.remove(3);

		// Brisanje unetog elementa
		String imeZaBrisanje = Svetovid.in.readToken("Unesite element za brisanje:");
		lista.remove(imeZaBrisanje);

		// Ucitavanje imena iz fajla
		String filename = Svetovid.in.readToken("Unesite ime fajla za citanje:");
		if (!Svetovid.testIn(filename)) {
			return;
		}

		SvetovidReader fajl = Svetovid.in(filename);

		LinkedList<String> novaLista = new LinkedList<>();

		while (fajl.hasMore()) {
			novaLista.add(fajl.readToken());
		}
		fajl.close();

		// Dodavanje imena iz ArrayList u LinkedList
		novaLista.addAll(lista);

		// Ispis imena u fajl
		String newFilename = Svetovid.in.readToken("Unesite ime fajla za pisanje:");
		if (!Svetovid.testOut(newFilename)) {
			return;
		}

		SvetovidWriter fajlZaPisanje = Svetovid.out(newFilename);

		for (String ime : novaLista) {
			fajlZaPisanje.println(ime);
		}
		fajlZaPisanje.close();
	}
}
