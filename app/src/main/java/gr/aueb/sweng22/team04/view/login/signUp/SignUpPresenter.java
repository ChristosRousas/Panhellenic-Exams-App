package gr.aueb.sweng22.team04.view.login.signUp;

import gr.aueb.sweng22.team04.dao.CandidateDAO;
import gr.aueb.sweng22.team04.dao.ScientificFieldDAO;
import gr.aueb.sweng22.team04.dao.UserDAO;
import gr.aueb.sweng22.team04.model.Candidate;
import gr.aueb.sweng22.team04.model.ScientificField;
import gr.aueb.sweng22.team04.model.User;

public class SignUpPresenter {

    private SignUpView view;
    private CandidateDAO candidateDAO;
    private ScientificFieldDAO scientificFieldDAO;
    private UserDAO userDAO;

    public SignUpView getView(){
        return this.view;
    }

    public void setView(SignUpView view){
        this.view = view;
    }

    public void setCandidateDAO(CandidateDAO candidateDAO){
        this.candidateDAO = candidateDAO;
    }

    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public void setScientificFieldDAO(ScientificFieldDAO scientificFieldDAO){
        this.scientificFieldDAO = scientificFieldDAO;
    }

    public CandidateDAO getCandidateDAO(){
        return this.candidateDAO;
    }

    public UserDAO getUserDAO(){
        return this.userDAO;
    }

    public Boolean onSignUp(String firstName, String lastName, String policeNumberID ,String birthday, String email, String password, String scientificField){
        if(firstName.isEmpty() || lastName.isEmpty() || policeNumberID.isEmpty() || birthday.isEmpty() || email.isEmpty() || password.isEmpty()){
            view.emptyField();
            return false;
        }

        if(!email.contains("@")){
            view.showInvalidEmail();
            return false;
        }

        if(password.length() < 7){
            view.showInvalidPassword();
            return false;
        }

        char charArray[] = policeNumberID.toCharArray();
        if(Character.isDigit(charArray[0]) || Character.isDigit(charArray[1])){
            view.showInvalidPoliceID();
            return false;
        }

        ScientificField field = scientificFieldDAO.findScientificField(scientificField);
        Candidate candidate = new Candidate(password, email, firstName, lastName, birthday, policeNumberID, field);
        candidateDAO.addCandidate(candidate);
        userDAO.addUser(candidate);
        return true;
    }
}
