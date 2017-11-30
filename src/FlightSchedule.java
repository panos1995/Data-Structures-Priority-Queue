import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * CS_Domes_Dedomenwn_Project2
 * @author Ntoulos Panagiotis
 *FlightSchedule.java
 */

public class FlightSchedule {
	static PQ EV=new PQ(10);
	public static void main(String[] args) {									//*****************//
		loadandStoreFile("D:\\eclipse\\Domes_2_project\\src\\Files\\tester.txt");//mou etrexe mono me to full path//
		
		printer(EV);
		loadandStoreFile("D:\\eclipse\\Domes_2_project\\src\\Files\\tester2.txt");
		printer(EV);
				}

	
	
	
/**
 * 
 * @param path
 */
//phra thn idea apo mia ergasia mou sthn java2//
public static void loadandStoreFile(String path) {
	int icounter=1;
	String timer ;
	File f = null;
	BufferedReader reader = null;
	String what_to_do;
	Flight flight=null;
	String departure;
	boolean result;
	KeyFlight Key = null;
	String flightnumber;
	String flighttime;
	String line;
	int counter=0;
	StringTokenizer st;
	try {
	f = new File(path);
	} catch (NullPointerException e) {
	System.err.println("File not found.");
	}
	try {
	reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
	} catch (FileNotFoundException e) {
	System.err.println("Error opening file!");
	}
	try{
		
		line = reader.readLine();
		if(line.startsWith("END")){System.out.println("empty file");return;}
			while(line!=null){
				
				 st = new StringTokenizer(line,"\t");
		
				 timer=st.nextToken("\t");
				int  Itimer=Integer.parseInt(timer);
				 
				// System.out.println(Itimer);
				 what_to_do=st.nextToken("\t");
				// System.out.print(what_to_do);
				 flightnumber=st.nextToken();
			int  Iflightnumber=Integer.parseInt(flightnumber);
				// System.out.print(Iflightnumber);
				 departure=st.nextToken("\t");
				// System.out.print(departure);
				 flighttime=st.nextToken("\t");
				
			 int Iflighttime=Integer.parseInt(flighttime);
			// System.out.print(Iflighttime);
				 Key=new KeyFlight(Iflightnumber,Iflighttime);
				 flight=new Flight(Key);
				 if(!EV.isEmpty())
				 if(Itimer>=EV.max().gettime()){Flight temp=	EV.getmax();
					String help;
					if((temp.isDeparture())){
						help="departed";
						}else{help="landed";}
							System.out.println("Flight "+temp.getnumber()+" "+help+" at "+temp.gettime());}
				 if(what_to_do.equals("insert")){
				// System.out.print("worked");
				 if(departure.equals("D")){
					 result=true;
				 }else{result=false;}
				 flight.setdeparture(result);//8a mporousa na kanw new flight alla gia e3ikonomisi to ekana me seter//
				 EV.insert(flight);
				// System.out.println("worked again");
				 
				 
				 }else if(what_to_do.equals("cancel")){
					 
					 EV.remove(Key);
					 				 }
				 else if(what_to_do.equals("update")){
					// System.out.println(flight.getnumber());
					 EV.UpdateKey(flight, Key);
				 }
				line=reader.readLine();
				++icounter;
				 if(line.startsWith("END"))break;
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				++counter;
			}
		
		
		
		
		
	} catch (IOException e) {
		System.out.println("Line " + counter + ": Sudden end.");
	}
	try {
	reader.close();
	} catch (IOException e) {
	System.err.println("Error closing file.");
	}
	}
public static void printer(PQ x){
	Flight temp;
	int lenght=x.getsize();
		for(int i=1;i<=lenght;i++){
			temp=	x.getmax();
			String help;
			if((temp.isDeparture())){
				help="departed";
				}else{help="landed";}
					System.out.println("Flight "+temp.getnumber()+" "+help+" at "+temp.gettime());
					

		}
			System.out.println("<------------------------------------------------------> ");

	
}
}


