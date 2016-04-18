/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/
package au.com.spatialvision.cordova.indooratlas;

import java.util.List;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.content.Context;

public class IndoorAtlasListener extends CordovaPlugin {
    public static String TAG = "IndoorAtlas";

    /**
     * Create an indooratlas listener.
     */
    public IndoorAtlasListener() {

     }

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The associated CordovaWebView.
     */
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        Log.i(TAG, "initialize");
        super.initialize(cordova, webView);
    }

    /**
     * Executes the request.
     *
     * @param action        The action to execute.
     * @param args          The exec() arguments.
     * @param callbackId    The callback id used when calling back into JavaScript.
     * @return              Whether the action was valid.
     */
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.i(TAG, "execute: "+ action + ", args:" + args.toString());
        callbackContext.success("hello");

//        if (action.equals("start")) {
//            this.callbackContext = callbackContext;
//
//            this.mVenueId = args.getString(0);
//            this.mFloorId = args.getString(1);
//            this.mFloorPlanId = args.getString(2);
//
//            if (this.status != IndoorAtlasListener.RUNNING) {
//                // If not running, then this is an async call, so don't worry about waiting
//                // We drop the callback onto our stack, call start, and let start and the sensor callback fire off the callback down the road
//                //this.start();
//
//                startPositioning();
//            }
//        }
//        else if (action.equals("stop")) {
//            if (this.status == IndoorAtlasListener.RUNNING) {
//                this.stopPositioning();
//            }
//        } else {
//          // Unsupported action
//            return false;
//        }
//
//        PluginResult result = new PluginResult(PluginResult.Status.NO_RESULT, "");
//        result.setKeepCallback(true);
//        callbackContext.sendPluginResult(result);
        return true;
    }

    private void log(final String msg) {
        Log.d(TAG, msg);
    }


    private void initIndoorAtlas() {
          Context context=this.cordova.getActivity().getApplicationContext();
    }

}
