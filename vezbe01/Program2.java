class Program2 {
	static void procitajFajlIIspisi() {
		if (Svetovid.testIn("fajl1.txt")) {
			System.out.println(Svetovid.in("fajl1.txt").readAll());
			Svetovid.in("fajl1.txt").close();
		}
	}

	public static void main(String[] args) {
		procitajFajlIIspisi();
	}
}
