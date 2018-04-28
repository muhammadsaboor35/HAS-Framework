package DeviceControllers;

import java.sql.Timestamp;


/**
 * @author Muhammad Saboor
 * @version 28/4/2018
 */
public interface UltrasonicSensorController extends DeviceController {
   public double getDistance();
   public Timestamp getIntrusionTimestamp();
}