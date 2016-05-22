package com.test.samimchala.data.repositories;

import com.test.samimchala.data.cloud.WeatherApi;
import com.test.samimchala.domain.entities.WindForecast;
import com.test.samimchala.domain.repositories.SessionRepository;

import javax.inject.Inject;

import rx.Observable;

public class SessionDataRepository implements SessionRepository {

    private WeatherApi weatherApi;

    @Inject public SessionDataRepository(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    @Override
    public Observable<WindForecast> askForWindForecast(String city) {

        return weatherApi.getWeatherForecast(city);
    }
}
