package com.example.androidlistview;

import android.support.v7.app.ActionBarActivity;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView lista = (ListView) this.findViewById(R.id.Lista);

		String[] meses = { "janeiro", "fevereiro", "março", "abril", "maio",
				"junho", "agosto", "setembro", "outubro", "novembro",
				"dezembro" };
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1);
		aa.addAll(meses);
		lista.setChoiceMode(1);
		lista.setAdapter(aa);
		// Create a message handling object as an anonymous class.
		OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// Do something in response to the click
				String mesSelecionado;
				mesSelecionado = parent.getAdapter().getItem(position)
						.toString();
				Log.v("listviu", mesSelecionado);

				Toast toast = Toast.makeText(parent.getContext(), "Mês de "
						+ mesSelecionado, Toast.LENGTH_SHORT);
				toast.show();
			}
		};
		lista.setOnItemClickListener(mMessageClickedHandler);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
