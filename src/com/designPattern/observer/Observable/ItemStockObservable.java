package com.designPattern.observer.Observable;

import com.designPattern.observer.Observer.NotificationAlertObserver;

public interface ItemStockObservable {

    public void addSubscriber(NotificationAlertObserver observer);
    public void removeSubscriber(NotificationAlertObserver observer);
    public void notifySubscribers();
    public void setItemStockCount(int newStockAdded);
    public int getItemStockCount();

}
