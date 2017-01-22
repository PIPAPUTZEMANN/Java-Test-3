
public class DateFIFO {
	int index=-1;
	Date [] elements;
	Date [] buffer;
	
	public DateFIFO(int size){
		
		if(size<0){
			
			size=10;
			
		}
		elements= new Date[size];
		}
	
	public void push(Date aDate){
		
		index++;
		
		if(index >= elements.length){
			
			buffer=elements;
			
			elements=new Date [buffer.length+10];
			
			System.arraycopy(buffer, 0, elements, 0, buffer.length);
			
		}
		
		elements[index]= aDate;
		buffer= new Date[0];
		}
	
	public Date pop(){               // _123456789
		Date erstesElement;
		if(index>=0){
			erstesElement = new Date(elements[0]);
			buffer = elements;
			elements= new Date [buffer.length];
			
			System.arraycopy(buffer,1,elements,0,buffer.length-1);
			index--;
			
		}else{
			erstesElement = null;
		}
		
		return erstesElement;
	
		
	}
	
	public int find(Date aDate){
		int position=-1;
		for(int i = 0; i < index; i++) {
			if(elements[i].equals(aDate))
				position = i;
		}
		return position;
		
	}
	
	
	public Date peek(){
		
		return new Date(elements[0]);
		
		
		
	}
	
	public boolean isEmpty(){
		
		boolean empty=false;
		
	if(index==0){
		if(elements[0]==null){
			
			empty=true;
		}
		
	}
	return empty;
		
		
	}
	public DateFIFO deepCopy(){
		
		DateFIFO copy=new DateFIFO(elements.length);
		for(int i =0;i<elements.length;i++){
			if (elements[i] != null){
			copy.push(new Date(elements[i]));
			}				
		}
		return copy;
		
		
	}
	
}
