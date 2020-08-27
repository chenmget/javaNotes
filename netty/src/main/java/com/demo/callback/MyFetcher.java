package com.demo.callback;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-08-27 19:34
 **/
public class MyFetcher implements Fetcher {

    final Data data;

    public MyFetcher(Data data) {
        this.data = data;
    }

    @Override
    public void fetchData(FetcherCallback callback) {
        try {
            callback.onData(data);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
