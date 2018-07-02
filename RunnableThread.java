package tiaa;

public class RunnableThread implements Runnable {

	private DetectParts avaliableParts;
	public static int finishedProduct = 0;
	int seconds;
	public static boolean moreProductsFlag = false;

	public static boolean isMoreProductsFlag() {
		return moreProductsFlag;
	}

	public static void setMoreProductsFlag(boolean moreProductsFlag) {
		RunnableThread.moreProductsFlag = moreProductsFlag;
	}

	private boolean run = true;

	public void shutdown() {
		this.run = false;
	}

	public RunnableThread(int delay, boolean run) {

		this.seconds = delay;
	}

	@Override
	public void run() {

		avaliableParts = new DetectParts();

		synchronized (avaliableParts) {
			moreProductsFlag = avaliableParts.getUnfinishedProducts();
			System.out.println("MoreProducts " + moreProductsFlag);
			System.out.println(Thread.currentThread().getName() + " Start.");
			if (moreProductsFlag) {
				finishedProduct++;
			}
			System.out.println(finishedProduct);

			System.out.println(Thread.currentThread().getName() + " End.");

		}
		System.out.println("Total Products " + finishedProduct);

		processCommand(finishedProduct, moreProductsFlag);

		if (!moreProductsFlag) {
			int timeTaken = 0;
			Thread.currentThread().interrupt();

			System.out.println("Thread Intrrupted stopped");
			this.shutdown();
		}
		;

	}

	private void processCommand(int finishedProduct, boolean moreProductsFlag) {
		try {

			Thread.sleep(1000);

			int i = 1;

			System.out.println("Total Time " + RunnableThread.finishedProduct
					* 1000 % 3);
			if (!moreProductsFlag) {
				this.shutdown();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
