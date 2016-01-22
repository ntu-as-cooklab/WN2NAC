package org.cook_team.wn2nac;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import de.greenrobot.event.EventBus;

public class ConfigFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    private static EventBus bus = EventBus.getDefault();

    private EditText idEditText, ipEditText;
    private Button applyButton;

    public ConfigFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if (!bus.isRegistered(this)) bus.register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_config, container, false);

        idEditText = (EditText) rootView.findViewById(R.id.idEditText);
        ipEditText = (EditText) rootView.findViewById(R.id.ipEditText);
        applyButton = (Button) rootView.findViewById(R.id.applyButton);
        applyButton.setOnClickListener(this);

        idEditText.setText(Wn2nacPreferences.ID);
        ipEditText.setText(Wn2nacNetwork.server_address);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        //if (!bus.isRegistered(this)) bus.register(this);
    }

    @Override
    public void onPause() {
        //bus.unregister(this);
        super.onPause();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.applyButton:
                Wn2nacPreferences.IDset = true;
                Wn2nacPreferences.ID = String.valueOf(idEditText.getText());
                Wn2nacNetwork.server_address = String.valueOf(ipEditText.getText());
                Wn2nacPreferences.write();
                bus.post(new Wn2nacService.ToastEvent("設定已儲存"));
                break;
        }
    }
}
