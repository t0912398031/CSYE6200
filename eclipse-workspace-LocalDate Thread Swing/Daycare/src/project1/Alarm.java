package project1;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Alarm extends AbstractAlarmAPI{
	
	private String title;
	private String description;
	private Boolean isRepeating;
	private Boolean isEnable;
	private LocalDate startDate;
	private List<LocalDate> startDateList;

	
	
	public Alarm() {
		super();
		this.title = "General Alarm";
		this.description = "Time to go";
		this.isEnable = true;
		this.isRepeating =false;
		this.startDateList = new ArrayList<>();
		
	}
	

	public Alarm(String title, String description, Boolean isRepeating, int year,int month, int day, Boolean isEnable) {
		super();
		this.title = title;
		this.description =description;
		this.isRepeating = isRepeating;
		this.isEnable = isEnable;
		this.startDateList = new ArrayList<>();
		this.startDateList.add(LocalDate.of(year, month, day));
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
	

	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public List<LocalDate> getStartDateList() {
		return startDateList;
	}

	public abstract void addEventDates();
	
	@Override
	public void alarm() {
		for (LocalDate startDate : this.startDateList) {
			if (LocalDate.now().compareTo(startDate) > 0) {
				System.out.println("Invalid start date");
				return;
			}
			if (LocalDate.now().equals(startDate)) {
				this.setStartDate(startDate);
				this.emailReminder();
				this.SMSReminder();
				this.mailReminder();
				break;
			} else {
				this.setStartDate(startDate);
				System.out.println(alarmInfo());
				System.out.println(timeRemaining());
				
			}
		}
	}

	@Override
	public String alarmInfo() {
		StringBuilder sb =new StringBuilder();
		sb.append("Title: ").append(this.getTitle()).append("\n")
		.append("Description: ").append(this.getDescription()).append("\n")
		.append("Event Date: ").append(startDate);
		return sb.toString();
	}
	@Override
	public String timeRemaining() {
		StringBuilder sb = new StringBuilder();
		sb.append(Period.between(LocalDate.now(), startDate).getYears()).append(" year(s),")
		.append(Period.between(LocalDate.now(), startDate).getMonths()).append(" month(s),")
		.append(Period.between(LocalDate.now(), startDate).getDays()).append(" day(s) left!");
		return sb.toString();
	}

	@Override
	public void emailReminder() {
		System.out.println("email to admin@neu.edu");
		System.out.println(this.alarmInfo());
		
	}

	@Override
	public void SMSReminder() {
		System.out.println("txt to his phone");
		System.out.println(this.alarmInfo());
	}

	@Override
	public void mailReminder() {
		System.out.println("mail to his address");
		System.out.println(this.alarmInfo());
	}


	

	

}
