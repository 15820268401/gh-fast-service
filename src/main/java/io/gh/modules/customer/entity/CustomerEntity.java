package io.gh.modules.customer.entity;

import io.gh.common.validator.group.AddGroup;
import io.gh.common.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

public class CustomerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Boolean del;

    private Date createrTime;

    private Date updateTime;

    private String uploadUser;

    private Date uploadTime;

    private String downloadUser;

    private Date downloadTime;

    private String dateTime;

    private String aliasname;

    private String idcard;

    private String phone;

    private String money;

    private String purpose;

    private String deadline;

    private String requiredTime;

    private String unit;

    private String monthlyIncome;

    private String issueForm;

    private String unitName;

    private String duty;

    private String workHours;

    private String socialSecurity;

    private String publicGold;

    private String cardinalNumber;

    private String business;

    private String legalPerson;

    private String operationTime;

    private String waterSituation;

    private String education;

    private String sesamePoints;

    private String creditCard;

    private String creditLimit;

    private String credit;

    private String bankLoan;

    private String bankLoanQi;

    private String bankLoanMonthlyPayments;

    private String sesameLoan;

    private String sesameLoanQi;

    private String sesameLoanMonthlyPayments;

    private String atomLoan;

    private String atomLoanQi;

    private String atomLoanMonthlyPayments;

    private String policyCircumstances;

    private String insuranceCompany;

    private String payAmount;

    private String paidIn;

    private String other;

    private String nameOfTheProperty;

    private String area;

    private String loansDeadline;

    private String housesPayMoneyForMonth;

    private String nameOfTheCar;

    private String carMoney;

    private String carPayType;

    private String carPayMoneyForMonth;

    private String maritalStatus;

    private String familyKnow;

    private String clientGrade;

    private String reviewSituation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public Date getCreaterTime() {
        return createrTime;
    }

    public void setCreaterTime(Date createrTime) {
        this.createrTime = createrTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Date getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(Date downloadTime) {
        this.downloadTime = downloadTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime == null ? null : dateTime.trim();
    }

    public String getAliasname() {
        return aliasname;
    }

    public void setAliasname(String aliasname) {
        this.aliasname = aliasname == null ? null : aliasname.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline == null ? null : deadline.trim();
    }

    public String getRequiredTime() {
        return requiredTime;
    }

    public void setRequiredTime(String requiredTime) {
        this.requiredTime = requiredTime == null ? null : requiredTime.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome == null ? null : monthlyIncome.trim();
    }

    public String getIssueForm() {
        return issueForm;
    }

    public void setIssueForm(String issueForm) {
        this.issueForm = issueForm == null ? null : issueForm.trim();
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours == null ? null : workHours.trim();
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity == null ? null : socialSecurity.trim();
    }

    public String getPublicGold() {
        return publicGold;
    }

    public void setPublicGold(String publicGold) {
        this.publicGold = publicGold == null ? null : publicGold.trim();
    }

    public String getCardinalNumber() {
        return cardinalNumber;
    }

    public void setCardinalNumber(String cardinalNumber) {
        this.cardinalNumber = cardinalNumber == null ? null : cardinalNumber.trim();
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business == null ? null : business.trim();
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime == null ? null : operationTime.trim();
    }

    public String getWaterSituation() {
        return waterSituation;
    }

    public void setWaterSituation(String waterSituation) {
        this.waterSituation = waterSituation == null ? null : waterSituation.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getSesamePoints() {
        return sesamePoints;
    }

    public void setSesamePoints(String sesamePoints) {
        this.sesamePoints = sesamePoints == null ? null : sesamePoints.trim();
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard == null ? null : creditCard.trim();
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit == null ? null : creditLimit.trim();
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit == null ? null : credit.trim();
    }

    public String getBankLoan() {
        return bankLoan;
    }

    public void setBankLoan(String bankLoan) {
        this.bankLoan = bankLoan == null ? null : bankLoan.trim();
    }

    public String getBankLoanQi() {
        return bankLoanQi;
    }

    public void setBankLoanQi(String bankLoanQi) {
        this.bankLoanQi = bankLoanQi == null ? null : bankLoanQi.trim();
    }

    public String getBankLoanMonthlyPayments() {
        return bankLoanMonthlyPayments;
    }

    public void setBankLoanMonthlyPayments(String bankLoanMonthlyPayments) {
        this.bankLoanMonthlyPayments = bankLoanMonthlyPayments == null ? null : bankLoanMonthlyPayments.trim();
    }

    public String getSesameLoan() {
        return sesameLoan;
    }

    public void setSesameLoan(String sesameLoan) {
        this.sesameLoan = sesameLoan == null ? null : sesameLoan.trim();
    }

    public String getSesameLoanQi() {
        return sesameLoanQi;
    }

    public void setSesameLoanQi(String sesameLoanQi) {
        this.sesameLoanQi = sesameLoanQi == null ? null : sesameLoanQi.trim();
    }

    public String getSesameLoanMonthlyPayments() {
        return sesameLoanMonthlyPayments;
    }

    public void setSesameLoanMonthlyPayments(String sesameLoanMonthlyPayments) {
        this.sesameLoanMonthlyPayments = sesameLoanMonthlyPayments == null ? null : sesameLoanMonthlyPayments.trim();
    }

    public String getAtomLoan() {
        return atomLoan;
    }

    public void setAtomLoan(String atomLoan) {
        this.atomLoan = atomLoan == null ? null : atomLoan.trim();
    }

    public String getAtomLoanQi() {
        return atomLoanQi;
    }

    public void setAtomLoanQi(String atomLoanQi) {
        this.atomLoanQi = atomLoanQi == null ? null : atomLoanQi.trim();
    }

    public String getAtomLoanMonthlyPayments() {
        return atomLoanMonthlyPayments;
    }

    public void setAtomLoanMonthlyPayments(String atomLoanMonthlyPayments) {
        this.atomLoanMonthlyPayments = atomLoanMonthlyPayments == null ? null : atomLoanMonthlyPayments.trim();
    }

    public String getPolicyCircumstances() {
        return policyCircumstances;
    }

    public void setPolicyCircumstances(String policyCircumstances) {
        this.policyCircumstances = policyCircumstances == null ? null : policyCircumstances.trim();
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany == null ? null : insuranceCompany.trim();
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount == null ? null : payAmount.trim();
    }

    public String getPaidIn() {
        return paidIn;
    }

    public void setPaidIn(String paidIn) {
        this.paidIn = paidIn == null ? null : paidIn.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getNameOfTheProperty() {
        return nameOfTheProperty;
    }

    public void setNameOfTheProperty(String nameOfTheProperty) {
        this.nameOfTheProperty = nameOfTheProperty == null ? null : nameOfTheProperty.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getLoansDeadline() {
        return loansDeadline;
    }

    public void setLoansDeadline(String loansDeadline) {
        this.loansDeadline = loansDeadline == null ? null : loansDeadline.trim();
    }

    public String getHousesPayMoneyForMonth() {
        return housesPayMoneyForMonth;
    }

    public void setHousesPayMoneyForMonth(String housesPayMoneyForMonth) {
        this.housesPayMoneyForMonth = housesPayMoneyForMonth == null ? null : housesPayMoneyForMonth.trim();
    }

    public String getNameOfTheCar() {
        return nameOfTheCar;
    }

    public void setNameOfTheCar(String nameOfTheCar) {
        this.nameOfTheCar = nameOfTheCar == null ? null : nameOfTheCar.trim();
    }

    public String getCarMoney() {
        return carMoney;
    }

    public void setCarMoney(String carMoney) {
        this.carMoney = carMoney == null ? null : carMoney.trim();
    }

    public String getCarPayType() {
        return carPayType;
    }

    public void setCarPayType(String carPayType) {
        this.carPayType = carPayType == null ? null : carPayType.trim();
    }

    public String getCarPayMoneyForMonth() {
        return carPayMoneyForMonth;
    }

    public void setCarPayMoneyForMonth(String carPayMoneyForMonth) {
        this.carPayMoneyForMonth = carPayMoneyForMonth == null ? null : carPayMoneyForMonth.trim();
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus == null ? null : maritalStatus.trim();
    }

    public String getFamilyKnow() {
        return familyKnow;
    }

    public void setFamilyKnow(String familyKnow) {
        this.familyKnow = familyKnow == null ? null : familyKnow.trim();
    }

    public String getClientGrade() {
        return clientGrade;
    }

    public void setClientGrade(String clientGrade) {
        this.clientGrade = clientGrade == null ? null : clientGrade.trim();
    }

    public String getReviewSituation() {
        return reviewSituation;
    }

    public void setReviewSituation(String reviewSituation) {
        this.reviewSituation = reviewSituation == null ? null : reviewSituation.trim();
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser;
    }

    public String getDownloadUser() {
        return downloadUser;
    }

    public void setDownloadUser(String downloadUser) {
        this.downloadUser = downloadUser;
    }
}