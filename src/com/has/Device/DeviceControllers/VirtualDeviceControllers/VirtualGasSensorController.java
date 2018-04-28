package DeviceControllers.VirtualDeviceControllers;


/**
 * @author Muhammad Saboor
 * @version 28/4/2018
 */
public class VirtualGasSensorController implements VirtualDeviceController {
   private double lpgConcentration;
   private double methaneConcentration;
   private double ethaneConcentration;
   private double propaneConcentration;
   private double carbonMonoOxideConcentration;
   private double smokeConcentration;
   
   public VirtualGasSensorController() {
      this.lpgConcentration = 0;
      this.methaneConcentration = 0;
      this.ethaneConcentration = 0;
      this.propaneConcentration = 0;
      this.carbonMonoOxideConcentration = 0;
      this.smokeConcentration = 0;
   }
   
   public double getLPGConcentration() {
      return this.lpgConcentration;
   }
   
   public double getMethaneConcentration() {
      return this.methaneConcentration;
   }
   
   public double getEthaneConcentration() {
      return this.ethaneConcentration;
   }
   
   public double getPropaneConcentration() {
      return this.propaneConcentration;
   }
   
   public double getCarbonMonoOxideConcentration() {
      return this.carbonMonoOxideConcentration ;
   }
   
   public double getSmokeConcentration() {
      return this.smokeConcentration;
   }
   
   public void setLPGConcentration( double lpgConcentration ) {
      this.lpgConcentration = lpgConcentration;
   }
   
   public void setMethaneConcentration( double methaneConcentration ) {
      this.methaneConcentration = methaneConcentration;
   }
   
   public void setEthaneConcentration( double ethaneConcentration ) {
      this.ethaneConcentration = ethaneConcentration;
   }
   
   public void setPropaneConcentration( double propaneConcentration ) {
      this.propaneConcentration = propaneConcentration;
   }
   
   public void setCarbonMonoOxideConcentration( double carbonMonoOxideConcentration ) {
      this.carbonMonoOxideConcentration = carbonMonoOxideConcentration;
   }
   
   public void setSmokeConcentration( double smokeConcentration ) {
      this.smokeConcentration = smokeConcentration;
   }
}