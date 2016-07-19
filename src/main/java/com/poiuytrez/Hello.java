package com.poiuytrez;

import io.vertx.core.Vertx;
import io.vertx.redis.RedisClient;
import io.vertx.redis.RedisOptions;

public class Hello {

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();
        vertx
                .createHttpServer()
                .requestHandler(req -> req.response().end("Hello World!"))
                .listen(8083, handler -> {
                    if (handler.succeeded()) {
                        System.out.println("http://localhost:8083/");

                        // connect to redis
                        RedisOptions config = new RedisOptions()
                                .setHost("my-redis");

                        RedisClient redis = RedisClient.create(vertx, config);
                        redis.set("hello", "world", res -> {
                            if (res.succeeded()) {
                                System.err.println("succeeded");
                            } else {
                                res.cause().printStackTrace();
                            }
                        });


                    } else {
                        System.err.println("Failed to listen on port 8083");
                    }
                });
    }

}
