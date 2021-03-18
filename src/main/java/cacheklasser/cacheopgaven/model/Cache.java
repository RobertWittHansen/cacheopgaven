package cacheklasser.cacheopgaven.model;

import java.util.HashMap;
import java.util.Map;

public class Cache
{
    // Attribut.
    private Map<Integer, String> map;

    public Cache()
    {
        this.map = new HashMap<Integer, String>();
        // map.put(6, "Hej");
    }

    public String get(int key)
    { return map.get(key); }

    public void set(int key, String value )
    {
        map.put(key,value);
    }

    public boolean has(int key)
    {
        // vi laver en ny String'variabel ved navn foundValue
        // vi finder den værdi i vores map, som har key'værdien vi har fået med som parameter
        String foundValue = map.get(key);
        // hvis foundValue er null, findes der ikke data på keyen
        if( foundValue != null )
        {
            return true;
        }

        return false;
    }

    public void delete(int key)
    {
        map.remove(key);
    }
}
