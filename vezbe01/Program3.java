class Program3 {
	static void ucitajFajlIIzracunaj(String filename) {
		if (Svetovid.testIn(filename)) {double suma = 0.0;
			int n = 0;

			while (Svetovid.in(filename).hasMore()) {
				suma += Svetovid.in(filename).readDouble();
				n++;
			}

			Svetovid.in(filename).close();

			System.out.println(String.format("Suma brojeva je %f a prosek je %f.", suma, suma / n));
		}
	}

	public static void main(String[] args) {
		ucitajFajlIIzracunaj("brojevi.txt");
	}
}
