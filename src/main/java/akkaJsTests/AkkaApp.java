package akkaJsTests;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;

public class AkkaApp {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("jsTestSystem");
        ActorRef routerActor = system.actorOf(Props.create(RouterActor.class));
        final Http http = Http.get(system);

    }

}
