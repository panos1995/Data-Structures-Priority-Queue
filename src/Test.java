import java.util.StringTokenizer;


public class Test {

	public static void main(String[] args) {
		PQ hey=new PQ(15);
		KeyFlight first=new KeyFlight(001,810);
		KeyFlight second=new KeyFlight(002,910);
		KeyFlight third=new KeyFlight(003,1010);
		KeyFlight four=new KeyFlight(004,2210);
		KeyFlight five=new KeyFlight(005,2310);
		KeyFlight test=new KeyFlight(003,2320);
		KeyFlight tester=new KeyFlight(003,10);
		Flight f1=new Flight(first,true);
		Flight f2=new Flight (second,true);
		Flight f3=new Flight(third,true);
		Flight f4=new Flight(four,true);
		Flight f5=new Flight (five,true);
		Flight f6=new Flight(tester,true);
		hey.insert(f3);
		hey.insert(f5);
		int k=5;
		System.out.println(k*0.1);
		hey.insert(f4);
		hey.insert(f2);
		hey.insert(f1);
		hey.Sprint();
		System.out.println(" ");
		hey.UpdateKey(f1,five);
		hey.Sprint();System.out.println(" ");
		hey.UpdateKey(f6, test);
		hey.Sprint();System.out.println(" ");
		
		
		

}}
