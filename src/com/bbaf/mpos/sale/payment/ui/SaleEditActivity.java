package com.bbaf.mpos.sale.payment.ui;

import com.bbaf.mpos.R;
import com.bbaf.mpos.FacadeController.Register;
import com.bbaf.mpos.ProductDescription.ProductDescription;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Activity for editing the price while in sale process. Controller of EditSale in Sale view.
 * @author Sarathit Sangtaweep 5510546182, Poramet Homprakob 5510546077
 */
public class SaleEditActivity extends Activity {
	
	private TextView textViewEditUnitPriceId;
	private TextView textViewEditUnitPriceName;
	private EditText editTextUnitPrice;
	private EditText editTextEditQuantity;
	private Button buttonEditSalePriceConfirm;
	private Button buttonEditSalePriceCancel;
	
	private static final int EDIT_CANCEL = 0;
	private static final int EDIT_SUCCESS = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sale_edit);
		
		final ProductDescription product = (ProductDescription) getIntent().getSerializableExtra("ProductDescription");
		
		textViewEditUnitPriceId = (TextView)findViewById(R.id.textViewEditUnitPriceId);
		textViewEditUnitPriceId.setText(product.getId());
		
		textViewEditUnitPriceName = (TextView)findViewById(R.id.textViewEditUnitPriceName);
		textViewEditUnitPriceName.setText(product.getName());
		
		editTextUnitPrice = (EditText)findViewById(R.id.editTextUnitPrice);
		editTextUnitPrice.setHint(String.valueOf(Register.getInstance().getInventory().getProduct(product.getId()).getPrice()));
		
		editTextEditQuantity = (EditText)findViewById(R.id.editTextEditQuantity);
		editTextEditQuantity.setHint(String.valueOf(Register.getInstance().getSale().getList(Register.getInstance().getInventory().getProduct(product.getId())).getQuantity()));
		
		buttonEditSalePriceConfirm = (Button)findViewById(R.id.buttonEditSalePriceConfirm);
		buttonEditSalePriceConfirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!editTextUnitPrice.getText().toString().equals(""))
					Register.getInstance().getSale().getList(product).setUnitPrice(Double.parseDouble(editTextUnitPrice.getText().toString()));
				
				if (!editTextEditQuantity.getText().toString().equals(""))
					Register.getInstance().getSale().getList(Register.getInstance().getInventory().getProduct(product.getId())).setQuantity(Integer.parseInt(editTextEditQuantity.getText().toString()));
					
				setResult(EDIT_SUCCESS);
				finish();
			}
		});
		
		buttonEditSalePriceCancel = (Button)findViewById(R.id.buttonEditSalePriceCancel);
		buttonEditSalePriceCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setResult(EDIT_CANCEL);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sale_edit, menu);
		return true;
	}
}