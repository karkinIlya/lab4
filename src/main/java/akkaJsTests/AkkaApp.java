package akkaJsTests;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

public class AkkaApp extends AllDirectives {

    public static final String HOST_NAME = "localhost";
    public static final int PORT_NAME = 8080;

    public static void main(String[] args) throws IOException {
        final ActorSystem system = ActorSystem.create("jsTestSystem");
        ActorRef routerActor = system.actorOf(Props.create(RouterActor.class));
        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);

        final AkkaApp app = new AkkaApp();
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
                app
                        .createRoute()
                        .flow(system, materializer);
        final CompletionStage<ServerBinding> binding =
                http.bindAndHandle(
                        routeFlow,
                        ConnectHttp.toHost(HOST_NAME, PORT_NAME),
                        materializer);
        System.out.println("Server online at http://localhost:8080/\nPress RETURN to stop...");
        System.in.read();
        binding
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound ->system.terminate());
    }

    private Route createRoute() {
        return route(
                path("??", () ->
                        get(() ->
                                complete("<h1>sss</h1>")
                        )
                )
        );
    }

}
