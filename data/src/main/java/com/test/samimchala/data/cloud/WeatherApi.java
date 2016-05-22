package com.test.samimchala.data.cloud;

import com.test.samimchala.domain.entities.WindForecast;

import javax.inject.Inject;

import rx.Observable;

public class WeatherApi {

    private final Endpoint endpoint;

    @Inject
    public WeatherApi(Endpoint endpoint) {
        this.endpoint =  endpoint;
    }

    public Observable<WindForecast> getWeatherForecast(String city) {
        return endpoint.getWeather(city, "like", ConfigEndpoint.REST_API_KEY);
    }
}
