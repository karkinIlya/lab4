package akkaJsTests;

import akka.actor.UntypedAbstractActor;
import akka.actor.UntypedActor;

public class ExecuteActor<InT, OutT> extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof JsTest) {
            JsTest<InT, OutT> test = (JsTest<InT, OutT>)message;

        }
    }
}
