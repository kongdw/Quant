package com.pbmgo.service;

import java.util.concurrent.Callable;

/**
 * @author David Kong
 * @date 2016/11/8.
 */
public interface RequestTask<T> extends Callable<T> {
}
