**About the Project**

This project was developed as an academic assignment for the Object-Oriented Programming in Java course at university.

It simulates mortgage/financing plans for real estate (houses, land, and apartments) for a fictional bank, applying OOP concepts such as:
- Classes, objects, methods, and attributes
- Inheritance and polymorphism
- Abstract classes
- Encapsulation
- Exception handling
he main goal is to translate real-world concepts into computational systems, while practicing incremental and modular development in Java.
⚠️ Note: This project does not include a front-end interface; all interaction is performed via the console.

Features

The system allows users to:
- Simulate financing for different types of properties.
- Calculate financing based on:
- Property value
- Duration of financing (in months)
- Annual interest rate
- Manage multiple financing objects using lists.
- Handle exceptions with custom error classes.
- (Planned) Data persistence with text file and serialized object storage.

**Technologies Used**
Language: Java
IDE: IntelliJ IDEA
Core concepts: Object-Oriented Programming (OOP), encapsulation, inheritance, polymorphism, abstract classes, exception handling, collections.

src/
 ├─ financing/
 │   ├─ Financing.java           # Abstract base class
 │   ├─ House.java               # Subclass of Financing
 │   ├─ Land.java                # Subclass of Financing
 │   ├─ Apartment.java           # Subclass of Financing
 ├─ exceptions/
 │   ├─ FinancingException.java  # Custom exceptions
 └─ Main.java                    # Entry point of the application
 
### 1. Abstract Base Class
The `Financing` class is abstract and defines the common structure for all types of financing (House, Land, Apartment).
```java
public abstract class Financing implements Serializable {
    protected double propertyValue;
    protected int financingTerm; // in years
    protected double annualInterestRate;

    public Financing(double propertyValue, int financingTerm, double annualInterestRate) {
        this.propertyValue = propertyValue;
        this.financingTerm = financingTerm;
        this.annualInterestRate = annualInterestRate;
    }

    public abstract double calculateMonthlyPayment();
    public abstract double calculateTotalPayment();
}
```
### 2. Displaying Financing Data
The base class also provides a method to display financing details, showing how subclasses can reuse logic.
public void displayFinancingData() {
```java
     System.out.printf("Property Value: $%.2f%n", propertyValue);
    System.out.printf("Term: %d years (%d months)%n", financingTerm, financingTerm * 12);
    System.out.printf("Annual Interest Rate: %.2f%%%n", annualInterestRate);
    System.out.printf("Estimated Monthly Payment: $%.2f%n", calculateMonthlyPayment());
    System.out.printf("Total Payment: $%.2f%n", calculateTotalPayment());
}
 ```
### 3. Subclass Example – Apartment
The `Apartment` class extends the abstract `Financing` class, demonstrating **inheritance** and **polymorphism**

```java
public class Apartment extends Financing implements Serializable {
    private int parkingSpaces;
    private int floorNumber;

    public Apartment(double propertyValue, int financingTerm, double annualInterestRate, int parkingSpaces, int floorNumber) {
        super(propertyValue, financingTerm, annualInterestRate);
        this.parkingSpaces = parkingSpaces;
        this.floorNumber = floorNumber;
    }

    public int getParkingSpaces() { return parkingSpaces; }
    public int getFloorNumber() { return floorNumber; }

    @Override
    public double calculateMonthlyPayment() {
        double monthlyRate = getAnnualInterestRate() / 12 / 100;
        int totalMonths = financingTerm * 12;
        double factor = Math.pow(1 + monthlyRate, totalMonths);
        return propertyValue * monthlyRate * factor / (factor - 1); // PRICE formula
    }
    @Override
    public double calculateTotalPayment() {
        return calculateMonthlyPayment() * financingTerm * 12;
    }
    @Override
    public void displayFinancingData() {
        super.displayFinancingData();
        System.out.printf("Parking Spaces: %d%n", parkingSpaces);
        System.out.printf("Apartment Floor: %d%n", floorNumber);
    }
}
 ```
### 4. Main Program Execution
The `Main` class demonstrates the full workflow:  
- Collecting user input  
- Storing multiple financing objects in a list  
- Displaying detailed financing data  
- Saving to both serialized and text files

```java
public class Main {
    public static void main(String[] args) {

        InterfaceUsuario ui = new InterfaceUsuario();

        List<Financiamento> financings = new ArrayList<>();
        financings.add(new Casa(200000, 20, 4.5, 100.00, 200.00));
        financings.add(new Casa(300000, 25, 6.0, 200.00, 400.00));
        financings.add(new Apartamento(150000, 15, 5.0, 2, 3));
        financings.add(new Apartamento(500000, 30, 7.5, 3, 2));
        financings.add(new Terreno(350000, 28, 6.5, "Residential"));

        System.out.println("Enter new financing data:");
        Financiamento newFinancing = ui.getFinancingData();
        financings.add(newFinancing);

        ArquivoSerializado.saveAndDisplay((ArrayList<Financiamento>) financings, "financings.ser");
        ArquivoTexto.saveToTxt(financings, "financings.txt");

        double totalPropertyValue = 0;
        double totalFinancingValue = 0;

        System.out.println("\nFULL DETAIL OF CONTRACTED FINANCINGS:\n");

        int count = 1;
        for (Financiamento f : financings) {
            System.out.println("\nFinancing " + count++);
            f.displayFinancingData();

            totalPropertyValue += f.getValorImovel();
            totalFinancingValue += f.calculateTotalPayment();
        }

        System.out.println("\nFINAL INVESTMENT BALANCE");
        System.out.printf("Total value of all properties: $%.2f%n", totalPropertyValue);
        System.out.printf("Total value of all financings: $%.2f%n", totalFinancingValue);

        ui.closeScanner();
    }
}
 ```
### 5. Example Console Output
Below is an example of the program running in the console, demonstrating user interaction and calculated results:
<img width="693" height="450" alt="java" src="https://github.com/user-attachments/assets/a264fd33-dadd-4f3c-8a5d-ffe40febd364" />

**Notes**
- This project was developed individually as a university assignment.
- All code was written by myself (no external code was used).
- Features were implemented incrementally according to the weekly course schedule.

**How to Run**
Clone the repository: git clone <REPOSITORY_URL>
Open the project in IntelliJ IDEA.
Make sure JDK 17 or higher is configured.
Compile and run the Main.java class.
Use the console interface to simulate financing scenarios.
