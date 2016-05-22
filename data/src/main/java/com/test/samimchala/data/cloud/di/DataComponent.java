package com.test.samimchala.data.cloud.di;


import com.test.samimchala.data.cloud.Endpoint;

import dagger.Component;

@Component(modules = DataModule.class)
public interface  DataComponent {
    Endpoint endpoint();
}
