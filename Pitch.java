import java.util.Iterator;

public class Pitch implements DealerType {

	private PitchDealer dealer;
	
	//constructor
	public PitchDealer createDealer() 
	{
		dealer = new PitchDealer();
		return dealer;
	}
	
	//getter and setter
	public PitchDealer getDealer()
	{
		return dealer;
	}
	public void setDealer(PitchDealer d)
	{
		dealer = d;
	}
}
