enum Suit
{
	MON ("red"), TUE ("orange"), WED ("yellow"),THU ("green"), FRI ("blue"), SAT ("indigo"), SUN ("purple");
	private final String color;
	private Suit (String suitColor)
	{
		color = suitColor;
	}
	public String getColor ()
	{
		return color;
	}
}
public class CH06b_EnumTest
{
	public static void main(String[] args)
	{
		Suit s = Suit.FRI;
		System.out.println("s.ordinal()="+s.ordinal());
		System.out.println("s.compareTo(Suit.WED)="+s.compareTo(Suit.WED));
		System.out.println("s.toString()="+s.toString());
		System.out.println("s.getColor() = "+s.getColor());
		System.out.println("MON "+Suit.MON.getColor());
		System.out.println("TUE "+Suit.TUE.getColor());
		System.out.println("WED "+Suit.WED.getColor());
		System.out.println("THU "+Suit.THU.getColor());
		System.out.println("FRI "+Suit.FRI.getColor());
		System.out.println("SAT "+Suit.SAT.getColor());
		System.out.println("SUN "+Suit.SUN.getColor());
	}
}