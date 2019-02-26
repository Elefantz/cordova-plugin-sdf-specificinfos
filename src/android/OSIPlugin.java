package net.suivideflotte.osi.plugin;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;

import android.os.Build.VERSION;

import java.util.Map;

public class OSIPlugin extends CordovaPlugin {
 
	private static final String TAG = "OSIPlugin";
	
	public static CordovaWebView gWebView;
	 
	public OSIPlugin() {}
	
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
		gWebView = webView;
		Log.d(TAG, "==> OSIPlugin initialize");
		
	}
	 
	public boolean execute(final String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {

		Log.d(TAG,"==> OSIPlugin execute: "+ action);
		
		try{
			// READY //
			if (action.equals("ready")) {
				//
				callbackContext.success();
			}
			// GET APILEVEL //
			else if (action.equals("getAPILevel")) {
				cordova.getActivity().runOnUiThread(new Runnable() {
					public void run() {
						try{
							final int apiLevel = VERSION.SDK_INT;
							
							callbackContext.success( apiLevel );
							Log.d(TAG,"\tapiLevel: "+ apiLevel);
						}catch(Exception e){
							Log.d(TAG,"\tError retrieving apiLevel");
						}
					}
				});
			}
			
			else{
				callbackContext.error("Method not found");
				return false;
			}
		}catch(Exception e){
			Log.d(TAG, "ERROR: onPluginAction: " + e.getMessage());
			callbackContext.error(e.getMessage());
			return false;
		}
		
		//cordova.getThreadPool().execute(new Runnable() {
		//	public void run() {
		//	  //
		//	}
		//});
		
		//cordova.getActivity().runOnUiThread(new Runnable() {
        //    public void run() {
        //      //
        //    }
        //});
		return true;
	}
	
	
  
  @Override
	public void onDestroy() {
		gWebView = null;
	}
} 
