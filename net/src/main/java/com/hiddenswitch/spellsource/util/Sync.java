package com.hiddenswitch.spellsource.util;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.FiberScheduler;
import co.paralleluniverse.fibers.Suspendable;
import co.paralleluniverse.strands.SuspendableAction1;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

import java.util.function.*;

import static io.vertx.ext.sync.Sync.awaitResult;

/**
 * Created by bberman on 2/15/17.
 */
public class Sync {
	@Suspendable
	public static void defer(SuspendableAction1<Void> handler) {
		Vertx.currentContext().runOnContext(suspendableHandler(handler));
	}

	@Suspendable
	public static <T> Handler<T> suspendableHandler(SuspendableAction1<T> handler) {
		FiberScheduler scheduler = io.vertx.ext.sync.Sync.getContextScheduler();
		return p -> new Fiber<Void>(scheduler, () -> handler.call(p)).start();
	}

	/*
	@Suspendable
	public static <T> Handler<T> suspendableHandler(Handler<T> handler) {
		FiberScheduler scheduler = getContextScheduler();
		return p -> new Fiber<Void>(scheduler, () -> handler.handle(p)).start();
	}
	*/


	@Suspendable
	public static <R> R invoke(Supplier<R> func0) {
		return awaitResult(h -> Vertx.currentContext().executeBlocking(done -> {
			done.complete(func0.get());
		}, false, h));
	}

	@Suspendable
	public static <R> R invoke(ThrowingSupplier<R> func0) {
		return awaitResult(h -> Vertx.currentContext().executeBlocking(done -> {
			done.complete(func0.get());
		}, false, h));
	}

	@Suspendable
	public static <T> void invoke0(Consumer<T> func1, T arg1) {
		Void res = awaitResult(h -> Vertx.currentContext().executeBlocking(done -> {
			func1.accept(arg1);
			done.complete();
		}, false, h));
	}

	@Suspendable
	public static void invoke0(NoArgs func0) {
		Void res = awaitResult(h -> Vertx.currentContext().executeBlocking(done -> {
			func0.apply();
			done.complete();
		}, false, h));
	}

	@Suspendable
	public static <T, R> R invoke(Function<T, R> func1, T arg1) {
		return awaitResult(h -> Vertx.currentContext().executeBlocking(done -> {
			done.complete(func1.apply(arg1));
		}, false, h));
	}

	@Suspendable
	public static <T, R> R invoke(ThrowingFunction<T, R> func1, T arg1) {
		return awaitResult(h -> Vertx.currentContext().executeBlocking(done -> {
			done.complete(func1.apply(arg1));
		}, false, h));
	}

	@Suspendable
	public static <T1, T2, R> R invoke(BiFunction<T1, T2, R> func2, T1 arg1, T2 arg2) {
		return awaitResult(h -> Vertx.currentContext().executeBlocking(done -> {
			done.complete(func2.apply(arg1, arg2));
		}, false, h));
	}

	@Suspendable
	public static <T1, T2, R> R invoke(ThrowingBiFunction<T1, T2, R> func2, T1 arg1, T2 arg2) {
		return awaitResult(h -> Vertx.currentContext().executeBlocking(done -> {
			done.complete(func2.apply(arg1, arg2));
		}, false, h));
	}

	@Suspendable
	public static <R> R invoke1(Consumer<Handler<AsyncResult<R>>> func) {
		return awaitResult(func);
	}

	@Suspendable
	public static <T1, R> R invoke(BiConsumer<T1, Handler<AsyncResult<R>>> func, T1 arg1) {
		return awaitResult(h -> func.accept(arg1, h));
	}

	@Suspendable
	public static <T1, T2, R> R invoke(TriConsumer<T1, T2, Handler<AsyncResult<R>>> func, T1 arg1, T2 arg2) {
		return awaitResult(h -> func.accept(arg1, arg2, h));
	}


	@FunctionalInterface
	public interface ThrowingSupplier<R> extends Supplier<R> {
		@Override
		default R get() {
			try {
				return getThrows();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		R getThrows() throws Exception;
	}

	@FunctionalInterface
	public interface ThrowingFunction<T, R> extends Function<T, R> {

		@Override
		default R apply(T t) {
			try {
				return applyThrows(t);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		R applyThrows(T t) throws Exception;
	}

	@FunctionalInterface
	public interface ThrowingBiFunction<T1, T2, R> extends BiFunction<T1, T2, R> {

		@Override
		default R apply(T1 t1, T2 t2) {
			try {
				return applyThows(t1, t2);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		R applyThows(T1 t1, T2 t2) throws Exception;
	}
}
