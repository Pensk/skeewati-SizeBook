package com.kotobadon.pensk.skeewati_sizebook;

import android.app.Application;
import android.content.Context;

/**
 * Created by pensk on 2017/02/05.
 */

public class SizeBookApplication extends Application {
    private static SizeBookController controller = null;
    private static SizeBookModel model = null;
    private static Context context;

    static SizeBookController getController() {
        if(controller == null) {
            return new SizeBookController();
        }
        return controller;
    }

    static SizeBookModel getModel() {
        if(model == null) {
            return new SizeBookModel();
        }
        return model;
    }

    // http://stackoverflow.com/questions/2002288/static-way-to-get-context-on-android
    // Statically get context for saving in the android filesystem in the Model (outside of an activity)
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    static Context getContext(){
        return context;
    }
}
