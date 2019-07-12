package com.shop.nixsolution;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.shop.nixsolution.room.DatabaseHelper;
import com.shop.nixsolution.room.InstanceDatabase;
import com.shop.nixsolution.room.Product;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddDataActivity extends AppCompatActivity {

    @BindView(R.id.title)
    EditText title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.save)
    public void onSaveClick() {
        DatabaseHelper databaseHelper = InstanceDatabase.getInstance().getDatabaseInstance();

        Product model = new Product();
        model.setName(title.getText().toString());
        databaseHelper.getDataDao().insert(model);

        finish();
    }
}