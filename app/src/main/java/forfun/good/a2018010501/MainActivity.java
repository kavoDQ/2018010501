package forfun.good.a2018010501;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CL1(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("今天好嗎?");
        builder.setMessage("選一個代表吧~");
        builder.setPositiveButton("還不錯", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"看起來不錯呢",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("不太好", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"遇到了什麼呢?",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("沒什麼特別的", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"記得保持微笑~",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void CL2(View v)
    {
        final TextView tv= findViewById(R.id.textView);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("能量測試");
        final EditText ed = new EditText(MainActivity.this);
        builder.setView(ed);
        builder.setPositiveButton("傳送能量", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"你的能量傳出去了!!!",Toast.LENGTH_SHORT).show();
                tv.setText(ed.getText().toString());
            }
        });
        builder.setNegativeButton("取消傳送", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"你沒能量",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
        tv.setText(ed.getText().toString());


    }

}
