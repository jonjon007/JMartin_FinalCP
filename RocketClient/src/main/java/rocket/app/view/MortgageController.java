package rocket.app.view;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketBase.RateBLL;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	@FXML TextField txtHouseCost;
	@FXML TextField txtDownPayment;
	@FXML TextField txtCreditScore;
	@FXML TextField txtIncome;
	@FXML TextField txtExpenses;
	@FXML ComboBox cmbTerm;
	@FXML Label lblMortgagePayment;
	
	private TextField txtNew;
	
	private MainApp mainApp;
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public ComboBox getCmbTerm(){
		return cmbTerm;
	}
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message Here...");
		alert.setHeaderText("Look, an Information Dialog");
		//alert.setContentText(txtNew.getText());
		alert.setContentText("Information Dialog");
		alert.showAndWait().ifPresent(rs -> {
		    if (rs == ButtonType.OK) {
		        System.out.println("Pressed OK.");
		    }
		});
		//But nothing gets sent???
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		double finalPayment;
		
		double PV = lRequest.getdAmount() - lRequest.getiDownPayment();
		double FV = 0;
		int numPayments = 12*lRequest.getiTerm(); //Parse??
		double rate = lRequest.getdRate();
		double monthlyFinal;
		double monthly1 = lRequest.getdIncome()*0.28; 
		double monthly2 = lRequest.getdIncome()*0.36 - lRequest.getdExpenses();
		if(monthly1 > monthly2)
			monthlyFinal = monthly1;
		else
			monthlyFinal = monthly2;
		finalPayment = RateBLL.getPayment(rate, numPayments, PV, FV, true);
		if(finalPayment/(numPayments*12) > monthlyFinal)
			lblMortgagePayment.setText(String.format("%.2f: House Cost too high", finalPayment));
		if(finalPayment/(numPayments*12) > monthlyFinal)
			lblMortgagePayment.setText(String.format("%.2f", finalPayment));
	}
}
