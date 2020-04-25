class ListaFilmova {
	class Film {
		class Glumac {
			String ime;
			Glumac next;

			public Glumac(String ime) {
				this.ime = ime;
				this.next = null;
			}
		}

		String ime;
		Glumac head;
		Film next;

		public Film(String ime) {
			this.ime = ime;
			this.head = null;
			this.next = null;
		}

		public boolean imaGlumca(String ime) {
			if (this.head == null) {
				return false;
			}

			for (Glumac curr = this.head; curr != null; curr = curr.next) {
				if (curr.ime.equals(ime)) {
					return true;
				}
			}

			return false;
		}

		public void dodajGlumca(String ime) {
			if (!this.imaGlumca(ime)) {
				Glumac novi = new Glumac(ime);
				novi.next = this.head;
				this.head = novi;
			}
		}

		public String toString() {
			String output = "[";

			if (this.head != null) {
				output += this.head.ime;

				for (Glumac curr = this.head.next; curr != null; curr = curr.next) {
					output += String.format(", %s", curr.ime);
				}
			}

			output += "]";

			return output;
		}
	}

	Film head;

	public ListaFilmova() {
		this.head = null;
	}

	public boolean imaFilm(String ime) {
		if (this.head == null) {
			return false;
		}

		for (Film curr = this.head; curr != null; curr = curr.next) {
			if (curr.ime.equals(ime)) {
				return true;
			}
		}

		return false;
	}

	public Film nadjiFilm(String imeFilma) {
		Film curr;

		for (curr = this.head; curr != null && !curr.ime.equals(imeFilma); curr = curr.next);

		return curr;
	}

	public void dodaj(String ime) {
		if (!this.imaFilm(ime)) {
			Film novi = new Film(ime);
			novi.next = this.head;
			this.head = novi;
		}
	}

	public void dodajGlumca(String imeGlumca, String imeFilma) {
		if (this.head == null) {
			return;
		}

		Film film = this.nadjiFilm(imeFilma);

		if (film == null) {
			return;
		}

		film.dodajGlumca(imeGlumca);
	}

	public void obrisiSaGlumcem(String imeGlumca) {
		while (this.head != null && this.head.imaGlumca(imeGlumca)) {
			this.head = this.head.next;
		}
		if (this.head == null) {
			return;
		}

		Film prev = this.head;
		while (prev.next != null) {
			if (prev.next.imaGlumca(imeGlumca)) {
				prev.next = prev.next.next;
			} else {
				prev = prev.next;
			}
		}
	}

	public String toString() {
		String output = "[";

		if (this.head != null) {
			output += String.format("%s %s", this.head.ime, this.head);

			for (Film curr = this.head.next; curr != null; curr = curr.next) {
				output += String.format(" %s %s", curr.ime, curr);
			}
		}

		output += "]";

		return output;
	}
}