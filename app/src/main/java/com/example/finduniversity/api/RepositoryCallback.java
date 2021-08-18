package com.example.finduniversity.api;

public interface RepositoryCallback<T> {

    void onSuccess(T data);
    void onError();
}
