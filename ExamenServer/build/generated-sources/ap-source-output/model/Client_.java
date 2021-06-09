package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Transaction;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-05T20:33:19")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile ListAttribute<Client, Transaction> transactionList1;
    public static volatile SingularAttribute<Client, String> numero;
    public static volatile ListAttribute<Client, Transaction> transactionList;
    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile SingularAttribute<Client, String> nom;

}