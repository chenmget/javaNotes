package com.netty.callback;

public interface Fetcher {
    void fetchData(FetcherCallback callback);
}
