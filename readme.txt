Requirements:
- docker 1.10
- docker compose 1.6+

To run the project:
1. Edit "version" in build.gradle to use Vert.x 3.3.2 or Vert.x 3.2.1
2. Build the fat jar
run at the root of the project:
./gradlew shadowJar
3. Run the containers
run at the root of the project:
docker-compose up

With Vert.x 3.3.2 I get:
webserver               | java.net.UnknownHostException: failed to resolve 'my-redis.home'. Exceeded max queries per resolve 3
webserver               | 	at io.vertx.core.dns.impl.fix.DnsNameResolverContext.finishResolve(DnsNameResolverContext.java:435)
webserver               | 	at io.vertx.core.dns.impl.fix.DnsNameResolverContext.tryToFinishResolve(DnsNameResolverContext.java:362)
webserver               | 	at io.vertx.core.dns.impl.fix.DnsNameResolverContext$2.operationComplete(DnsNameResolverContext.java:160)
webserver               | 	at io.netty.util.concurrent.DefaultPromise.notifyListener0(DefaultPromise.java:518)
webserver               | 	at io.netty.util.concurrent.DefaultPromise.notifyListenersNow(DefaultPromise.java:492)
webserver               | 	at io.netty.util.concurrent.DefaultPromise.notifyListenersWithStackOverFlowProtection(DefaultPromise.java:431)
webserver               | 	at io.netty.util.concurrent.DefaultPromise.notifyListeners(DefaultPromise.java:420)
webserver               | 	at io.netty.util.concurrent.DefaultPromise.setSuccess(DefaultPromise.java:99)
webserver               | 	at io.vertx.core.dns.impl.fix.DnsQueryContext.setSuccess(DnsQueryContext.java:197)
webserver               | 	at io.vertx.core.dns.impl.fix.DnsQueryContext.finish(DnsQueryContext.java:180)
webserver               | 	at io.vertx.core.dns.impl.fix.DnsNameResolver$DnsResponseHandler.channelRead(DnsNameResolver.java:680)
webserver               | 	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348)
webserver               | 	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:334)
webserver               | 	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:326)
webserver               | 	at io.netty.handler.codec.MessageToMessageDecoder.channelRead(MessageToMessageDecoder.java:102)
webserver               | 	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348)
webserver               | 	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:334)
webserver               | 	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:326)
webserver               | 	at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1320)
webserver               | 	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348)
webserver               | 	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:334)
webserver               | 	at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:905)
webserver               | 	at io.netty.channel.nio.AbstractNioMessageChannel$NioMessageUnsafe.read(AbstractNioMessageChannel.java:93)
webserver               | 	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:563)
webserver               | 	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:504)
webserver               | 	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:418)
webserver               | 	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:390)
webserver               | 	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:742)
webserver               | 	at java.lang.Thread.run(Thread.java:745)