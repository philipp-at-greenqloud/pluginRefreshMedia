README 
======


Tested with PhoneGap 2.0.0

by Philipp Veit
for GreenQloud.com

This PhoneGap-Plugin updates the gallerie after downloading a file in Android.

<br/>

How to install and start?

Add this in res/xml/config.xml:
    \<plugin name="pluginRefreshMedia" value="com.greenqloud.plugin.PluginRefreshMedia"/>
      
And call this in your JavaScript-File:

	 var URI = "file:///mnt/sdcard/Download/google.png"; // OR
	 URI = "/mnt/sdcard/Download/google.png";
	 Call refreshMedia.refresh(URI);

