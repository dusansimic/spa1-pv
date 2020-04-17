class Lista {
	class Node {
		String data;
		Node next;

		public Node(String data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	public Lista() {
		this.head = null;
	}

	public void dodaj(String data) {
		Node element = new Node(data);

		element.next = this.head;
		this.head = element;
	}

	public int prebrojVelikaSlova() {
		int br = 0;

		for (Node curr = this.head; curr != null; curr = curr.next) {
			if (curr.data.length() > 0 && Character.isUpperCase((curr.data.charAt(0)))) {
				br++;
			}
		}

		return br;
	}

	public double prosecnaDuzina() {
		double suma = 0.0;
		int broj = 0;

		for (Node curr = this.head; curr != null; curr = curr.next) {
			suma += curr.data.length();
			broj++;
		}

		if (broj == 0) {
			Svetovid.out.println("Lista je prazna!");
			return 0;
		}

		return suma / (double) broj;
	}

	public void brisiVeci() {
		if (this.head == null) {
			return;
		}

		Node prev = this.head;

		while (prev.next != null) {
			if (prev.next.data.length() > prev.data.length()) {
				prev.next = prev.next.next;
			} else {
				prev = prev.next;
			}
		}
	}

	public String toString() {
		String output = "";

		for (Node curr = this.head; curr != null; curr = curr.next) {
			output += String.format("%s ", curr.data);
		}

		return output;
	}
}