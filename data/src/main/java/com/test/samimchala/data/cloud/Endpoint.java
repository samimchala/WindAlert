package com.test.samimchala.data.cloud;

import com.test.samimchala.domain.entities.WindForecast;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface Endpoint {

    @GET("/data/2.5/weather")
    Observable<WindForecast>  getWeather(@Query("q") String strCity, @Query("type") String type, @Query("APPID") String key);
}
