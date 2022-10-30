public class AbstractBankDetails {

    Bank getInstance(String bankName){
        Bank bank=null;
        if("SBI".equalsIgnoreCase(bankName)){
            bank=new Sbi();
        }else if("HDFC".equalsIgnoreCase(bankName)){
            bank=new Hdfc();
        }else if("ICICI".equalsIgnoreCase(bankName)){
            bank=new Icici();
        }

        return bank;
    }
    public static void main(String[] args) {
       AbstractBankDetails abstractBankDetails=new AbstractBankDetails();

       long startTime = System.nanoTime();
       Bank b=abstractBankDetails.getInstance("hdfc");
       System.out.println(b.getInterest());
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("duration time in second:"+totalTime);
    }

    //for running duration time of program


}
interface Bank{

    double getInterest();

    void setInterest(double interest);
}

 class Hdfc implements Bank{
     double interest=12.2;

     public double getInterest() {
         return interest;
     }

     public void setInterest(double interest) {
         this.interest = interest;
     }
 }
class Sbi implements Bank{
    double interest=11.9;

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}
class Icici implements Bank{
    double interest=21.0;

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}