package _28_digital_wallet;

/**
 * @author Ikechi Ucheagwu
 * @created 15/01/2023 - 21:22
 * @project Algo Github
 */

/*
 * Create TransactionException, DigitalWallet, and DigitalWalletTransaction classes here.
 */

class TransactionException extends Exception {
    String errorMessage, errorCode;
    public TransactionException(String errorMessage, String errorCode) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

}

class DigitalWallet {
    String walletId, userName, userAccessCode, accessToken;
    int walletBalance;
    public DigitalWallet(String walletId, String userName) {
        this.walletId = walletId;
        this.userName = userName;
    }

    public DigitalWallet(String walletId, String userName, String userAccessCode) {
        this.walletId = walletId;
        this.userName = userName;
        this.userAccessCode = userAccessCode;
    }

    public void setUserAccessCode(String userAccessCode) {
        this.userAccessCode = userAccessCode;
    }

    public String getUserAccessCode() {
        return userAccessCode;
    }

    public String getWalletId() {
        return walletId;
    }

    public String getUsername() {
        return userName;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return userAccessCode;
    }

    public void setWalletBalance(int walletBalance) {
        this.walletBalance = walletBalance;
    }

    public int getWalletBalance() {
        return walletBalance;
    }
}

class DigitalWalletTransaction {
    public void addMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
        if (digitalWallet.getAccessToken() == null ) {
            throw new TransactionException("User not authorized", "USER_NOT_AUTHORIZED");
        }

        if (amount <= 0) {
            throw new TransactionException("Amount should be greater than zero", "INVALID_AMOUNT");
        }

        int oldBalance = digitalWallet.getWalletBalance();
        int newBalance = oldBalance + amount;

        digitalWallet.setWalletBalance(newBalance);
    }

    public void payMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
        if (digitalWallet.getAccessToken() == null ) {
            throw new TransactionException("User not authorized", "USER_NOT_AUTHORIZED");
        }

        if (amount <= 0) {
            throw new TransactionException("Amount should be greater than zero", "INVALID_AMOUNT");
        }

        if (digitalWallet.getWalletBalance() < amount) {
            throw new TransactionException("Insufficient balance", "INSUFFICIENT_BALANCE");
        }

        int oldBalance = digitalWallet.getWalletBalance();
        int newBalance = oldBalance - amount;

        digitalWallet.setWalletBalance(newBalance);

    }
}
