import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PolicyDemo {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("PolicyInformation.txt");
        Scanner inputFile = new Scanner(file);

        ArrayList<Policy> policies = new ArrayList<>();
        int smokerCount = 0;
        int nonSmokerCount = 0;

        while (inputFile.hasNextLine()) {
            int policyNumber = Integer.parseInt(inputFile.nextLine());
            String providerName = inputFile.nextLine();
            String firstName = inputFile.nextLine();
            String lastName = inputFile.nextLine();
            int age = Integer.parseInt(inputFile.nextLine());
            String smokingStatus = inputFile.nextLine();
            double height = Double.parseDouble(inputFile.nextLine());
            double weight = Double.parseDouble(inputFile.nextLine());

            Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                    age, smokingStatus, height, weight);
            policies.add(policy);

            if (smokingStatus.equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        inputFile.close();

        for (Policy p : policies) {
            System.out.println("Policy Number: " + p.getPolicyNumber());
            System.out.println("Provider Name: " + p.getProviderName());
            System.out.println("Policyholder's First Name: " + p.getPolicyholderFirstName());
            System.out.println("Policyholder's Last Name: " + p.getPolicyholderLastName());
            System.out.println("Policyholder's Age: " + p.getPolicyholderAge());
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + p.getSmokingStatus());
            System.out.printf("Policyholder's Height: %.1f inches\n", p.getHeight());
            System.out.printf("Policyholder's Weight: %.1f pounds\n", p.getWeight());
            System.out.printf("Policyholder's BMI: %.2f\n", p.getBMI());
            System.out.printf("Policy Price: $%.2f\n", p.getPolicyPrice());
            System.out.println();
        }

        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}  