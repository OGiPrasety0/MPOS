package com.bbaf.mpos.sale.payment.ui;

import com.bbaf.mpos.R;
import com.bbaf.mpos.R.layout;
import com.bbaf.mpos.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PaymentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_payment);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.payment, menu);
		return true;
	}

}
