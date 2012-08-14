/**
 * 
 */
package com.greenqloud.plugin;

import java.io.File;

import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.phonegap.api.Plugin;

/**
 * @author Philipp Veit (for GreenQloud.com)
 * 
 */
public class PluginRefreshMedia extends Plugin {

	/**
	 * Executes the request and returns PluginResult.
	 * 
	 * @param action
	 *            The action to execute.
	 * @param args
	 *            JSONArry of arguments for the plugin.
	 * @param callbackId
	 *            The callback id used when calling back into JavaScript.
	 * @return A PluginResult object with a status and message.
	 */
	@Override
	public PluginResult execute(String action, JSONArray args, String callbackId) {

		PluginResult.Status status = PluginResult.Status.OK;
		String result = "";

		try {

			if (action.equals("refresh")) {

				String filePath = checkFilePath(args.getString(0));

				if (filePath.equals("")) {
					return new PluginResult(PluginResult.Status.ERROR);
				}

				File file = new File(filePath);

				Intent scanIntent = new Intent(
						Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
				scanIntent.setData(Uri.fromFile(file));

				// For more information about cordova.getContext() look here:
				// http://simonmacdonald.blogspot.com/2012/07/phonegap-android-plugins-sometimes-we.html?showComment=1342400224273#c8740511105206086350
				Context context = cordova.getContext();
				context.sendBroadcast(scanIntent);
			}
			return new PluginResult(status, result);
		} catch (JSONException e) {
			return new PluginResult(PluginResult.Status.JSON_EXCEPTION);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return new PluginResult(PluginResult.Status.ERROR);
		}

	}

	private String checkFilePath(String filePath) {
		String return_value = "";
		try {
			return_value = filePath.replaceAll("^file://", "");

		} catch (Exception e) {
			System.out.println("Error with the filePath");
		}

		return return_value;
	}
}
