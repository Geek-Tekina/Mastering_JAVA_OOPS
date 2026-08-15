package com.designPattern.observer.Observer;

import com.designPattern.observer.Observable.ItemStockObservable;

public class EmailAlertObserver implements NotificationAlertObserver{
    // This is very important, as we are using empty update methods, we need the object of Observable to get info about
    // data. So we will use Constructor injection
    private final ItemStockObservable observable;
    private final String email;
    public EmailAlertObserver(ItemStockObservable observable, String email){
        this.observable = observable;
        this.email = email;
    }
    @Override
    public void update() {
        System.out.println("Email Notification Sent to - " + this.email);
    }
}
