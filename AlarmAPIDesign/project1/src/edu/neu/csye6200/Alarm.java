package edu.neu.csye6200;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Alarm extends AbstractAlarmAPI{
	
	private String title;
	private String description;
	private Boolean isRepeating;
	private Boolean isEnable;
//	private LocalDate startDate;
	private List<LocalDate> startDateList;
	private List<LocalDate> overDuedList;

	
	
	public Alarm() {
		super();
		this.title = "General Alarm";
		this.description = "Time to go";
		this.isEnable = true;
		this.isRepeating =false;
		this.startDateList = new ArrayList<>();
		this.overDuedList = new ArrayList<>();
		
	}
	

	public Alarm(String title, String description, Boolean isRepeating, int year,int month, int day, Boolean isEnable) {
		super();
		this.title = title;
		this.description =description;
		this.isRepeating = isRepeating;
		this.isEnable = isEnable;
		this.startDateList = new ArrayList<>();
		this.startDateList.add(LocalDate.of(year, month, day));
		this.overDuedList = new ArrayList<>();
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getIsRepeating() {
		return isRepeating;
	}

	public void setIsRepeating(Boolean isRepeating) {
		this.isRepeating = isRepeating;
	}
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Boolean getIsEnable() {
		return isEnable;
	}


	public void setIsEnable(Boolean enable) {
		this.isEnable = enable;
	}
	

//	public LocalDate getStartDate() {
//		return startDate;
//	}
//
//
//	public void setStartDate(LocalDate startDate) {
//		this.startDate = startDate;
//	}
	
	public List<LocalDate> getStartDateList() {
		return startDateList;
	}
	

	public List<LocalDate> getOverDuedList() {
		return overDuedList;
	}


	public abstract void addEventDates();
//	public abstract void addPastEventDates();
	
	
	@Override
	public void alarm() {
		for (LocalDate startDate : this.startDateList) {
//			if (LocalDate.now().compareTo(startDate) > 0) {
//				System.out.println("Invalid start date");
//				return;
//			}
			if (LocalDate.now().equals(startDate)) {
//				this.setStartDate(startDate);
				System.out.println("************Today's event***********");
				this.emailReminder(startDate);
				this.SMSReminder(startDate);
				this.mailReminder(startDate);
				break;
			} else {
//				this.setStartDate(startDate);
				System.out.println("************Incoming event***********");
				System.out.println(alarmInfo(startDate));
				System.out.println(timeRemaining(startDate));
				
			}
		}
	}
	
	@Override
	public void overDuedAlarm() {
		overDuedList.stream().forEach(n->{
			System.out.println("************Past event***********");
			System.out.println(alarmInfo(n));
			System.out.println(timeRemaining(n));
		});
		
	}

	@Override
	public String alarmInfo(LocalDate date) {
		StringBuilder sb =new StringBuilder();
		sb.append("Title: ").append(this.getTitle()).append("\n")
		.append("Description: ").append(this.getDescription()).append("\n")
		.append("Event Date: ").append(date);
		return sb.toString();
	}
	
	
	@Override
	public String timeRemaining(LocalDate date) {
		StringBuilder sb = new StringBuilder();
		if(date.compareTo(LocalDate.now())>=0) {
		sb.append(Period.between(LocalDate.now(), date).getYears()).append(" year(s),")
		.append(Period.between(LocalDate.now(), date).getMonths()).append(" month(s),")
		.append(Period.between(LocalDate.now(), date).getDays()).append(" day(s) left!");}
		else {
			sb.append(Period.between(date,LocalDate.now()).getYears()).append(" year(s),")
			.append(Period.between(date,LocalDate.now()).getMonths()).append(" month(s),")
			.append(Period.between(date,LocalDate.now()).getDays()).append(" day(s) passed!");
		}
		return sb.toString();
	}

	@Override
	public void emailReminder(LocalDate date) {
		System.out.println("email to admin@neu.edu");
		System.out.println(this.alarmInfo(date));
		System.out.println();
		
	}

	@Override
	public void SMSReminder(LocalDate date) {
		System.out.println("txt to his phone");
		System.out.println(this.alarmInfo(date));
		System.out.println();
	}

	@Override
	public void mailReminder(LocalDate date) {
		System.out.println("mail to his address");
		System.out.println(this.alarmInfo(date));
		System.out.println();
	}


	

	

}
