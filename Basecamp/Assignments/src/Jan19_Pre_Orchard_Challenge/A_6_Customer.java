package Jan19_Pre_Orchard_Challenge;
import java.text.DecimalFormat;

public class A_6_Customer {
	String name, mobileNumber;
	double feedbackRating;
	A_6_Customer(String name, String mobileNumber, double feedbackRating) {
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.feedbackRating = feedbackRating;
	}
	public double getFeedbackRating() {
		return feedbackRating;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getName() {
		return name;
	}
	public String getPrettyFeedbackRating() {
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(getFeedbackRating());
	}
	public void setFeedbackRating(double feedbackRating) {
		this.feedbackRating = feedbackRating;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
