
public class KeyFlight implements Comparable<KeyFlight> {

	protected int number;
	protected int time;
	
	public KeyFlight(int number,int time){
		this.number=number;
		this.time=time;
	}
	
	public  int compareTo(KeyFlight other){
		if(number==other.number) return 0;
	return -1;
	
			}
	}
