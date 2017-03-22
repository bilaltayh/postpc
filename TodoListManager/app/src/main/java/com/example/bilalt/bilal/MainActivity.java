package com.example.bilalt.bilal;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {

    private com.example.bilalt.bilal.ChatArrayAdapter chatArrayAdapter;
    private ListView listView;
    private int counter = 0;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.display);
        chatArrayAdapter = new ChatArrayAdapter(getApplicationContext(), R.layout.activity_main);
        listView.setAdapter(chatArrayAdapter);
        final Context main = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                final int N = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(main);
                View view = ((MainActivity)main).getLayoutInflater().inflate(R.layout.alert, null);
                TextView Text =  (TextView) view.findViewById(R.id.text_edit);
                Button deleteM =  (Button) view.findViewById(R.id.delete);
                Text.setText(Text.getText());

                builder.setView(view);
                final AlertDialog dialog = builder.create();
                dialog.show();

                deleteM.setOnClickListener(
                        new View.OnClickListener() {
                            public void onClick(View v) {
                                chatArrayAdapter.delete(N);
                                dialog.dismiss();

                            }
                        }
                );
            }
        });
    }


    public void selfMessage(View view) {
        EditText text = (EditText) findViewById(R.id.input);
        String message = text.getText().toString();
        text.getText().clear();

        if (message == null || message == "") {
            return;
        }
        chatArrayAdapter.add(new MessageOBJ(counter, message));
        counter++;

        listView.setSelection(chatArrayAdapter.getCount() - 1);
    }

}