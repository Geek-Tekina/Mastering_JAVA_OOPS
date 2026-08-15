package com.designPattern.observer;

import com.designPattern.observer.Observable.IphoneStockObservable;
import com.designPattern.observer.Observable.ItemStockObservable;
import com.designPattern.observer.Observer.EmailAlertObserver;
import com.designPattern.observer.Observer.PushNotificationAlertObserver;

public class Main {
    public static void main(String[] args) {
        ItemStockObservable iphoneStockObservableObj = new IphoneStockObservable();

        iphoneStockObservableObj.addSubscriber(new EmailAlertObserver(iphoneStockObservableObj, "tpbc1717@gmail.com"));
        iphoneStockObservableObj.addSubscriber(new PushNotificationAlertObserver(iphoneStockObservableObj, "www.socialx.com"));
        iphoneStockObservableObj.addSubscriber(new EmailAlertObserver(iphoneStockObservableObj, "hemant_mishra_0501@gmail.com"));

        // now let's say Iphone stock came
        iphoneStockObservableObj.setItemStockCount(10);
    }
}
