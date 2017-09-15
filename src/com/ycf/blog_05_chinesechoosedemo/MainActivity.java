package com.ycf.blog_05_chinesechoosedemo;

import java.text.SimpleDateFormat;

import com.ycf.blog_05_chinesechoosedemo.datedialog.DateTimePickerDialog;
import com.ycf.blog_05_chinesechoosedemo.datedialog.DateTimePickerDialog.OnDateTimeSetListener;
import com.ycf.blog_05_chinesechoosedemo.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private Button btn_choose;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_choose=(Button)this.findViewById(R.id.btn_choose);
		btn_choose.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog();
			}
		});
	}
	public void showDialog()
	{
		DateTimePickerDialog dialog  = new DateTimePickerDialog(this, System.currentTimeMillis());
		dialog.setOnDateTimeSetListener(new OnDateTimeSetListener()
	      {
			public void OnDateTimeSet(AlertDialog dialog, long date)
			{
				Toast.makeText(MainActivity.this, "您输入的日期是："+getStringDate(date), Toast.LENGTH_LONG).show();
			}
		});
		dialog.show();
	}
	/**
	* 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	*
	*/
	public static String getStringDate(Long date) 
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);
		
		return dateString;
	}
}
