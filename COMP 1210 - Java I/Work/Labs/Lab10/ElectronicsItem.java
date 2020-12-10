public class ElectronicsItem extends InventoryItem
{
   public static final double SHIPPING_COST = 1.5;
   protected double weight;

   public ElectronicsItem(String nameIn, double priceIn, double weightIn)
   {
      super(nameIn, priceIn);
      weight = weightIn;
   }

   public double calculateCost()
   {
      return super.calculateCost() + (SHIPPING_COST * weight);
   }
}