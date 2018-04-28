package DeviceControllers;

import java.sql.Timestamp;

public interface UltrasonicSensorController extends DeviceController {
   public double getDistance();
   public Timestamp getIntrusionTimestamp();
}