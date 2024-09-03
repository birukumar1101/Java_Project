 class Car {

    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carId,String brand,String model,double basePricePerDay){
        this.carId=carId;
        this.brand=brand;
        this.basePricePerDay=basePricePerDay;
        this.isAvailable=true;
    }
    public String getCarId(){
        return carId;
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public double calculateprice(int rentalDay){
        return basePricePerDay * rentalDay;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public void rent(){
        isAvailable=false;
    }

     public void returnCar() {
        isAvailable=true;
     }
 }
