package project1;

import java.time.LocalDate;
import java.time.Period;

public class RegistrationAlarm extends Alarm{
	
	private LocalDate dob;
	
	
	public RegistrationAlarm(int DOByear,int DOBmonth,int DOBday) {
		super();
		this.dob = LocalDate.of(DOByear, DOBmonth, DOBday);
		this.setDescription("It's time to register");
		this.setTitle("Registration Day");
		this.addEventDates();
	}
	

	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public void addEventDates() {
		long period =Period.between(dob, LocalDate.now()).toTotalMonths();
		long age = period/12;
		if(dob.plusYears(age).equals(LocalDate.now())) this.getStartDateList().add(dob.plusYears(age));
		else this.getStartDateList().add(dob.plusYears(age+1));
	}
	
	
	public static void demo() {
		Alarm registrationAlarm = new RegistrationAlarm(2016,5,27);
		registrationAlarm.alarm();
	}

}
