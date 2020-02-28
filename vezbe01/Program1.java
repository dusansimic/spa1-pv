class Program1 {
	static void upisiUFajl() {
		if (Svetovid.testOut("fajl1.txt")) {
			Svetovid.out("fajl1.txt").print("Prvi red\nDrugi red\n\nCetvrti red");
			Svetovid.out("fajl1.txt").close();
		}
	}

	public static void main(String[] args) {
		upisiUFajl();
	}
}
