import java.math.BigDecimal;

//Банковский счет: String iban; BigDecimal balance; Person owner
public class Account {
    private String iban;
    private BigDecimal balance;
    private Person owner;

    public Account(String iban, BigDecimal balance, Person owner) {
        this.iban = iban;
        this.balance = balance;
        this.owner = owner;
    }

    public String getIban() {
        return iban;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Person getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return String.format("Банківський рахунок: %s, баланс на рахунку: (%.02f), %s",
                iban, balance, owner);
    }
}
