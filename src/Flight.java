
public class Flight implements Comparable<Flight> {

protected KeyFlight Key;
protected boolean departure;

public Flight(KeyFlight Key,boolean departure){
	this.Key=Key;
	this.departure=departure;
}
public Flight(KeyFlight Key){
	this.Key=Key;
}
/**
 * @return time	
 */
	public int gettime(){
		return Key.time;
	}
	/**
	 * 
	 * @return number
	 */
	public int getnumber(){
		return Key.number;
	}
	/**
	 *@param key to set
	 */
	public void setKey(KeyFlight Key){
		this.Key=Key;
	}

	/**
	 * if return>0 => f1>f2
	 * 
	 * if return<0 => f1<f2
	 */
public int compareTo(Flight other){
	if(Key.number==other.Key.number){ return 0;}
	if(Key.time<other.Key.time){
		return 1;}
	 
	else if(Key.time>other.Key.time)
	{
		return -1;
	}
	else if(Key.time==other.Key.time)
	{
		if(Key.number<other.Key.number){
			return 1;}
		
		
		else{return -1;}
	}
	
	return 1;
	
	
	
	
}
	public void setdeparture(boolean departure){
		this.departure=departure;
	}
	
	public boolean isDeparture(){
		return departure==true;
	}
}
