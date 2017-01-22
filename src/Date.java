





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

public Day getWeekday(){
	
	Day wday=null;
	
	
	int T=this.getDay();
	int Nt;
	int Nm=0;
	int NJz;
	int NJh;
	int Nsj=0;
	int w;
	
	
	// Wochentag bestimmen
	
	Nt=T%7;
	
	// Montag bestimmen
	
	
	
	switch(this.getMonth()){
	
	case 1 : Nm = 0; break;
	case 2 : Nm = 3; break;
	case 3 : Nm = 3; break;
	case 4 : Nm = 6; break;
	case 5 : Nm = 1; break;
	case 6 : Nm = 4; break;
	case 7 : Nm = 6; break;
	case 8 : Nm = 2; break;
	case 9 : Nm = 5; break;
	case 10: Nm = 0; break;
	case 11: Nm = 3; break;
	case 12: Nm = 5; break;
	
	
	}
	
	//Jahresziffer die letzten beiden Ziffern
	
	int jz = this.getYear()%1000%100;
	
	NJz=(jz+(jz/4))%7;
	
	// Jahresziffer die ersten beiden Ziffern
	
	int jh = (this.getYear()-jz)/100;
	
	NJh=(3-(jh%4))*2;
	
	
	if(isValidDate(this.getDay(),this.getMonth(),this.getYear())){
		
		if (getMonth() == 1 || getMonth() == 2){
			Nsj = -1;	
		
	}
	}
	// Berechnung
	
	
	
	w=(Nt+Nm+NJh+NJz+Nsj);
	
	
	switch (w) {
	case 0 : wday = Day.Sunday;		break;
	case 1 : wday = Day.Monday;		break;
	case 2 : wday = Day.Tuesday;	break;
	case 3 : wday = Day.Wednesday;	break;
	case 4 : wday = Day.Thursday;	break;
	case 5 : wday = Day.Friday;		break;
	case 6 : wday = Day.Saturday;	break;
	}
	return wday;
}

public int getYear() {
	// TODO Auto-generated method stub
	return year;
}

public int getDay() {
	// TODO Auto-generated method stub
	return day;
}

public int getMonth() {
	// TODO Auto-generated method stub
	return month;
}



			
		
	
	
}



