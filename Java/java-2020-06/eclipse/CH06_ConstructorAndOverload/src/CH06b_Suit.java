enum UserStatus {
	PENDING, ACTIVE, INACTIVE, DELETED;
}
public class CH06b_Suit {
	public static void main(String[] args) {
		for (UserStatus status : UserStatus.values()) {
			System.out.println(status);
		}
	}
}
