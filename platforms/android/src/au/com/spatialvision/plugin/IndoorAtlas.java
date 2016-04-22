package au.com.spatialvision.plugin;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.util.Log;
import android.widget.Toast;

import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;
import com.indooratlas.android.sdk.resources.IALatLng;
import com.indooratlas.android.sdk.resources.IALocationListenerSupport;


public class IndoorAtlas extends CordovaPlugin {
  public static class LastResult {
    double lat;
    double lng;

    LastResult(double lat, double lng) {
      this.lat = lat;
      this.lng = lng;
    }
  }

  public static String TAG = "IndoorAtlas";

  private LastResult lastResult;

  private IALocationManager mIALocationManager;
  private IALocationListener mLocationListener = new IALocationListenerSupport() {
    @Override
    public void onLocationChanged(IALocation location) {
      String msg = "location is: " + location.getLatitude() + "," + location.getLongitude();
      Log.d(TAG, msg);
      lastResult = new LastResult(location.getLatitude(), location.getLongitude());
    }
  };

  /**
   * Sets the context of the Command. This can then be used to do things like
   * get file paths associated with the Activity.
   *
   * @param cordova The context of the main Activity.
   * @param webView The associated CordovaWebView.
   */
  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
    Log.i(TAG, "initializing location manager");

    final Context context=this.cordova.getActivity().getApplicationContext();

    cordova.getActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mIALocationManager = IALocationManager.create(context);
        mIALocationManager.requestLocationUpdates(IALocationRequest.create(), mLocationListener);
      }
    });

    Log.i(TAG, "initialized location manager");
  }


  @Override
  public boolean execute(
    String action, 
    JSONArray args, 
    CallbackContext callbackContext
  ) throws JSONException {
    Log.i(TAG, "execute");

    if ("echo".equals(action)) {
      echo(args.getString(0) + "...", callbackContext);
      return true;
    }
    if ("current".equals(action)) {
      callbackContext.success(lastResult.lat + "," + lastResult.lng);
      return true;
    }


    
    return false;
  }

  private void echo(
    String msg, 
    CallbackContext callbackContext
  ) {
    Log.i(TAG, "echo");
    if (msg == null || msg.length() == 0) {
      callbackContext.error("Empty message!");
    } else {
      Toast.makeText(
        webView.getContext(), 
        msg, 
        Toast.LENGTH_LONG
      ).show();
      callbackContext.success(msg);
    }
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mIALocationManager.destroy();
  }

}

