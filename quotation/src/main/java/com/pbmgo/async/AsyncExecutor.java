package com.pbmgo.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * AsyncExecutor interface
 *
 * @author David Kong
 * @date 2016/11/10.
 */
public interface AsyncExecutor {

    /**
     * Starts processing of an async task. Returns immediately with async result.
     *
     * @param task task to be executed asynchronously
     * @return async result for the task
     */
    <T> AsyncResult<T> startProcess(Callable<T> task);

    /**
     * Starts processing of an async task. Returns immediately with async result. Executes asyncCallback
     * when the task is completed.
     *
     * @param task     task to be executed asynchronously
     * @param asyncCallback asyncCallback to be executed on task completion
     * @return async result for the task
     */

    <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> asyncCallback);

    /**
     * Ends processing of an async task. Blocks the current thread if necessary and returns the
     * evaluated value of the completed task.
     *
     * @param asyncAsyncResult async result of a task
     * @return evaluated value of the completed task
     * @throws ExecutionException   if execution has failed, containing the root cause
     * @throws InterruptedException if the execution is interrupted
     */
    <T> T endProcess(AsyncResult<T> asyncAsyncResult) throws ExecutionException, InterruptedException;
}
