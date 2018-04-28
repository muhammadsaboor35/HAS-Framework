package DeviceControllers;

public interface GasSensorController extends DeviceController {
   public double getLPGConcentration();
   public double getMethaneConcentration();
   public double getEthaneConcentration();
   public double getPropaneConcentration();
   public double getCarbonMonoOxideConcentration();
   public double getSmokeConcentration();
}