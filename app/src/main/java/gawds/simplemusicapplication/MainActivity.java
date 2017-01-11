package gawds.simplemusicapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button startButton,stopButton,pauseButton;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {  /*on create is the first method call*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);/*view has to be set first */
        startButton =(Button)findViewById(R.id.startButton);
        stopButton =(Button)findViewById(R.id.stopButton);
        pauseButton =(Button)findViewById(R.id.pauseButton);
        startButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);/*same method is called on three of them so we use ids to differentiaite them */
        mediaPlayer=MediaPlayer.create(this,R.raw.song);/* it is initialized here*/
    }
    //linear layout is used in this project
     //activity lifecycle
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy called",Toast.LENGTH_SHORT).show();
        if(mediaPlayer!=null)
            mediaPlayer.stop();
        mediaPlayer.release();

    }
    public void onStart(){
        super.onStart();
        Toast.makeText(this,"onStart called",Toast.LENGTH_SHORT).show();
    }
    public void onResume(){
        super.onResume();
        Toast.makeText(this,"onResume called",Toast.LENGTH_SHORT).show();
    }
    public void onStop(){
        super.onStop();
        Toast.makeText(this,"onStop called",Toast.LENGTH_SHORT).show();
    }
    public void onPause(){
        super.onPause();
        Toast.makeText(this,"onPause called",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view){
        int id=view.getId();
        if(id==R.id.startButton){
           // Toast.makeText(this,"start clicked",Toast.LENGTH_SHORT).show();
            //mediaPlayer.start();
            if(mediaPlayer!=null){
                mediaPlayer.start();
            }
            else
                mediaPlayer=MediaPlayer.create(this,R.raw.song);
            mediaPlayer.start();

        }
        else if(id==R.id.pauseButton){
            //Toast.makeText(this,"pause clicked",Toast.LENGTH_SHORT).show();
            //mediaPlayer.pause();
            if(mediaPlayer!=null&& mediaPlayer.isPlaying()){
                mediaPlayer.pause();
                pauseButton.setText("resume");
            }else if(mediaPlayer!=null)
            {
                pauseButton.setText("Pause");
                mediaPlayer.start();
            }


        }
        else  if(id==R.id.stopButton){
            //Toast.makeText(this,"stop clicked",Toast.LENGTH_SHORT).show();
        if(mediaPlayer!=null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);//it shows the user all the items present in menu main
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id== R.id.home)
            Toast.makeText(this, "menu clicked", Toast.LENGTH_SHORT).show();


        else if(id == R.id.settings)
        {Toast.makeText(this,"settings clicked",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,settings1.class);
            startActivity(intent);
        }
        else if (id == R.id.item3)
            Toast.makeText(this,"item3 clicked",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);

    }

}
