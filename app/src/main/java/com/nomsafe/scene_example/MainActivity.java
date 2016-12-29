package com.nomsafe.scene_example;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Scene mainScene;
    private Scene emailScene;
    private Scene googleScene;
    private Scene facebookScene;

    ImageButton button1;
    ImageButton button2;
    ImageButton button3;

    private ViewGroup sceneRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (ImageButton) findViewById(R.id.email_button);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "Email button pressed", Toast.LENGTH_SHORT).show();
                TransitionManager.go(emailScene);
            }
        });

        button2 = (ImageButton) findViewById(R.id.google_button);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "google button pressed", Toast.LENGTH_SHORT).show();
                TransitionManager.go(googleScene);
            }
        });

        button3 = (ImageButton) findViewById(R.id.facebook_button);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "facebook button pressed", Toast.LENGTH_SHORT).show();
                TransitionManager.go(facebookScene);
            }
        });

        sceneRoot = (ViewGroup) findViewById(R.id.scene_root);

        mainScene = new Scene(sceneRoot, (ViewGroup) sceneRoot.findViewById(R.id.scene_container));

        emailScene = Scene.getSceneForLayout(sceneRoot, R.layout.email_login_scene, this);
        googleScene = Scene.getSceneForLayout(sceneRoot, R.layout.google_login_scene, this);
        facebookScene = Scene.getSceneForLayout(sceneRoot, R.layout.facebook_login_scene, this);
    }
}
