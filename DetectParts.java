package tiaa;

// Identify if sufficient parts are available in inventory
public final class DetectParts {
	private static int NoOfBolts = 10;

	public static int getReqmachine() {
		return reqMachine;
	}

	public static int getReqbolts() {
		return reqBolts;
	}

	public static int getTime() {
		return time;
	}

	public synchronized static void setNoofbolts(int noofbolts) {
		NoOfBolts = noofbolts;
	}

	public synchronized static void setNoofmachines(int noofmachines) {
		NoOfMachines = noofmachines;
	}

	private static int NoOfMachines = 5;
	private static final int reqMachine = 1;
	private static final int reqBolts = 2;
	private static final int time = 60;
	private static boolean moreProductFlag = true;

	public synchronized static boolean isMoreproductflag() {
		return moreProductFlag;
	}

	public synchronized static void setMoreproductflag(boolean moreproductflag) {
		moreProductFlag = moreproductflag;
	}

	public synchronized static int getNoofbolts() {
		return NoOfBolts;
	}

	public synchronized static int getNoofmachines() {
		return NoOfMachines;
	}

	public synchronized boolean getUnfinishedProducts() {
		int bolts = getNoofbolts();
		int givenbolts = 0;
		givenbolts++;
		bolts = bolts - 1;
		setNoofbolts(bolts);
		int machines = getNoofmachines();
		int givenmachines = 0;

		givenmachines++;
		machines = machines - 1;
		setNoofmachines(machines);
		System.out.println(NoOfMachines + " " + NoOfBolts);
		if (givenbolts < reqBolts) {
			int morebolts = getNoofbolts();
			givenbolts++;
			morebolts = morebolts - 1;
			setNoofbolts(morebolts);

		}
		if (givenbolts >= 2 && givenmachines == 1) {
			System.out.println("Machine Assembled");

		}
		if (NoOfBolts % 2 > 0 && NoOfBolts % 2 < 1) {
			System.out.println("Insufficient Bolts");
		}
		if (NoOfMachines % 3 < 0 && NoOfBolts % 3 < 0) {
			System.out.println("More products can not be produced");
			setMoreproductflag(false);

		}
		return moreProductFlag;
	}

}
