package lilunke.class16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class parkingLot {
    public enum VehicleSize{
        Compact(1), Large(2);
        private final int size;

        VehicleSize(int size){
            this.size = size;
        }

        public int getSize(){
            return size;
        }
    }

    public static abstract class Vehicle{
        public abstract VehicleSize getSize();
    }

    public static class Car extends Vehicle{
        @Override
        public VehicleSize getSize(){
            return VehicleSize.Compact;
        }
    }

    public static class Truck extends Vehicle{
        @Override
        public VehicleSize getSize(){
            return VehicleSize.Large;
        }
    }

    static class ParkingSpot{
        private final VehicleSize size;
        private Vehicle currentVehicle;

        ParkingSpot(VehicleSize size) {
            this.size = size;
        }

        boolean fit(Vehicle v){
            return currentVehicle == null && size.getSize() >= v.getSize().getSize();
        }

        void park(Vehicle v){
            currentVehicle = v;
        }

        void leave(){
            currentVehicle = null;
        }

        Vehicle getCurrentVehicle(){
            return currentVehicle;
        }
    }

    static class Level{
        private final List<ParkingSpot> spots;
        Level(int numOfSpots){
            List<ParkingSpot> list = new ArrayList<>(numOfSpots);
            int i = 0;
            for ( ; i < numOfSpots / 2; i++) {
                list.add(new ParkingSpot(VehicleSize.Compact));
            }
            for ( ; i < numOfSpots; i++) {
                list.add(new ParkingSpot(VehicleSize.Large));
            }
            spots = Collections.unmodifiableList(list);
        }

        boolean hasSpot(Vehicle v) {
            for (ParkingSpot s : spots) {
                if (s.fit(v)) {
                    return true;
                }
            }
            return false;
        }

        boolean park(Vehicle v){
            for (ParkingSpot s : spots) {
                if (s.fit(v)) {
                    s.park(v);
                    return true;
                }
            }
            return false;
        }

        boolean leave(Vehicle v) {
            for (ParkingSpot s : spots) {
                if (s.getCurrentVehicle() == v) {
                    s.leave();
                    return true;
                }
            }
            return false;
        }
    }

    public static class ParkingLot {
        private final Level[] levels; // why don't use list?
        public ParkingLot(int numLevels, int numSpotsPerLevel) {
            levels = new Level[numLevels];
            for (int i = 0; i < numLevels; i++) {
                levels[i] = new Level(numSpotsPerLevel);
            }
        }

        public boolean hasSpots(Vehicle v) {
            for (Level l : levels) {
                if (l.hasSpot(v)) {
                    return true;
                }
            }
            return false;
        }

        public boolean park(Vehicle v) {
            for (Level l : levels) {
                if (l.park(v)) {
                    return true;
                }
            }
            return false;
        }

        public boolean leave(Vehicle v) {
            for (Level l : levels) {
                if (l.leave(v)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main (String[] args) {
        ParkingLot lot = new ParkingLot(4, 10);
        List<Vehicle> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            final Vehicle v = i % 2 == 0 ? new Car(): new Truck();
            list.add(v);
            boolean hasSpot = lot.hasSpots(v);
            if ( i < 40) {
                assert hasSpot;
                assert lot.park(v);
            } else {
                assert !hasSpot;
                assert !lot.park(v);
            }
        }
        assert list.size() == 50;
        int i = 0;
        for (Vehicle v : list) {
            assert i >= 40 || lot.leave(v);
            i++;
        }
    }
}
