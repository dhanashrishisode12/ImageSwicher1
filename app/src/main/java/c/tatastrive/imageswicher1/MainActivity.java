package c.tatastrive.imageswicher1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
   // int img[]={R.drawable.};
   int index = -1;
    int[] images = new int[]
            {R.drawable.image_one,R.drawable.image_two,R.drawable.image_three,R.drawable.image_four};
    int img_length = images.length;
    TextView t;
    ImageSwitcher i1;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = findViewById(R.id.parent);
        b = findViewById(R.id.button2);
        i1 = findViewById(R.id.image1);
        //set the ViewFactory of the ImageSwitcher that will create Imageview object when task
        i1.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });
        Animation left = AnimationUtils.loadAnimation(this,R.anim.slide_animation);

        Animation right = AnimationUtils.loadAnimation(this,R.anim.out);
        i1.setInAnimation(right);
        i1.setOutAnimation(left);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if (index == img_length)
                {
                    index = 0;
                }
                i1.setImageResource(images[index]);
            }
        });

    }
}
