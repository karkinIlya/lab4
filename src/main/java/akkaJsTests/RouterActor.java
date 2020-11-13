package akkaJsTests;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.dispatch.OnFailure;
import akka.dispatch.OnSuccess;
import akka.pattern.Patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouterActor extends UntypedActor {
    public static final int EXECUTE_ACTORS_COUNT = 10;
    public static final int TIMEOUT_MILLIS = 5000;
    private List<ActorRef> executeActorsList;
    private int nextExecuteActorsCallNumber = 0;
    private ActorRef storeActor;

    private ActorRef getFreeExecuteActor() {
        int currentExecuteActorsCallNumber = nextExecuteActorsCallNumber;
        nextExecuteActorsCallNumber = (nextExecuteActorsCallNumber == EXECUTE_ACTORS_COUNT - 1) ?
                0 : nextExecuteActorsCallNumber + 1;
        return executeActorsList.get(currentExecuteActorsCallNumber);
    }

    public RouterActor() {
        storeActor = getContext().actorOf(Props.create(StoreActor.class));
        executeActorsList = new ArrayList<>();
        for (int i = 0; i < EXECUTE_ACTORS_COUNT; i++) {
            ActorRef currentExecuteActor = getContext().actorOf(Props.create(ExecuteActor.class));
            currentExecuteActor.tell(storeActor, this.getSelf());
            executeActorsList.add(currentExecuteActor);
        }
    }
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof String) {  // Имитирует POST - запрос
            List<JsTest> testList;
            for (JsTest test: testList) {
                getFreeExecuteActor().tell(test, this.getSelf());
                getContext().sender().tell("Executing", this.getSelf());
            }
        } else if (message instanceof Integer) {  // GET
            String packageId = "0";
            Patterns.ask(storeActor, packageId, TIMEOUT_MILLIS).onSuccess(
                    new OnSuccess<String>() {
                        ActorRef sender = getSender();

                        @Override
                        public void onSuccess(String result) throws Throwable {
                            sender.tell(result, getSelf());
                        }
                    },
                    new OnFailure() {

                        @Override
                        public void onFailure(Throwable failure) throws Throwable {

                        }
                    });
        }
    }
}
