package models.ui;

public class Expenses {

    private String name;
    private String note;
    private String category;
    private String date;
    private String amount;
    private String paymentMode;
    private String reference;
    private String repeatEvery;
    private String repeatDate;
    private String cycles;
    private String fileName;
    private String verifyAmount;
    private String verifyReceipt;
    private String verifyPaymentMode;

    public Expenses() {
    }

    public Expenses(String name,
                    String note,
                    String category,
                    String date,
                    String amount,
                    String paymentMode,
                    String reference,
                    String repeatEvery,
                    String repeatDate,
                    String cycles,
                    String fileName,
                    String verifyAmount,
                    String verifyReceipt,
                    String verifyPaymentMode
                    ) {
        this.name = name;
        this.note = note;
        this.category = category;
        this.date = date;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.reference = reference;
        this.repeatEvery = repeatEvery;
        this.repeatDate = repeatDate;
        this.cycles = cycles;
        this.fileName = fileName;
        this.verifyAmount = verifyAmount;
        this.verifyReceipt = verifyReceipt;
        this.verifyPaymentMode = verifyPaymentMode;
    }

    public String getName() { return name; }
    public String getNote() { return note; }
    public String getCategory() { return category; }
    public String getDate() { return date; }
    public String getAmount() { return amount; }
    public String getPaymentMode() { return paymentMode; }
    public String getReference() { return reference; }
    public String getRepeatEvery() { return repeatEvery; }
    public String getRepeatDate() { return repeatDate; }
    public String getCycles() { return cycles; }
    public String getFileName() { return fileName; }
    public String getVerifyAmount() { return verifyAmount; }
    public String getVerifyReceipt() { return verifyReceipt; }
    public String getVerifyPaymentMode() { return verifyPaymentMode; }
}