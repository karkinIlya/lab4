package akkaJsTests;

import akka.actor.AbstractActor;
import akka.actor.UntypedActor;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StoreActor extends UntypedActor {
    private Map<String, JsTest<String, Integer>> store = new HashMap<>();

    @Override
    public void onReceive(Object message) throws Throwable {

    }
}
