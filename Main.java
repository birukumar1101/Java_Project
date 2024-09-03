public class Main {
    public static void main(String[] args) {
        CarRentalSystem rental=new CarRentalSystem();

        Car car1=new Car("C01","Suzuki","swift",70);
        Car car2=new Car("C02","Honda","Creta",60);
        Car car3=new Car("C03","Tata","Nexon",80);
        Car car4=new Car("C04","Mahindra","Scorpio",60);
        Car car5=new Car("C05","Mahindra","Thar",100);
        rental.addCar(car1);
        rental.addCar(car2);
        rental.addCar(car3);
        rental.addCar(car4);
        rental.addCar(car5);


        rental.menu();
    }
}
