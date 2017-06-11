package com.example.dell.xmezhou1b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends Activity {

    String path = "http://result.eolinker.com/Ikx4fDc398b93bfd0c8a146468e1f8cddfe9166719cba13?uri=zhoukao";
    private GridView gv;
    private List<Student.StudentsBean.StudentBean> list = new ArrayList<Student.StudentsBean.StudentBean>();

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 0){

                RequestParams params = new RequestParams(path);
                x.http().get(params, new org.xutils.common.Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        System.out.println("result = " + result);
                        Gson gson = new Gson();
                        Student student = gson.fromJson(result, Student.class);
                        List<Student.StudentsBean.StudentBean> sList = student.getStudents().getStudent();

                        list.addAll(sList);
                        MyAdapter adapter = new MyAdapter(SecondActivity.this,list);
                        gv.setAdapter(adapter);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {
                        pb.setVisibility(View.GONE);
                    }
                });


            }

        }
    };
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        gv = (GridView) findViewById(R.id.gv);
        pb = (ProgressBar) findViewById(R.id.pb);

        handler.sendEmptyMessageDelayed(0,3000);


        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra("name",list.get(position).getName());
                intent.putExtra("imageuri",list.get(position).getImg());
                intent.putExtra("info",list.get(position).getContent());
                startActivity(intent);

            }
        });
    }
}
