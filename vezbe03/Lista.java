import org.svetovid.io.SvetovidReader;
import org.svetovid.io.SvetovidWriter;

class Lista {
	Node head;
	int count;

	public Lista() {
		this.head = null;
		this.count = 0;
	}

	public void dodaj(Node el) {
		el.next = this.head;
		this.head = el;
		count++;
	}

	public void ispisi() {
		for (Node curr = this.head; curr != null; curr = curr.next) {
			Svetovid.out.print(String.format(" %s", curr.data));
		}

		Svetovid.out.println();
	}

	public void ispisiDuzeOdTri() {
		for (Node curr = this.head; curr != null; curr = curr.next) {
			if (curr.data.length() > 3) {
				Svetovid.out.print(String.format(" %s", curr.data));
			}
		}

		Svetovid.out.println();
	}

	public void brojJednakih(String b) {
		int i = 0;
		for (Node curr = this.head; curr != null; curr = curr.next) {
			if (b.equals(curr.data)) {
				i++;
			}
		}

		Svetovid.out.println(String.format("Nadjeno je %d elementata koji su jednaki stringu %s.", i, b));
	}

	public void ispisiPoslednji() {
		Node curr;
		for (curr = this.head; curr.next != null; curr = curr.next);

		if (curr != null) {
			Svetovid.out.println(String.format("Poslednji element niza je %s.", curr.data));
		}
	}

	public boolean ucitaj(String filename) {
		if (!Svetovid.testIn(filename)) {
			Svetovid.out.println("Nije moguce otvoriti fajl za citanje!");
			return false;
		}

		SvetovidReader fImena = Svetovid.in(filename);
		this.head = null;
		this.count = 0;

		while (fImena.hasMore()) {
			this.dodaj(new Node(fImena.readToken()));
		}

		fImena.close();
		
		return true;
	}

	public boolean snimi(String filename) {
		if (!Svetovid.testOut(filename)) {
			Svetovid.out.println("Nije moguce otvoriti fajl za pisanje!");
			return false;
		}

		SvetovidWriter fImena = Svetovid.out(filename);

		for (Node curr = this.head; curr != null; curr = curr.next) {
			fImena.println(curr.data);
		}

		fImena.close();
		return true;
	}

	public boolean includes(String str) {
		for (Node curr = this.head; curr != null; curr = curr.next) {
			if (str.equals(curr.data)) {
				return true;
			}
		}

		return false;
	}

	public String toString() {
		String output = "";
		Node curr = this.head;

		while (curr != null) {
			output += String.format(" %s", curr.data);
		}

		return output;
	}
}