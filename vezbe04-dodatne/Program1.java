class Program1 {
	public static void main(String[] args) {
		int n = Svetovid.in.readInt("Broj stringova za unos:");

		Lista lista = new Lista();
		for (int i = 0; i < n; i++) {
			lista.dodaj(Svetovid.in.readLine(String.format("Unesite %d string:", i + 1)));
		}

		Svetovid.out.println(String.format("Stringova sa velikim pocetnim slovom u listi ima %d.", lista.prebrojVelikaSlova()));

		Svetovid.out.println(String.format("Prosecna duzina stringova u listi je %.2f.", lista.prosecnaDuzina()));

		Svetovid.out.println(lista);
		lista.brisiVeci();
		Svetovid.out.println(lista);
	}
}
