package com.pbmgo.async;

import java.util.Optional;

/**
 * 异步回调接口
 * @author David Kong
 * @date 2016/11/10.
 */
public interface AsyncCallback<T> {

    /**
     * Complete handler which is executed when async task is completed or fails execution.
     *
     * @param value the evaluated value from async task, undefined when execution fails
     * @param ex empty value if execution succeeds, some exception if executions fails
     */
    void onComplete(T value, Optional<Exception> ex);
}
