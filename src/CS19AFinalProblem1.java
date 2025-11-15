/* 
Suppose there is a class BulkItem with public methods getPricePerOunce and getWeight. These methods return the item’s price per ounce and weight in ounces, respectively. Both methods have return type double.  Additionally, there is a public field  isTaxable of type boolean to signify whether or not sales tax will be applied. Implement a method  getCost(BulkItem [] items) that returns the total cost of all items as a double. The cost of each item is the price per ounce multiplied by the number of ounces, with sales tax added, if applicable. The tax rate is 10% for all taxable items. Ignore array elements that are null or have a negative price per ounce or for which the weight is not a positive number.  If the array doesn’t have any elements that can contribute to the total cost then just return 0. Use only basic Java as covered in our course. Implement just the method getCost; do not provide a whole program or write any other code.
 */

// package AdHoc.TopSort.src;
public class BulkItem {
    public double getPricePerOunce() {
        // Implementation not shown
        return 0.0;
    }

    public double getWeight() {
        // Implementation not shown
        return 0.0;
    }

    public boolean isTaxable;
}

public class CS19AFinalProblem1 {
    public static double getCost(BulkItem[] items) {
        double totalCost = 0.0;
        final double TAX_RATE = 0.10;

        for (BulkItem item : items) {
            if (item != null && item.getPricePerOunce() >= 0 && item.getWeight() > 0) {
                double cost = item.getPricePerOunce() * item.getWeight();
                if (item.isTaxable) {
                    cost += cost * TAX_RATE; // Add tax if applicable
                }
                totalCost += cost;
            }
        }

        return totalCost;
    }
}
