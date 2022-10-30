package abstractfactorydesignpatternmap;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AbstractFactoryDesignPatternMap {
    private final static Map<String, Supplier<Bank>> whiteListedAggregators = new HashMap<>();
    static {
        whiteListedAggregators.put("sbi", Sbi::new);
        whiteListedAggregators.put("hdfc", Hdfc::new);
        whiteListedAggregators.put("icici", Icici::new);
    }

    Bank getInstance(String bankName){
        String inpData = bankName;
        Supplier<Bank> aggrObj = whiteListedAggregators.get(inpData);
        if (aggrObj != null) {
            return aggrObj.get();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        AbstractFactoryDesignPatternMap abstractFactoryDesignPatternMap=new AbstractFactoryDesignPatternMap();
        long startTime = System.nanoTime();
        System.out.println(abstractFactoryDesignPatternMap.getInstance("hdfc").getInterest());
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Program Execution Time in nanoTime is "+totalTime);
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
class Icici implements Bank {
    double interest = 21.0;

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}

