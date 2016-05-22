package com.test.samimchala.data.cloud.di;


import com.test.samimchala.data.cloud.ApiResponseConverter;
import com.test.samimchala.data.cloud.ConfigEndpoint;
import com.test.samimchala.data.cloud.Endpoint;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

@Module
public class DataModule {
    @Provides
    Endpoint provideEndpoints() {
        ApiResponseConverter apiResponseConverter = new ApiResponseConverter();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setConverter(apiResponseConverter)
                .setEndpoint(ConfigEndpoint.BASE_URL)
                .build();

        return restAdapter.create(Endpoint.class);
    }
}
