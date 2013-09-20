package com.jersey.dao;

import javax.naming.*;
import javax.sql.*;

public class OracleDao {
	private static DataSource oracleDS = null;
	private static Context context = null;
	
	public static DataSource OracleConn() throws Exception {
		/**
		* check to see if the database object is already defined...
		* if it is, then return the connection, no need to look it up again.
		*/
		if (oracleDS != null) {
			return oracleDS;
		}

		/**
		* This only needs to run one time to get the database object.
		* context is used to lookup the database object in weblogic
		* Oracle308tube will hold the database object
		*/
		if (context == null) {
			context = new InitialContext();
		}

		oracleDS = (DataSource)context.lookup("oracledb");
		
		return oracleDS;
	}
}
