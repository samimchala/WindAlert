package com.test.samimchala.domain.repositories;

import com.test.samimchala.domain.entities.WindForecast;

import rx.Observable;

public interface SessionRepository {
    Observable<WindForecast> askForWindForecast(String city);
}