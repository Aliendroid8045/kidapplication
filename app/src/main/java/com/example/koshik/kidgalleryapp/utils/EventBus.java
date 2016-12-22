package com.example.koshik.kidgalleryapp.utils;

import com.squareup.otto.Bus;

/**
 * Created by koshik on 25-11-2016.
 */

public class EventBus extends Bus {
    private static final EventBus bus = new EventBus();

    private EventBus() {

    }

    public static Bus getInstance() {
        return bus;
    }
}
