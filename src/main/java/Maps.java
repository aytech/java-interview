import java.util.HashMap;
import java.util.Map;

/**
 * What is the expected output?
 * If they answer 1, run the code and then ask "why is the output 2?"
 * Follow on - fix it so that the end size of the map is just 1 (equals + hashCode)
 * Solution:
 * - implement (override) equals() and hashCode() methods in the MapKey class
 */

public class Maps {
    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        mapTest.updateStatus("Foo", 100, "OK");
        mapTest.updateStatus("Foo", 100, "Error");
        System.out.println(mapTest.size());
    }

    static class MapKey {
        String objType;
        int id;
        public MapKey(String objType, int id) {
            this.objType = objType;
            this.id = id;
        }

        // This is the solution, not to be
        // presented to the candidate
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MapKey mk)) {
                return false;
            }
            return mk.id == this.id && mk.objType.equals(this.objType);
        }

        // This is the solution, not to be
        // presented to the candidate
        @Override
        public int hashCode() {
            int code = 17;
            if (id != 0) {
                code = 31 * code + id;
            }
            if (objType != null) {
                code = 31 * code + objType.hashCode();
            }
            return code;
        }
    }

    static class MapTest {
        private final Map<MapKey, String> map = new HashMap<>();

        public void updateStatus(String objType, int id, String status) {
            map.put(new MapKey(objType, id), status);
        }

        public int size() {
            return map.size();
        }
    }
}
