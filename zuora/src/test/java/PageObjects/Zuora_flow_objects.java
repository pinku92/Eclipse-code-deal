package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Zuora_flow_objects {

	private WebDriver driver;

	public Zuora_flow_objects(WebDriver driver) {
		this.driver = driver;
	}

	// login page

	@FindBy(how = How.XPATH, using = ".//*[@id='id_username']")
	public List<WebElement> zuora_login_username;

	@FindBy(how = How.XPATH, using = ".//*[@id='id_password']")
	public List<WebElement> zuora_login_password;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'login')]")
	public List<WebElement> zuora_login_submit;

	// zuora homepage

	@FindBy(how = How.XPATH, using = ".//*[@id='Customers_BillingAccount']")
	public List<WebElement> zuora_customers_customer_accounts;

	@FindBy(how = How.XPATH, using = ".//*[@id='Customers_Subscriptions']")
	public List<WebElement> zuora_customers_customer_subscriptions;

	// zuora search

	@FindBy(how = How.XPATH, using = ".//*[@id='findKey_input']")
	public List<WebElement> zuora_customers_search_customer;

	@FindBy(how = How.XPATH, using = ".//*[@id='SearchButton']")
	public List<WebElement> zuora_customers_search_button;

	@FindBy(how = How.XPATH, using = ".//*[@id='search_input']")
	public List<WebElement> zuora_subscription_search_customer;

	@FindBy(how = How.XPATH, using = ".//*[@id='z-sidebar']/div[2]/div/div[2]/form/a/span")
	public List<WebElement> zuora_subscription_search_button;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='Search_Result1']/table/tbody/tr/td/div/table//a[1]")
	public List<WebElement> zuora_subscription_search_user_list;
	
	
	

	// Search_list_page

	@FindBy(how = How.XPATH, using = "//td//tr[2]//a[1]")
	public List<WebElement> zuora_customers_searched_user_emaillink;

	@FindBy(how = How.XPATH, using = "//td//tr[2]//a[1]")
	public List<WebElement> zuora_customers_searched_user_emaillink_2;

	@FindBy(how = How.XPATH, using = ".//*[@id='listView']/h2/span")
	public List<WebElement> zuora_customers_searched_user_list_view;

	// Basic info

	@FindBy(how = How.XPATH, using = ".//*[@id='basicInfo_table']//tr[contains(.,'Legacy User Id:')]//span")
	public List<WebElement> zuora_customers_basicinfo_userID;

	// SUBSCRIPTION TABLE INFO ACTION ALERTS PLUS

	// @FindBy(how = How.XPATH, using =
	// ".//*[@id='subsciptions']/tbody/tr[2]/td[1]/a")
	// public List<WebElement>
	// zuora_customers_search_list_subscriptiontable_subscription_number;

	@FindBy(how = How.XPATH, using = ".//*[@id='Subscription_viewAll']")
	public WebElement zuora_customers_search_list_subscriptiontable_viewall;

	@FindBy(how = How.XPATH, using = ".//*[@id='subsciptions']/tbody/tr[2]/td[1]//a[2]")
	public List<WebElement> zuora_customers_search_list_subscriptiontable_subscription_number;

	@FindBy(how = How.XPATH, using = ".//*[@id='subsciptions']/tbody/tr[2]/td[3]")
	public List<WebElement> zuora_customers_search_list_subscriptiontable_subscription_product;

	@FindBy(how = How.XPATH, using = ".//*[@id='subsciptions']/tbody/tr[2]/td[4]")
	public List<WebElement> zuora_customers_search_list_subscriptiontable_contract_effectivedate;

	@FindBy(how = How.XPATH, using = ".//*[@id='subsciptions']/tbody/tr[2]/td[5]")
	public List<WebElement> zuora_customers_search_list_subscriptiontable_next_renewaldate;

	@FindBy(how = How.XPATH, using = ".//*[@id='subsciptions']/tbody/tr[2]/td[6]")
	public List<WebElement> zuora_customers_search_list_subscriptiontable_subscription_status;

	@FindBy(how = How.XPATH, using = ".//*[@id='id__subsciptions_[0].includeListofProducts'][contains(.,'Action Alerts PLUS')]/../../td[1]//a[2]")
	public WebElement zuora_customers_search_list_subscriptiontable_subscription_number_link;

	@FindBy(how = How.XPATH, using = ".//*[@id='id__subsciptions_[0].includeListofProducts'][contains(.,'Action Alerts PLUS')]/../../td[1]")
	public List<WebElement> zuora_customers_search_list_subscriptiontable_subscription_number_1;

	@FindBy(how = How.XPATH, using = ".//*[@id='id__subsciptions_[0].includeListofProducts'][contains(.,'Action Alerts PLUS')]/../../td[3]")
	public List<WebElement> zuora_customers_search_list_subscriptiontable_subscription_product_1;

	@FindBy(how = How.XPATH, using = ".//*[@id='id__subsciptions_[0].includeListofProducts'][contains(.,'Action Alerts PLUS')]/../../td[4]")
	public List<WebElement> zuora_customers_search_list_subscriptiontable_contract_effectivedate_1;

	@FindBy(how = How.XPATH, using = ".//*[@id='id__subsciptions_[0].includeListofProducts'][contains(.,'Action Alerts PLUS')]/../../td[5]")
	public List<WebElement> zuora_customers_search_list_subscriptiontable_next_renewaldate_1;

	@FindBy(how = How.XPATH, using = ".//*[@id='id__subsciptions_[0].includeListofProducts'][contains(.,'Action Alerts PLUS')]/../../td[6]")
	public List<WebElement> zuora_customers_search_list_subscriptiontable_subscription_status_1;

	// Open the subscription link

	@FindBy(how = How.XPATH, using = ".//*[@id='b11']//tr[contains(.,'Auto Renew:')]//span")
	public List<WebElement> zuora_customers_subscription_detail_auto_renew;

	@FindBy(how = How.XPATH, using = ".//*[@id='b11']//tr[contains(.,'Promo Campaign:')]//span")
	public List<WebElement> zuora_customers_subscription_detail_promo_campaign;

	@FindBy(how = How.XPATH, using = ".//*[@id='b11']//tr[contains(.,'Promo Code:')]//span")
	public List<WebElement> zuora_customers_subscription_detail_promo_code;

	@FindBy(how = How.XPATH, using = ".//*[@id='b11']//tr[contains(.,'Payment Method Id:')]//span")
	public List<WebElement> zuora_customers_subscription_detail_payment_methodid;

	@FindBy(how = How.XPATH, using = ".//*[@id='b11']//tr[contains(.,' C3 Origin Id: ')]//span")
	public List<WebElement> zuora_customers_subscription_detail_c3orgin_id;

	@FindBy(how = How.XPATH, using = ".//*[@id='titleLabelID']")
	public List<WebElement> zuora_customers_subscription_label;

	@FindBy(how = How.XPATH, using = ".//*[@id='product[0].id_div']/div/table/tbody/tr/td/strong/span")
	public List<WebElement> zuora_customers_subscription_product_label;

	// CUSTOMER CREATION
	
	@FindBy(how = How.XPATH, using = "//*[@id='swithAction']")
	public List<WebElement> zuora_payment_method_id;

	@FindBy(how = How.XPATH, using = ".//*[@id='accountName']")
	public List<WebElement> zuora_add_customer_accountname;

	@FindBy(how = How.XPATH, using = ".//*[@id='customFieldsData.cf4Data']")
	public List<WebElement> zuora_add_customer_userid;

	@FindBy(how = How.XPATH, using = ".//*[@id='customFieldsData.cf6Data']")
	public List<WebElement> zuora_add_customer_oid;

	@FindBy(how = How.XPATH, using = ".//*[@id='billToContact_firstName']")
	public List<WebElement> zuora_add_customer_bill_to_contact_fname;

	@FindBy(how = How.XPATH, using = ".//*[@id='billToContact_lastName']")
	public List<WebElement> zuora_add_customer_bill_to_contact_lname;

	@FindBy(how = How.XPATH, using = ".//*[@id='billToContact_workEmail']")
	public List<WebElement> zuora_add_customer_bill_to_contact_work_email;

	@FindBy(how = How.XPATH, using = ".//*[@id='billToContact_country']//option")
	public List<WebElement> zuora_add_customer_bill_to_contact_country;

	@FindBy(how = How.XPATH, using = ".//*[@id='billToContact_address1']")
	public List<WebElement> zuora_add_customer_bill_to_contact_address1;

	@FindBy(how = How.XPATH, using = ".//*[@id='billToContact_address2']")
	public List<WebElement> zuora_add_customer_bill_to_contact_address2;

	@FindBy(how = How.XPATH, using = ".//*[@id='billToContact_city']")
	public List<WebElement> zuora_add_customer_bill_to_contact_city;

	@FindBy(how = How.XPATH, using = ".//*[@id='billToContact_state']//option")
	public List<WebElement> zuora_add_customer_bill_to_contact_state;

	@FindBy(how = How.XPATH, using = ".//*[@id='billToContact_postalCode']")
	public List<WebElement> zuora_add_customer_bill_to_contact_postalcode;

	@FindBy(how = How.XPATH, using = ".//*[@id='otherGW_creditCard_handler']")
	public List<WebElement> zuora_add_customer_bill_to_contact_credit_card;

	@FindBy(how = How.XPATH, using = ".//*[@id='CreditCard_cardNumber']")
	public List<WebElement> zuora_add_customer_bill_to_contact_card_number;

	@FindBy(how = How.XPATH, using = "//select[@name='defaultPaymentMethod.creditCardExpirationMonth']//option")
	public List<WebElement> zuora_add_customer_bill_to_contact_card_select_month;

	@FindBy(how = How.XPATH, using = "//select[@name='defaultPaymentMethod.creditCardExpirationYear']//option")
	public List<WebElement> zuora_add_customer_bill_to_contact_card_select_year;

	@FindBy(how = How.XPATH, using = ".//*[@id='CreditCard_cardHolderName']")
	public List<WebElement> zuora_add_customer_bill_to_contact_card_holdername;

	@FindBy(how = How.XPATH, using = "//select[@name='defaultPaymentMethod.creditCardCountry']//option")
	public List<WebElement> zuora_add_customer_bill_to_contact_card_select_country;

	@FindBy(how = How.XPATH, using = "//input[@name='defaultPaymentMethod.creditCardAddress1']")
	public List<WebElement> zuora_add_customer_bill_to_contact_card_address;

	@FindBy(how = How.XPATH, using = "//input[@name='defaultPaymentMethod.creditCardCity']")
	public List<WebElement> zuora_add_customer_bill_to_contact_card_city;

	@FindBy(how = How.XPATH, using = "//select[@name='defaultPaymentMethod.creditCardState']//option")
	public List<WebElement> zuora_add_customer_bill_to_contact_card_select_state;

	@FindBy(how = How.XPATH, using = "//input[@name='defaultPaymentMethod.creditCardPostalCode']")
	public List<WebElement> zuora_add_customer_bill_to_contact_card_postalcode;

	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	public List<WebElement> zuora_add_customer_bill_to_contact_card_email;

	@FindBy(how = How.XPATH, using = "//input[@id='phoneNumber']")
	public List<WebElement> zuora_add_customer_bill_to_contact_card_phone;

	@FindBy(how = How.XPATH, using = ".//*[@id='saveAcc']/span")
	public List<WebElement> zuora_add_customer_bill_to_contact_card_save;

	//CREATE SUBSCRIPTION
	
	@FindBy(how = How.XPATH, using = "//span[contains(.,'create new subscription')]")
	public List<WebElement> zuora_create_subscription_btn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='edit_Subscription__customFieldsData_Payment Method Id']")
	public List<WebElement> zuora_create_subscription_paymentid;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='edit_Subscription__customFieldsData_Product Name']")
	public List<WebElement> zuora_create_subscription_productname;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='edit_Subscription__customFieldsData_Leg Type']//option")
	public List<WebElement> zuora_create_subscription_legtype;
	
	@FindBy(how = How.XPATH, using = "//input[@id='_label_product[0].id']")
	public List<WebElement> zuora_create_subscription_prodct_dropdown_field;
	
	@FindBy(how = How.XPATH, using = "//div[@id='_select_product[0].id']//div")
	public List<WebElement> zuora_create_subscription_prodct_dropdown_list;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='_label_rateplan[0].id']")
	public List<WebElement> zuora_create_subscription_rateplan_dropdown_field;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='_div_rateplan[0].id']//div")
	public List<WebElement> zuora_create_subscription_rateplan_dropdown_list;
	
	@FindBy(how = How.XPATH, using = "//span[contains(.,'save and activate')]")
	public List<WebElement> zuora_create_subscription_save_activate;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='CE_date']")
	public List<WebElement> zuora_create_subscription_contract_effective;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='SA_date']")
	public List<WebElement> zuora_create_subscription_start_activate;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='z-boxPopup-formAction-button-save']/span")
	public List<WebElement> zuora_create_subscription_save;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='invoiceOwner_c']/span/a")
	public List<WebElement> zuora_create_subscription_invoice_owner;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='z-status']//span[@id='status_val']")
	public List<WebElement> zuora_subscription_status;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='_subscription_detail_more__li']/a/span")
	public List<WebElement> zuora_subscription_more_btn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='_subscription_detail_more_']//a")
	public List<WebElement> zuora_subscription_more_preview_link;
	
	@FindBy(how = How.XPATH, using = "//h5[contains(.,'Contract Effective:')]/../../td/input")
	public List<WebElement> zuora_subscription_contract_effective_date1;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='_ce_']")
	public List<WebElement> zuora_subscription_contract_effective_date;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='z-action-nav']//a/span[contains(.,'cancel')]")
	public List<WebElement> zuora_subscription_cancel_btn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='contractEffectiveDate_id']")
	public List<WebElement> zuora_subscription_cancel_contract_effectivedate;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='requestDate_id']")
	public List<WebElement> zuora_subscription_cancel_date;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='cancellationPolicy_id']//option")
	public List<WebElement> zuora_subscription_cancel_effetcive_date;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='z-boxPopup-formAction-button-save']/span")
	public List<WebElement> zuora_subscription_cancel_save_button;
	
	
	@FindBy(how = How.XPATH, using = ".//*[@id='b11']//span[contains(.,'Done')]")
	public List<WebElement> zuora_subscription_more_preview_done_button;
	
	
	
	
	//INVOICE _PROCESS
	
	@FindBy(how = How.XPATH, using = "//a[contains(.,'create bill run')]")
	public WebElement zuora_create_billrun_link;
	
	@FindBy(how = How.XPATH, using = "//span[contains(.,'create bill run')]")
	public List<WebElement> zuora_create_billrun_button;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='confirm_yes']")
	public List<WebElement> zuora_confirm_ok;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='invoices']//tr//th[2]/../../tr//td[2]")
	public List<WebElement> zuora_invoice_id_from_subscription_page;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='invoices']//tr//th[2]/../../tr//td[7]")
	public List<WebElement> zuora_invoice_status_from_subscription_page;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='username']")
	public List<WebElement> zuora_invoice_status_invoice_username;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='password']")
	public List<WebElement> zuora_invoice_status_invoice_password;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Sign In']")
	public List<WebElement> zuora_invoice_status_invoice_signin;
	
	@FindBy(how = How.XPATH, using = "xhtml:html/xhtml:body/xhtml:pre")
	public List<WebElement> zuora_invoice_status_invoice_process_status;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='invoices']//tr//th[2]/../../tr//td[5]")
	public List<WebElement> zuora_invoice_status_balanceinfo;
	
	
	
	
	
	
	
	
	
	
	
	
}
