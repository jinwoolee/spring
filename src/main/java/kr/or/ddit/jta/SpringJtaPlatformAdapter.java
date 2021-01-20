package kr.or.ddit.jta;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.util.Assert;

@SuppressWarnings("serial")
public class SpringJtaPlatformAdapter extends AbstractJtaPlatform{
	private static TransactionManager sTransactionManager;
    private static UserTransaction sUserTransaction;


    @Override
    protected TransactionManager locateTransactionManager() {
        Assert.notNull(sTransactionManager, "TransactionManager has not been setted");
        return sTransactionManager;
    }


    @Override
    protected UserTransaction locateUserTransaction() {
        Assert.notNull(sUserTransaction, "UserTransaction has not been setted");
        return sUserTransaction;
    }


    public void setJtaTransactionManager(JtaTransactionManager jtaTransactionManager) {
        sTransactionManager = jtaTransactionManager.getTransactionManager();
        sUserTransaction = jtaTransactionManager.getUserTransaction();
    }


    public void setTransactionManager(TransactionManager transactionManager) {
        sTransactionManager = transactionManager;
    }


    public void setUserTransaction(UserTransaction userTransaction) {
        sUserTransaction = userTransaction;
    }
}
