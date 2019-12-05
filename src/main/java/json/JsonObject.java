package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    HashMap<String, Json> array;

    public JsonObject(JsonPair... jsonPairs) {
        array = new HashMap<>();
        for (JsonPair elem : jsonPairs) {
            add(elem);
        }
        int i=0;
        i=6;
    }

    @Override
    public String toJson() {
        String res = "{";
        for (java.util.Map.Entry<String, Json> stringJsonEntry : array.entrySet()) {
            res=
                    res.concat("'" + stringJsonEntry.getKey() + "': " + stringJsonEntry.getValue().toJson() + ", ");
        }
        if (res.equals("{")){
            return "{}";
        }
        res=res.substring(0,res.length()-2)+"}";
//        res = res.replace(", ", "}");
        return res;
//        return "{}";
    }

    public void add(JsonPair jsonPair) {
//        array.add(jsonPair);
        array.put(jsonPair.key, jsonPair.value);
    }

    public Json find(String name) {
        return array.get(name);
    }

    public JsonObject projection(String... names) {
        // ToDo
        return null;
    }
}
