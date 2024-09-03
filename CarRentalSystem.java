import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem(){
        cars=new ArrayList<>();
        customers=new ArrayList<>();
        rentals=new ArrayList<>();
    }
    public void addCar(Car car){
       cars.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void rentCar(Car car,Customer customer,int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car,customer,days));
        }else{
            System.out.println("Sorry Sir Car is not Available for rent");
        }
    }
    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToRemove=null;
        for (Rental rental:rentals){
            if(rental.getCar()==car){
                 rentalToRemove=rental;
                 break;
            }
        }
        if (rentalToRemove!=null){
            rentals.remove(rentalToRemove);
           // System.out.println("Car Return Successfully");
        }
        else {
            System.out.println("Car was not rented");
        }
    }
    public void menu(){
        Scanner s= new Scanner(System.in);

        while(true){
            System.out.println("=====Car Rental System=====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");

            int choice=s.nextInt();
            s.nextLine();

            if(choice==1){
                System.out.println("\n== Rent a car ==\n");
                System.out.print("Enter your name: ");
                String customerName=s.nextLine();


                System.out.println("\n Available Cars: ");
                for(Car car:cars){
                    if (car.isAvailable()){
                        System.out.println(car.getCarId()+"-"+car.getBrand()+"-"+car.getModel());
                        //System.out.println(car.getModel());
                    }
                }
                System.out.println("\n Enter the car ID you want to rent: ");
                String carId=s.nextLine();

                System.out.println("Enter the number of days for rental: ");
                int rentalDays=s.nextInt();
                s.nextLine();

                Customer newCustomer=new Customer("CUS"+(customers.size()+1),customerName);

                Car selectedCar=null;

                for(Car car:cars){
                    if(car.getCarId().equals(carId)&&car.isAvailable()){
                        selectedCar=car;
                        break;
                    }
                }
                if(selectedCar !=null){
                    double totalPrice=selectedCar.calculateprice(rentalDays);
                    System.out.println("\n=== Rental Information ===\n");
                    System.out.println("Customer ID: "+newCustomer.getCustomerId());
                    System.out.println("Customer Name: "+newCustomer.getName());
                    System.out.println("Car: "+selectedCar.getBrand());
                    System.out.println("RentalDays: "+rentalDays);
                    System.out.printf("Total Price: $%.2f%n",totalPrice);

                    System.out.print("\n Confirm rental(Y/N): ");
                    String confirm=s.nextLine();


                    if (confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedCar,newCustomer,rentalDays);
                        System.out.println("\ncar rented successfully");
                    }else {
                        System.out.println("\n Rental canceled");
                    }
                }
                else {
                    System.out.println("\n Invalid car selection or car is not available for rent.");
                }
            }
            else if (choice==2){
                System.out.println("\n== Return a Car ==\n");
                System.out.println("Enter the car ID you want to return: ");
                String carId=s.nextLine();

                Car carToReturn=null;
                for(Car car : cars){
                    if(car.getCarId().equals(carId)&& !car.isAvailable()){
                        carToReturn=car;
                        break;
                    }
                }
                if(carToReturn!=null){
                    Customer customer=null;
                    for(Rental rental:rentals){
                        if(rental.getCar()==carToReturn){
                            customer=rental.getCustomer();
                            break;
                        }
                    }
                    if (carToReturn!=null){
                        returnCar(carToReturn);
                        System.out.println("Car return successfully by "+customer.getName());
                    }
                    else{
                        System.out.println("Car was not rented or rental information is missing");
                    }
                }else{
                    System.out.println("Invalid car ID or car is not rented");
                }
            } else if (choice==3) {
                break;
            }else {
                System.out.println("Invalid choice. Please Enter valid choice");
            }
        }
        System.out.println("Thank you for using the car Rental System");
    }
}
