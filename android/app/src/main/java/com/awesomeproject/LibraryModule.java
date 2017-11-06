package com.awesomeproject;

import android.content.Context;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.ihealth.common.model.RequestModel;
import com.ihealth.common.model.ResponseModel;

/**
 * Created by Jeepend on 2017/11/6.
 */

public class LibraryModule extends ReactContextBaseJavaModule {
    private Context mContext;
    public LibraryModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mContext = reactContext;
    }

    @Override
    public String getName() {
        return "LibraryModule";
    }

    @ReactMethod
    public void start() {
        RequestModel requestModel = new RequestModel(mContext);
        requestModel.apiVersion = "100";
        requestModel.deviceType = RequestModel.IHLDeviceType.IHLDeviceType_PO3;
        requestModel.deviceMacOrUUID = "7CEC79DE33BD";
        requestModel.action = RequestModel.IHLAction.IHLActionAddSyncMeasure;
        requestModel.addType = RequestModel.IHLAddType.IHLAddDeviceWithScan;
        requestModel.setOnReceiveListener(new ResponseModel.OnReceiveListener() {
            @Override
            public void onReceive(ResponseModel responseModel) {
                Log.i("jeepend", responseModel.toString());
            }
        });
        requestModel.start();
    }
}
