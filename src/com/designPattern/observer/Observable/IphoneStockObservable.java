package com.designPattern.observer.Observable;

import com.designPattern.observer.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservable implements ItemStockObservable {
    private List<NotificationAlertObserver> observerList;
    private int iphoneStock;

    public IphoneStockObservable(){
        this.observerList = new ArrayList<>();
        this.iphoneStock = 0;
    }
    @Override
    public void addSubscriber(NotificationAlertObserver observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeSubscriber(NotificationAlertObserver observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver observer : this.observerList){
            observer.update();
        }
    }

    @Override
    public void setItemStockCount(int newStockAdded) {

        boolean wasOutOfStock = this.iphoneStock == 0;

        this.iphoneStock += newStockAdded;

        if(wasOutOfStock && this.iphoneStock > 0){
            notifySubscribers();
        }
    }

    @Override
    public int getItemStockCount() {
        return this.iphoneStock;
    }
}
