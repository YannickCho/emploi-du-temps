package org.eclipse.model;

import java.io.Serializable;

public class EmploiDuTemps implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String[][] tabEmploi = new String[21][5];
	
	public EmploiDuTemps() {}

	public String[][] getTabEmploi() {
		return tabEmploi;
	}

	public void setTabEmploi(String[][] tabEmploi) {
		this.tabEmploi = tabEmploi;
	}
	
	
	
}
