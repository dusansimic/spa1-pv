class Program1 {
	public static void main(String[] args) {
		int n = Svetovid.in.readInt("Unesite broj stringova:");

		Lista lista = new Lista();
		for (int i = 0; i < n; i++) {
			lista.dodaj(new Node(Svetovid.in.readToken(String.format("Uneiste %s. string: ", i + 1))));
		}

		lista.ispisi();
		lista.ispisiDuzeOdTri();
		lista.brojJednakih(Svetovid.in.readToken("Unesite string b:"));
		lista.ispisiPoslednji();
	}
}