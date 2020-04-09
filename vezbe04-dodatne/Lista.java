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
	int count;

	public Lista() {
		this.head = null;
		this.count = 0;
	}

	public void dodaj(String data) {
		Node element = new Node(data);

		element.next = this.head;
		this.head = element;

		this.count++;
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

		for (Node curr = this.head; curr != null; curr = curr.next) {
			suma += curr.data.length();
		}

		return suma / (double) this.count;
	}

	public void brisiVeci() {
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