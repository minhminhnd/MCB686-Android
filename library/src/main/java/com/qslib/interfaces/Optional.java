package com.qslib.interfaces;

import android.support.annotation.Nullable;

/**
 * Created by dangpp on 2/9/2018.
 */

public class Optional<T> {
    private final T t;

    public Optional(@Nullable T t) {
        this.t = t;
    }

    public static <T> Optional<T> from(@Nullable T object) {
        return new Optional<>(object);
    }

    public boolean isPresent() {
        return t != null;
    }

    public Optional<T> doIfPresent(Consumer<T> action) {
        if (t != null) {
            action.accept(t);
        }

        return this;
    }

    public Optional<T> doIfEmpty(Consumer<T> action) {
        if (t == null) {
            action.accept(t);
        }

        return this;
    }


    @Nullable
    public T get() {
        return t;
    }

    @Nullable
    public T get(T defaultVal) {
        return t == null ? defaultVal : t;
    }
}