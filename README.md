Adskom SDK Android
==================

Getting Started
---------------

1. Download/clone the SDK from git.

    `git clone git@github.com:hendriksaragih/adskom.git`
2. In your project import the library Adskom

    * File → Import → Android → Existing Android Code into Workspace → Next
    * Select Adskom folder : `/path_download/Adskom`
    * Projects → Select All
    * Uncheck `Copy projects into workspace` and `Add project to working sets`
    * Finish
    
    <img src="http://img.prntscr.com/img?url=http://i.imgur.com/Xdjc8ZD.png" width="30%" />
    <img src="http://img.prntscr.com/img?url=http://i.imgur.com/ued74ar.png" width="30%" />
3. Example

    ```java
    import com.adskom.sdk.Adskom;
    
    public class YourActivity extends Activity {
      @Override
		  protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    addListenerOnButton();
		  }
		  
		  public void addListenerOnButton() {
		    button = (Button) findViewById(R.id.btnTrack);
		    button.setOnClickListener(new OnClickListener() {
		  	  @Override
		      public void onClick(View args) {
		        String result = Adskom.track(123, "view ad");
		      }
		    });
		  }
    }
    ```
4. Don't forget to add this setting to your AndroidManifest.xml file

    ```xml
		<manifest xlmns:android...>
		 ...
		 <uses-permission android:name="android.permission.INTERNET" />
		 <application ...
		</manifest>
    ```
