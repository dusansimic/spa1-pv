class Lista {
	class Node {
		char data;
		Node next;

		public Node(char data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;
	int count;

	public Lista() {
		this.head = null;
		this.count = 0;
	}

	public boolean dodaj(char data) {
		Node element = new Node(data);
		element.next = this.head;
		this.head = element;
		return true;
	}

	public void ispisiVelika() {
		Node curr = this.head;
		while (curr != null) {
			if (Character.isUpperCase(curr.data)) {
				Svetovid.out.print(String.format("%c ", curr.data));
			}
			curr = curr.next;
		}
		Svetovid.out.println();
	}

	public void izbaciMala() {
		while (Character.isLowerCase(this.head.data)) {
			this.head = this.head.next;
		}

		Node prev = this.head;
		while (prev.next != null) {
			if (Character.isLowerCase(prev.next.data)) {
				prev.next = prev.next.next;
			} else {
				prev = prev.next;
			}
		}
	}

	public Lista izvdojiCifre() {
		Lista novaLista = new Lista();
		Node poslednji = null;

		// Ukoliko je cifra na prvom mestu u listi
		while (this.head != null && Character.isDigit(this.head.data)) {
			if (novaLista.head == null) {
				novaLista.head = this.head;
				this.head = this.head.next;
				poslednji = novaLista.head;
				poslednji.next = null;
			} else {
				poslednji.next = this.head;
				this.head = this.head.next;
				poslednji = poslednji.next;
				poslednji.next = null;
			}
		}

		Node prev = this.head;
		while (this.head != null && prev.next != null) {
			if (Character.isDigit(prev.next.data)) {
				if (novaLista.head == null) {
					novaLista.head = prev.next;
					prev.next = prev.next.next;
					poslednji = novaLista.head;
					poslednji.next = null;
				} else {
					poslednji.next = prev.next;
					prev.next = prev.next.next;
					poslednji = poslednji.next;
					poslednji.next = null;
				}
			} else {
				prev = prev.next;
			}
		}

		return novaLista;
	}

	public String toString() {
		String output = "";

		Node curr = this.head;
		while (curr != null) {
			output += String.format("%c ", curr.data);
			curr = curr.next;
		}

		return output;
	}
}
