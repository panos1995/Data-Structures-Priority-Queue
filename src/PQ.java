/**
 * CS_Domes_Dedomenwn_Project2
 * @author Ntoulos Panagiotis
 *PQ.java
 */
public class PQ {

	private Flight[] heap;
	private int size;
	int findupdate;
	/**
	 * constuctor of Heap
	 * @param capacity
	 */
	public PQ(int capacity){
		if (capacity<1) throw new IllegalArgumentException();
		this.heap=new Flight[capacity+1];
		this.size=0;
		
	}
	/**
	 * 
	 * @return usage size of the heap
	 */
	public int getsize(){
		return size;
}
	/**
	 * Swaping objects
	 * @param heap[i] object
	 * @param heap[j] object
	 */
	private void swap(int i,int j){
		Flight temp=heap[i];
		heap[i]=heap[j];
		heap[j]=temp;
		}
	
	/**
	 * printing
	 */
	public void print(){
		for (int i=1;i<=size;i++){
			
			System.out.println("flight number "+heap[i].getnumber()+" time :"+heap[i].gettime());
			
		}
		
}
/**
 * 
 * @return true if heap is empty
 */
	public boolean isEmpty(){
		return size==0;
						}
	/**
	 * 
	 * @return the max object of the heap without remove it
	 */
	Flight max(){
		return heap[1];
	}
	/**
	 * Insert an object in this heap
	 * doubles the capacity of the heap if size>=heap.length-1
	 * @param object
	 */
	public void insert(Flight object){
		 if (object == null) throw new IllegalArgumentException();
		//resize check//
		 if (size >= 0.75*(heap.length-1)) 
			 resize();
		 //place object//
		 heap[++size]=object;
		 //swiiim//
		 swim(size);
	}
	
	/**
	 * doubles the array's capacity
	 */
	private void resize(){
		Flight[] helperarray;
		helperarray=new Flight[heap.length*2];
		//coppy objects//
		for (int i=1;i<=size;i++)
			helperarray[i]=heap[i];
		heap=helperarray;
				}
	
		/**
		 * 
		 * @return the root of the heap
		 */
		public Flight getmax(){
		if(size==0) throw new IllegalStateException();
		Flight object=heap[1];
			if(size==1) return object;
	
			if(size>1) heap[1]=heap[size];
	
			heap[size--]=null;
	
			sink(1);
	
				return object;
			
		}
		
	/**
	 * updates the key
	 * @param x flight
	 * @param k flight.key
	 */
	public void UpdateKey(Flight x, KeyFlight k){
		if(x==null) throw new IllegalArgumentException();
		if(findflight(x)) heap[findupdate].setKey(k);

		sink(findupdate);//pai3e me sink prota
		swim(findupdate);//an einai megalutero apo ton patera kane.
	}
	/**
	 * removes the flight with the Keyflight==k
	 * @param k
	 * @return
	 */
		public Flight remove (KeyFlight k){
		
		if(k==null) throw new IllegalArgumentException();
		if(findKeyflight(k)){
			Flight temp=heap[findupdate];
			swap(findupdate,size);
			heap[size--]=null;
			sink(findupdate);
			return temp;
		}
				
		return null;
	}


	private void swim(int i){
		while(i>1){
			int p=i/2;
			int result=heap[p].compareTo(heap[i]);
			if(result>0)
					return; //parent pio urgent apo to paidi
			
			swap(i,p);
			i=p;
		}
	}
	
	private void sink(int i){
        int left = 2*i, right = left+1, max = left;
        // If 2*i >= size, node i is a leaf
        while (left <= size) {
            // Determine the largest children of node i
            if (right <= size) {
                max = heap[left].compareTo(heap[right]) > 0 ? left : right;
            }
            // If the heap condition holds, stop. Else swap and go on.
            if (heap[i].compareTo(heap[max])  > 0) return;
            swap(i, max);
            i = max; left = 2*i; right = left+1; max = left;
        }
    }
/**
 * finds flight
 * @param x
 * @return true if x is exist
 */
	public boolean findflight(Flight x){
		for(int i=1;i<=size;i++){
			if(heap[i].compareTo(x)==0){
				this.findupdate=i;
				return true;
			}
			
	}
	
	
		return false;
}
	/**
	 * find keyflight
	 * @param k
	 * @return true is key exist at the heap
	 */
	public boolean findKeyflight(KeyFlight k){
		for(int i=1;i<=size;i++){
			if(heap[i].Key.compareTo(k)==0){
				this.findupdate=i;
				return true;
			}
		
		
		}
		return false;
	}


	public void Sprint(){
for (int i=1;i<=size;i++){
			
			System.out.print(heap[i].gettime()+"\t");
			
		}
		System.out.println();
	}
















}
