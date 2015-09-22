package fr.enoent.videokit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private static final String TAG = MainActivity.class.getSimpleName();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ((Button) findViewById(R.id.btn_concat)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				
				String command="-y -i /sdcard/test.mp4 -vf crop=480:480:0:0 -acodec aac -b:a 44000 -vcodec mpeg4 -b:v 960000 -strict -2 /sdcard/test1.mp4";
				String[] strArray=command.split(" ");
				long time=System.currentTimeMillis();
				if (Videokit.getInstance().process(strArray)) {
					Log.d(TAG, "Trimming: success "+(System.currentTimeMillis()-time));
					
				} else {
					Log.d(TAG, "Trimming: failure");
				}
//				if (Videokit.getInstance().process(new String[] {
//						"-y",					// Overwrite output files
//						"-i",					// Input file
//						"/sdcard/input.mp4",
//						"-ss",					// Start position
//						"0",
//						"-t",					// Duration
//						"15",
//						"-vcodec",				// Video codec
//						"copy",
//						"-acodec",				// Audio codec
//						"copy",
//						"/sdcard/output.mp4"	// Output file
//				})) {
//					Log.d(TAG, "Trimming: success");
//				} else {
//					Log.d(TAG, "Trimming: failure");
//				}
			}
		});
    }
}
