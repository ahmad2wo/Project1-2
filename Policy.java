/**
 * The Policy class represents a health insurance policy
 * with information about the policyholder and the policy terms.
 */
public class Policy {
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String smokingStatus;
    private double height;
    private double weight;

    /** Default constructor */
    public Policy() {
        policyNumber = 0;
        providerName = "";
        policyholderFirstName = "";
        policyholderLastName = "";
        policyholderAge = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    /**
     * Constructs a Policy with all fields.
     * @param policyNumber The policy number
     * @param providerName The provider name
     * @param firstName Policyholder's first name
     * @param lastName Policyholder's last name
     * @param age Policyholder's age
     * @param smokingStatus "smoker" or "non-smoker"
     * @param height Policyholder's height in inches
     * @param weight Policyholder's weight in pounds
     */
    public Policy(int policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = firstName;
        this.policyholderLastName = lastName;
        this.policyholderAge = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    public int getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }
    public String getPolicyholderFirstName() { return policyholderFirstName; }
    public String getPolicyholderLastName() { return policyholderLastName; }
    public int getPolicyholderAge() { return policyholderAge; }
    public String getSmokingStatus() { return smokingStatus; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }
    public void setProviderName(String providerName) { this.providerName = providerName; }
    public void setPolicyholderFirstName(String firstName) { this.policyholderFirstName = firstName; }
    public void setPolicyholderLastName(String lastName) { this.policyholderLastName = lastName; }
    public void setPolicyholderAge(int age) { this.policyholderAge = age; }
    public void setSmokingStatus(String status) { this.smokingStatus = status; }
    public void setHeight(double height) { this.height = height; }
    public void setWeight(double weight) { this.weight = weight; }

    /**
     * Calculates and returns the BMI.
     * @return The BMI of the policyholder
     */
    public double getBMI() {
        return (weight * 703) / (height * height);
    }

    /**
     * Calculates and returns the policy price.
     * @return The policy price in dollars
     */
    public double getPolicyPrice() {
        double price = 600.0;
        if (policyholderAge > 50) price += 75.0;
        if (smokingStatus.equalsIgnoreCase("smoker")) price += 100.0;
        double bmi = getBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }
        return price;
    }  
}