 class Customer {
    private String customerId;
    private String name;
   // private String customerAdharCard;


    public Customer(String customerId,String name){
        this.customerId=customerId;
        this.name=name;
       // this.customerAdharCard=customerAdharCard;
    }
    public String getCustomerId(){
        return customerId;
    }
    public String getName(){
        return name;
    }


}
