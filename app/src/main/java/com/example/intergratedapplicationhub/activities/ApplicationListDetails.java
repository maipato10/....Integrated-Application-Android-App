package com.example.intergratedapplicationhub.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.intergratedapplicationhub.R;
import com.example.intergratedapplicationhub.application_activities.BackendlessApplication;
import com.example.intergratedapplicationhub.entities.Application;

import java.util.List;

public class ApplicationListDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView tvApplicationStatus,tvResStatus;

    TextView tvSID, tvSName,tvSSurName,tvSGender,tvSHomeLanguage,tvSTitle,tvSGmail;
    TextView tvSHouseNumber,tvSStreetName,tvSTown,tvSCity,tvSZipCode;
    TextView tvSG11S1,tvSG11S2,tvSG11S3,tvSG11S4,tvSG11S5,tvSG11S6,tvSG11S7;
    TextView tvSG11S1Mark,tvSG11S2Mark,tvSG11S3Mark,tvSG11S4Mark,tvSG11S5Mark,tvSG11S6Mark,tvSG11S7Mark;
    TextView tvSG12S1,tvSG12S2,tvSG12S3,tvSG12S4,tvSG12S5,tvSG12S6,tvSG12S7;
    TextView tvSG12S1Mark,tvSG12S2Mark,tvSG12S3Mark,tvSG12S4Mark,tvSG12S5Mark,tvSG12S6Mark,tvSG12S7Mark;
    TextView tvSFirstChoice,tvSSecondChoice,tvSCampusAplied,tvSResidenceAplied;
    TextView tvSFirstChoiceStatus,tvSSecondChoiceStatus,tvSResidenceChoice;

    Button btnNewStatus,btnMetricResults;
    private int index;
    LinearLayout lvStatus ;
    TextView tvFirst,tvSecond;
    Spinner spinnerFirst,spinnerSecond,spinnerResStatus;
    private String firstChoiceStatus,secondChoiceStatus,residenceStatus;

    private View mProgressView;
    private View mLoginFormView;
    private TextView tvLoad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_list_details);

        Intent intent = getIntent();
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        tvLoad = findViewById(R.id.tvLoad);
        btnMetricResults = findViewById(R.id.btnMetricResults);

        tvSFirstChoice = findViewById(R.id.tvSFirstChoice);
        tvSSecondChoice = findViewById(R.id.tvSSecondChoice);
        tvSCampusAplied = findViewById(R.id.tvSCampusApplied);
        tvSResidenceAplied = findViewById(R.id.tvSResidenceAplied);


        tvResStatus = findViewById(R.id.tvResStatus);
        btnNewStatus = findViewById(R.id.btnNewStatus);
        lvStatus = findViewById(R.id.lvStatus);
        tvFirst = findViewById(R.id.tvFirst);
        tvSecond = findViewById(R.id.tvSecond);
        spinnerFirst = findViewById(R.id.spinnerFirst);
        spinnerSecond = findViewById(R.id.spinnerSecond);
        spinnerResStatus = findViewById(R.id.spinnerResStatus);
        tvFirst.setText(intent.getStringExtra("FirstChoice"));
        tvSecond.setText(intent.getStringExtra("SecondChoice"));
        tvResStatus.setText("Residence");
        index = getIntent().getExtras().getInt("key");


        tvSFirstChoiceStatus = findViewById(R.id.tvSFirstChoiceStaus);
        tvSSecondChoiceStatus = findViewById(R.id.tvSSecondChoiceStatus);
        tvSResidenceChoice = findViewById(R.id.tvSResidenceChoice);

        tvSName = findViewById(R.id.tvSName);
        tvSSurName = findViewById(R.id.tvSSurnameName);
        tvSID = findViewById(R.id.tvSID);
        tvSGender = findViewById(R.id.tvSGender);
        tvSHomeLanguage = findViewById(R.id.tvSHomeLanguage);
        tvSTitle = findViewById(R.id.tvSTitle);
        tvSGmail = findViewById(R.id.tvSGmail);

        tvSHouseNumber = findViewById(R.id.tvSHouseNumber);
        tvSStreetName = findViewById(R.id.tvSStreetName);
        tvSTown = findViewById(R.id.tvSTown);
        tvSCity = findViewById(R.id.tvSCity);
        tvSZipCode = findViewById(R.id.tvSZipCode);

        tvSG11S1 = findViewById(R.id.tvSG11S1);
        tvSG11S2 = findViewById(R.id.tvSG11S2);
        tvSG11S3 = findViewById(R.id.tvSG11S3);
        tvSG11S4 = findViewById(R.id.tvSG11S4);
        tvSG11S5 = findViewById(R.id.tvSG11S5);
        tvSG11S6 = findViewById(R.id.tvSG11S6);
        tvSG11S7 = findViewById(R.id.tvSG11S7);

        tvSG11S1Mark = findViewById(R.id.tvSG11S1Mark);
        tvSG11S2Mark = findViewById(R.id.tvSG11S2Mark);
        tvSG11S3Mark = findViewById(R.id.tvSG11S3Mark);
        tvSG11S4Mark = findViewById(R.id.tvSG11S4Mark);
        tvSG11S5Mark = findViewById(R.id.tvSG11S5Mark);
        tvSG11S6Mark = findViewById(R.id.tvSG11S6Mark);
        tvSG11S7Mark = findViewById(R.id.tvSG11S7Mark);

        tvSG12S1 = findViewById(R.id.tvSG12S1);
        tvSG12S2 = findViewById(R.id.tvSG12S2);
        tvSG12S3 = findViewById(R.id.tvSG12S3);
        tvSG12S4 = findViewById(R.id.tvSG12S4);
        tvSG12S5 = findViewById(R.id.tvSG12S5);
        tvSG12S6 = findViewById(R.id.tvSG12S6);
        tvSG12S7 = findViewById(R.id.tvSG12S7);

        tvSG12S1Mark = findViewById(R.id.tvSG12S1Mark);
        tvSG12S2Mark = findViewById(R.id.tvSG12S2Mark);
        tvSG12S3Mark = findViewById(R.id.tvSG12S3Mark);
        tvSG12S4Mark = findViewById(R.id.tvSG12S4Mark);
        tvSG12S5Mark = findViewById(R.id.tvSG12S5Mark);
        tvSG12S6Mark = findViewById(R.id.tvSG12S6Mark);
        tvSG12S7Mark = findViewById(R.id.tvSG12S7Mark);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.applicationStatuses,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFirst.setAdapter(adapter);
        spinnerFirst.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.applicationStatuses,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSecond.setAdapter(adapter2);
        spinnerSecond.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.resStatus,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerResStatus.setAdapter(adapter3);
        spinnerResStatus.setOnItemSelectedListener(this);

        btnNewStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackendlessApplication.applications.get(index).setFirstChoiceStatus(firstChoiceStatus);
                BackendlessApplication.applications.get(index).setSecondChoiceStatus(secondChoiceStatus);
                BackendlessApplication.applications.get(index).setResidenceStatus(residenceStatus);

                showProgress(true);
                tvLoad.setText("Busy Updating Status.....");
                Backendless.Persistence.save(BackendlessApplication.applications.get(index), new AsyncCallback<Application>() {
                    @Override
                    public void handleResponse(Application response) {
                        Toast.makeText(ApplicationListDetails.this, " Status Successfully Updated ", Toast.LENGTH_SHORT).show();
                        ApplicationListDetails.this.finish();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(ApplicationListDetails.this, "ERROR : " + fault.getMessage(), Toast.LENGTH_SHORT).show();
                        showProgress(false);
                    }
                });

            }
        });


        tvSID.setText(intent.getStringExtra("IdNumber"));
        tvSName.setText(intent.getStringExtra("Name"));
        tvSSurName.setText(intent.getStringExtra("Surname"));
        tvSGender.setText(intent.getStringExtra("Gender"));
        tvSHomeLanguage.setText(intent.getStringExtra("HomeLanguage"));
        tvSTitle.setText(intent.getStringExtra("Title"));
        tvSGmail.setText(intent.getStringExtra("Email"));


        tvSHouseNumber.setText(intent.getStringExtra("HouseNumber"));
        tvSStreetName.setText(intent.getStringExtra("StreetName"));
        tvSTown.setText(intent.getStringExtra("Town"));
        tvSCity.setText(intent.getStringExtra("City"));
        tvSZipCode.setText(intent.getStringExtra("ZipCode"));


        tvSG11S1.setText("  "+intent.getStringExtra("Subject1") + ":");
        tvSG11S1Mark.setText(intent.getStringExtra("Mark1") + " %");
        tvSG11S2.setText("  "+intent.getStringExtra("Subject2") + ":");
        tvSG11S2Mark.setText(intent.getStringExtra("Mark2") + " %");
        tvSG11S3.setText("  "+intent.getStringExtra("Subject3") + ":");
        tvSG11S3Mark.setText(intent.getStringExtra("Mark3") + " %");
        tvSG11S4.setText("  "+intent.getStringExtra("Subject4") + ":");
        tvSG11S4Mark.setText(intent.getStringExtra("Mark4") + " %");
        tvSG11S5.setText("  "+intent.getStringExtra("Subject5") + ":");
        tvSG11S5Mark.setText(intent.getStringExtra("Mark5") + " %");
        tvSG11S6.setText("  "+intent.getStringExtra("Subject6") + ":");
        tvSG11S6Mark.setText(intent.getStringExtra("Mark6") + " %");
        tvSG11S7.setText("  "+intent.getStringExtra("Subject7") + ":");
        tvSG11S7Mark.setText(intent.getStringExtra("Mark7") + " %");




        tvSG12S1.setText("  "+intent.getStringExtra("MetricSubject1") + ":");
        tvSG12S1Mark.setText(intent.getStringExtra("MetricMark1") + " %");
        tvSG12S2.setText("  "+intent.getStringExtra("MetricSubject2") + ":");
        tvSG12S2Mark.setText(intent.getStringExtra("MetricMark2") + " %");
        tvSG12S3.setText("  "+intent.getStringExtra("MetricSubject3") + ":");
        tvSG12S3Mark.setText(intent.getStringExtra("MetricMark3") + " %");
        tvSG12S4.setText("  "+intent.getStringExtra("MetricSubject4") + ":");
        tvSG12S4Mark.setText(intent.getStringExtra("MetricMark4") + " %");
        tvSG12S5.setText("  "+intent.getStringExtra("MetricSubject5") + ":");
        tvSG12S5Mark.setText(intent.getStringExtra("MetricMark5") + " %");
        tvSG12S6.setText("  "+intent.getStringExtra("MetricSubject6") + ":");
        tvSG12S6Mark.setText(intent.getStringExtra("MetricMark6") + " %");
        tvSG12S7.setText("  "+intent.getStringExtra("MetricSubject7") + ":");
        tvSG12S7Mark.setText(intent.getStringExtra("MetricMark7") + " %");



        tvSFirstChoice.setText(intent.getStringExtra("FirstChoice"));
        tvSSecondChoice.setText(intent.getStringExtra("SecondChoice"));
        tvSCampusAplied.setText(intent.getStringExtra("Campus"));
        tvSResidenceAplied.setText(intent.getStringExtra("Residence"));

        tvSSecondChoiceStatus.setText(intent.getStringExtra("SecondChoiceStatus"));
        tvSFirstChoiceStatus.setText(intent.getStringExtra("FirstChoiceStatus"));
        tvSResidenceChoice.setText(intent.getStringExtra("ResidenceStatus"));

        if(BackendlessApplication.user.getProperty("Role").toString().equals("Student")){

        }
        else{

            btnNewStatus.setVisibility(View.VISIBLE);
            lvStatus.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String str1 = spinnerFirst.getSelectedItem().toString();
        String str2 = spinnerSecond.getSelectedItem().toString();
        String str3 = spinnerResStatus.getSelectedItem().toString();
        firstChoiceStatus = str1;
        secondChoiceStatus = str2;
        residenceStatus = str3;


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });

            tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
            tvLoad.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            tvLoad.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }


}
