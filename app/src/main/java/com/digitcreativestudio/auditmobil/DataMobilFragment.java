package com.digitcreativestudio.auditmobil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.digitcreativestudio.auditmobil.entities.Car;
import com.digitcreativestudio.auditmobil.utilities.SessionPreference;

/**
 * Created by ADIK on 15/05/2017.
 */

public class DataMobilFragment extends BaseFragment {
    Car car;

    EditText policeNumberEditText,
            managerEditText,
            lastCheckDateEditText,
            checkDateEditText,
            brandYearEditText,
            productEditText,
            capacityEditText,
            locationEditText;

    Button checkButton;

    public DataMobilFragment() {
    }

    public static DataMobilFragment newInstance() {
        DataMobilFragment fragment = new DataMobilFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_data_mobil, container, false);
        policeNumberEditText = (EditText) rootView.findViewById(R.id.nomor_polisi_edit_text);
        managerEditText = (EditText) rootView.findViewById(R.id.pengelola_edit_text);
        lastCheckDateEditText = (EditText) rootView.findViewById(R.id.tgl_pemeriksaan_terakhir_edit_text);
        checkDateEditText = (EditText) rootView.findViewById(R.id.tgl_pemeriksaan_edit_text);
        brandYearEditText = (EditText) rootView.findViewById(R.id.merek_mobil_edit_text);
        productEditText = (EditText) rootView.findViewById(R.id.jenis_produk_edit_text);
        capacityEditText = (EditText) rootView.findViewById(R.id.kapasitas_edit_text);
        locationEditText = (EditText) rootView.findViewById(R.id.lokasi_edit_text);

        Car car = (new SessionPreference(getContext())).getCar();
        if(car != null){
            policeNumberEditText.setText(car.getPoliceNumber());
            managerEditText.setText(car.getManager());
            lastCheckDateEditText.setText(car.getLastCheck());
            checkDateEditText.setText(car.getCheckDate());
            brandYearEditText.setText(car.getBrandYear());
            productEditText.setText(car.getProduct());
            capacityEditText.setText(car.getCapacity());
            locationEditText.setText(car.getLocation());
        }

        return rootView;
    }

    @Override
    public boolean isValid() {
        boolean isValid = true;
        car = new Car();
        String policeNumber = policeNumberEditText.getText().toString().trim();
        car.setPoliceNumber(policeNumber);
        if(policeNumber.isEmpty()){
            policeNumberEditText.setError("Masukkan nomor polisi");
            isValid = false;
        }
        String manager = managerEditText.getText().toString().trim();
        car.setManager(manager);
        if(manager.isEmpty()){
            managerEditText.setError("Masukkan pengelola");
            isValid = false;
        }
        String lastCheckDate = lastCheckDateEditText.getText().toString().trim();
        car.setLastCheck(lastCheckDate);
        if(lastCheckDate.isEmpty()){
            lastCheckDateEditText.setError("Masukkan tanggal terakhir pemeriksaan");
            isValid = false;
        }
        String checkDate = checkDateEditText.getText().toString().trim();
        car.setCheckDate(checkDate);
        if(checkDate.isEmpty()){
            checkDateEditText.setError("Masukkan tanggal pemeriksaan");
            isValid = false;
        }
        String brandYear = brandYearEditText.getText().toString().trim();
        car.setBrandYear(brandYear);
        if(brandYear.isEmpty()){
            brandYearEditText.setError("Masukkan merak dan tahun");
            isValid = false;
        }
        String product = productEditText.getText().toString().trim();
        car.setProduct(product);
        if(product.isEmpty()){
            productEditText.setError("Masukkan produk");
            isValid = false;
        }
        String capacity = capacityEditText.getText().toString().trim();
        car.setCapacity(capacity);
        if(capacity.isEmpty()){
            capacityEditText.setError("Masukkan kapasitas");
            isValid = false;
        }
        String location = locationEditText.getText().toString().trim();
        car.setLocation(location);
        if(location.isEmpty()){
            locationEditText.setError("Masukkan lokasi");
            isValid = false;
        }
        return isValid;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public void updateData(Car car) {
        if(car != null) {
            policeNumberEditText.setText(car.getPoliceNumber());
            managerEditText.setText(car.getManager());
            lastCheckDateEditText.setText(car.getLastCheck());
            checkDateEditText.setText(car.getCheckDate());
            brandYearEditText.setText(car.getBrandYear());
            productEditText.setText(car.getProduct());
            capacityEditText.setText(car.getCapacity());
            locationEditText.setText(car.getLocation());
        }
    }
}
