package DeviceControllers;


/**
 * @author Muhammad Saboor
 * @version 28/4/2018
 */
public interface GasSensorController extends DeviceController {
   public double getLPGConcentration();
   public double getMethaneConcentration();
   public double getEthaneConcentration();
   public double getPropaneConcentration();
   public double getCarbonMonoOxideConcentration();
   public double getSmokeConcentration();
}