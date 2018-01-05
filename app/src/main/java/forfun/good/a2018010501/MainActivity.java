package forfun.good.a2018010501;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    int ch = -1 ;
    int tmp = -1 ;
    boolean[] chks = new boolean[4];
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

    public void CL3(View v)
    {
        final  TextView tv2 = findViewById(R.id.textView2);
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("水果項目表");
        final String fruits[] = {"鳳梨","西瓜","芒果","包子"};
        builder.setNegativeButton("取消88", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setItems(fruits, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                tv2.setText(fruits[i]);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    public void CL4(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("單選一個");
        final String fruits[] = {"鳳梨","西瓜","芒果","包子"};
        final  TextView tv3 = findViewById(R.id.textView3);
        tmp = ch ; //為了讓每次都要重整
        builder.setSingleChoiceItems(fruits,ch, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                tmp= i ; //預設-1 什麼都不選

            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                ch = tmp  ; //按下確定後才變成此值
                tv3.setText(fruits[ch]);

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
    public void CL5(View V)
    {
        AlertDialog.Builder builder =new  AlertDialog.Builder(MainActivity.this);
        builder.setTitle("多選列表");
        final String fruits[] = {"鳳梨","西瓜","芒果","包子"};
        final TextView tv4 = findViewById(R.id.textView4);

        builder.setMultiChoiceItems(fruits, chks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i <= 3; i++) {
                    if (chks[i])
                    {
                        sb.append(fruits[i] + "&");
                    }
                }
                tv4.setText(sb.toString());
            }
        });

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv4.setText("");
            }
        });
        builder.show();

    }
    public void CL6(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("測試用");
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View v1 = inflater.inflate(R.layout.layout1,null);
        //自訂View的寫法,在小框裡面
        final TextView tv5 = v1.findViewById(R.id.textView5);
        Button btn1 = v1.findViewById(R.id.button6);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tv5.setText("hello android");
            }
        });

        builder.setView(v1);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
}
