package com.designPattern.observer.Observer;

import com.designPattern.observer.Observable.ItemStockObservable;

public class PushNotificationAlertObserver implements NotificationAlertObserver{
    private final ItemStockObservable observable;
    private final String websiteURL;

    public PushNotificationAlertObserver(ItemStockObservable observable, String websiteURL){
        this.observable = observable;
        this.websiteURL = websiteURL;
    }
    @Override
    public void update() {
        System.out.println("Push Notification sent to - " + this.websiteURL);
    }
}
