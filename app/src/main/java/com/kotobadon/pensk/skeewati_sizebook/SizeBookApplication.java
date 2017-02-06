package com.kotobadon.pensk.skeewati_sizebook;

import android.app.Application;

/**
 * Created by pensk on 2017/02/05.
 */

public class SizeBookApplication extends Application {
    private static SizeBookController controller = null;
    private static SizeBookModel model = null;

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
}
