public class Person {
	
	// atributtes
	private String firstName, lastName, passport;
	private PriorityLevel prioriry;
	
	// construtor
	public Person(String firstName, String lastName, String passport, PriorityLevel priority) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.passport = passport;
		this.prioriry = priority;
	}

	// getters and setters 
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public PriorityLevel getPrioriry() {
		return prioriry;
	}

	public void setPrioriry(PriorityLevel prioriry) {
		this.prioriry = prioriry;
	}
	
	@Override
	public String toString() {
		return this.getFirstName() + " " + this.getPrioriry();
	}

}
