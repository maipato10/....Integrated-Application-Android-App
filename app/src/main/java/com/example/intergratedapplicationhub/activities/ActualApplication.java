package com.example.intergratedapplicationhub.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.example.intergratedapplicationhub.R;
import com.example.intergratedapplicationhub.application_activities.BackendlessApplication;
import com.example.intergratedapplicationhub.entities.Application;
import com.example.intergratedapplicationhub.entities.Marks;
import com.example.intergratedapplicationhub.entities.MetricMarks;

import java.util.ArrayList;
import java.util.List;

public class ActualApplication extends AppCompatActivity  {

    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    ArrayAdapter<CharSequence> adapter2;
    ArrayAdapter<CharSequence> adapter4;
    ArrayAdapter<CharSequence> adapter6;
    ArrayAdapter<CharSequence> adapter7;
    ArrayAdapter<CharSequence> adapter8;
    ArrayAdapter<CharSequence> adapter9;
    ArrayAdapter<CharSequence> adapter10;
    ArrayAdapter<CharSequence> adapter11;
    ArrayAdapter<CharSequence> adapter12;
    ArrayAdapter<CharSequence> adapter13;

    Button btnApply,btnReApply,btnFinish;
    LinearLayout submit,register;

    TextView tvFirstChoice,tvSecondChoice;
    Button btnCourses;
    String universityName,universityCampus,mark1,mark2,mark3,mark4,mark5,mark6,mark7,campusName,residenceName;
    String subject1,subject2,subject3,subject4,subject5,subject6,subject7,apScore;
    String metricMark1,metricMark2,metricMark3,metricMark4,metricMark5,metricMark6,metricMark7;
    String metricSubject1,metricSubject2,metricSubject3,metricSubject4,metricSubject5,metricSubject6,metricSubject7;

    private View mProgressView;
    private View mLoginFormView;
    private TextView tvLoad;

    TextView  mItemSelected;
    String[] listItems;
    boolean[] checkedItems;
    //holds checked items
    ArrayList<Integer> mUserItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_application);

        submit = findViewById(R.id.submit);
        register = findViewById(R.id.register);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        tvLoad = findViewById(R.id.tvLoad);


        String whereClause = "Email = '" + BackendlessApplication.user.getEmail() + "'";
        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setWhereClause(whereClause);
        showProgress(true);
        tvLoad.setText("Retrieving Your grade 11 Marks For Application");
        Backendless.Persistence.of(Marks.class).find(queryBuilder, new AsyncCallback<List<Marks>>() {
            @Override
            public void handleResponse(List<Marks> response) {
                BackendlessApplication.marks = response;

                mark1 = BackendlessApplication.marks.get(0).getMark1();
                mark2 = BackendlessApplication.marks.get(0).getMark2();
                mark3 = BackendlessApplication.marks.get(0).getMark3();
                mark4 = BackendlessApplication.marks.get(0).getMark4();
                mark5 = BackendlessApplication.marks.get(0).getMark5();
                mark6 =BackendlessApplication.marks.get(0).getMark6();
                mark7 = BackendlessApplication.marks.get(0).getMark7();
                subject1 = BackendlessApplication.marks.get(0).getSubject1();
                subject2 = BackendlessApplication.marks.get(0).getSubject2();
                subject3 = BackendlessApplication.marks.get(0).getSubject3();
                subject4 = BackendlessApplication.marks.get(0).getSubject4();
                subject5 = BackendlessApplication.marks.get(0).getSubject5();
                subject6 = BackendlessApplication.marks.get(0).getSubject6();
                subject7 = BackendlessApplication.marks.get(0).getSubject7();
                BackendlessApplication.user.getProperty("Name");
                showProgress(false);
                Toast.makeText(ActualApplication.this, "Marks Successfully Retrieved", Toast.LENGTH_SHORT).show();

                //metric results
                String whereClause2 = "Email = '" + BackendlessApplication.user.getEmail() + "'";
        DataQueryBuilder queryBuilder2 = DataQueryBuilder.create();
        queryBuilder2.setWhereClause(whereClause2);
        showProgress(true);
        tvLoad.setText("Retrieving Your final grade 12 Marks For Application");

        Backendless.Persistence.of(MetricMarks.class).find(queryBuilder2, new AsyncCallback<List<MetricMarks>>() {
            @Override
            public void handleResponse(List<MetricMarks> matric) {
                BackendlessApplication.metricMarks = matric;
                metricMark1 = BackendlessApplication.metricMarks.get(0).getMark1();
                metricMark2 = BackendlessApplication.metricMarks.get(0).getMark2();
                metricMark3 = BackendlessApplication.metricMarks.get(0).getMark3();
                metricMark4 = BackendlessApplication.metricMarks.get(0).getMark4();
                metricMark5 = BackendlessApplication.metricMarks.get(0).getMark5();
                metricMark6 =BackendlessApplication.metricMarks.get(0).getMark6();
                metricMark7 = BackendlessApplication.metricMarks.get(0).getMark7();
                metricSubject1 = BackendlessApplication.metricMarks.get(0).getSubject1();
                metricSubject2 = BackendlessApplication.metricMarks.get(0).getSubject2();
                metricSubject3 = BackendlessApplication.metricMarks.get(0).getSubject3();
                metricSubject4 = BackendlessApplication.metricMarks.get(0).getSubject4();
                metricSubject5 = BackendlessApplication.metricMarks.get(0).getSubject5();
                metricSubject6 = BackendlessApplication.metricMarks.get(0).getSubject6();
                metricSubject7 = BackendlessApplication.metricMarks.get(0).getSubject7();
                //BackendlessApplication.user.getProperty("Name");
                showProgress(false);
                Toast.makeText(ActualApplication.this, "grade 12 results Successfully Retrieved", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(ActualApplication.this, "Error: " + fault.getMessage(), Toast.LENGTH_SHORT).show();
                showProgress(false);
                //showProgress(false);
            }
        });


            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(ActualApplication.this, "ERROR : "+ fault.getMessage(), Toast.LENGTH_SHORT).show();
                showProgress(false);

            }
        });



        btnApply= findViewById(R.id.btnApply);
        btnReApply= findViewById(R.id.btnReApply);
        btnFinish= findViewById(R.id.btnFinish);
        tvFirstChoice= findViewById(R.id.tvFirstChoice);
        tvSecondChoice = findViewById(R.id.tvSecondChoice);
        btnCourses = findViewById(R.id.btnCourses);


        spinner4 = findViewById(R.id.spinnerFaculty);
        adapter12 = ArrayAdapter.createFromResource(this, R.array.cutFaculties, android.R.layout.simple_spinner_item);
        adapter13 = ArrayAdapter.createFromResource(this, R.array.ufsFaculties, android.R.layout.simple_spinner_item);


        spinner1 = findViewById(R.id.spinnerInstitution);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.institution,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        spinner2 = findViewById(R.id.spinnerCampus);
        adapter2 = ArrayAdapter.createFromResource(this,R.array.cutCampus,android.R.layout.simple_spinner_item);
        adapter4 = ArrayAdapter.createFromResource(this,R.array.ufsCampus,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner3 = findViewById(R.id.spinnerResidences);
        adapter6 = ArrayAdapter.createFromResource(this,R.array.Residence,android.R.layout.simple_spinner_item);
        adapter7 = ArrayAdapter.createFromResource(this,R.array.BloemfonteinCampusResidences,android.R.layout.simple_spinner_item);
        adapter8 = ArrayAdapter.createFromResource(this,R.array.welkomCampusResidences,android.R.layout.simple_spinner_item);
        adapter9 = ArrayAdapter.createFromResource(this,R.array.ufsBloemfonteinCampusResidence,android.R.layout.simple_spinner_item);
        adapter10 = ArrayAdapter.createFromResource(this,R.array.ufsQwaqwaCampusResidence,android.R.layout.simple_spinner_item);
        adapter11 = ArrayAdapter.createFromResource(this,R.array.ufsSouthCampusResidence,android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==1){

                    spinner2.setAdapter(adapter2);
                    spinner4.setAdapter(adapter12);
                }
                else if(i==2)
                {
                    spinner2.setAdapter(adapter4);
                    spinner4.setAdapter(adapter13);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(ActualApplication.this, "Select something", Toast.LENGTH_SHORT).show();

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spinner1.getSelectedItem().equals("Central University Of Technology"))
                {
                    universityName = "Central University Of Technology";
                    if(i==1){
                        spinner3.setAdapter(adapter7);
                        //listItems = getResources().getStringArray(R.array.cutManagementFacultyCourse);
                        //checkedItems = new boolean[listItems.length];
                        universityCampus = "Bloemfontein Campus";

                    }
                    else if (i==2){
                        spinner3.setAdapter(adapter8);
                        //listItems = getResources().getStringArray(R.array.welkomCampusCourses);
                        //checkedItems = new boolean[listItems.length];
                        universityCampus = "Welkom Campus";
                    }

                }
                else if(spinner1.getSelectedItem().equals("University Of Free State"))
                {
                    universityName = "University Of Free State";
                    if(i==1){
                        spinner3.setAdapter(adapter9);
                        listItems = getResources().getStringArray(R.array.ufsBloemCampusCourses);
                        checkedItems = new boolean[listItems.length];
                        universityCampus = "Bloemfontein Campus";

                    }
                    else if(i==2)
                    {
                        spinner3.setAdapter(adapter10);
                        //listItems = getResources().getStringArray(R.array.qwaqwaCampusCourses);
                        //checkedItems = new boolean[listItems.length];
                        universityCampus = "Qwaqwa Campus";

                    }
                    else if(i==3){
                        spinner3.setAdapter(adapter11);
                        //listItems = getResources().getStringArray(R.array.southCampusCourses);
                        //checkedItems = new boolean[listItems.length];
                        universityCampus = "South Campus";

                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spinner1.getSelectedItem().equals("Central University Of Technology"))
                {
                    if(i==1){
                        listItems = getResources().getStringArray(R.array.cutEngineeringFacultyPrograms);
                        checkedItems = new boolean[listItems.length];
                    }
                    else if(i==2){
                        listItems = getResources().getStringArray(R.array.cutHealthFacultyPrograms);
                        checkedItems = new boolean[listItems.length];
                    }
                    else if(i==3){
                        listItems = getResources().getStringArray(R.array.cutHumanitiesFacultyPrograms);
                        checkedItems = new boolean[listItems.length];
                    }
                    else if(i==4){
                        listItems = getResources().getStringArray(R.array.cutManagementFacultyCourse);
                        checkedItems = new boolean[listItems.length];
                    }
                }
                else if(spinner1.getSelectedItem().equals("University Of Free State"))
                {
                    if(i==1){
                        listItems = getResources().getStringArray(R.array.ufsEconomicFaculty);
                        checkedItems = new boolean[listItems.length];
                    }
                    else if(i==2){
                        listItems = getResources().getStringArray(R.array.ufsEducationFaculty);
                        checkedItems = new boolean[listItems.length];
                    }
                    else if(i==3){
                        listItems = getResources().getStringArray(R.array.ufsHealthFaculty);
                        checkedItems = new boolean[listItems.length];
                    }
                    else if(i==4){
                        listItems = getResources().getStringArray(R.array.ufsHumanities);
                        checkedItems = new boolean[listItems.length];
                    }
                    else if(i==5){
                        listItems = getResources().getStringArray(R.array.ufsLaw);
                        checkedItems = new boolean[listItems.length];
                    }
                    else if(i==6){
                        listItems = getResources().getStringArray(R.array.ufsTheology);
                        checkedItems = new boolean[listItems.length];
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(spinner1.getSelectedItem().equals("Central University Of Technology"))
                {
                    if(spinner2.getSelectedItem().equals("Bloemfontein Campus"))
                    {
                        if(i==1)
                        {
                            residenceName = "Huis Technikon";
                        }
                        else if(i==2)
                        {
                            residenceName = "Welgemoed";
                        }
                        else if(i==3)
                        {
                            residenceName = "Mannheim Ladies";
                        }
                        else if(i==4)
                        {
                            residenceName = "Eendrag";
                        }
                        else if(i==5)
                        {
                            residenceName = "Loggies";
                        }
                        else if(i==6)
                        {
                            residenceName = "Mannheim Men";
                        }
                        else if(i==7) {
                            residenceName = "Gymnos";
                        }

                    }
                    else if(spinner2.getSelectedItem().equals("Welkom Campus"))
                    {
                        if(i==1)
                        {
                            residenceName = "Maipato";
                        }
                    }

                }//end
                else if(spinner1.getSelectedItem().equals("University Of Free State"))
                {
                    if(spinner2.getSelectedItem().equals("Bloemfontein Campus"))
                    {
                        if(i==1)
                        {
                            residenceName = "Phela";
                        }
                        else if(i==2)
                        {
                            residenceName = "Lehakwe";
                        }
                    }

                    else if(spinner2.getSelectedItem().equals("Qwaqwa Campus"))
                    {
                        if(i==1)
                        {
                            residenceName = "Thetha";
                        }
                        else if(i==2)
                        {
                            residenceName = "Huis";
                        }
                    }
                    if(spinner2.getSelectedItem().equals("South Campus"))
                    {
                        if(i==1)
                        {
                            residenceName = "Legae";
                        }
                        else if(i==2)
                        {
                            residenceName = "Liberty";
                        }
                        else if(i==3)
                        {
                            residenceName = "Toka";
                        }
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(ActualApplication.this);
                mBuilder.setTitle("Courses Available");
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if(isChecked)
                        {
                            if(!mUserItems.contains(position)){
                                mUserItems.add(position);
                            }

                        }

                        else if(mUserItems.contains(position)){
                            mUserItems.remove(position);
                        }

                    }
                });
                mBuilder.setCancelable(true);
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {
                        try{

                            String item = "";
                            for(int i = 0; i<mUserItems.size(); i++){
                                tvFirstChoice.setText(listItems[mUserItems.get(0)]);
                                tvSecondChoice.setText(listItems[mUserItems.get(1)]);
                                item = item + listItems[mUserItems.get(i)];
                                if(i != mUserItems.size() - 1){
                                    item = item + ",";

                                }
                            }



                        }
                        catch (Exception e)
                        {
                            if(mUserItems.size()<2)
                            Toast.makeText(ActualApplication.this, "error: choose two courses ", Toast.LENGTH_SHORT).show();
                            else
                                throw e;
                        }


                    }
                });
                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setNegativeButton("Clear all", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //looping through checked items to clear them all
                        for(int i=0; i<checkedItems.length; i++){
                            checkedItems[i]=false;
                            mUserItems.clear();

                        }
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });
        btnReApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit.setVisibility(View.GONE);
                register.setVisibility(View.VISIBLE);

            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActualApplication.this.finish();
            }
        });
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mUserItems.size()<2) {
                    Toast.makeText(ActualApplication.this, "error: choose two courses ", Toast.LENGTH_SHORT).show();
                }
                else{

                    Application application = new Application();
                    application.setMark1(mark1);
                    application.setMark2(mark2);
                    application.setMark3(mark3);
                    application.setMark4(mark4);
                    application.setMark5(mark5);
                    application.setMark6(mark6);
                    application.setMark7(mark7);
                    application.setSubject1(subject1);
                    application.setSubject2(subject2);
                    application.setSubject3(subject3);
                    application.setSubject4(subject4);
                    application.setSubject5(subject5);
                    application.setSubject6(subject6);
                    application.setSubject7(subject7);
                    application.setMetricMark1(metricMark1);
                    application.setMetricMark2(metricMark2);
                    application.setMetricMark3(metricMark3);
                    application.setMetricMark4(metricMark4);
                    application.setMetricMark5(metricMark5);
                    application.setMetricMark6(metricMark6);
                    application.setMetricMark7(metricMark7);
                    application.setMetricSubject1(metricSubject1);
                    application.setMetricSubject2(metricSubject2);
                    application.setMetricSubject3(metricSubject3);
                    application.setMetricSubject4(metricSubject4);
                    application.setMetricSubject5(metricSubject5);
                    application.setMetricSubject6(metricSubject6);
                    application.setMetricSubject7(metricSubject7);
                    application.setResidence(residenceName);
                    application.setUniversityName(universityName);
                    application.setUniversityCampus(universityCampus);
                    //application.setApplicationStatus("In Process");
                    application.setFirstChoice(tvFirstChoice.getText().toString().trim());
                    application.setSecondChoice(tvSecondChoice.getText().toString().trim());
                    application.setUserEmail(BackendlessApplication.user.getEmail());
                    application.setHouseNumber(BackendlessApplication.user.getProperty("HouseNumber").toString());
                    application.setName(BackendlessApplication.user.getProperty("Name").toString());
                    application.setID(BackendlessApplication.user.getProperty("IdNumber").toString());
                    application.setLastName(BackendlessApplication.user.getProperty("Surname").toString());
                    application.setStreetName(BackendlessApplication.user.getProperty("StreetName").toString());
                    application.setTown(BackendlessApplication.user.getProperty("Town").toString());
                    application.setCity(BackendlessApplication.user.getProperty("City").toString());
                    application.setZipCode(BackendlessApplication.user.getProperty("ZipCode").toString());
                    application.setTitle(BackendlessApplication.user.getProperty("Title").toString());
                    application.setHomeLanguage(BackendlessApplication.user.getProperty("HomeLanguage").toString());
                    application.setGender(BackendlessApplication.user.getProperty("Gender").toString());
                    application.setFirstChoiceStatus("In Process");
                    application.setSecondChoiceStatus("In Process");
                    application.setResidenceStatus("in process");
                    showProgress(true);
                    tvLoad.setText("Finalizing Your Application...");

                    Backendless.Persistence.save(application, new AsyncCallback<Application>() {
                        @Override
                        public void handleResponse(Application response) {
                            Toast.makeText(ActualApplication.this, "Application Successful", Toast.LENGTH_SHORT).show();
                            submit.setVisibility(View.VISIBLE);
                            register.setVisibility(View.GONE);
                            tvFirstChoice.setText("");
                            tvSecondChoice.setText("");
                            mUserItems.clear();
                            showProgress(false);

                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {
                            Toast.makeText(ActualApplication.this, "ERROR :"+ fault.getMessage(), Toast.LENGTH_SHORT).show();
                            showProgress(false);

                        }
                    });



                }

            }
        });
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
