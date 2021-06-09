package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Client;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-05T20:33:19")
@StaticMetamodel(Transaction.class)
public class Transaction_ { 

    public static volatile SingularAttribute<Transaction, String> date;
    public static volatile SingularAttribute<Transaction, String> code;
    public static volatile SingularAttribute<Transaction, Client> idDest;
    public static volatile SingularAttribute<Transaction, Client> idExp;
    public static volatile SingularAttribute<Transaction, Integer> montant;
    public static volatile SingularAttribute<Transaction, Integer> id;
    public static volatile SingularAttribute<Transaction, Integer> status;

}