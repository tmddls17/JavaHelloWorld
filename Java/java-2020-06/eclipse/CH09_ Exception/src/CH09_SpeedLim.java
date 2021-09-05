import java.util.Scanner;

public class CH09_SpeedLim {
	private int limitspeed;
	private int currentspeed;

	public CH09_SpeedLim(int limit, int speed) {
		limitspeed = limit;
		currentspeed = speed;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int limit = 0, speed = 0;
		System.out.print("Input the speed limit: ");
		limit = kb.nextInt();
		System.out.print("Input the current speed: ");
		speed = kb.nextInt();
		CH09_SpeedLim lim = new CH09_SpeedLim(limit, speed);
		lim.SpeedWarning();
		kb.close();
	}

	public void SpeedWarning() {
		try {
			if (limitspeed < currentspeed) {
				throw new Exception("Speed Limit 100km exceeded!");
			} else {
				System.out.println("You are a law abiding\n" + "citizen!");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("You are being fined.");
		}
		System.out.println("Your current speed: " + currentspeed);
	}
}