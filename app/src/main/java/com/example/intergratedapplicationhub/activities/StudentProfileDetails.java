package com.example.intergratedapplicationhub.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.example.intergratedapplicationhub.R;
import com.example.intergratedapplicationhub.application_activities.BackendlessApplication;
import com.example.intergratedapplicationhub.entities.Application;
import com.example.intergratedapplicationhub.entities.ApplicationAdapter;
import com.example.intergratedapplicationhub.entities.Marks;
import com.example.intergratedapplicationhub.entities.MetricMarks;

import java.util.List;


public class StudentProfileDetails extends AppCompatActivity {
    TextView tvSID, tvSName,tvSSurName,tvSGender,tvSHomeLanguage,tvSTitle,tvSGmail;
    TextView tvSHouseNumber,tvSStreetName,tvSTown,tvSCity,tvSZipCode;
    TextView tvSG11S1,tvSG11S2,tvSG11S3,tvSG11S4,tvSG11S5,tvSG11S6,tvSG11S7;
    TextView tvSG11S1Mark,tvSG11S2Mark,tvSG11S3Mark,tvSG11S4Mark,tvSG11S5Mark,tvSG11S6Mark,tvSG11S7Mark;
    TextView tvSG12S1,tvSG12S2,tvSG12S3,tvSG12S4,tvSG12S5,tvSG12S6,tvSG12S7;
    TextView tvSG12S1Mark,tvSG12S2Mark,tvSG12S3Mark,tvSG12S4Mark,tvSG12S5Mark,tvSG12S6Mark,tvSG12S7Mark;
    ImageView imageView;
    private View mProgressView;
    private View mLoginFormView;
    private TextView tvLoad;
    Button btnMetricResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile_details);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        tvLoad = findViewById(R.id.tvLoad);
        btnMetricResults = findViewById(R.id.btnMetricResults);

        imageView =findViewById(R.id.imageView);


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

        String whereClause = "Email = '" + BackendlessApplication.user.getEmail() + "'";
        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setWhereClause(whereClause);

        showProgress(true);
        tvLoad.setText("Getting your profile details....Please Wait");
        Backendless.Data.of( Marks.class ).find( queryBuilder,
                new AsyncCallback<List<Marks>>(){
                    @Override
                    public void handleResponse(final List<Marks> foundContacts) {
                        BackendlessApplication.marks = foundContacts;
                        String whereClause = "Email = '" + BackendlessApplication.user.getEmail() + "'";
                        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
                        queryBuilder.setWhereClause(whereClause);
                        tvLoad.setText("Profile details found....checking for metric results");

                        Backendless.Data.of(MetricMarks.class).find(queryBuilder, new AsyncCallback<List<MetricMarks>>() {
                            @Override
                            public void handleResponse(List<MetricMarks> response)
                            {
                                showProgress(false);
                                btnMetricResults.setVisibility(View.VISIBLE);

                                BackendlessApplication.metricMarks = response;

                                for (MetricMarks metricMarks : response)
                                {
                                    tvSG12S1.setText("  "+metricMarks.getSubject1() + ":");
                                    tvSG12S1Mark.setText(metricMarks.getMark1() + " %");
                                    tvSG12S2.setText("  "+metricMarks.getSubject2() + ":");
                                    tvSG12S2Mark.setText(metricMarks.getMark2() + " %");
                                    tvSG12S3.setText("  "+metricMarks.getSubject3() + ":");
                                    tvSG12S3Mark.setText(metricMarks.getMark3() + " %");
                                    tvSG12S4.setText("  "+metricMarks.getSubject4() + ":");
                                    tvSG12S4Mark.setText(metricMarks.getMark4() + " %");
                                    tvSG12S5.setText("  "+metricMarks.getSubject5() + ":");
                                    tvSG12S5Mark.setText(metricMarks.getMark5() + " %");
                                    tvSG12S6.setText("  "+metricMarks.getSubject6() + ":");
                                    tvSG12S6Mark.setText(metricMarks.getMark6() + " %");
                                    tvSG12S7.setText("  "+metricMarks.getSubject7() + ":");
                                    tvSG12S7Mark.setText(metricMarks.getMark7() + " %");

                                }

                                for (Marks mark : foundContacts) {

                                    //Toast.makeText(StudentProfileDetails.this, "Success" + mark.getMark1(), Toast.LENGTH_SHORT).show();

                                    tvSG11S1.setText("  "+mark.getSubject1() + ":");
                                    tvSG11S1Mark.setText(mark.getMark1() + " %");
                                    tvSG11S2.setText("  "+mark.getSubject2() + ":");
                                    tvSG11S2Mark.setText(mark.getMark2() + " %");
                                    tvSG11S3.setText("  "+mark.getSubject3() + ":");
                                    tvSG11S3Mark.setText(mark.getMark3() + " %");
                                    tvSG11S4.setText("  "+mark.getSubject4() + ":");
                                    tvSG11S4Mark.setText(mark.getMark4() + " %");
                                    tvSG11S5.setText("  "+mark.getSubject5() + ":");
                                    tvSG11S5Mark.setText(mark.getMark5() + " %");
                                    tvSG11S6.setText("  "+mark.getSubject6() + ":");
                                    tvSG11S6Mark.setText(mark.getMark6() + " %");
                                    tvSG11S7.setText("  "+mark.getSubject7() + ":");
                                    tvSG11S7Mark.setText(mark.getMark7() + " %");

                                    tvSID.setText(BackendlessApplication.user.getProperty("IdNumber").toString());
                                    tvSName.setText(BackendlessApplication.user.getProperty("Name").toString());
                                    tvSSurName.setText(BackendlessApplication.user.getProperty("Surname").toString());
                                    tvSGender.setText(BackendlessApplication.user.getProperty("Gender").toString());
                                    tvSHomeLanguage.setText(BackendlessApplication.user.getProperty("HomeLanguage").toString());
                                    tvSTitle.setText(BackendlessApplication.user.getProperty("Title").toString());
                                    tvSGmail.setText(BackendlessApplication.user.getEmail().toString());

                                    tvSHouseNumber.setText(BackendlessApplication.user.getProperty("HouseNumber").toString());
                                    tvSStreetName.setText(BackendlessApplication.user.getProperty("StreetName").toString());
                                    tvSTown.setText(BackendlessApplication.user.getProperty("Town").toString());
                                    tvSCity.setText(BackendlessApplication.user.getProperty("City").toString());
                                    tvSZipCode.setText(BackendlessApplication.user.getProperty("ZipCode").toString());


                                }
                            }

                            @Override
                            public void handleFault(BackendlessFault fault) {
                                showProgress(false);
                                Toast.makeText(StudentProfileDetails.this, "No metric results found", Toast.LENGTH_SHORT).show();

                            }
                        });



                    }


                    @Override
                    public void handleFault( BackendlessFault fault )
                    {
                        showProgress(false);
                        Toast.makeText(StudentProfileDetails.this, "Error", Toast.LENGTH_SHORT).show();
                        // an error has occurred, the error code can be retrieved with fault.getCode()
                    }
                });



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(StudentProfileDetails.this, UpdateStudent.class);
                i.putExtra("IdNumber",BackendlessApplication.user.getProperty("IdNumber").toString());
                i.putExtra("Email",  BackendlessApplication.user.getEmail());
                i.putExtra("Surname",BackendlessApplication.user.getProperty("Surname").toString());
                i.putExtra("City",BackendlessApplication.user.getProperty("City").toString());
                i.putExtra("Gender",BackendlessApplication.user.getProperty("Gender").toString());
                i.putExtra("HomeLanguage",BackendlessApplication.user.getProperty("HomeLanguage").toString());
                i.putExtra("Title",BackendlessApplication.user.getProperty("Title").toString());
                i.putExtra("HouseNumber",BackendlessApplication.user.getProperty("HouseNumber").toString());
                i.putExtra("StreetName",BackendlessApplication.user.getProperty("StreetName").toString());
                i.putExtra("Town",BackendlessApplication.user.getProperty("Town").toString());
                i.putExtra("ZipCode",BackendlessApplication.user.getProperty("ZipCode").toString());
                i.putExtra("Name",BackendlessApplication.user.getProperty("Name").toString());
                startActivity(i);
                StudentProfileDetails.this.finish();

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
