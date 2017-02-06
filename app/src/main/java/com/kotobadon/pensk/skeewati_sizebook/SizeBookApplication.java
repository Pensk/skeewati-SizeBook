package com.kotobadon.pensk.skeewati_sizebook;

import android.app.Application;
import android.content.Context;
import android.util.Size;

/**
 * Created by pensk on 2017/02/05.
 */

//Keeps track of the Model, Controller, and the currently chosen Person Record
public class SizeBookApplication extends Application {
    transient private static SizeBookController controller = null;
    transient private static SizeBookModel model = null;
    private static int current;
    // Keep an instance of the application to reference outside of an Activity
    private static SizeBookApplication instance;

    static SizeBookModel getModel() {
        if(model == null) {
            return new SizeBookModel();
        }
        return model;
    }

    public static SizeBookController getController() {
        if(controller == null) {
            return new SizeBookController(getModel());
        }
        return controller;
    }

    public static SizeBookApplication getInstance(){
        return instance;
    }

    // get/set the current Person Record ID
    public static int getCurrent(){
        return current;
    }

    public static void setCurrent(int c){
        current = c;
    }

    // http://stackoverflow.com/questions/2002288/static-way-to-get-context-on-android
    // Statically get context for saving in the android filesystem in the model (outside of an activity)
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        current = -1;
    }
}
