





public class Date {

private int day;
private int month;
private int year;
private static int[] lastDayInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };


Date(){
	
	this.day=01;
	this.month=01;
	this.year=1970;
}

Date(int myday,int mymonth,int myyear){
	
this();
	
	if(isValidDate(myday,mymonth,myyear)==true){
		
		this.day=myday;
		this.month=mymonth;
		this.year=myyear;
	}
	
	
	
	

	
	
	
}

Date(Date other){

	day=other.day;
	month=other.month;
	year=other.year;
	
	
}

boolean setDate(int newday, int newmonth, int newyear){
	
	if(isValidDate(newday,newmonth,newyear)){
		
		this.day=newday;
		this.month=newmonth;
		this.year=newyear;
		return true;
	}else{
	
		return false;
	
	}
	
}

public static boolean isValidDate(int anyday, int anymonth, int anyyear) {
	
	if (anyyear%400 == 0 || (anyyear%4 == 0 && anyyear%100 != 0)) {
		lastDayInMonth[1] = 29;	}
		
		else{
		lastDayInMonth[1] = 28;
		}
		
	
	if(anyyear >= 1582 && anymonth >= 1 && anymonth <= 12 && anyday >= 1 && anyday <= lastDayInMonth[anymonth-1]){
		
		return true;
		
	}
	else{
		
		return false;
	}
	
		
			}

public String toString(){
	
	return String.format("%02d.%02d.%04d", day, month, year);
	
	
	
}

public boolean isBefore(Date otherDate){
	
	if(this.year < otherDate.year || (this.year==otherDate.year && this.month < otherDate.month) || (this.year==otherDate.year && this.month==otherDate.month && this.day < otherDate.day)){
		
		return true;
		
		
	}else{ 
		
		return false;
	}
}
public Date nextDay(){
		
	if(isValidDate(day+1,month,year)){
		
		return new Date(day+1,month,year);
	}
	
	else if(isValidDate(1,month+1,year)){
		
		return new Date(1,month+1,year);
	}else{
		
		return new Date(1,1,year+1);
	}
	
	}
			
		
	
	
}



