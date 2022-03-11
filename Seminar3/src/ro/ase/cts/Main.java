package ro.ase.cts;


import ro.ase.cts.contract.ExpressionSQL;
import ro.ase.cts.orchestrators.Orchestrator;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
            ExpressionSQL create = null;
            ExpressionSQL insert = null;
            ExpressionSQL read = null;

        try {
            create = (ExpressionSQL) Class.forName("ro.ase.cts.sql.CreateTable").getDeclaredConstructor().newInstance();
            insert = (ExpressionSQL) Class.forName("ro.ase.cts.sql.InsertData").getDeclaredConstructor().newInstance();
            read = (ExpressionSQL) Class.forName("ro.ase.cts.sql.ReadData").getDeclaredConstructor().newInstance();
            Orchestrator orchestrator = new Orchestrator(create, insert, read);
            orchestrator.execute();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
