class Osoba {
	String ime;
	Osoba next;

	public Osoba(String ime) {
		this.ime = ime;
		this.next = null;
	}

	public String toString() {
		return ime;
	}
}

class Kuca {
	int redniBr;
	Osoba head;
	Kuca next;

	public Kuca(int redniBr) {
		this.redniBr = redniBr;
		this.head = null;
		this.next = null;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void dodajOsobu(String ime) {
		Osoba nova = new Osoba(ime);
		nova.next = this.head;
		this.head = nova;
	}

	public int brojDuzihOdN(int n) {
		int broj = 0;

		for (Osoba curr = this.head; curr != null; curr = curr.next) {
			if (curr.ime.length() > n) {
				broj++;
			}
		}

		return broj;
	}

	public Osoba obrisiPoslednji() {
		if (this.head == null) {
			return null;
		}
		if (this.head.next == null) {
			Osoba ret = this.head;
			this.head = null;
			return ret;
		}

		Osoba prev;
		for (prev = this.head; prev.next.next != null; prev = prev.next);

		Osoba ret = prev.next;
		prev.next = null;

		return ret;
	}

	public String toString() {
		String output = String.format("\t%d [\n", this.redniBr);
		output += "\t\tosobe [\n";

		for (Osoba curr = this.head; curr != null; curr = curr.next) {
			output += String.format("\t\t\t%s\n", curr);
		}

		output += "\t\t]\n\t]\n";
		return output;
	}
}

class Ulica {
	Kuca head;

	public Ulica() {
		this.head = null;
	}

	public void dodajKucu(int redniBrojKuce) {
		if (this.head != null && this.head.redniBr == redniBrojKuce) {
			return;
		}

		Kuca nova = new Kuca(redniBrojKuce);

		if (this.head == null || this.head.redniBr > redniBrojKuce) {
			nova.next = this.head;
			this.head = nova;
			return;
		}

		Kuca prev = this.head;
		while (prev.next != null) {
			if (prev.next.redniBr == redniBrojKuce) {
				return;
			}

			if (prev.redniBr < redniBrojKuce && prev.next.redniBr > redniBrojKuce) {
				nova.next = prev.next;
				prev.next = nova;
				return;
			}

			prev = prev.next;
		}

		prev.next = nova;
	}

	private Kuca getKuca(int n) {
		for (Kuca curr = this.head; curr != null; curr = curr.next) {
			if (curr.redniBr == n) {
				return curr;
			}
		}

		return null;
	}

	public void dodajOsobu(String ime, int redniBrojKuce) {
		Kuca kuca = getKuca(redniBrojKuce);
		if (kuca != null) {
			kuca.dodajOsobu(ime);
		}
	}

	public int najvecaSaVeceOdN(int n) {
		if (this.head == null) {
			return 0;
		}

		Kuca max = this.head;
		for (Kuca curr = this.head.next; curr != null; curr = curr.next) {
			if (curr.brojDuzihOdN(n) > max.brojDuzihOdN(n)) {
				max = curr;
			}
		}

		return max.redniBr;
	}

	public void prebaciAuB(int a, int b) {
		Kuca A = getKuca(a);
		if (A == null || A.isEmpty()) {
			return;
		}
		Osoba prenos = A.obrisiPoslednji();
		Kuca B = getKuca(b);
		if (B == null) {
			return;
		}
		B.dodajOsobu(prenos.ime);
	}

	public String toString() {
		String output = "ulica [\n";

		for (Kuca curr = this.head; curr != null; curr = curr.next) {
			output += curr;
		}

		output += "]";
		return output;
	}
}
