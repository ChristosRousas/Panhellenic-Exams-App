package gr.aueb.sweng22.team04.view.FindDepartment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;
import gr.aueb.sweng22.team04.view.candidate.CandidatePresenter;

public class FindDepartmentActivity extends AppCompatActivity implements FindDepartmentView{

    FindDepartmentPresenter presenter;
    CandidatePresenter candidatePresenter;
    private Button btnFindDepartment;
    private TextView txtSearchForDepartment;
    private EditText edtID;
    private TextView txtDepartment;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_department);
        FindDepartmentViewModel viewModel = new ViewModelProvider(this).get(FindDepartmentViewModel.class);
        presenter = viewModel.getPresenter();
        presenter.setView(this);


        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        Bundle extras = getIntent().getExtras();
        /*String Candidate_email = extras.getString("email");
        String Candidate_password = extras.getString("password");

        candidatePresenter.setEmail(Candidate_email);
        candidatePresenter.setPassword(Candidate_password);*/

        edtID = (EditText) findViewById(R.id.EnterDepartmentID);
        txtSearchForDepartment = findViewById(R.id.SearchForDepartment);
        txtDepartment = findViewById(R.id.Department);
        btnFindDepartment = findViewById(R.id.FindDepartment);

        btnFindDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edtID.getText().toString();
                presenter.onFindDepartment(Integer.parseInt(id));
            }
        });
    }

    @Override
    public void showDepartment(String temp)
    {
        txtDepartment.setText(temp);
    }

    @Override
    public void showDepartmentNotFound() {
        txtDepartment.setText("Department with this id not found");
    }
}
